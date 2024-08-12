package es.tipolisto.breeds.data.repositories

import android.util.Log
import es.tipolisto.breeds.data.models.animal.Animal
import es.tipolisto.breeds.data.network.RetrofitClient

class BeautyRepository {
    companion object{
        suspend fun checkExistImage(nameUser:String,animal: Animal?):String? {
            val service= RetrofitClient.getRetrofitService()
            var message:String?=""
            if(animal!=null) {
                val response = service.checkImageBeauty(
                    nameUser,
                    animal.name
                )
                message= response.body()
                Log.d("TAG","BeautyRepository dice: mensaje: $message")
                // Log.d("TAG","BeautyRepository dice: vamos a insertar en internet $nameUser y ${animal.toString()}")
            }
            return message
        }

        suspend fun insertBeautyOnInternet(nameUser:String,animal: Animal?):String? {
            val service= RetrofitClient.getRetrofitService()
            var message:String?=""
            if(animal!=null) {
                val response = service.saveBeauty(
                    nameUser,
                    animal.name,
                    animal.type,
                    animal.breed,
                    animal.family,
                    animal.description,
                    animal.year_of_birth,
                    animal.sex,
                    animal.address,
                    animal.image
                )
                message= response.body()
                Log.d("TAG","BeautyRepository dice: mensaje: $message")
               // Log.d("TAG","BeautyRepository dice: vamos a insertar en internet $nameUser y ${animal.toString()}")
            }
            return message
        }
    }
}
