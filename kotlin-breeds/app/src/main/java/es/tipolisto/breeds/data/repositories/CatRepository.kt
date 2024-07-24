package es.tipolisto.breeds.data.repositories

import android.util.Log
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.network.RetrofitClient
import es.tipolisto.breeds.data.providers.CatProvider
import kotlin.random.Random

class CatRepository {
    companion object{

        /*suspend fun loadCatsAndInsertBuffer() {
            val service= RetrofitClient.getRetrofitCatService()
            val response=service.getAllBreeds()
            val listBreedsCats=response.body()
            if(listBreedsCats!!.isEmpty()) Log.d("TAG", "Lista vacía")
            else{
                listBreedsCats.forEachIndexed {index, cat->
                    if(cat.reference_image_id!=null){
                        val responseImageCat=service.getImageCat(cat.reference_image_id)
                        val imageCat=responseImageCat.body()
                        if(imageCat!=null)
                            listBreedsCats.get(index).image= imageCat
                    }
                }
                CatProvider.listCats=listBreedsCats
            }
        }*/
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

        fun getRandomCatFromBuffer(restricted:List<CatTL?>): CatTL?{
            var cat : CatTL?=null
            if(!CatProvider.listCats.isEmpty()){
                val random = Random.nextInt(CatProvider.listCats.size)
                Log.d("TAG3", "CatRepository dice: el random es: "+random.toString())
                cat=CatProvider.listCats[random]
                Log.d("TAG3", "CatRepository dice: el random es: "+cat.toString())
                for(i in restricted){
                    if(cat.name.equals(i?.name)) {
                        getRandomCatFromBuffer(restricted)
                    }
                }
            }else{
                Log.d("TAG3", "la lista esta vacia")
            }
            return cat
        }

        /*fun getCatFromIdImageCatInBuffer(referenceImageId: String):Cat?{
            var cat: Cat?=null
            CatProvider.listCats.forEach{
                val reference=it.reference_image_id;
                if(reference!=null ){
                  if(reference.equals(referenceImageId)) cat=it
                }

            }
            return cat
        }*/

        fun getCatFromIdFromBuffer(id: Int):CatTL?{
            var cat: CatTL?=null
            CatProvider.listCats.forEach{
                val idCat=it.id;
                if(idCat!=null ){
                    if(idCat==id) cat=it
                }
            }
            return cat
        }

        fun getBreedCatNameByIdCat(id:String?):String{
            var name=""
            CatProvider.listBreedCats.forEach {
                val idCat = it.id_name;
                if (idCat != null) {
                    if (idCat.equals(id)) name = it.name_es
                }
            }
            return name
        }
    }//Final del cpompanion object

}