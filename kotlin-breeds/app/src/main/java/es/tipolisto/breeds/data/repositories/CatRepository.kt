package es.tipolisto.breeds.data.repositories

import android.util.Log
import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.network.RetrofitClient
import es.tipolisto.breeds.data.providers.CatProvider
import kotlin.random.Random

class CatRepository {
    companion object{

        suspend fun loadCatsAndInsertBuffer() {
            val service= RetrofitClient.getRetrofitService()
            val response=service.getAllCats()
            val listCats=response.body()
            if (listCats != null) CatProvider.listCats=listCats
        }
        suspend fun loadBreedCatsAndInsertBuffer() {
            val service= RetrofitClient.getRetrofitService()
            val response=service.getAllBreedCats()
            val listBreedsCats=response.body()
            if (listBreedsCats != null) CatProvider.listBreedCats=listBreedsCats
        }

        fun getListCatsFromBuffer()=CatProvider.listCats

        fun getList3RandomCatsFromBuffer(): MutableList<CatTL?>{
            var listCats= mutableListOf<CatTL?>()
            if(!CatProvider.listCats.isEmpty()){
                //Obtenemos los 3 números aleatorios diferentes
                val setRandom= mutableSetOf<String>()
                //Como los et no pueden tener repetidos los metemos en un set
                while (setRandom.size<3){
                    var i=Random.nextInt(CatProvider.listCats.size)
                    if(!setRandom.contains(CatProvider.listCats[i].breed_id)){
                        setRandom.add(CatProvider.listCats[i].breed_id)
                        listCats.add(CatProvider.listCats[i])
                    }
                    listCats.forEach {
                        if(it?.breed_id=="") {
                            Log.d("TAG", "CatRepository: Hay un gato sin raza")
                        }
                    }
                }
            }else{
                Log.d("TAG3", "la lista esta vacia")
            }
            return listCats
        }

        /**
         * devuelve la raza de gato a partir de su breed_id
         * la tabla cats y breed_cat están rellacionadas por el breed_id (en cat) y por el id_name (en breedCat)
         * Solo utilizada en competitionScreen
         */
        fun getBreedCatFromBreedIdFromBuffer(idName: String?):BreedCatTL?{
            var breedCat: BreedCatTL?=null
            CatProvider.listBreedCats.forEach{
                if(it.id_name.equals(idName)) breedCat=it
            }
            return breedCat
        }

        fun getBreedCatByIdFromBuffer(id: Int):BreedCatTL?{
            var breedCat: BreedCatTL?=null
            CatProvider.listBreedCats.forEach{
                val idbreedCat=it.id;
                if(idbreedCat==id) breedCat=it
            }
            return breedCat
        }

        fun getBreedCatNameByIdCat(id:String?):String{
            var name=""
            //Log.d("TAG2", "CatRepository dice: vamos a buscar el nombre del gato con el id: $id")
            CatProvider.listBreedCats.forEach {
                val idCat = it.id_name.trim()
                if (idCat.equals(id))
                    name = it.name_es
            }
            return name
        }
    }//Final del cpompanion object

}