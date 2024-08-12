package es.tipolisto.breeds.data.models.user

data class User(
    var name: String="",
    var password: String="",
    var score: Int=0,
    var nameBeaduty: String="",
    var description: String="",
    var image: String=""
)
