package es.tipolisto.breeds.data.repositories

import android.util.Log
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



        suspend fun saveBeauty(name: String, password: String, nameBeauty: String, description: String, image: String) :String? {
           /* @Field("user") name: String,
            @Field("password") password: String,
            @Field("nameBeauty") nameBeauty: String,
            @Field("description") description: String,
            @Field("image") image: String
            */
            var message:String?="";
            val service= RetrofitClient.getRetrofitService()
            val response=service.saveBeauty(name, password, nameBeauty, description, image)
            message=response.body()
            Log.d("TAG3", message.toString())
            return message
        }
    }
}