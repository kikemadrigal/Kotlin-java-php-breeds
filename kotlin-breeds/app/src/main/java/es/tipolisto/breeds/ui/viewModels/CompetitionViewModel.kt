package es.tipolisto.breeds.ui.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.tipolisto.breeds.data.database.AppDataBaseClient
import es.tipolisto.breeds.data.database.favorites.FavoritesEntity
import es.tipolisto.breeds.data.database.records.RecordDao
import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.fish.FishTL
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.data.providers.CatProvider
import es.tipolisto.breeds.data.repositories.CatRepository
import es.tipolisto.breeds.data.repositories.DogRepository
import es.tipolisto.breeds.data.repositories.FishRepository
import es.tipolisto.breeds.ui.states.CatsScreenState
import es.tipolisto.breeds.ui.states.CompetitionScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.random.Random
import kotlin.random.nextInt

class CompetitionViewModel(private val recordDao:RecordDao): ViewModel() {
    var state by mutableStateOf(CompetitionScreenState())
        private set
    //Para que solo se carga una vez la lista de internet
    var justOnce by mutableStateOf(false)
    //Para la barra de progreso
    var stateIsloading by mutableStateOf(false)
    var gameOver by mutableStateOf(false)
        private set
    var clickPressed by mutableStateOf(false)


    /*suspend fun loadAndInsertBuffer(){
        stateIsloading=true
        CatRepository.loadCatsAndInsertBuffer()
        gameOver=false
        stateIsloading=false
    }*/
    fun initGame() {
        gameOver=false
        state.lives=7
        state.score=0
    }

    fun getAllBreedsCats():List<BreedCatTL>{
        return CatProvider.listBreedCats
    }
    fun get3Ramdom(){
        viewModelScope.launch {
            if (clickPressed)delay(2000)
            //Seleccionamos la lista que vamos a utilizar
            state.listSelected = Random.nextInt(0..2)
            when(state.listSelected){
                0->{
                    val listRandomCats= CatRepository.getListRandomCatsFromBuffer()
                    state=state.copy(listRandomCats=listRandomCats)
                    Log.d("TAG2", "CompetitionViewModel: Cat 1->${CatRepository.getBreedCatFromBreedIdFromBuffer(listRandomCats[0]?.breed_id)?.name_es}")
                    Log.d("TAG2", "CompetitionViewModel: Cat 2->${CatRepository.getBreedCatFromBreedIdFromBuffer(listRandomCats[1]?.breed_id)?.name_es}")
                    Log.d("TAG2", "CompetitionViewModel: Cat 3->${CatRepository.getBreedCatFromBreedIdFromBuffer(listRandomCats[2]?.breed_id)?.name_es}")
                    Log.d("TAG2", "CompetitionViewModel: El Cat elegido es el ${state.correctAnswer+1}->${CatRepository.getBreedCatFromBreedIdFromBuffer(state.listRandomCats[state.correctAnswer]?.breed_id)?.name_es}")
                }
                1->{
                    val listRandomDogs= DogRepository.getRandomListDogsFromBuffer()
                    state=state.copy(listRandomDogs=listRandomDogs)
                    Log.d("TAG2", "DogViewModel: dog 1->${DogRepository.getBreedDogNameByBreedIdDog(listRandomDogs[0]?.breed_id)?.name_es}")
                    Log.d("TAG2", "DogViewModel: dog 2->${DogRepository.getBreedDogNameByBreedIdDog(listRandomDogs[1]?.breed_id)?.name_es}")
                    Log.d("TAG2", "DogViewModel: dog 3->${DogRepository.getBreedDogNameByBreedIdDog(listRandomDogs[2]?.breed_id)?.name_es}")
                    Log.d("TAG2", "DogViewModel: El dog elegido es el ${state.correctAnswer+1}->${DogRepository.getBreedDogNameByBreedIdDog(state.listRandomDogs[state.correctAnswer]?.breed_id)?.name_es}")
                }
                2->{
                    val listRandomFish= FishRepository.getRandomListFishFromBuffer()
                    state=state.copy(listRandomFish=listRandomFish)
                    Log.d("TAG2", "FishViewModel: fish 1->${FishRepository.getSpecieFishFromSpecieIdInBuffer(listRandomFish[0]?.specie_id)?.name_es}")
                    Log.d("TAG2", "FishViewModel: fish 2->${FishRepository.getSpecieFishFromSpecieIdInBuffer(listRandomFish[1]?.specie_id)?.name_es}")
                    Log.d("TAG2", "FishViewModel: fish 3->${FishRepository.getSpecieFishFromSpecieIdInBuffer(listRandomFish[2]?.specie_id)?.name_es}")
                    Log.d("TAG2", "FishViewModel: El fish elegido es el ${state.correctAnswer+1}->${FishRepository.getSpecieFishFromSpecieIdInBuffer(state.listRandomFish[state.correctAnswer]?.specie_id)?.name_es}")
                }
            }
            //Seleccionamos una de las respuesta para que sea la correcta
            state.correctAnswer= Random.nextInt(0..2)
            clickPressed=false
        }
    }

    fun getActive():Any?{
        var animal:Any?=null
        when(state.listSelected){
            0->animal=state.listRandomCats[state.correctAnswer]
            1->animal=state.listRandomDogs[state.correctAnswer]
            2->animal=state.listRandomFish[state.correctAnswer]
        }
        return animal
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

    /*fun getNameAnimalById(id:Int):String?{
        var cat:CatTL?=null
        var dog:DogTL?=null
        var fish:FishTL?=null
        var nameAnimal=""
        when(getActive()){
            is CatTL->{
                cat= CatRepository.getBreedCatNameByIdCat(id.toString())
                nameAnimal=animal.
            }
            1->animal= DogRepository.getBreedDogNameByIdDog(id.toString())
            2->animal= FishRepository.getBreedFishNameByIdFish(id.toString())
        }
         return
    }*/
}











