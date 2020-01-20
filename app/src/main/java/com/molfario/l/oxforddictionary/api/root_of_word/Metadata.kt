package com.molfario.l.oxforddictionary.api.root_of_word


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("provider")
    val provider: String
)