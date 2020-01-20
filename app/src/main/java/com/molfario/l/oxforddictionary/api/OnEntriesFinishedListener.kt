package com.molfario.l.oxforddictionary.api

import com.molfario.l.oxforddictionary.api.word_entries.WordEntries

interface OnEntriesFinishedListener {
    fun onSuccess(entries: WordEntries)
    fun onFailure(error:Throwable)
}