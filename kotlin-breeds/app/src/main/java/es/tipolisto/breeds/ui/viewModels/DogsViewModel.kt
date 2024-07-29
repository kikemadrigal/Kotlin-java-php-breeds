package es.tipolisto.breeds.ui.viewModels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.tipolisto.breeds.data.database.favorites.FavoritesEntity
import es.tipolisto.breeds.data.database.records.RecordDao
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.dog.BreedDogTL
import es.tipolisto.breeds.data.models.dog.Dog
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.providers.CatProvider
import es.tipolisto.breeds.data.providers.DogProvider
import es.tipolisto.breeds.data.repositories.DogRepository
import es.tipolisto.breeds.data.repositories.FavoritesRepository
import es.tipolisto.breeds.data.repositories.FishRepository
import es.tipolisto.breeds.ui.states.DogScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.random.Random
import kotlin.random.nextInt

class DogsViewModel(private val recordDao: RecordDao): ViewModel() {
    var state by mutableStateOf(DogScreenState())
        private set
    var justOnce by mutableStateOf(false)
    var stateIsLoading by mutableStateOf(false)
    var gameOver by mutableStateOf(false)
        private set
    var clickPressed by mutableStateOf(false)


    fun initGame() {
        gameOver=false
        state.lives=5
        state.score=0
    }
    fun getAllBreedsDogs():List<BreedDogTL>{
        return DogProvider.listBreedDogs
    }

    fun get3RamdomDogs(){
        viewModelScope.launch {
            if (clickPressed) delay(2000)
            val listRandomDogs= DogRepository.getRandomListDogsFromBuffer()
            state=state.copy(
                listRandomDogs=listRandomDogs
            )
            state.correctAnswer= Random.nextInt(0..2)
            clickPressed=false
            Log.d("TAG2", "DogViewModel: dog 0->${DogRepository.getBreedDogNameByBreedIdDog(listRandomDogs[0]?.breed_id)}")
            Log.d("TAG2", "DogViewModel: dog 1->${DogRepository.getBreedDogNameByBreedIdDog(listRandomDogs[1]?.breed_id)}")
            Log.d("TAG2", "DogViewModel: dog 2->${DogRepository.getBreedDogNameByBreedIdDog(listRandomDogs[2]?.breed_id)}")
            Log.d("TAG2", "DogViewModel: El elegido es el ${state.correctAnswer}->${DogRepository.getBreedDogNameByBreedIdDog(state.listRandomDogs[state.correctAnswer]?.breed_id)}")
        }
    }

    fun getActiveDog(): DogTL?{
        return state.listRandomDogs[state.correctAnswer]
    }


    fun checkCorrectAnswer(answer:Int){
        //Log.d("TAG", "GogViewModel: Has pinchado en el radiobutton "+answer)
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

    /**
     * Esta función es solo utilizada en el detailScreen
     */
    fun getBreedDogById(id:Int):BreedDogTL?{
        Log.d("TAG", "DogViewModel dice: Vamos a ver hay un gato con este breed id "+id)
        return DogRepository.getBreedDogByIdFromBuffer(id)
    }

}