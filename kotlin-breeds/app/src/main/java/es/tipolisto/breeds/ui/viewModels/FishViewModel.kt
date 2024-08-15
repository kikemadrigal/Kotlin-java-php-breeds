package es.tipolisto.breeds.ui.viewModels

import android.content.Context
import android.util.Log
import android.widget.GridLayout.Spec
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.tipolisto.breeds.data.database.favorites.FavoritesEntity
import es.tipolisto.breeds.data.database.records.RecordDao
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.fish.Fish
import es.tipolisto.breeds.data.models.fish.FishTL
import es.tipolisto.breeds.data.models.fish.SpecieFishTL
import es.tipolisto.breeds.data.providers.CatProvider
import es.tipolisto.breeds.data.providers.FishProvider
import es.tipolisto.breeds.data.repositories.CatRepository
import es.tipolisto.breeds.data.repositories.FavoritesRepository
import es.tipolisto.breeds.data.repositories.FishRepository
import es.tipolisto.breeds.ui.states.FishScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.random.Random
import kotlin.random.nextInt

class FishViewModel(private val recordDao: RecordDao): ViewModel() {
    var state by mutableStateOf(FishScreenState())
        private set
    var justOnce by mutableStateOf(false)
    //var stateIsLoading by mutableStateOf(FishScreenState().isLoading)
    var stateIsLoading by mutableStateOf(false)
    var gameOver by mutableStateOf(false)
        private set
    var clickPressed by mutableStateOf(false)

    fun initGame() {
        gameOver=false
        state.lives=7
        state.score=0
    }

    fun get3RamdomFish(){
        viewModelScope.launch {
            if (clickPressed) delay(2000)
            stateIsLoading=true
            val listRandomFish= FishRepository.get3RandomListFishFromBuffer()
            state=state.copy(
                listRandomFish=listRandomFish
            )
            state.correctAnswer= Random.nextInt(0..2)
            clickPressed=false
            stateIsLoading=false
            Log.d("TAG2", "FishViewModel: fish 1->${FishRepository.getSpecieFishFromSpecieIdInBuffer(listRandomFish[0]?.specie_id)?.name_es}")
            Log.d("TAG2", "FishViewModel: fish 2->${FishRepository.getSpecieFishFromSpecieIdInBuffer(listRandomFish[1]?.specie_id)?.name_es}")
            Log.d("TAG2", "FishViewModel: fish 3->${FishRepository.getSpecieFishFromSpecieIdInBuffer(listRandomFish[2]?.specie_id)?.name_es}")
            Log.d("TAG2", "FishViewModel: El elegido es el ${state.correctAnswer}->${FishRepository.getSpecieFishFromSpecieIdInBuffer(state.listRandomFish[state.correctAnswer]?.specie_id)?.name_es}")
        }
    }



    fun getActiveFish(): FishTL?{
        return state.listRandomFish[state.correctAnswer]
    }


    fun checkCorrectAnswer(answer:Int){
        Log.d("TAG", "GogViewModel: Has pinchado en el radiobutton "+answer)
        if(answer==state.correctAnswer){
            state.score+=10
        }
        else {
            state.lives--
            if(state.lives<=0){

                gameOver=true
            }
        }
    }

    @Composable
    private fun checkRecord() {


    }

    fun getSpecieFishByIdFish(id:Int): SpecieFishTL?{
        Log.d("TAG", "FishViewModel dice: Vamos a ver hay un gato con este breed id "+id)
        return FishRepository.getSpecieFishFromSpecieIdInBuffer(id)
    }
    fun getAllSpeciesFish():List<SpecieFishTL>{
        return FishRepository.getSpecieFishFromBuffer()
    }
    fun getAllFish():List<FishTL>{
        return FishRepository.getListFishFromBuffer()
    }

}