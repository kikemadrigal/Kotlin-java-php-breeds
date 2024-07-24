package es.tipolisto.breeds.data.providers


import es.tipolisto.breeds.data.models.cat.BreedCatTL
import es.tipolisto.breeds.data.models.cat.CatTL

class CatProvider {
    companion object{
        //var listCats:List<Cat> = emptyList()
        var listCats:List<CatTL> = emptyList()
        var listBreedCats:List<BreedCatTL> = emptyList()
    }
}