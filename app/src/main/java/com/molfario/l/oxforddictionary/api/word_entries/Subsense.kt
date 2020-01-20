package com.molfario.l.oxforddictionary.api.word_entries


import com.google.gson.annotations.SerializedName

data class Subsense(
    @SerializedName("definitions")
    val definitions: List<String>,
    @SerializedName("id")
    val id: String
)