package es.tipolisto.breeds.ui.views.screens.cats

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.components.RatingBar
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.CatsViewModel
import es.tipolisto.breeds.ui.viewModels.FavoritesViewModel
import es.tipolisto.breeds.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCatScreen(
    navController: NavController,
    catsViewModel: CatsViewModel,
    idCat:Int,
    favoritesViewModel: FavoritesViewModel
){
    val cat = catsViewModel.getBreedCatById(idCat)
    //Le ponemos si está en la lista de favoritos o no
    favoritesViewModel.checkIsInFavorites(cat?.id?:0)
    //val isFavorite=favoritesViewModel.isFavorite
    val isFavorite: Boolean by favoritesViewModel.isFavorite.observeAsState(initial = false)
    val context= LocalContext.current
    val isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.cat_detail))
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector =Icons.AutoMirrored.Filled.ArrowBack,contentDescription = "Back")
                        }
                    },
                    actions = {
                        //Esto es el coración que al pinchar lo agregamos a favoritos, será oscuro si no está en favoritos
                        IconButton(onClick = {
                            if (cat != null) {
                                //Si está en favoritos
                                if (isFavorite){
                                    val list=favoritesViewModel.getFavoritesByIdAnimal(cat.id)
                                    favoritesViewModel.delete(list[0])
                                    Log.d("TAG", "Favorite borrado")
                                    favoritesViewModel.setFavorite(false)
                                //Si no está en la lista de favoritos
                                }else{
                                    favoritesViewModel.createFavorite(cat)
                                    Toast.makeText(context, "Added breed cat to favorites", Toast.LENGTH_LONG)
                                        .show()
                                    Log.d("TAG", "No está en favoritos")
                                    favoritesViewModel.setFavorite(true)
                                }
                            }
                        }) {
                            if(!isFavorite)
                                Image(painter= painterResource(id = R.drawable.favorites_enabled), contentDescription = "Cat list" )
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
            val breedCat = catsViewModel.getBreedCatById(idCat)
            if (breedCat == null) {
                Toast.makeText(context, stringResource(id = R.string.there_was_a_problem_getting_the_data),Toast.LENGTH_LONG).show()
                navController.popBackStack()
                navController.navigate(AppScreens.ListCatsScreen.route)
            }
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
                    modifier=Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    CatImageDetail(breedCat)
                    CatDescriptionDetail(breedCat)
                }
            }
        }//Final del scafold
    }//Final del theme
}

@Composable
private fun getDetail(breedCat: BreedCatTL):String{
    var content: String = breedCat.temperament_es+ "\n"+
            breedCat.origin_es + "\n"+
            breedCat.morphology_es + "\n"+
            breedCat.country_code+ "\n"+
            breedCat.description_es + "\n"
    return content
}

@Composable
fun CatImageDetail(breedCat: BreedCatTL?){
    val url = Constants.Companion.URL_BASE_IMAGES_TIPOLISTO_ES+breedCat?.path_image
    val model by remember { mutableStateOf(url) }
    AsyncImage(
        model = model,
        contentDescription = "Image act",
        modifier = Modifier
            .size(300.dp, 200.dp),
        contentScale = ContentScale.Fit
    )
}
@Composable
fun createLink(text:String){
    val webAnnotatedString = buildAnnotatedString {
        append("Web: ")
        pushStringAnnotation(tag = "Wikipedia", annotation = text)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(text)
        }
        pop()
    }
    ClickableText(
        text = webAnnotatedString,
        style = MaterialTheme.typography.bodyLarge,
        onClick = { offset ->
            webAnnotatedString.getStringAnnotations(tag = "Wikipedia", start = 0, end = webAnnotatedString.length)
            Log.d("TAG","Click")
        }
    )
}

@Composable
fun CatDescriptionDetail(breedCat: BreedCatTL?){
    if (breedCat != null) {
        Text( text = breedCat.name + ".", style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center, modifier=Modifier.fillMaxWidth())
        Text( text = getDetail(breedCat = breedCat) + ".", style = MaterialTheme.typography.bodyMedium)
        Text(text = breedCat.wikipedia_url + ".")
        createLink(breedCat.wikipedia_url)
        Spacer(modifier = Modifier.size(10.dp))
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            //Con modifier.wight le decimos que vamos a tener 2 huecos a reparti con 1f le decimos que uno cada uno
            Text(text = stringResource(id = R.string.cat_indoor), modifier=Modifier.weight(1f))
            RatingBar(breedCat.indoor.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row(modifier=Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.cat_adaptability), modifier=Modifier.weight(1f))
            RatingBar(breedCat.adaptability.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row(modifier=Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.cat_affection_level), modifier=Modifier.weight(1f))
            RatingBar( breedCat.affection_level.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row(modifier=Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.cat_child_friendly), modifier=Modifier.weight(1f))
            RatingBar(  breedCat.child_friendly.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row(modifier=Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.cat_cat_friendly), modifier=Modifier.weight(1f))
            RatingBar(breedCat.cat_friendly.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_dog_friendly), modifier=Modifier.weight(1f))
            RatingBar(breedCat.dog_friendly.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_energy_level), modifier=Modifier.weight(1f))
            RatingBar(breedCat.energy_level.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_grooming), modifier=Modifier.weight(1f))
            RatingBar(breedCat.grooming.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_health_issues), modifier=Modifier.weight(1f))
            RatingBar(  breedCat.health_issues.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp) )
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_intelligence), modifier=Modifier.weight(1f))
            RatingBar(breedCat.intelligence.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row(modifier=Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.cat_shedding_level), modifier=Modifier.weight(1f))
            RatingBar(  breedCat.shedding_level.toFloat() , modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_social_needs), modifier=Modifier.weight(1f))
            RatingBar(breedCat.social_needs.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row(modifier=Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.cat_stranger_friendly), modifier=Modifier.weight(1f))
            RatingBar( breedCat.stranger_friendly.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp) )
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_vocalisation), modifier=Modifier.weight(1f))
            RatingBar(breedCat.vocalisation.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_experimental), modifier=Modifier.weight(1f))
            RatingBar(breedCat.experimental.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_suppressed_tail), modifier=Modifier.weight(1f))
            RatingBar(  breedCat.suppressed_tail.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
        Row (modifier=Modifier.fillMaxWidth()){
            Text(text = stringResource(id = R.string.cat_short_legs), modifier=Modifier.weight(1f))
            RatingBar(breedCat.short_legs.toFloat(), modifier= Modifier
                .weight(1f)
                .size(30.dp))
        }
    }
}
