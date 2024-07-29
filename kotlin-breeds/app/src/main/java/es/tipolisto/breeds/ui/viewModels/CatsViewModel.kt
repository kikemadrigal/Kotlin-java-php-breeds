package es.tipolisto.breeds.ui.viewModels


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.tipolisto.breeds.data.database.records.RecordDao
import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.providers.CatProvider
import es.tipolisto.breeds.data.repositories.CatRepository
import es.tipolisto.breeds.ui.states.CatsScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt


class CatsViewModel(private val recordDao:RecordDao): ViewModel() {
    var state by mutableStateOf(CatsScreenState())
        private set
    //Para que solo se carga una vez la lista de internet
    var justOnce by mutableStateOf(false)
    //Para la barra de progreso
    var stateIsloading by mutableStateOf(false)
    var gameOver by mutableStateOf(false)
        private set
    var clickPressed by mutableStateOf(false)

    fun initGame() {
        gameOver=false
        state.lives=5
        state.score=0
    }

    fun getAllBreedsCats():List<BreedCatTL>{
        return CatProvider.listBreedCats
    }

    /**
     * Este método asigna los valores a state.listRandomCats y a state.correctAnswer
     * Es llamado al iniciar el viewModel y cuando se pulsa una de las tres opciones
     */
    fun get3RamdomCats(){
        viewModelScope.launch {
            if (clickPressed)delay(2000)
            val listRandomCats= CatRepository.getListRandomCatsFromBuffer()
            state=state.copy(
                listRandomCats=listRandomCats
            )
            //Seleccionamos una de las respuesta para que sea la correcta
            state.correctAnswer= Random.nextInt(0..2)
            clickPressed=false

            Log.d("TAG2", "CatViewModel: Cat 1->${CatRepository.getBreedCatNameByIdCat(listRandomCats[0]?.breed_id)}")
            Log.d("TAG2", "CatViewModel: Cat 2->${CatRepository.getBreedCatNameByIdCat(listRandomCats[1]?.breed_id)}")
            Log.d("TAG2", "CatViewModel: Cat 3->${CatRepository.getBreedCatNameByIdCat(listRandomCats[2]?.breed_id)}")
            Log.d("TAG2", "CatViewModel: El elegido es el ${state.correctAnswer}->${state.listRandomCats[state.correctAnswer]?.breed_id}")
        }
    }
    //getActiveCat:Solo usada para obtener la imagen
    fun getActiveCat(): CatTL?{
         return state.listRandomCats[state.correctAnswer]
    }

    fun checkCorrectAnswer(checkResponse:Int){
        if(checkResponse==state.correctAnswer){
            state.score+=10
        }
        else {
            state.lives--
            if(state.lives<=0){
                gameOver=true
            }
        }
    }

    fun getBreedCatById(id:Int):BreedCatTL?{
        return CatRepository.getBreedCatByIdFromBuffer(id)
    }
}











