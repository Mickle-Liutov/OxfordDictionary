package com.molfario.l.oxforddictionary.views.interfaces

interface MainView {
    fun showLoader()
    fun dismissLoader()
    fun showResult(result:String)
    fun showRoot(root:String)
}