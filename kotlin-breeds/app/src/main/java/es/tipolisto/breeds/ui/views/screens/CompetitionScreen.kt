package es.tipolisto.breeds.ui.views.screens




import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.fish.FishTL
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.data.repositories.CatRepository
import es.tipolisto.breeds.data.repositories.DogRepository
import es.tipolisto.breeds.data.repositories.FishRepository
import es.tipolisto.breeds.ui.components.MyAlertDialogNewRecord
import es.tipolisto.breeds.ui.components.MyCircularProgressIndicator
import es.tipolisto.breeds.ui.components.onBackPressed
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.CompetitionViewModel
import es.tipolisto.breeds.ui.viewModels.RecordsViewModel
import es.tipolisto.breeds.utils.AudioEffectsType
import es.tipolisto.breeds.utils.Constants
import es.tipolisto.breeds.utils.MediaPlayerClient



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompetitionScreen(navController: NavController, competitionViewModel:CompetitionViewModel, recordsViewModel: RecordsViewModel, mediaPlayerClient: MediaPlayerClient) {
    val context= LocalContext.current

    //Esto es para que solo se ejecute 1 vez
    LaunchedEffect(key1 = true){
        if (!competitionViewModel.justOnce) {
            if (competitionViewModel.getAllCats().isNotEmpty() &&
                competitionViewModel.getAllDogs().isNotEmpty() &&
                competitionViewModel.getAllBreedsCats().isNotEmpty() &&
                competitionViewModel.getAllBreedsDogs().isNotEmpty() &&
                competitionViewModel.getAllFish().isNotEmpty() ) {
                competitionViewModel.get3Ramdom()
                competitionViewModel.justOnce = true
            }
        }
    }
    //Conrol del botón atrás
    BackHandler{
        onBackPressed({competitionViewModel.initGame()},navController,context)
    }

    val isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}
    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold (
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.Competition))
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon={
                        IconButton(
                            onClick = {
                                onBackPressed({competitionViewModel.initGame()},navController,context)
                            }
                        ){
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,contentDescription = "Back")
                        }
                    }
                )
            }
        ){
            if(competitionViewModel.getAllCats().isEmpty() ||
                competitionViewModel.getAllBreedsCats().isEmpty() ||
                competitionViewModel.getAllDogs().isEmpty() ||
                competitionViewModel.getAllBreedsDogs().isEmpty() ||
                competitionViewModel.getAllFish().isEmpty() ||
                competitionViewModel.getSpecieFish().isEmpty()){
                Toast.makeText(context, stringResource(id = R.string.there_was_a_problem_getting_the_data),Toast.LENGTH_LONG).show()
                navController.popBackStack()
                navController.navigate(AppScreens.SplashScreen.route)
            }
            GameCompetitionScreenContent(it,competitionViewModel,recordsViewModel, navController,mediaPlayerClient)
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameCompetitionScreen() {
    BreedsTheme (darkTheme = false){
        //GameCatScreen()
    }
}

@Composable
fun GameCompetitionScreenContent(paddingsValues:PaddingValues, competitionViewModel: CompetitionViewModel, recordsViewModel: RecordsViewModel, navController: NavController, mediaPlayerClient: MediaPlayerClient){
    var showNewRecordDialog by rememberSaveable { mutableStateOf(true) }
    val stateNewRecord: Boolean by recordsViewModel.stateNewrecord.observeAsState(false)
    val context= LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingsValues)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
        //verticalArrangement = Arrangement.Center
    ){
        if(competitionViewModel.gameOver) {
            recordsViewModel.checkRecord(competitionViewModel.state.score)
            //Obtenemos el record que hay encima
            if(stateNewRecord) {
                MyAlertDialogNewRecord(
                    stateNewRecord,
                    {
                        showNewRecordDialog = false
                    },
                    {
                        name->
                        if(name.length>30) Toast.makeText(context,"The name must have less than 30 characters",Toast.LENGTH_LONG).show()
                        else if(name.length<3) Toast.makeText(context,"Name too short",Toast.LENGTH_LONG).show()
                        else {
                            recordsViewModel.insertNewRecord(
                                name,
                                competitionViewModel.state.score,
                                "mix"
                            )
                            competitionViewModel.initGame()
                            navController.popBackStack()
                            navController.navigate(AppScreens.MenuScreen.route)
                        }
                    }
                )
            }else{
                competitionViewModel.initGame()
                navController.popBackStack()
                navController.navigate(AppScreens.MenuScreen.route)
            }
        }else{
            Hud(competitionViewModel)
            //Pintamos la imagen del gato activo
            DrawImageCompetition(competitionViewModel)
            if(competitionViewModel.stateIsloading){
                MyCircularProgressIndicator(isDisplayed = true)
            }else
                MyCircularProgressIndicator(isDisplayed = false)
            //Pondreos el resultado a verdadero o falso
            CompetitionTest(competitionViewModel, mediaPlayerClient)
        }
    }
}




@Composable
fun Hud(competitionViewModel: CompetitionViewModel){
    val lives=competitionViewModel.state.lives
    val score=competitionViewModel.state.score
    Row (
        modifier= Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(
                1.dp,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.secondary
            ),
        horizontalArrangement = Arrangement.Center
    ){
        //Mira las tipografías aki: https://m3.material.io/styles/typography/type-scale-tokens
        Text(text = stringResource(R.string.lives), style = MaterialTheme.typography.headlineMedium)
        Text(text = lives.toString(), style = MaterialTheme.typography.headlineMedium)
        Text(text = stringResource(R.string.score), style = MaterialTheme.typography.headlineMedium)
        Text(text = score.toString(), style = MaterialTheme.typography.headlineMedium)
    }
}


@Composable
fun DrawImageCompetition(competitionViewModel: CompetitionViewModel){
    //Cuando se ontenga el gato activo se repintará la imagen
    val animalType= competitionViewModel.getActive()
    var path_image=""
    when(animalType){
        is CatTL->path_image=animalType.path_image
        is DogTL->path_image=animalType.path_image
        is FishTL ->path_image=animalType.path_image
    }
    if(path_image == null){
        Image(
            painter = painterResource(id = R.drawable.without_image),
            contentDescription = "Without image",
            Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
    }else{
        competitionViewModel.stateIsloading=true
        SubcomposeAsyncImage(
            model = Constants.URL_BASE_IMAGES_TIPOLISTO_ES+path_image,
            contentDescription = "Select a breed",
            loading = {
                CircularProgressIndicator(color = Color.Blue)
            },
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        competitionViewModel.stateIsloading=false
    }
}

@Composable
fun CompetitionTest(competitionViewModel: CompetitionViewModel, mediaPlayerClient: MediaPlayerClient){
    val context=LocalContext.current
    //val mediaPlayerClient by remember{ mutableStateOf(MediaPlayerClient(context))}
    DisposableEffect(Unit) {
        if(PreferenceManager.readPreferenceMusicOnOff(context)){
            mediaPlayerClient.playInGameMusic()
        }
        onDispose {
            mediaPlayerClient.stopInGameMusic()
        }
    }
    val correctAnswer=competitionViewModel.state.correctAnswer
    when(competitionViewModel.state.listSelected){
         0->FillTestCat(competitionViewModel,correctAnswer,mediaPlayerClient)
         1->FillTestDog(competitionViewModel,correctAnswer,mediaPlayerClient)
         2->FillTestFish(competitionViewModel,correctAnswer,mediaPlayerClient)
    }
}

@Composable
fun FillTestCat(competitionViewModel:CompetitionViewModel, correctAnswer:Int, mediaPlayerClient: MediaPlayerClient){
    for (i in 0..<competitionViewModel.state.listRandomCats.size) {
        Spacer(modifier = Modifier.size(10.dp))
        TextButton(
            modifier=Modifier.fillMaxWidth(),
            onClick = {
                if(!competitionViewModel.clickPressed) {
                    competitionViewModel.checkCorrectAnswer(i)
                    if (correctAnswer == i) mediaPlayerClient.playSound(AudioEffectsType.typeSuccess)
                    else mediaPlayerClient.playSound(AudioEffectsType.typeFail)
                    competitionViewModel.clickPressed = true
                    competitionViewModel.get3Ramdom()
                }
            }
        ){
            val breedCat=competitionViewModel.state.listRandomCats[i]?.breed_id
            val breedCatName=CatRepository.getBreedCatNameByIdCat(breedCat)
            val text=(i+1).toString()+")  "+ breedCatName+"."
            if(competitionViewModel.clickPressed){
                Text(
                    text = text,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color=if(correctAnswer==i)Color.Black else Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier= Modifier
                        .fillMaxWidth()
                        .background(if (correctAnswer == i) Color.Green else Color.Red)
                )
            }else{
                Text(
                    text = text,
                    maxLines = 2,
                    //Esto añade 3 puntos al final para definir que hay más textp
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground ,
                    modifier=Modifier
                        .fillMaxWidth()
                )
            }
        }
    }//fin del for
}

@Composable
fun FillTestDog(competitionViewModel: CompetitionViewModel, correctAnswer:Int, mediaPlayerClient: MediaPlayerClient){
    for (i in 0..<competitionViewModel.state.listRandomDogs.size) {
        Spacer(modifier = Modifier.size(10.dp))
        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                competitionViewModel.checkCorrectAnswer(i)
                if (correctAnswer == i) mediaPlayerClient.playSound(AudioEffectsType.typeSuccess)
                else mediaPlayerClient.playSound(AudioEffectsType.typeFail)
                competitionViewModel.clickPressed=true
                competitionViewModel.get3Ramdom()
            }
        ) {
            val breedDog=competitionViewModel.state.listRandomDogs[i]?.breed_id
            val breedDogName= DogRepository.getBreedDogByBreedIdFromBuffer(breedDog)
            val text=(i+1).toString()+")  "+ breedDogName?.name_es+"."
            if(competitionViewModel.clickPressed){
                Text(
                    text = text,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color=if(correctAnswer==i)Color.Black else Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier= Modifier
                        .fillMaxWidth()
                        .background(if (correctAnswer == i) Color.Green else Color.Red)
                )
            }else{
                Text(
                    text = text,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground ,
                    modifier=Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun FillTestFish(competitionViewModel: CompetitionViewModel, correctAnswer:Int, mediaPlayerClient: MediaPlayerClient){
    for (i in 0..<competitionViewModel.state.listRandomFish.size) {
        Spacer(modifier = Modifier.size(10.dp))
        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                competitionViewModel.checkCorrectAnswer(i)
                if (correctAnswer == i) mediaPlayerClient.playSound(AudioEffectsType.typeSuccess)
                else mediaPlayerClient.playSound(AudioEffectsType.typeFail)
                competitionViewModel.clickPressed=true
                competitionViewModel.get3Ramdom()
            }
        ) {
            val specieId=competitionViewModel.state.listRandomFish[i]?.specie_id
            val specie= FishRepository.getSpecieFishFromSpecieIdInBuffer(specieId)
            val text=(i+1).toString()+")  "+ specie?.name_es+"."
            if(competitionViewModel.clickPressed){
                Text(
                    text = text,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color=if(correctAnswer==i)Color.Black else Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier= Modifier
                        .fillMaxWidth()
                        .background(if (correctAnswer == i) Color.Green else Color.Red)
                )
            }else{
                Text(
                    text = text,
                    //maxLines = 1,
                    //overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground ,
                    modifier=Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}




