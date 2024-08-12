@file:OptIn(ExperimentalMaterial3Api::class)

package es.tipolisto.breeds.ui.views.screens


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.database.records.RecordEntity
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.components.getRecordsAnnotated
import es.tipolisto.breeds.ui.components.getRegisterAnnotated
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.RecordsViewModel
import es.tipolisto.breeds.utils.Util.Companion.trimString



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordsScreen(recordsViewModel: RecordsViewModel,navController:NavController) {
    val context= LocalContext.current
    val isDarkMode by remember { mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context)) }
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Records")
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon={
                        IconButton(onClick = { navController.popBackStack()}) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,contentDescription = "Back", tint = Color.White)
                        }
                    }
                )
            }
        ) {
            //val context = LocalContext.current
            val listRecords: List<RecordEntity> = recordsViewModel.getFirst20()
            if (listRecords.isEmpty())
                Text(text = stringResource(id = R.string.empty_list))
            else{
                val uriHandler= LocalUriHandler.current
                val registerAnnotated = getRegisterAnnotated()
                val recordsAnnotated = getRecordsAnnotated()
                Column(
                    modifier= Modifier
                        .fillMaxSize()
                        .padding(it),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(
                        onClick = {
                            navController.navigate(AppScreens.LoginScreen.route)
                        },
                        ) {
                        Column{
                            Text(text = stringResource(R.string.upload_to_internet))
                            Spacer(modifier = Modifier.size(2.dp))
                        }
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = stringResource(R.string.you_need_to_register))
                    ClickableText(
                        text = registerAnnotated,
                        onClick = { offset ->
                            val uri= registerAnnotated.getStringAnnotations(tag = "Register", start = offset, end = offset).firstOrNull()?.item
                            if(uri!=null)
                                uriHandler.openUri(uri)
                            Log.d("TAG","Click en register")
                        }
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = stringResource(R.string.records_view_internet_records))
                    Spacer(modifier = Modifier.size(10.dp))
                    ClickableText(
                        text = recordsAnnotated,
                        onClick = { offset ->
                            val uri= recordsAnnotated.getStringAnnotations(tag = "Records", start = offset, end = offset).firstOrNull()?.item
                            if(uri!=null)
                                uriHandler.openUri(uri)
                            Log.d("TAG","Click en web de ver web de records")
                        }
                    )

                    Spacer(modifier = Modifier.size(10.dp))
                    LazyColumn{
                        items(listRecords){
                                item->
                            ListIntemRow(item)
                        }
                    }
                }
            }
        }//Final de scafold
    }//Final de breedsTheme
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecordsScreenPreview() {
    BreedsTheme (darkTheme = false) {
        //ListRecordsScreen()
    }
}


@Composable
fun ListIntemRow(recordEntity: RecordEntity){
    Row(modifier= Modifier
        .padding(10.dp, 5.dp, 10.dp, 5.dp)
        ){
        Text(text = recordEntity.position.toString(),modifier=Modifier.weight(0.5f),style = MaterialTheme.typography.bodyMedium)
        Text(text = recordEntity.score.toString(),modifier=Modifier.weight(1f),style = MaterialTheme.typography.bodyMedium )
        Text(text = recordEntity.name,modifier=Modifier.weight(1f),style = MaterialTheme.typography.bodyMedium)
        Text(text = recordEntity.typeAnimal,modifier=Modifier.weight(1f),style = MaterialTheme.typography.bodyMedium)
        Text(text = trimString(recordEntity.date),modifier=Modifier.weight(1f),style = MaterialTheme.typography.bodySmall)
    }
    Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
}



