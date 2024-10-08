package es.tipolisto.breeds.ui.views.screens.fish


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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.data.repositories.FishRepository
import es.tipolisto.breeds.ui.components.MyAlertDialogNewRecord
import es.tipolisto.breeds.ui.components.MyCircularProgressIndicator
import es.tipolisto.breeds.ui.components.onBackPressed
import es.tipolisto.breeds.ui.navigation.AppScreens
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.FishViewModel
import es.tipolisto.breeds.ui.viewModels.RecordsViewModel
import es.tipolisto.breeds.utils.AudioEffectsType
import es.tipolisto.breeds.utils.Constants
import es.tipolisto.breeds.utils.MediaPlayerClient


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameFishScreen(navController: NavController, fishViewModel: FishViewModel, recordsViewModel: RecordsViewModel, mediaPlayerClient: MediaPlayerClient){
    val context=LocalContext.current
    val isDarkMode by remember { mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context)) }

    DisposableEffect(Unit) {
        if(PreferenceManager.readPreferenceMusicOnOff(context)){
            mediaPlayerClient.playInGameMusic()
        }
        onDispose {
            mediaPlayerClient.stopInGameMusic()
        }
    }
    LaunchedEffect(key1 = true){
        if(!fishViewModel.justOnce){
            if (fishViewModel.getAllFish().isNotEmpty() && fishViewModel.getAllSpeciesFish().isNotEmpty()) {
                fishViewModel.get3RamdomFish()
                fishViewModel.justOnce = true
            }
        }
    }
    //Conrol del botón atrás
    BackHandler{
        onBackPressed({fishViewModel.initGame()},navController,context)
    }

    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(R.string.fish_species))
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(
                                onClick = {
                                    onBackPressed({fishViewModel.initGame()},navController,context)
                                }
                        ) {
                            Icon( imageVector = Icons.AutoMirrored.Filled.ArrowBack,contentDescription = "Back" )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            if(fishViewModel.getAllSpeciesFish().isEmpty()){
                                Toast.makeText(context,"Empty list", Toast.LENGTH_LONG).show()
                            }else {
                                navController.navigate(AppScreens.ListFishScreen.route)
                            }
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.fish),
                                contentDescription = "Fish list"
                            )
                        }
                    }
                )
            }
        ) {
            if(fishViewModel.getAllFish().isEmpty() || fishViewModel.getAllSpeciesFish().isEmpty()){
                Toast.makeText(context, stringResource(id = R.string.there_was_a_problem_getting_the_data),Toast.LENGTH_LONG).show()
                navController.popBackStack()
                navController.navigate(AppScreens.SplashScreen.route)
            }

            GameFishScreenContent(it, fishViewModel, recordsViewModel,navController, mediaPlayerClient)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameFishScreenPreview() {
    BreedsTheme (darkTheme = false){
        //GameFishScreen()
    }
}



@Composable
fun GameFishScreenContent(paddingsValues:PaddingValues, fishViewModel: FishViewModel, recordsViewModel: RecordsViewModel,navController: NavController, mediaPlayerClient: MediaPlayerClient){
    var showNewRecordDialog by rememberSaveable { mutableStateOf(true) }
    val stateNewRecord: Boolean by recordsViewModel.stateNewrecord.observeAsState(false)
    val context= LocalContext.current
    if(fishViewModel.getAllSpeciesFish().isEmpty())
        navController.navigate(AppScreens.SplashScreen.route)
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(paddingsValues)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally
    ){

        if(fishViewModel.gameOver) {
            recordsViewModel.checkRecord(fishViewModel.state.score)
            if(stateNewRecord) {
                MyAlertDialogNewRecord(
                    stateNewRecord,
                    {
                        showNewRecordDialog = false
                    },
                    { name->
                        if(name.length>30) Toast.makeText(context,"The name must have less than 30 characters",Toast.LENGTH_LONG).show()
                        else if(name.length<3) Toast.makeText(context,"Name too short",Toast.LENGTH_LONG).show()
                        else {
                            recordsViewModel.insertNewRecord(
                                name,
                                fishViewModel.state.score,
                                "fish"
                            )
                            fishViewModel.initGame()
                            navController.popBackStack()
                            navController.navigate(AppScreens.MenuScreen.route)
                        }
                    }
                )
            }else {
                fishViewModel.initGame()
                navController.popBackStack()
                navController.navigate(AppScreens.MenuScreen.route)
            }
        }else {
            FishHud(fishViewModel)
            //Pintamos la imagen del gato activo
            DrawImageFish(fishViewModel)
            if(fishViewModel.stateIsLoading){
                MyCircularProgressIndicator(isDisplayed = true)
            }else
                MyCircularProgressIndicator(isDisplayed = false)
            //Pondreos el resultado a verdadero o falso
            FishTest(fishViewModel, mediaPlayerClient)
        }
    }
}

@Composable
fun FishHud(fishViewModel: FishViewModel){
    val lives=fishViewModel.state.lives.toString()
    val score=fishViewModel.state.score.toString()
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
        Text(text = stringResource(id = R.string.lives), fontSize = 30.sp)
        Text(text = lives, fontSize = 30.sp)
        Text(text = stringResource(R.string.score), fontSize = 30.sp)
        Text(text = score, fontSize = 30.sp)
    }
}
@Composable
fun DrawImageFish(fishViewModel: FishViewModel){
    val fish= fishViewModel.getActiveFish()
    if(fish==null){
       Image(
            painter = painterResource(id = R.drawable.without_image),
            contentDescription = "Splash breeds",
            Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

    }else{
        SubcomposeAsyncImage(
            model = Constants.URL_BASE_IMAGES_TIPOLISTO_ES+fish.path_image,
            contentDescription = "Select a specie",
            loading = {
                CircularProgressIndicator(color = Color.Blue)
            },
            modifier = Modifier
                .size(300.dp, 300.dp)
                .padding(top = 20.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun FishTest(fishViewModel: FishViewModel, mediaPlayerClient:MediaPlayerClient){
    val listFishRandom=fishViewModel.state.listRandomFish
    val correctAnswer=fishViewModel.state.correctAnswer
    //Dibujamos el test
    for (i in 0..<listFishRandom.size) {
        Spacer(modifier = Modifier.size(10.dp))
        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if(!fishViewModel.clickPressed) {
                    fishViewModel.checkCorrectAnswer(i)
                    if (correctAnswer == i) mediaPlayerClient.playSound(AudioEffectsType.typeSuccess)
                    else mediaPlayerClient.playSound(AudioEffectsType.typeFail)
                    fishViewModel.clickPressed = true
                    fishViewModel.get3RamdomFish()
                }
            }
        ) {
            val specieId=fishViewModel.state.listRandomFish[i]?.specie_id
            val specie= FishRepository.getSpecieFishFromSpecieIdInBuffer(specieId)
            val text=(i+1).toString()+")  "+ specie?.name_es+"."
            //if (text.length > 100) text=text.substring(0, 30) + "..."
            if(fishViewModel.clickPressed){
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