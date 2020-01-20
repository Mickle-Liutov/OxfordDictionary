package com.molfario.l.oxforddictionary.api.root_of_word


import com.google.gson.annotations.SerializedName

data class LexicalCategory(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String
)