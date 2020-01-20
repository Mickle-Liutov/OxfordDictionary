package com.molfario.l.oxforddictionary.models

import com.molfario.l.oxforddictionary.api.ApiClient
import com.molfario.l.oxforddictionary.api.ApiInterface
import com.molfario.l.oxforddictionary.api.OnEntriesFinishedListener
import com.molfario.l.oxforddictionary.api.OnRootFinishedListener
import com.molfario.l.oxforddictionary.api.root_of_word.RootOfWord
import com.molfario.l.oxforddictionary.api.word_entries.WordEntries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel {
    fun searchWord(word: String, listenerEntries: OnEntriesFinishedListener, listenerRoot:OnRootFinishedListener) {
        val api = ApiClient.getClient()!!.create(ApiInterface::class.java)
        val rootCall = api.getRootOfWord(word)
        rootCall.enqueue(object : Callback<RootOfWord> {
            override fun onResponse(call: Call<RootOfWord>, response: Response<RootOfWord>) {
                if (response.code() == 200) {
                    response.body()?.let { listenerRoot.onSuccess(it) }
                    callEntries(response.body(), listenerEntries, api)
                } else {
                    listenerRoot.onFailure(Throwable(response.message()))
                }
            }

            override fun onFailure(call: Call<RootOfWord>, t: Throwable) {
                listenerRoot.onFailure(t)
            }
        })
    }

    private fun callEntries(root: RootOfWord?, listenerEntries: OnEntriesFinishedListener, api: ApiInterface) {
        root?.let {
            val entriesCall =
                api.getEntriesOfWord(root.results[0].lexicalEntries[0].inflectionOf[0].text)
            entriesCall.enqueue(object : Callback<WordEntries> {
                override fun onResponse(call: Call<WordEntries>, response: Response<WordEntries>) {
                    if (response.code() == 200) {
                        response.body()?.let {
                            listenerEntries.onSuccess(it)
                        }
                    } else {
                        listenerEntries.onFailure(Throwable(response.message()))
                    }
                }

                override fun onFailure(call: Call<WordEntries>, t: Throwable) {
                    listenerEntries.onFailure(t)
                }
            })
        }
    }
}