package es.tipolisto.breeds.ui.views.screens

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import coil.compose.AsyncImage

import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.components.SampleSpinner
import es.tipolisto.breeds.ui.components.getRateBeautiesAnnotated
import es.tipolisto.breeds.ui.components.getRegisterAnnotated
import es.tipolisto.breeds.ui.components.getWebAnnotated
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.utils.Constants.Companion.CAMERAX_PERMISSIONS


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeautiesScreen(navController: NavController){
    /*if(!hasREquiredPermission()){
        ActivityCompat.requestPermissions(
            LocalContext.current, CAMERAX_PERMISSIONS,0
        )
    }*/

    val context= LocalContext.current
    var isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}

    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Beauty ranking",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        ) {
            //Spacer(modifier = Modifier.padding(it))
            Beauty(it)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Beauty(it: PaddingValues) {
    //var email by remember {mutableStateOf("")}
    var name by remember {mutableStateOf("")}
    var description by remember {mutableStateOf("")}
    var breed by remember {mutableStateOf("")}
    var family by remember {mutableStateOf("")}
    var year_of_birth by remember {mutableStateOf("")}
    var sex by remember {mutableStateOf("")}
    var address by remember {mutableStateOf("")}

    val options = listOf("Cat", "Dog", "Fish")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    val uriHandler= LocalUriHandler.current
    val rateBeautiesAnnotated= getRateBeautiesAnnotated()
    val registerAnnotated = getRegisterAnnotated()


    var selectedImageUri by remember { mutableStateOf<Uri?>(null)  }
    val singlePhotoPickerLauncher= rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {uri->selectedImageUri=uri}
    )
    Column(
        modifier = Modifier.padding(it).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.you_need_to_register))
        ClickableText(
            text = rateBeautiesAnnotated,
            onClick = { offset ->
                val uri= rateBeautiesAnnotated.getStringAnnotations(tag = "web", start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en web")
            }
        )


        Spacer(modifier = Modifier.size(10.dp))
        ClickableText(
            text = registerAnnotated,
            onClick = { offset ->
                val uri= registerAnnotated.getStringAnnotations(tag = "register", start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en web")
            }
        )
        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = breed,
            onValueChange = { breed = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "breed") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = family,
            onValueChange = { family = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "family") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Description") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = year_of_birth,
            onValueChange = { year_of_birth = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Year of birth") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = sex,
            onValueChange = { sex = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Sex") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = address,
            onValueChange = { address = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )








        if (selectedImageUri==null){
            Image(
                modifier = Modifier.height(300.dp),
                painter = painterResource(id = R.drawable.photo_dog),
                contentDescription = "Photo animal"
            )
        }else{
            AsyncImage(
                model = selectedImageUri,
                contentDescription = null,
                modifier= Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
                )
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Button(
                onClick = { singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                ) },
                modifier=Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(),
                enabled = true
            ) {
                Text(text = "Poner foto")
            }
            Button(
                onClick = { singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                ) },
                modifier=Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(),
                enabled = true
            ) {
                Text(text = "Cámara")
            }

        }
        Row (modifier=Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    /*TODO*/
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(),
                enabled = true
            ) {
                Text(text = "Subir mi belleza")
            }
        }



    }

}//Final de la funcion

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BeautyPreview(){
    val paddingValues=PaddingValues(10.dp)
    Beauty(paddingValues)
}

/*
@Composable
fun hasREquiredPermission():Boolean{
    return CAMERAX_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            LocalContext.current,
            it,
            ) == PackageManager.PERMISSION_GRANTED
    }
}*/









