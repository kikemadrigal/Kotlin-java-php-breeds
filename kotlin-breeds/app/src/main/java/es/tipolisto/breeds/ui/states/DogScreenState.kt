package es.tipolisto.breeds.ui.states

import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.dog.Dog
import es.tipolisto.breeds.data.models.dog.DogTL

data class DogScreenState(
    val listRandomDogs: MutableList<DogTL?> = mutableListOf(null, null, null),
    var lives:Int=7,
    var score:Int=0,
    var correctAnswer:Int=0
)
