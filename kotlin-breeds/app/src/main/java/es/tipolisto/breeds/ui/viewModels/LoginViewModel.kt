package es.tipolisto.breeds.ui.viewModels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    private val _email=MutableLiveData<String>()
    val email:LiveData<String> = _email
    private val _password=MutableLiveData<String>()
    val password:LiveData<String> = _password
    private val _loginEnable=MutableLiveData<Boolean>()
    val loginEnable:LiveData<Boolean> = _loginEnable

    fun onLoginChange(email:String, password:String){
        _email.value=email
        _password.value=password
        _loginEnable.value=isValidEmail(email) && isValidPassword(password)
    }
    fun onLoginSelected(){

    }

    private fun isValidPassword(password: String): Boolean = password.length > 6
    private fun isValidEmail(email: String):Boolean= Patterns.EMAIL_ADDRESS.matcher(email).matches()
}