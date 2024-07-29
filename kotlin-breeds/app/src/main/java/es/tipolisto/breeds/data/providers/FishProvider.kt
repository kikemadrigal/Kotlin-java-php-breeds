package es.tipolisto.breeds.data.providers


import es.tipolisto.breeds.data.models.fish.FishTL
import es.tipolisto.breeds.data.models.fish.SpecieFishTL

class FishProvider {
    companion object{
        var listFish:List<FishTL> = emptyList()
        var listSpecieFish:List<SpecieFishTL> = emptyList()
    }
}