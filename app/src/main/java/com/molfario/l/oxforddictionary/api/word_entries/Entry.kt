package com.molfario.l.oxforddictionary.api.word_entries


import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("senses")
    val senses: List<Sense>
)