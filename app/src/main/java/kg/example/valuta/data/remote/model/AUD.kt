package kg.example.valuta.data.remote.model


import com.google.gson.annotations.SerializedName

data class AUD(
    @SerializedName("ID")
    override val iD: String,
    @SerializedName("NumCode")
    override val numCode: String,
    @SerializedName("CharCode")
    override val char: String,
    @SerializedName("Nominal")
    override val nominal: Int,
    @SerializedName("Name")
    override val name: String,
    @SerializedName("Value")
    override val value: Double,
    @SerializedName("Previous")
    override val previous: Double
) : Currency(iD, numCode, char, nominal, name, value, previous)