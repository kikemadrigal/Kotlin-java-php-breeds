package es.tipolisto.breeds.data.network;

import java.util.List;


import es.tipolisto.breeds.data.model.BreedsDog;
import es.tipolisto.breeds.data.model.Dog;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IDogApi {

    //API1 Web: https://www.thedogapi.com/ Url base: https://api.thedogapi.com/v1/ api_key=dc1e51b2-d3e2-4f59-89a6-0a67fba096ac
    //-------------------------------------------------------------------------------------------------------------------------

    //api_key=live_j5vqrzrFkOhf1AsiXwprmdoKWyTqokjM3hFVZ4cIOU0AKwM01F7FUxlZn1ppN3JZ
    //Listar todas las razas: https://api.thedogapi.com/v1/breeds
    //Listar todas las razas con un límite= https://api.thedogapi.com/v1/images/search?limit=100&order=Desc
    //Obtener datos raza sin imagen según el nombre de una raza: https://api.thedogapi.com/v1/breeds/search?name=Akita
    //Obtener id, url, width y height según el nombre de la raza: https://api.thedogapi.com/v1/images/search?breed_name=beng
    //Obtener una imagen aleatoria: https://api.thedogapi.com/v1/images/search

    //https://api.thedogapi.com/v1/images/search
    //Devuelve un objeto aleatorio de tipo list<DogResponse>
    @GET("images/search")
    Call<List<Dog>> getDog();


    //Devuelve la raza de perro que corresponde al id pasado en la Url
    //https://api.thedogapi.com/v1/images/search?bree_id=HJ7Pzg5EQ
    @GET("images/search")
    Call<List<Dog>> getDataDogBreedById(@Query("breed_id") String breed_id);

    //Devuelve la raza de perro que corresponde al nombre pasado en la Url
    //https://api.thedogapi.com/v1/images/search?bree_id=HJ7Pzg5EQ
    @GET("images/search")
    Call<List<Dog>> getDataDogBreedByName(@Query("name") String name);

    //Devuelve un listado aleatorio de perros: https://api.thedogapi.com/v1/images/search?limit=100&order=Desc
    @GET("images/search?limit=100&order=Desc")
    Call<List<Dog>> getListDog();


    //Devuelve el listado completo de razas: https://api.thedogapi.com/v1/breeds
    @GET("breeds")
    Call<List<BreedsDog>> getListBreedDog();


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
