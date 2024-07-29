@file:OptIn(ExperimentalMaterial3Api::class)

package es.tipolisto.breeds.ui.views.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.components.getContactAnnotated
import es.tipolisto.breeds.ui.components.getTermsAnnotated
import es.tipolisto.breeds.ui.components.getWebAnnotated
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.utils.MediaPlayerClient


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController:NavController, mediaPlayerClient: MediaPlayerClient) {
    val context = LocalContext.current
    //val mediaPlayerClient by remember{ mutableStateOf(MediaPlayerClient(context))}
    var switchmusicChecked by remember {mutableStateOf(PreferenceManager.readPreferenceMusicOnOff(context))}
    var isEnabledMusic by remember {mutableStateOf(PreferenceManager.readPreferenceMusicOnOff(context))}
    //Está es la variable que le pasamos al theme
    var isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    //Nos sirve para poner el switch a la derecha si está ativado el modo noche
    var switchThemeDarkChecked by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    //En settingsScreen hace falta el tema ya que solo cambia donde está la variable mutable
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Settings", color= Color.White, fontWeight = FontWeight.Bold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon={
                        IconButton(onClick = { navController.popBackStack()}) {
                            Icon(imageVector = Icons.Default.ArrowBack,contentDescription = "Back", tint = Color.White)
                        }
                    }
                )
            }
        ) {
            //val iconsThemeDarkIsChecked=if(musicIsChecked) Icons.Filled.Check else Icons.Filled.Close
            Spacer(modifier = Modifier.size(10.dp))
            Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    ){
                Row(
                    modifier = Modifier
                        .padding(10.dp, 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null
                    )
                    Text(text = "Music on / off")
                    Switch(
                        checked = switchmusicChecked,
                        onCheckedChange = {
                            mediaPlayerClient.clickAudio()
                            switchmusicChecked=it
                            isEnabledMusic=!isEnabledMusic
                            PreferenceManager.savePreferenceMusicOnOff(context,isEnabledMusic)
                            //if(!isEnabledMusic) mediaPlayerClient.stopMenuMusic()
                            //else mediaPlayerClient.playMenuMusic()
                        },
                    )
                }



                /*
                Dark mode on / off
                */
                Row (
                    modifier = Modifier
                        .padding(10.dp, 10.dp)
                        .fillMaxWidth(),
                    //Arrangement.SpaceEvenly reparte los elementos dejando espacios en los lados
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null
                    )
                    Text(text = "Theme dark On / Off")
                    Switch(
                        checked = switchThemeDarkChecked,
                        onCheckedChange = {
                            mediaPlayerClient.clickAudio()
                            switchThemeDarkChecked=it
                            isDarkMode=!isDarkMode
                            PreferenceManager.savePreferenceThemeDarkOnOff(context,it)
                        },

                    )
                }


                Texts()
            }


        }
    }//Final de BreedsTheme
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview() {
    BreedsTheme (darkTheme = false){
        //SettingsScreen()
    }
}

@Composable
fun Texts(){
    Spacer(modifier = Modifier.background(Color.Magenta))

    val uriHandler= LocalUriHandler.current
    val webAnnotated= getWebAnnotated()
    val termsAnnotated = getTermsAnnotated()
    val contactAnnotated=getContactAnnotated()
    Column (modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)){
        ClickableText(
            text = webAnnotated,
            onClick = { offset ->
                val uri= webAnnotated.getStringAnnotations(tag = "web", start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en web")
            }
        )
        //Spacer(modifier = Modifier.size(10.dp))
        ClickableText(
            text = termsAnnotated,
            onClick = { offset ->
                val uri=termsAnnotated.getStringAnnotations(tag = "contact",start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en contact")
            }
        )
        //Spacer(modifier = Modifier.size(10.dp))
        ClickableText(
            text = contactAnnotated,
            onClick = { offset ->
                val uri=contactAnnotated.getStringAnnotations(tag = "terms", start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en terminos")
            }
        )
        Text(text = stringResource(id = R.string.settings_description))
    }
}




