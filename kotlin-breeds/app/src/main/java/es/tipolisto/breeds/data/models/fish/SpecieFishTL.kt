package es.tipolisto.breeds.data.models.fish

import com.google.gson.annotations.SerializedName

data class SpecieFishTL(
    val id: Int,
    val name: String,
    val name_es: String,
    val description: String,
    val url_image: String,
    val url_wiki: String,
    val morphology: String,
    val habitat: String,
    val feeding: String,
    val phylum: String,
    @SerializedName("class")
    val clase: String,
    val orden: String,
    val family: String,
    val genus: String,
    val path_image: String,
    val date: String,
    val creator_id: Int
)