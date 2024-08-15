package es.tipolisto.breeds.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import es.tipolisto.breeds.data.models.dog.Dog
import es.tipolisto.breeds.data.models.fish.Fish
import es.tipolisto.breeds.utils.Constants
import org.json.JSONException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.scalars.ScalarsConverterFactory


class RetrofitClient{
    companion object{
        fun createRetrofit(baseUrl:String, gson: Gson): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        fun getRetrofitService():IApiService{
            val gson = GsonBuilder()
                .create()
            val retrofit=createRetrofit(Constants.URL_BASE,gson)
            val api = retrofit.create(IApiService::class.java)
            return api
        }
        // .addConverterFactory(ScalarsConverterFactory.create())
        /*fun getRetrofitCatService():ICatApiService{
            val gson = GsonBuilder()
                .create()
            val retrofit=createRetrofit(Constants.URL_BASE,gson)
            return retrofit.create(ICatApiService::class.java)
        }*/
        /*fun getRetroDogService():IDogApiService{
            val gson = GsonBuilder()
                .registerTypeAdapter(Dog::class.java, DogDeserializer())
                .create()
            val retrofit=createRetrofit(Constants.URL_BASE_DOG, gson)
            return retrofit.create(IDogApiService::class.java)
        }*/
        fun getRetrofitFishService():IFishApiService{
            val gson = GsonBuilder()
                .registerTypeAdapter(Fish::class.java, FishDeserializer())
                .create()
            val retrofit=createRetrofit(Constants.URL_BASE_FISH, gson)
            return retrofit.create(IFishApiService::class.java)
        }
    }


}
