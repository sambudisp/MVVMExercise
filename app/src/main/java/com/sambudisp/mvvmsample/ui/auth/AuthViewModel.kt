package com.sambudisp.mvvmsample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.sambudisp.mvvmsample.data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    var email : String? = null
    var password : String? = null
    var authListener : AuthListener? = null

    fun onLoginButtonClick(view : View){
        authListener?.onStarted()
        if (email.isNullOrEmpty() ||password.isNullOrEmpty()){
            //failed
            authListener?.onFailure("Invalid Email/Password")
            return
        }

        //success
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }
}