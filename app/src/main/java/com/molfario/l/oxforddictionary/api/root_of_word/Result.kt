package com.molfario.l.oxforddictionary.api.root_of_word


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("lexicalEntries")
    val lexicalEntries: List<LexicalEntry>,
    @SerializedName("word")
    val word: String
)