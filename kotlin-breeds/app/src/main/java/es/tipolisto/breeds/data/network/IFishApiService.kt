package es.tipolisto.breeds.data.network

import es.tipolisto.breeds.data.models.fish.Fish
import es.tipolisto.breeds.utils.Constants

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface IFishApiService {
    /*
    1- obtenemos una lista de objetos Fish: https://rapidapi.com/myapos--FqlEzvrlv/api/fish-species/
    [
        0:{
            id:1
            name:"Airbreathing catfish"
            url:"https://en.wikipedia.org/wiki/Airbreathing_catfish"
            img_src_set:{
                    1.5x:"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Clarias_batrachus-ZOO.Brno.jpg/330px-Clarias_batrachus-ZOO.Brno.jpg"
                    2x:"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Clarias_batrachus-ZOO.Brno.jpg/440px-Clarias_batrachus-ZOO.Brno.jpg"
            }
            meta:{
                genera:"Bathyclarias, Channallabes, Clariallabes, Clarias, Dinotopterus, Dolichallabes, Encheloclarias, Gymnallabes, Heterobranchus, Horaglanis, Platyallabes, Platyclarias, Pseudotanganikallabes, Tanganikallabes, Uegitglanis, Xenoclarias",
                scientific_classification:{
                    domain:"eukaryota"
                    kingdom:"animalia"
                    phylum:"chordata"
                    class:"actinopterygii"
                    order:"siluriformes"
                    superfamily:"siluroidea"
                    family:"clariidaebonaparte,_1846"
                }
            }

         },
         1:{
            ....
         },
         ....
    ]
     */
    /*
        Modelo de datos de https://breeds.tipolisto.es/api/specieFish.php
        {
            "id": "1",
            "name": "Airbreathing-catfish",
            "name_es": "cláridos o bagres laberintos, Clariidae, Airbreathing-catfish",
            "description": "{\"genera\":\"Bathyclarias - Channallabes - Clariallabes - Clarias - Dinotopterus - Dolichallabes - Encheloclarias - Gymnallabes - Heterobranchus - Horaglanis - Platyallabes - Platyclarias - Pseudotanganikallabes - Tanganikallabes - Uegitglanis - Xenoclarias\" -\"scientific_classification\":{\"phylum\":\"chordata\" -\"domain\":\"eukaryota\" -\"superfamily\":\"siluroidea\" -\"family\":\"clariidaebonaparte -_1846\" -\"kingdom\":\"animalia\" -\"class\":\"actinopterygii\" -\"order\":\"siluriformes\"}}",
            "url_wiki": "https://es.wikipedia.org/wiki/Clariidae",
            "url_image": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Clarias_batrachus-ZOO.Brno.jpg/330px-Clarias_batrachus-ZOO.Brno.jpg",
            "morphology": "En la boca tienen cuatro pares de barbillas. La aleta dorsal se extiende sobre gran parte de la longitud del cuerpo, carece de espinas y tiene más de 30 radios blandos, en unos casos está separada de la aleta caudal y en otras especies unida a ella con aleta caudal redondeada.3?  Las branquias tienen una apertura ancha, pudiendo respirar aire mediante un órgano laberinto que surge de los arcos branquiales; gracias a su respiración aérea algunas especies son capaces de viajar por distancias cortas en tierra (\"bagres andarines\").3?  Algunas especies son excavadoras en el fango, para lo cual tienen ojos pequeños, algunas incluso ciegas, y las aletas pectorales y pélvicas son pequeñas o incluso están ausentes.",
            "habitat": "Se encuentra en ríos y lagos de África, Siria, sur de Turquía y desde las Filipinas hasta Java.",
            "feeding": "Nothing",
            "phylum": "",
            "class": "",
            "orden": "",
            "family": "",
            "genus": "",
            "path_image": "media/images-list-fish/Airbreathing-catfish.jpg",
            "date": "0000-00-00 00:00:00",
            "creator_id": "1"
        },

     */
    /*
    @GET("fishes")
    //@GET("fish/Tarpon")
    @Headers("X-RapidAPI-Key: ${Constants.KEY_API_FISH}" ,"X-RapidAPI-Host: fish-species.p.rapidapi.com")
    suspend fun getAllFish(): Response<List<Fish>>

    @GET("fish/{name}")
    suspend fun getImageFish(@Path("name") name:String): Response<Fish>
    */
}