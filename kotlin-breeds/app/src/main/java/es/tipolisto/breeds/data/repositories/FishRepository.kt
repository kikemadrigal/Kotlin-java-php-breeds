package es.tipolisto.breeds.data.repositories

import android.util.Log
import android.widget.GridLayout.Spec
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.fish.Fish
import es.tipolisto.breeds.data.models.fish.FishTL
import es.tipolisto.breeds.data.models.fish.SpecieFishTL
import es.tipolisto.breeds.data.network.RetrofitClient
import es.tipolisto.breeds.data.providers.CatProvider
import es.tipolisto.breeds.data.providers.DogProvider
import es.tipolisto.breeds.data.providers.FishProvider
import kotlin.random.Random


class FishRepository {
    companion object {
        suspend fun loadFishAndInsertBuffer() {
            try {
                val service= RetrofitClient.getRetrofitService()
                val response=service.getAllFish()
                val listFish=response.body()
                if(listFish!=null)
                    FishProvider.listFish=listFish
            }catch (ex: Exception){
                Log.d("TAG", "Excepción en "+ex)
            }


        }
        suspend fun loadSpecieFishAndInsertBuffer() {
            try {
                val service= RetrofitClient.getRetrofitService()
                val response=service.getAllSpecieFish()
                val listSpecieFish=response.body()
                if(listSpecieFish!=null)
                    FishProvider.listSpecieFish=listSpecieFish
            }catch (ex: Exception){
                Log.d("TAG", "Excepción en "+ex)
            }
        }

        fun getListFishFromBuffer()=FishProvider.listFish
        fun getSpecieFishFromBuffer()=FishProvider.listSpecieFish
        /*fun get3RandomListFishFromBuffer(): MutableList<FishTL?>{
            var listFish= mutableListOf<FishTL?>()
            var fish : FishTL?=null
            if(FishProvider.listFish.isNotEmpty()){
                //Obtenemos los 3 números aleatorios diferentes
                val setRandom= mutableSetOf<Int>()
                //Como los et no pueden tener repetidos los metemos en un set
                while (setRandom.size<3){
                    setRandom.add(Random.nextInt(CatProvider.listCats.size))
                }
                for(i in setRandom){
                    listFish.add(FishProvider.listFish[i])
                }
            }else{
                Log.d("TAG3", "la lista esta vacia")
            }
            return listFish
        }*/

        fun get3RandomListFishFromBuffer(): MutableList<FishTL?>{
            var listFish= mutableListOf<FishTL?>()
            if(FishProvider.listFish.isNotEmpty()){
                //Obtenemos los 3 números aleatorios diferentes
                val setRandom= mutableSetOf<Int>()
                //Como los et no pueden tener repetidos los metemos en un set
                while (setRandom.size<3){
                    val i=Random.nextInt(30)
                    if(!setRandom.contains(FishProvider.listFish[i].specie_id)){
                        setRandom.add(FishProvider.listFish[i].specie_id)
                        listFish.add(FishProvider.listFish[i])
                    }
                }
            }else{
                Log.d("TAG3", "la lista esta vacia")
            }
            return listFish
        }

        fun getSpecieFishFromSpecieIdInBuffer(sepecie_id: Int?): SpecieFishTL?{
            //Log.d("TAG", "FishRepository dice: pasa por getFishFromSpecieIdInBuffer con id: "+id)
            var specieFish: SpecieFishTL?=null
            FishProvider.listSpecieFish.forEach{
                if(it.id==sepecie_id) {
                    specieFish=it
                }
            }
            return specieFish
        }
    }//Final del cpompanion object

    /*fun getSpecieNameByIdFish(id:Int):String{
        var name=""
        FishProvider.listSpecieFish.forEach {
            val idFish = it.id;
            if (idFish != null) {
                if (idFish==id) name = it.name_es
            }
        }
        return name
    }*/
}