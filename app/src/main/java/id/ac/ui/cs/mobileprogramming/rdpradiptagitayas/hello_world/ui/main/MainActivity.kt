package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.R
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.presentation.contracts.MainActivityContract.View
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.presentation.presenters.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {

    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter =
            MainActivityPresenter(
                this
            )
    }

    override fun initView() {
        val formData = mapOf(
            "name" to formName.text,
            "npm" to formNPM.text,
            "username" to formUsername.text,
            "email" to formEmail.text
        )
        registerButton.setOnClickListener { presenter?.submitDataToModel(formData) }
    }

    override fun updateViewData() {
        formStatus.text = presenter?.getDataFromModel().toString()
    }
}