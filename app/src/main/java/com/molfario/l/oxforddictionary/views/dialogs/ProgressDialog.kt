package com.molfario.l.oxforddictionary.views.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.molfario.l.oxforddictionary.R

class ProgressDialog(context:Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }
}