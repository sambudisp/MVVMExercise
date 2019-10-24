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

    private var binding: ActivityLoginBinding? = null
    private var viewModel: AuthViewModel? = null

    private var rootLayout: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBindViewModel()
        initComponent()

        viewModel?.authListener = this
    }

    private fun initBindViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding?.viewmodel = viewModel
    }

    override fun onStarted() {
        progress_bar?.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_bar?.hide()
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        progress_bar?.hide()
        toast("Login Failed : $message")
    }
}
}
