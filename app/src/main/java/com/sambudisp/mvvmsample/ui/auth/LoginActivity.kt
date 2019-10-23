package com.sambudisp.mvvmsample.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sambudisp.mvvmsample.R
import com.sambudisp.mvvmsample.databinding.ActivityLoginBinding
import com.sambudisp.mvvmsample.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    private var rootLayout: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponent()

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    private fun initComponent() {
        rootLayout = findViewById(R.id.root_layout)
    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccess() {
        toast("Login Success")
    }

    override fun onFailure(message: String) {
        toast("Login Failed : $message")
    }
}
