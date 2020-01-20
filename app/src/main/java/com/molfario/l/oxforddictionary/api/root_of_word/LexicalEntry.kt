package com.molfario.l.oxforddictionary.api.root_of_word


import com.google.gson.annotations.SerializedName

data class LexicalEntry(
    @SerializedName("grammaticalFeatures")
    val grammaticalFeatures: List<GrammaticalFeature>,
    @SerializedName("inflectionOf")
    val inflectionOf: List<InflectionOf>,
    @SerializedName("language")
    val language: String,
    @SerializedName("lexicalCategory")
    val lexicalCategory: LexicalCategory,
    @SerializedName("text")
    val text: String
)