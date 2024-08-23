package es.tipolisto.breeds.data.models.cat

import android.os.Parcel
import android.os.Parcelable

data class CatTL(
    val id: Int,
    val name: String,
    val name_es: String,
    val breed_id: String,
    val family: String,
    val description: String,
    val description_es: String,
    val year_of_birth: String,
    val sex: String,
    val address: String,
    val vaccines: String,
    val points: Int,
    val total_points: Int,
    val path_image: String,
    val validate: Int,
    val date: String,
    val creator_id: String
    )
