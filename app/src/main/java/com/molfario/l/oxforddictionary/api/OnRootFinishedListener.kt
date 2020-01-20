package com.molfario.l.oxforddictionary.api

import com.molfario.l.oxforddictionary.api.root_of_word.RootOfWord

interface OnRootFinishedListener {
    fun onSuccess(root: RootOfWord)
    fun onFailure(error:Throwable)
}