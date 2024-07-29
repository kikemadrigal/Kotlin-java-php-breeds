package es.tipolisto.breeds.data.network

import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.models.cat.ImageCat
import es.tipolisto.breeds.data.models.dog.BreedDogTL
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.dog.ImageDog
import es.tipolisto.breeds.data.models.fish.Fish
import es.tipolisto.breeds.data.models.fish.FishTL
import es.tipolisto.breeds.data.models.fish.SpecieFishTL
import es.tipolisto.breeds.utils.Constants
import retrofit2.Call

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {


    /*
   Json de https://breeds.tipolisto.es/api/breedCats.php
   [
       {
       "id": "1",
       "id_name": "abys ",
       "name": "Abyssinian",
       "name_es": "Abyssinian, Abisinio ",
       "cfa_url": "http://cfa.org/Breeds/BreedsAB/Abyssinian.aspx",
       "vetstreet_url": "http://www.vetstreet.com/cats/abyssinian",
       "vcahospitals_url": "https://vcahospitals.com/know-your-pet/cat-breeds/abyssinian",
       "temperament": "\"Active\" - Energetic - Independent - Intelligent - Gentle\r\n",
       "temperament_es": "Activo - Energético - Independiente - Inteligente - Suave\r\n\r\nEste gato tiene, como todos, un carácter único, una mezcla de ternura, curiosidad y fortaleza. Es un animal muy activo que nos exigirá constantemente atención y cariño. Es extremadamente limpio,",
       "origin": "Egypt ",
       "origin_es": "Egipto, Egypt \r\nEl origen del nombre de raza no tiene que ver con el lugar original donde esta se desarrolló, la cual se cree que fue Egipto, sino por el hecho de que el primer \"Abisinio\" exhibido en una exposición en Inglaterra se trajo con la información de haber sido importado desde ese país, Abisinia (hoy Etiopía). En el libro “Cats, Their Points”, escrito por Gordon Staples y publicado en 1874, se encuentra la primera mención sobre un Abisinio. El libro muestra un dibujo de un gato con una capa moteada y ausencia de rayas en las patas, rostro y cuello. Según describe el libro, este gato llamado “Zulu” era propiedad de la Sra. Barrett-Lennard y había llegado a Inglaterra en 1868 con una expedición militar desde Abisinia.2? Debido a la poca fundamentación en informes escritos esta teoría es poco aceptada entre los criadores ingleses, que prefieren inclinarse por la opinión que la raza fue realmente creada entre cruces de varios silvers and browns tabbies con los nativos gatos tickeados de Inglaterra conocidos como “British Bunny”.\r\n\r\nHacia finales del siglo xix la raza ya era conocida y a principios del siglo xx catalogada. Los ingleses fueron quienes comenzaron con la cría sistemática de Abisinios y en un principio se ocuparon de refinarla. En 1909 llegó el primer Abisinio a los Estados Unidos importado de Inglaterra, así comenzó en Norteamérica la cría de la raza, que tardaría tiempo en dar resultados. Hacia fines de la década del 30 fueron importados desde Inglaterra Abisinios de excelente calidad que fundaron la mayoría de los programas de cría americanos actuales.\r\n\r\nHoy en día todas las asociaciones felinas del mundo reconocen esta raza y sus cuatro colores tradicionales (Ruddy, Sorrel, Blue, y Fawn), y algunas también en otros colores menos aceptados. Actualmente en todo el mundo los Abisinios3? constituyen una de las razas más populares en términos de registro de nacimientos y no pueden faltar en los espectáculos donde se pueden admirar ejemplares de excelente calidad.\r\n",
       "morphology": "No",
       "morphology_es": "  Otro rasgo de la mayoría de los Abisinios es que conservan en elevado grado el carácter de cachorros, lo cual significa que mientras muchos felinos manifiestan una mayor madurez y una actitud más adulta en su comportamiento a medida que van creciendo, el Abisinio retiene por así decir ciertas trazas de inmadurez en su personalidad. Se desarrolla física y emocionalmente pero nunca pierde el talante travieso y juguetón que ponía de manifiesto cuando era un atractivo cachorro. Siempre movido por la curiosidad y preparado para participar en cualquier juego, un Abisinio solo tiene la edad que siente y siempre se considera joven de corazón.\r\n\r\nEl aspecto negativo de esta característica viene representado por el hecho de que para un Abisinio, las cortinas y los estantes son objetos que solo se hallan presentes para que pueda distraerse con ellos. Sin embargo, con un poco de adiestramiento, un Abisinio es lo bastante inteligente como para transigir y sobre esta base aceptará el que se nos otorguen algunas concesiones si a cambio proporcionamos todas las otras cosas buenas de la vida que esta raza espera y que resultan apropiadas para su estatus en la jerarquía social del mundo felino.\r\n\r\nLa puntuación TICA para la cabeza de estos Gatos (Abisinio y Somalí, en Adelante AB/SO) es de 35 puntos, conformados así: 10 puntos para el marco de la cabeza; 5 puntos para orejas, 5 para forma del contorno de los ojos, 5 para color de los ojos, 5 para puzzle y 5 para el perfil. Los estándares deseados se presentan a continuación.6?\r\n\r\nForma: De frente (el marco) debe presentar una forma casi triangular sin ser exagerada, pues debe presentar un mentón firme y contornos redondeados. El perfil presenta una forma elíptica casi perfecta, con una pequeña protuberancia al frente, que forma la trompa y que se denomina técnicamente “morro”; la curva de la frente va hacia arriba, luego se proyecta detrás de las orejas y luego desciende, con el ángulo posterior del mentón y luego asciende por la parte delantera de la cara coincidiendo con el pómulo del animal. El morro, que sobresale de esta elipse está formado por un suave puente que termina en una redondeada nariz y el mentón, que se ubica por detrás de la línea perpendicular siguiendo levemente la elipse que forma la cabeza. Esta forma le da al gato, 10 puntos para el estándar TICA.\r\nOrejas: son de base ancha, con extremos redondeados, en donde suele encontrarse un pequeño mechón como en el lince, que se curva desde el eje interior hacia fuera de la cabeza; se encuentran bastante proyectadas hacia delante en posición de alerta; a excepción del mechón referido. Presenta un pelo muy corto, de color preferiblemente blanco, de conformidad con los requerimientos típicos de color; cuando se observan de perfil son profundas; la parte más baja de las orejas se ubica en la línea superior de los ojos, en el primer tercio de la cabeza. Esta forma le da al gato 5 puntos para el estándar TICA.\r\nOjos: con forma de almendra; largos, brillantes y expresivos, rodeados por una línea negra; encima de los ojos, aparece una línea corta oscura, rompiendo la zona clara que va de la nariz hacia lo que sería la ceja; a los lados de cada ojo aparece una línea oscura como si fuera la continuación del párpado superior; el color del ojo puede ser dorado, verde, copper o hazle y se busca que sea lo más profundo y rico posible; no existe relación entre el color del ojo y el del pelaje. Tanto la forma, como el color del ojo otorgan al gato 5 puntos, cada uno, según los estándares TICA.\r\nMorro: Debe fluir suavemente de acuerdo a la cabeza, cuando se ve de frente y de perfil… El Muzzle otorga al gato, 5 puntos para el estándar TICA.\r\nPerfil: No deben presentarse contornos planos y deben mostrarse zonas curvas entre la frente, la nariz y el muzzle. El perfil otorga al gato 5 puntos para el estándar TICA.\r\nCuerpo\r\nLa puntuación TICA para el cuerpo de grupo AB/SO es de 35 puntos, conformados así: 10 puntos para el torso, 10 para las piernas y patas, 5 para la cola, 5 para la estructura ósea y 5 para la musculatura. Los estándares deseados se presentan a continuación.\r\n\r\nTorso: Debe ser de longitud media; liviano y ágil, mostrando una fortaleza muscular bien desarrollada, sin masas de ningún tipo y sólido al tacto; la caja torácica debe ser redondeada sin evidencia de lados planos; el costado trasero debe ser moderadamente arqueado dando la apariencia de que el animal está a punto de saltar. La proporción y el equilibrio son más deseados que la longitud extrema. 10 puntos para este estándar, según TICA.\r\nPiernas: Deben ser proporcionadas, largas y con sus músculos bien marcados; de esta manera, el Gato del grupo AB/SO se para bien lejos del suelo.\r\nPatas: Ovaladas y compactas; cuando se encuentra parado, debe dar la impresión de caminar de puntillas. El conjunto de Piernas y patas, dan al gato un total de 10 puntos para los estándares TICA.\r\n\r\nCola: Debe ser larga y tupida. 5 puntos para este estándar, según TICA.\r\nMusculatura: Fortaleza muscular bien desarrollada; sin apariencia de masas extrañas o bolas de acumulación de grasa; debe sentirse sólido y firme al tacto. Este estándar otorga 5 puntos, según TICA, a esta característica.\r\nPelaje / Color / Patrones\r\nLa puntuación TICA para estas características en el grupo AB/SO es de 30 puntos, conformados así: 10 puntos para la textura, 10 para el patrón o ticking y 10 para el color. Los estándares deseados se presentan a continuación.\r\n\r\nLongitud (AB): En la raza Abisinia, el pelaje debe ser suave al tacto con un brillo lustroso, fino en su textura; con longitud suficiente para acomodar entre cuatro y seis bandas de color, alternado entre oscuros y claros; el pelaje debe caer suavemente cerca del cuerpo; el pelaje encrespado no es deseable; debe ser más largo sobre la columna e irse acortando gradualmente hacia los flancos, las piernas y la cabeza.\r\nLongitud (SO): El pelaje en la raza Somalí, debe ser suave al tacto y ser extremadamente fino en la capa más baja, de las dos que presenta; debe ser semi-largo, excepto cerca de los hombros, donde solo se permite pelo muy corto; es deseable que el pelo de la cola sea lo más denso posible; igualmente es deseable el ruff y breeches. En el grupo AB/SO, la textura da al gato 10 puntos para el estándar TICA.\r\nPatrón: El patrón del pelaje es una característica genética a la que se le conoce como ticking, con colores oscuros intercalados con bandas de colores claros, los que dan un efecto traslúcido. Esta característica otorga 10 puntos, para el estándar TICA.\r\nColor: En cuanto a esta característica, existen para el grupo AB/SO, dos divisiones según TICA: La Tabby y la Silver/Smoke; Los Gatos Abisinios y Somalíes en la división Tabby, presentan colores cálidos, dando la impresión de un gato muy colorido. Se prefiere la fortaleza y la profundidad del color general, con tonos muy oscuros; igualmente, son deseables los tonos más oscuros sobre la columna vertebral; los tonos blancos o muy claros deben encontrarse solamente en el abdomen del animal, alrededor de los labios, en la zona frontal de la garganta y hacia el pecho. En la división Silver solo el color del pelo bajo debe ser diferente a la división Tabby, con los seis colores del ticking de ambas divisiones; en todas las variedades de Silver el color del pelaje inferior deberá ser blanco nieve con un ticking apropiado al color particular dando un brillante efecto plateado. Las bandas tradicionales de la división Tabby (Anaranjado-Marrón-Sorrel-Crema), son reemplazadas por el blanco, empezando el color más claro más cerca de la piel; pigmentaciones amarillas o marrones en el pecho, abdomen o debajo de la cola no son deseables; parches de colores claros son considerados como faltas, siendo más graves en la división Silver. Este estándar da al gato 10 puntos por esta característica, en el estándar TICA.\r\nCondiciones generales: La impresión general del grupo Abisinio/Somalí es de un gato medio con una apariencia estilizada. Los machos son más grandes que las hembras, las cuales presentan una estructura ósea más fina y usualmente son más activas que los machos. El grupo AB/SO muestra una estructura muscular muy desarrollada, firme y delgada, mostrando un particular interés en ruidos extraños. El gato Abisinio/Somalí es sinónimo de salud y vigor, bien equilibrado físicamente, con un temperamento gentil y sencillo de manejar.7?\r\nPenalizaciones\r\nFaltas en Color: Colores fríos, grisáceos, tonos arena; colores marcados de tonos canela, chocolate o grises; barras de colores marcadas en las piernas o en el interior de las mismas, en el cuerpo o sobre la columna; pelo muy corto o excesivamente largo; color o patrón de color equivocado.\r\nFaltas en Ticking y Patrón: Ausencia de pelo con ticking sobre el cuerpo, bandas o marcas en la cabeza y cola.\r\nFaltas en condición: Exceso de grasa corporal, pérdida del lustre del pelo, color de ojos extraño, pérdida de tono muscular, evidencia de enfermedades, son faltas que reducen puntos.\r\nEjemplares sin calificación: (WW): Ticking inverso (pelo con el color más claro en la parte más alejada de la raíz del mismo); en la división Tabby, colores blancos o manchas de colores blancos en el cuerpo, en áreas no permitidas.",
       "country_codes": "EG",
       "country_code": "EG",
       "description": "The Abyssinian is easy to care for - and a joy to have in your home. They re affectionate cats and love both people and other animals.",
       "description_es": "El gato abisinio es una raza de gato. Es una raza popular debido a su apariencia física y su personalidad. Tanto en reposo como en movimiento, este animal muestra una gran elegancia y armonía en sus movimientos. Es una amable, pero fuerte mascota, bastante juguetona\r\n\r\nEl abisinio es fácil de cuidar y es un placer tenerlo en casa. Son gatos cariñosos y aman tanto a las personas como a otros animales.",
       "life_span": "14 - 15",
       "indoor": "0",
       "lap": "1",
       "alt_names": "",
       "adaptability": "5",
       "affection_level": "5",
       "child_friendly": "3",
       "cat_friendly": "0",
       "dog_friendly": "4",
       "energy_level": "5",
       "grooming": "1",
       "health_issues": "2",
       "intelligence": "5",
       "shedding_level": "2",
       "social_needs": "5",
       "stranger_friendly": "5",
       "vocalisation": "1",
       "experimental": "0",
       "hairless": "0",
       "natural": "1",
       "rare": "0",
       "rex": "0",
       "suppressed_tail": "0",
       "short_legs": "0",
       "wikipedia_url": "https://es.wikipedia.org/wiki/Abisinio_(gato)",
       "hypoallergenic": "0",
       "weight": "{\"metric\":\"3 - 5\",\"imperial\":\"7  -  10\"}",
       "date": "0000-00-00 00:00:00",
       "reference_image_id": "0XYvRd7oD",
       "path_image": "media/images-list-cats/Abyssinian.jpg",
       "creator_id": "1"
       },
        {
        }....
     ]
    */
    @GET("breedCats.php")
    suspend fun getAllBreedCats(): Response<List<BreedCatTL>>

    /*
    [
        {
        "id": "1",
        "name": "Baptiste",
        "name_es": "Baptiste",
        "breed_id": "abys",
        "family": "Walker\t",
        "description": null,
        "description_es": "Soy un pelirrojo fogoso con una gran personalidad. Me encanta jugar a buscar y salir a pasear con correa.",
        "year_of_birth": "0",
        "sex": "0",
        "address": "Plaza Mayor, 10, 16001 Cuenca, Cuenca",
        "vaccines": "0",
        "path_image": "media/images-cats/Abyssinian-0.jpg",
        "date": "0000-00-00 00:00:00",
        "creator_id": "1"
        },
        {
        }....
     ]
     */
    @GET("cats.php")
    suspend fun getAllCats(): Response<List<CatTL>>
   /*
   [
        {
        "id": "365",
        "name": "Chewbacca",
        "name_es": "Chewbacca",
        "breed_id": "mcoo",
        "family": "Carrillo\t",
        "description": null,
        "description_es": "Soy un gato espadach?n de una franquicia popular. Soy conocido por mi astucia, encanto y habilidades con la espada.",
        "year_of_birth": "0",
        "sex": "1",
        "address": "Avenida de Navarra, 27, 20013 San Sebastián, Gipuzkoa",
        "vaccines": "0",
        "path_image": "media/images-cats/Maine-Coon-4.jpg",
        "date": "0000-00-00 00:00:00",
        "creator_id": "1"
        }
    ]
    */
    @GET("images/{reference_image_id}")
    suspend fun getImageCat(@Path ("reference_image_id") reference_image_id:String): Response<ImageCat>






    @GET("breedDogs.php")
    suspend fun getAllBreedDogs(): Response<List<BreedDogTL>>

    @GET("dogs.php")
    suspend fun getListDogs():Response<List<DogTL>>


    //Devuelve una imagen de un perro a partir del breed_id
    //https://api.thedogapi.com/v1/images/search?bree_id=HJ7Pzg5EQ
    @GET("images/search")
    suspend fun getDataDogBreedById(@Query("bree_id") reference_image_id:String):Response<List<ImageDog>>






    @GET("specieFish.php")
    suspend fun getAllSpecieFish(): Response<List<SpecieFishTL>>

    @GET("fish.php")
    //@Headers("X-RapidAPI-Key: ${Constants.KEY_API_FISH}" ,"X-RapidAPI-Host: fish-species.p.rapidapi.com")
    suspend fun getAllFish(): Response<List<FishTL>>



    @POST("saveScore.php")
    @FormUrlEncoded
    suspend fun saveScore(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("score") score: Int
    ): Response<String>

    @POST("saveBeauty.php")
    @FormUrlEncoded
    suspend fun saveBeauty(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("nameBeauty") nameBeauty: String,
        @Field("description") description: String,
        @Field("image") image: String
    ): Response<String>
}