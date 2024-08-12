package es.tipolisto.breeds.ui.states

import es.tipolisto.breeds.data.models.cat.CatTL
import es.tipolisto.breeds.data.models.dog.DogTL
import es.tipolisto.breeds.data.models.fish.FishTL

data class CompetitionScreenState(
    val listRandomCats: MutableList<CatTL?> = mutableListOf(null, null, null),
    val listRandomDogs: MutableList<DogTL?> = mutableListOf(null, null, null),
    val listRandomFish: MutableList<FishTL?> = mutableListOf(null, null, null),
    var lives:Int=7,
    var score:Int=0,
    var correctAnswer:Int=0,
    var listSelected:Int=0
    //var isLoading:Boolean=false
)

