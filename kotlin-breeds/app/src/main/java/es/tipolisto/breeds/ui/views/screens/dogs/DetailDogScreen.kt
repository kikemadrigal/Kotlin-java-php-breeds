package es.tipolisto.breeds.ui.views.screens.dogs

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.models.dog.BreedDogTL
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.components.MiAlertDialog
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.DogsViewModel
import es.tipolisto.breeds.ui.viewModels.FavoritesViewModel
import es.tipolisto.breeds.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailDogScreen(
    navController: NavController,
    dogsViewModel: DogsViewModel,
    id:Int,
    favoritesViewModel: FavoritesViewModel
){
    val breedDog = dogsViewModel.getBreedDogById(id)
    favoritesViewModel.checkIsInFavorites(breedDog?.id.toString())
    val isFavorite: Boolean by favoritesViewModel.isFavorite.observeAsState(initial = false)
    val context= LocalContext.current
    val isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(R.string.dog_detail), color = Color.White, fontWeight = FontWeight.Bold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon( imageVector = Icons.AutoMirrored.Filled.ArrowBack,contentDescription = "Back" )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                           if (breedDog != null) {
                               if (isFavorite){
                                   val list=favoritesViewModel.getFavoritesByIdAnimal(breedDog.id.toString())
                                   favoritesViewModel.delete(list[0])
                                   favoritesViewModel.setFavorite(false)
                               //Si no está en la lista de favoritos
                               }else{
                                   favoritesViewModel.createFavorite(breedDog)
                                   Toast.makeText(context, "Added breed dog to favorites", Toast.LENGTH_LONG)
                                       .show()
                                   favoritesViewModel.setFavorite(true)
                               }
                           }
                        }) {
                            if(!isFavorite)
                                Image(  painter = painterResource(id = R.drawable.favorites_enabled), contentDescription = "")
                        }
                        IconButton(onClick = {
                            navController.navigate(AppScreens.FavoritesScreen.route)
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.favorite_list),
                                contentDescription = "breedDog list"
                            )
                        }
                    }
                )
            }
        ) {
            val breedDog = dogsViewModel.getBreedDogById(id)
            if (breedDog == null) {
                Toast.makeText(context, stringResource(id = R.string.there_was_a_problem_getting_the_data),Toast.LENGTH_LONG).show()
                navController.popBackStack()
                navController.navigate(AppScreens.ListDogsScreen.route)
            }
            val url=breedDog?.path_image
            val model by remember { mutableStateOf(url) }
            Card(
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState()),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier=Modifier
                        .padding(20.dp),
                ) {
                    AsyncImage(
                        model = Constants.Companion.URL_BASE_IMAGES_TIPOLISTO_ES+model,
                        contentDescription = "Image breedDog",
                        modifier = Modifier
                            .size(300.dp, 200.dp),
                        contentScale = ContentScale.Fit
                    )
                    if (breedDog != null) {
                        Text(
                            text = breedDog.name_es,
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = getDetailDog(breedDog) + "",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }//Final del column
            }//Final del card
        }//Final del scafold
    }//Final del theme
}
@Composable
fun DetailDogScreenContent(it:PaddingValues, breedDog: BreedDogTL){
    Column(modifier = Modifier.padding(20.dp)){

    }
}

@Composable
private fun getDetailDog(breedDog: BreedDogTL):String{
    var content=stringResource(id = R.string.dog_description)+": "+ breedDog.description_es + "\n"+
        stringResource(id = R.string.dog_bred_for)+": "+ breedDog.bred_for_es + "\n"+
        stringResource(id = R.string.dog_breed_group)+": "+breedDog.breed_group_es+ "\n"+
        stringResource(id = R.string.dog_life_span)+": "+breedDog.life_span + "\n" +
        stringResource(id = R.string.dog_temperament)+": "+breedDog.temperament_es + "\n" +
        stringResource(id = R.string.dog_origin)+": "+breedDog.origin_es + "\n"+
        stringResource(id = R.string.dog_morphology)+": "+breedDog.morphology_es + "\n"+
        stringResource(id = R.string.dog_weight)+": "+breedDog.weight + "\n"+
        stringResource(id = R.string.dog_height)+": "+breedDog.height + "\n"
    return content
}

