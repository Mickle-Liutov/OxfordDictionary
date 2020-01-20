package com.molfario.l.oxforddictionary.api.word_entries


import com.google.gson.annotations.SerializedName

data class LexicalCategory(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String
)