package kg.example.valuta.data.remote.model

sealed class Currency(
    open val iD: String,
    open val numCode: String,
    open val char: String,
    open val nominal: Int,
    open val name: String,
    open val value: Double,
    open val previous: Double
)