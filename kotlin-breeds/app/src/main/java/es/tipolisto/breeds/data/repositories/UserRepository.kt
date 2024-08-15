package es.tipolisto.breeds.data.repositories

import android.util.Log
import es.tipolisto.breeds.data.models.animal.Animal
import es.tipolisto.breeds.data.network.RetrofitClient
import retrofit2.http.Field


class UserRepository {
    companion object{

        suspend fun saveScore(name: String?, password: String?, score: Int):String {
            var message:String?="";
            if(name!=null && password!=null){
                val service= RetrofitClient.getRetrofitService()

                val response=service.saveScore(name, password, score)
                message=response.body()
                Log.d("TAG3", "mensaje: "+message.toString())


            }else{
                Log.d("TAG3", "mensaje: algo es null")
            }
            return message?:"10"
        }
        suspend fun checkUser(name: String?, password: String?):String {
            var message:String?="";
            Log.d("TAG3", "El usuario es $name y la contraseña es $password")
            val service= RetrofitClient.getRetrofitService()
            if(name!=null && password!=null){
                val response=service.checkUser(name, password)
                message=response.body()
                Log.d("TAG3", "mensaje: "+message.toString())
            }else{
                Log.d("TAG3", "mensaje: algo es null")
            }
            return message?:""
        }


/*
        suspend fun saveBeauty(name: String, password:String, animal: Animal) :String? {
           /* @Field("user") name: String,
            @Field("password") password: String,
            @Field("nameBeauty") nameBeauty: String,
            @Field("description") description: String,
            @Field("image") image: String
            */
            var message:String?="";
            val service= RetrofitClient.getRetrofitService()
            val response=service.saveBeauty(animal.name, animal.type, animal.breed, animal.family, animal.description, animal.year_of_birth, animal.sex, animal.address, animal.image)
            message=response.body()
            Log.d("TAG3", message.toString())
            return message
        }*/
    }
}