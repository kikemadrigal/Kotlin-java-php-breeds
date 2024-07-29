package es.tipolisto.breeds.data.providers

import es.tipolisto.breeds.data.models.dog.BreedDogTL
import es.tipolisto.breeds.data.models.dog.DogTL


class DogProvider {
    companion object{
        var listDogs:List<DogTL> = emptyList()
        var listBreedDogs:List<BreedDogTL> = emptyList()
    }
}