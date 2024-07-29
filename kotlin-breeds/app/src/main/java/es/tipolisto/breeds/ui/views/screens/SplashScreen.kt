package es.tipolisto.breeds.ui.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.invalidateGroupsWithKey
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.repositories.CatRepository
import es.tipolisto.breeds.data.repositories.DogRepository
import es.tipolisto.breeds.data.repositories.FishRepository
import es.tipolisto.breeds.ui.components.MyCircularProgressIndicator
import es.tipolisto.breeds.ui.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController:NavController){
    var status by remember{mutableStateOf("")}

    //MyCircularProgressIndicator(isDisplayed = true)
    LaunchedEffect(key1 = true ){

        status="Chequenado conexión a internet y permisos"

        status="Loading cats from internet"
        CatRepository.loadCatsAndInsertBuffer()
        status="Loading breeds cats from internet"
        CatRepository.loadBreedCatsAndInsertBuffer()
        status="Loading dogs from internet"
        DogRepository.loadDogAndInsertBuffer()
        status="Loading breeds dogs from internet"
        DogRepository.loadBreedDogsAndInsertBuffer()
        status="Loading fish"
        FishRepository.loadFishAndInsertBuffer()
        status="Loading species"
        FishRepository.loadSpecieFishAndInsertBuffer()

        //Antes de navegar limpiamos la pila de ventanas para que no vuelva a salir el splash
        navController.popBackStack()
        navController.navigate(AppScreens.MenuScreen.route)
    }
    Splash(status)
}
@Composable
fun Splash(status:String){
    Column (modifier = Modifier.padding(0.dp)){
        Text(
            text = status,
            Modifier.background(color = Color.Blue)
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.splash_screen),
            contentDescription = "Splash breeds",
            Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview(){
    Splash(status = "Loading")
}



