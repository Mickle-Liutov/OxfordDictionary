package com.molfario.l.oxforddictionary.api.word_entries


import com.google.gson.annotations.SerializedName

data class WordEntries(
    @SerializedName("id")
    val id: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("word")
    val word: String
)