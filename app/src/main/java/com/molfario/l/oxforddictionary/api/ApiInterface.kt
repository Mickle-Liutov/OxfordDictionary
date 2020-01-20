package com.molfario.l.oxforddictionary.api

import com.molfario.l.oxforddictionary.api.root_of_word.RootOfWord
import com.molfario.l.oxforddictionary.api.word_entries.WordEntries
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiInterface {

    @Headers(
        "Accept:application/json",
        "app_id:a20cfc52",
        "app_key:6655a8e0ffd2207753265afba8d1989e"
    )
    @GET("/api/v2/lemmas/en/{word}")
    fun getRootOfWord(@Path("word") word: String): Call<RootOfWord>

    @Headers(
        "Accept:application/json",
        "app_id:a20cfc52",
        "app_key:6655a8e0ffd2207753265afba8d1989e"
    )
    @GET("/api/v2/entries/en/{word}")
    fun getEntriesOfWord(@Path("word") word: String): Call<WordEntries>
}