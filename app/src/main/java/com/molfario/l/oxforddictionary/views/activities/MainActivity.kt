package com.molfario.l.oxforddictionary.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.molfario.l.oxforddictionary.R
import com.molfario.l.oxforddictionary.presenters.MainPresenter
import com.molfario.l.oxforddictionary.views.dialogs.ProgressDialog
import com.molfario.l.oxforddictionary.views.interfaces.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    lateinit var presenter: MainPresenter
    lateinit var progressDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.onCreate()
        search_btn.setOnClickListener { presenter.searchWord(word_edt.text.toString()) }
    }

    override fun showLoader() {
        progressDialog = ProgressDialog(this)
        progressDialog.show()
    }

    override fun dismissLoader() {
        if(progressDialog.isShowing){
            progressDialog.dismiss()
        }
    }

    override fun showResult(result:String) {
        val finalText = "Result: " + result
        result_txt.text = finalText
    }

    override fun showRoot(root: String) {
        val finalText = "Root: " + root
        root_txt.text = finalText
    }
}
