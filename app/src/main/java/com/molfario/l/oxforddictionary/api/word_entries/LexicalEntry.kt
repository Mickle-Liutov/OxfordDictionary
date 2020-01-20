package com.molfario.l.oxforddictionary.api.word_entries


import com.google.gson.annotations.SerializedName

data class LexicalEntry(
    @SerializedName("entries")
    val entries: List<Entry>,
    @SerializedName("language")
    val language: String,
    @SerializedName("lexicalCategory")
    val lexicalCategory: LexicalCategory,
    @SerializedName("text")
    val text: String
)