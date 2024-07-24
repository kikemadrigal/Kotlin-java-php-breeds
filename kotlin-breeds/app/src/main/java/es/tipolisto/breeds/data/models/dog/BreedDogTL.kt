package es.tipolisto.breeds.data.models.dog

data class BreedDogTL(
    val id: Int,
    val breed_id: String,
    val name: String,
    val name_es: String,
    val description: String,
    val description_es: String,
    val wiki_url: String,
    val bred_for: String,
    val bred_for_es: String,
    val breed_group: String,
    val breed_group_es: String,
    val life_span: String,
    val temperament: String,
    val temperament_es: String,
    val origin: String,
    val origin_es: String,
    val morphology: String,
    val morphology_es: String,
    val weight: String,
    val height: String,
    val date: String,
    val reference_image_id: String,
    val path_image: String,
    val creator_id: Int
)