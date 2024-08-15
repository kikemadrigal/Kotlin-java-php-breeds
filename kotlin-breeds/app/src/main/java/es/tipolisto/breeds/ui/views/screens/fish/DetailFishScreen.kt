package es.tipolisto.breeds.ui.views.screens.fish

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.FavoritesViewModel
import es.tipolisto.breeds.ui.viewModels.FishViewModel
import es.tipolisto.breeds.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailFishScreen(
    navController: NavController,
    fishViewModel: FishViewModel,
    id:Int,
    favoritesViewModel: FavoritesViewModel
){

    val specieFish = fishViewModel.getSpecieFishByIdFish(id)
    if (specieFish == null) navController.navigate(AppScreens.ListFishScreen.route)
    val context= LocalContext.current
    favoritesViewModel.checkIsInFavorites(specieFish?.id.toString())
    Log.d("TAG","DeltailFishScreen dice: el pez es favorito? "+favoritesViewModel.isFavorite.value)
    val isFavorite: Boolean by favoritesViewModel.isFavorite.observeAsState(initial = false)
    val isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(R.string.fish_detail))
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                if (isFavorite){
                                    val list=favoritesViewModel.getFavoritesByIdAnimal(specieFish?.id.toString())
                                    if(list!=null)
                                        favoritesViewModel.delete(list[0])
                                    favoritesViewModel.setFavorite(false)
                                    //Si no está en la lista de favoritos
                                }else{
                                    favoritesViewModel.createFavorite(specieFish)
                                    Toast.makeText(context, "Added specie fish to favorites", Toast.LENGTH_LONG)
                                        .show()
                                    favoritesViewModel.setFavorite(true)
                                }
                            }
                        ) {
                            if (!isFavorite)
                                Image( painter = painterResource(id=R.drawable.favorites_enabled),contentDescription = "")

                        }
                        IconButton(onClick = {
                            navController.navigate(AppScreens.FavoritesScreen.route)
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.favorite_list),
                                contentDescription = "Cat list"
                            )
                        }
                    }
                )
            }
        ) {
            val specieFish = fishViewModel.getSpecieFishByIdFish(id)
            if(specieFish==null){
                Toast.makeText(context, stringResource(id = R.string.there_was_a_problem_getting_the_data),Toast.LENGTH_LONG).show()
                navController.popBackStack()
                navController.navigate(AppScreens.ListFishScreen.route)
            }
            val url = Constants.URL_BASE_IMAGES_TIPOLISTO_ES+specieFish?.path_image
            val model by remember { mutableStateOf(url) }
            Card(
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState()),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ){
                Column(
                    modifier=Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = model,
                        contentDescription = "Specie fish",
                        modifier = Modifier
                            .size(400.dp, 300.dp),
                        contentScale = ContentScale.Fit
                    )

                    Text(text = specieFish?.name_es+"", textAlign = TextAlign.Center)
                    Text(text = specieFish?.description + "", style = MaterialTheme.typography.bodyMedium)
                    Text(text = specieFish?.morphology + "", style = MaterialTheme.typography.bodyMedium)
                    Text(text = specieFish?.habitat + "", style = MaterialTheme.typography.bodyMedium)
                    Text(text = specieFish?.feeding + "", style = MaterialTheme.typography.bodyMedium)
                //Text(text = fish.meta + "", style = MaterialTheme.typography.bodyMedium)

                }//Final del column
            }//Final del card
        }//Fin scafold
    }//fin theme
}


