package com.molfario.l.oxforddictionary.api.root_of_word


import com.google.gson.annotations.SerializedName

data class RootOfWord(
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("results")
    val results: List<Result>
)