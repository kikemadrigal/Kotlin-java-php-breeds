package es.tipolisto.breeds.data.network

import es.tipolisto.breeds.data.models.dog.BreedDogTL
import es.tipolisto.breeds.data.models.dog.Dog
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.dog.ImageDog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IDogApiService {

    @GET("breedDogs.php")
    suspend fun getListBreedsDog():Response<List<BreedDogTL>>

    @GET("dogs.php")
    suspend fun getListDogs():Response<List<DogTL>>

    //Devuelve una imagen de un perro a partir del breed_id
    //https://api.thedogapi.com/v1/images/search?bree_id=HJ7Pzg5EQ
    @GET("images/search")
    suspend fun getDataDogBreedById(@Query("bree_id") reference_image_id:String):Response<List<ImageDog>>








    //Devuelve una imagen de la raza de perro que corresponde al nombre pasado en la Url
    //https://api.thedogapi.com/v1/images/search?bree_id=HJ7Pzg5EQ
    //No se utiliza
    @GET("images/search")
    fun getDataDogBreedByName(@Query("name") name:String):Response<List<Dog>>

    //https://api.thedogapi.com/v1/images/search
    //Devuelve un objeto imagen aleatoria de tipo list<Dog>
    //No se utiliza
    @GET("images/search")
    fun getDog():Response<List<Dog>>







    //                                  API 2:  URL base: https://dog.ceo/api/");
    //------------------------------------------------------------------------------------------------------------------------------

    /*

    //Obtención de una imagen aleatoria, la raza está incluida el el objeto DogREsponse que contiene el path con la URL de la imagen
    //https://dog.ceo/api/breeds/image/random
    @GET("breeds/image/random")
    Call<DogResponseApi2> getDog();

    //Obtención de una imagen aleatoria de una raza concreta
    //https://dog.ceo/api/breed/hound/images/random
    @GET("breed/hound/images/random")
    Call<DogListResponseApi2> getDogByBreeds();

    //Obtención de un objeto que contiene una lista de imágenes de cualquier raza, 100 es el número de imagánes a devolver
    //https://dog.ceo/api/
    @GET("breeds/image/random/100")
    Call<DogListResponseApi2> getListDog();

    //Obtención de un objeto ue contiene una lista de imágenes de una raza concreta y un String con la respuesta
    @GET("breed/hound/images")
    Call<DogListResponseApi2> getListDogByBreeds();


     */

}