package es.tipolisto.breeds.data.models.fish

data class FishTL(
    val id: Int,
    val name: String,
    val name_es: String,
    val specie_id: Int,
    val path_image: String,
    val date: String,
    val creator_id: Int
)