package es.tipolisto.breeds.data.repositories

import android.util.Log
import es.tipolisto.breeds.data.models.dog.BreedDogTL
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.network.RetrofitClient
import es.tipolisto.breeds.data.providers.DogProvider
import kotlin.random.Random

class DogRepository {
    companion object{
        suspend fun loadDogAndInsertBuffer() {
            try {
                val service= RetrofitClient.getRetrofitService()
                val response = service.getListDogs()
                val listBreedsDog = response.body()
                if (listBreedsDog == null) Log.d("TAG", "Lista vacía")
                else {
                    DogProvider.listDogs = listBreedsDog
                }
            //}catch (e:IllegalStateException){
            }catch (e:Exception){
                Log.d("TAG", "loadBreedDogsAndInsertBuffer: "+e.message)
            }

        }
        suspend fun loadBreedDogsAndInsertBuffer() {
            try {
                val service= RetrofitClient.getRetrofitService()
                val response = service.getAllBreedDogs()
                val listBreedsDogs = response.body()
                if (listBreedsDogs != null) DogProvider.listBreedDogs = listBreedsDogs
            //}catch (e:IllegalStateException){
            }catch (e:Exception){
                Log.d("TAG", "loadBreedDogsAndInsertBuffer: "+e.message)
            }



        }
        fun getListDogFromBuffer()=DogProvider.listDogs
        fun getListBreedsDogFromBuffer()=DogProvider.listBreedDogs

        /*fun getRandomListDogsFromBuffer(): MutableList<DogTL?>{
            var listDogs= mutableListOf<DogTL?>()
            //var dog : DogTL?=null
            if(!DogProvider.listDogs.isEmpty()){
                //Obtenemos los 3 números aleatorios diferentes
                val setRandom= mutableSetOf<Int>()
                //Como los et no pueden tener repetidos los metemos en un set
                while (setRandom.size<3){
                    setRandom.add(Random.nextInt(CatProvider.listCats.size))
                }
                for(i in setRandom){
                    listDogs.add(DogProvider.listDogs[i])
                }
            }else{
                Log.d("TAG3", "la lista esta vacia")
            }
            return listDogs
        }*/
        fun get3RandomListDogsFromBuffer(): MutableList<DogTL?>{
            val listDogs= mutableListOf<DogTL?>()
            if(DogProvider.listDogs.isNotEmpty()){
                //Obtenemos los 3 números aleatorios diferentes
                val setRandom= mutableSetOf<String>()
                //Como los et no pueden tener repetidos los metemos en un set
                while (setRandom.size<3){
                    val i=Random.nextInt(30)
                    if(!setRandom.contains(DogProvider.listDogs[i].breed_id)){
                        setRandom.add(DogProvider.listDogs[i].breed_id)
                        listDogs.add(DogProvider.listDogs[i])
                    }
                }
            }else{
                Log.d("TAG3", "la lista esta vacia")
            }
            return listDogs
        }



        /**
         * devuelve la raza de perro a partir de su breed_id
         * la relacción entre la tabla dog y breed_dog es por el breed_id
         * ver:https://breeds.tipolisto.es/sql/estructura&20bd.sql
         */
        fun getBreedDogByBreedIdFromBuffer(breed_id: String?):BreedDogTL?{
            var breedDog: BreedDogTL?=null
            DogProvider.listBreedDogs.forEach{
                val reference=it.breed_id;
                if(breed_id!=null)
                    if(reference.equals(breed_id)) breedDog=it
            }
            return breedDog
        }

        /**
         * Devuelve la raza del perro a partir de su id
         * solo utilziada en el detailScreen
         */
        fun getBreedDogByIdFromBuffer(id: Int?):BreedDogTL?{
            var breedDog: BreedDogTL?=null
            DogProvider.listBreedDogs.forEach{
                val reference=it.id;
                if(reference==id) breedDog=it
            }
            return breedDog
        }

        /**
         * Devuelve la raza deñ perro a partir de su breed_id
         * solo utilizado en el dogViewmodel
         */
        fun getBreedDogNameByBreedIdDog(breed_id:String?):BreedDogTL?{
            var breedDog: BreedDogTL?=null
            DogProvider.listBreedDogs.forEach {
                val idDog = it.breed_id.trim();
                if (idDog.equals(breed_id)) breedDog = it
            }
            return breedDog
        }
        fun getBreedDogNameByBreedId(breedId:String?):String{
            var name=""
            //Log.d("TAG2", "CatRepository dice: vamos a buscar el nombre del gato con el id: $id")
            DogProvider.listBreedDogs.forEach {
                val idDog = it.breed_id.trim()
                if (idDog.equals(breedId))
                    name = it.name_es
            }
            return name
        }

        /*fun getDogFromIdInBuffer(id: String):DogTL?{
            //Log.d("TAG", "Dogrepository dice: getDogFromIdInBuffer vamos a buscar el dog con el id: "+id)
            var dog: DogTL?=null
            DogProvider.listDogs.forEach{
                val reference=it.id;
                //Log.d("TAG", "Dogrepository dice: "+reference.toString())
                if(reference.toString().equals(id)){
                    Log.d("TAG", "Dogrepository dice: getDogFromIdInBuffer, encontrado el dog: "+id)
                    dog=it
                }
            }
            return dog
        }*/
    }//Final del cpompanion object

}