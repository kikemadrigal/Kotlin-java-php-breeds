package es.tipolisto.breeds.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.tipolisto.breeds.data.database.favorites.FavoritesDao
import es.tipolisto.breeds.data.database.favorites.FavoritesEntity
import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.models.dog.BreedDogTL
import es.tipolisto.breeds.data.models.dog.Dog
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.fish.Fish
import es.tipolisto.breeds.data.models.fish.FishTL
import es.tipolisto.breeds.data.models.fish.SpecieFishTL
import es.tipolisto.breeds.data.repositories.FavoritesRepository
import es.tipolisto.breeds.ui.states.FavoritesScreenState
import es.tipolisto.breeds.utils.Constants
import java.util.Date


class FavoritesViewModel(private val favoritesDao: FavoritesDao): ViewModel() {
    var state by mutableStateOf(FavoritesScreenState())
        private set
    var stateHeard by mutableStateOf(FavoritesScreenState().stateHeard)
    //var isFavorite by mutableStateOf(false)
    private val _isFavorite= MutableLiveData<Boolean>()
    var isFavorite: LiveData<Boolean> = _isFavorite
    fun getAll():List<FavoritesEntity>{
        val listFavorites=FavoritesRepository.getAll(favoritesDao).toMutableStateList()
        state=state.copy(
            listFavorites=listFavorites
        )
        return listFavorites
    }
    fun getAllCats():List<FavoritesEntity>{
        val listFavorites=FavoritesRepository.getAllOnlyCats(favoritesDao).toMutableStateList()
        state=state.copy(
            listFavorites=listFavorites
        )
        return listFavorites
    }
    fun getAllDogs():List<FavoritesEntity>{
        val listFavorites=FavoritesRepository.getAllOnlyDogs(favoritesDao).toMutableStateList()
        state=state.copy(
            listFavorites=listFavorites
        )
        return listFavorites
    }
    fun getAllFish():List<FavoritesEntity>{
        val listFavorites=FavoritesRepository.getAllOnlyFish(favoritesDao).toMutableStateList()
        state=state.copy(
            listFavorites=listFavorites
        )
        return listFavorites
    }
/*
    @ColumnInfo(name = "idAnimal") val idAnimal: String,
    @ColumnInfo(name = "nameBreed") val nameBreed: String,
    //Puede ser animal: cat, dog o fish
    @ColumnInfo(name = "animal") val animal: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: String
 */

    fun createFavorite(breedCat: BreedCatTL){
        //Creamos el favorito a partir del idBreed
        val favorite=FavoritesEntity(null, breedCat.id.toString(), breedCat.name_es, "Cat", Constants.URL_BASE_IMAGES_TIPOLISTO_ES+breedCat.path_image,breedCat.description_es, Date().toString())
        //val favorite= FavoritesRepository.getById(context,id)
        FavoritesRepository.insert(favoritesDao,favorite)
        //FavoritesRepository.insert(context,favorite)
        //Log.d("TAG","FisViewModel die: preparada el id: "+idBreed+"para añadir a favoritos a "+favorite.toString())
    }
    fun createFavorite(breedDog: BreedDogTL){
        val favorite=FavoritesEntity(null, breedDog.id.toString(), breedDog.name_es, "Dog", Constants.URL_BASE_IMAGES_TIPOLISTO_ES+breedDog.path_image,breedDog.description_es, Date().toString())
        FavoritesRepository.insert(favoritesDao,favorite)
    }
    fun createFavorite(specieFish: SpecieFishTL?){
        if(specieFish!=null){
            val favorite=FavoritesEntity(null, specieFish.id.toString(), specieFish.name_es, "Fish", Constants.URL_BASE_IMAGES_TIPOLISTO_ES+specieFish.path_image,specieFish.description, Date().toString())
            FavoritesRepository.insert(favoritesDao,favorite)
        }
    }

    fun checkIsInFavorites(id:Int){
        _isFavorite.value=false
        _isFavorite.value=FavoritesRepository.isFavorite(favoritesDao,id.toString())
    }
    fun checkIsInFavorites(id:String){
        _isFavorite.value=false
        _isFavorite.value=FavoritesRepository.isFavorite(favoritesDao,id)
    }

    fun setFavorite(isFavorite:Boolean){
        _isFavorite.value=isFavorite
    }


    fun getFavoritesByIdAnimal(idAnimal:Int):List<FavoritesEntity>{
        return FavoritesRepository.getByIdAnimal(favoritesDao,idAnimal.toString())
    }
    fun getFavoritesByIdAnimal(idAnimal:String):List<FavoritesEntity>{
        return FavoritesRepository.getByIdAnimal(favoritesDao,idAnimal)
    }

    fun delete(favoritesEntity: FavoritesEntity) {
        FavoritesRepository.delete(favoritesDao,favoritesEntity)
    }

    fun clickFavorite(){
        _isFavorite.value=!_isFavorite.value!!
    }
}