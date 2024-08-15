@file:OptIn(ExperimentalMaterial3Api::class)

package es.tipolisto.breeds.ui.views.screens.cats


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
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.setValue
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
import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.CatsViewModel
import es.tipolisto.breeds.utils.Constants


@Composable
fun ListCatsScreen(navController:NavController,catsViewModel:CatsViewModel) {
    val context= LocalContext.current
    val isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.cat_list))
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon( imageVector = Icons.AutoMirrored.Filled.ArrowBack,contentDescription = "Back")
                        }
                    }
                )
            }
        ) {
            if(catsViewModel.getAllBreedsCats().isEmpty()){
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
                val datos = catsViewModel.getAllBreedsCats()
                items(datos) { item ->
                    ListIntemRow(item, navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListCatsScreenPreview() {
    BreedsTheme (darkTheme = false){
        //ListCatsScreen()
    }
}


@Composable
fun ListIntemRow(breedCat: BreedCatTL, navController: NavController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable{
                navController.navigate(AppScreens.DetailCatScreen.route + "/${breedCat.id}")
            },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var description_es=breedCat.description_es;
            if(description_es.length>100){
                description_es=description_es.substring(0, 100) + "..."
            }
            CatImage(breedCat = breedCat)
            Text(text = breedCat.name_es, style = MaterialTheme.typography.headlineLarge)
            Text(text = description_es, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun CatImage(breedCat: BreedCatTL){
    //Image(painter= rememberAsyncImagePainter(request="https://loremflickr.com/100/100"), contentDescription = null )
    val url=Constants.URL_BASE_IMAGES_TIPOLISTO_ES+breedCat.path_image
    val model by remember { mutableStateOf(url) }
    AsyncImage(
        model = model,
        contentDescription = "Select a breed",
        modifier = Modifier
            .size(300.dp, 200.dp)
            .padding(10.dp),
        contentScale = ContentScale.FillWidth
    )
}