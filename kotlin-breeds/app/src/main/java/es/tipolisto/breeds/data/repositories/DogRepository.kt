package es.tipolisto.breeds.data.repositories

import android.util.Log
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.dog.Dog
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.dog.ImageDog
import es.tipolisto.breeds.data.network.RetrofitClient
import es.tipolisto.breeds.data.providers.CatProvider
import es.tipolisto.breeds.data.providers.DogProvider
import kotlin.random.Random

class DogRepository {
    companion object{
        suspend fun loadDogAndInsertBuffer() {
            val service= RetrofitClient.getRetrofitService()
            val response=service.getListDogs()
            val listBreedsDog =response.body()
            if(listBreedsDog!!.isEmpty()) Log.d("TAG", "Lista vacía")
            else{
                DogProvider.listDogs=listBreedsDog
            }
        }

        fun getListDogFromBuffer()=DogProvider.listDogs

        fun getRandomDogFromBuffer(restricted:List<DogTL?>): DogTL?{
            var dog : DogTL?=null
            if(!DogProvider.listDogs.isEmpty()){
                val random = Random.nextInt(DogProvider.listDogs.size)
                Log.d("TAG3", "DogRepository dice: el random es: "+random.toString())
                dog=DogProvider.listDogs[random]
                Log.d("TAG3", "DogRepository dice: el random es: "+dog.toString())
                for(i in restricted){
                    if(dog.name.equals(i?.name)) {
                        getRandomDogFromBuffer(restricted)
                    }
                }
            }else{
                Log.d("TAG3", "la lista esta vacia")
            }
            return dog
        }

        fun getDogFromBreedIdInBuffer(referenceBreedId: String):DogTL?{
            var dog: DogTL?=null
            DogProvider.listDogs.forEach{
                val reference=it.breed_id;
                if(reference!=null ){
                  if(reference.equals(referenceBreedId)) dog=it
                }

            }
            return dog
        }

        fun getDogFromIdInBuffer(id: String):DogTL?{
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
        }
    }//Final del cpompanion object

}