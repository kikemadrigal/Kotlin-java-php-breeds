package es.tipolisto.breeds.data.models.dog

data class DogTL(
    val id: Int,
    val name: String,
    val name_es: String,
    val breed_id: String,
    val family: String,
    val description: String,
    val description_es: String,
    val year_of_birth: String,
    val sex: Int,
    val address: String,
    val vaccines: String,
    val path_image: String,
    val date: String,
    val creator_id: Int
)