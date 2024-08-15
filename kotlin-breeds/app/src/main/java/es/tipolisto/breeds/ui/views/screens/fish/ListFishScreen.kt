@file:OptIn(ExperimentalMaterial3Api::class)

package es.tipolisto.breeds.ui.views.screens.fish

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.models.fish.SpecieFishTL
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.FishViewModel
import es.tipolisto.breeds.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListFishScreen(navController:NavController,fishViewModel: FishViewModel) {
    val context= LocalContext.current
    val isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(R.string.fish_list))
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) {
            if(fishViewModel.getAllSpeciesFish().isEmpty()){
                Toast.makeText(context, stringResource(id = R.string.there_was_a_problem_getting_the_data),
                    Toast.LENGTH_LONG).show()
                navController.popBackStack()
                navController.navigate(AppScreens.SplashScreen.route)
            }

            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val datos = fishViewModel.getAllSpeciesFish()
               items(datos) { item ->
                    ListIntemRow(item, navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListFishScreenPreview() {
    BreedsTheme (darkTheme = false){
        //ListFishScreen()
    }
}

//
@Composable
fun ListIntemRow(specie: SpecieFishTL, navController: NavController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable{
                navController.navigate(AppScreens.DetailFishScreen.route + "/${specie.id}")
            },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier=Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FishImage(specie)
            var descrpition=specie.description
            if(descrpition.length>100) descrpition=descrpition.substring(0,100)+"..."
            //Text(text = ""+fish.img_src_set, color= Color.White, fontSize = 20.sp )
            Text(text = specie.name_es, style = MaterialTheme.typography.headlineLarge)
            //Text(text = fish.urlWiki, color= Color.White, fontSize = 20.sp )
            Text(text = descrpition, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun FishImage(specie: SpecieFishTL){
    val url=Constants.URL_BASE_IMAGES_TIPOLISTO_ES+specie.path_image
    val model by remember { mutableStateOf(url) }
    AsyncImage(
        model = model,
        contentDescription = "Select a specie",
        modifier = Modifier
            .size(300.dp, 200.dp)
            .padding(10.dp),
        contentScale = ContentScale.FillWidth
    )
}