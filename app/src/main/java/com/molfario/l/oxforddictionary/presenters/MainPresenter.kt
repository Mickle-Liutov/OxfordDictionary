package com.molfario.l.oxforddictionary.presenters

import com.molfario.l.oxforddictionary.api.OnEntriesFinishedListener
import com.molfario.l.oxforddictionary.api.OnRootFinishedListener
import com.molfario.l.oxforddictionary.api.root_of_word.RootOfWord
import com.molfario.l.oxforddictionary.api.word_entries.WordEntries
import com.molfario.l.oxforddictionary.models.MainModel
import com.molfario.l.oxforddictionary.views.interfaces.MainView

class MainPresenter(val view: MainView) : Presenter {

    lateinit var model: MainModel
    override fun onCreate() {
        model = MainModel()
    }

    fun searchWord(word: String) {
        view.showLoader()
        model.searchWord(word, object : OnEntriesFinishedListener {
            override fun onSuccess(entries: WordEntries) {
                view.showResult(entries.results[0].lexicalEntries[0].entries[0].senses[0].definitions[0])
                view.dismissLoader()
            }

            override fun onFailure(error: Throwable) {
                view.showResult(error.toString())
                view.dismissLoader()
            }
        },
            object : OnRootFinishedListener {
                override fun onSuccess(root: RootOfWord) {
                    view.showRoot(root.results[0].lexicalEntries[0].inflectionOf[0].text)
                }

                override fun onFailure(error: Throwable) {
                    view.showResult(error.toString())
                    view.dismissLoader()
                }
            })
    }

}