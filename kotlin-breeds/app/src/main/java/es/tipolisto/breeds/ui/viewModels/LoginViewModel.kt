package es.tipolisto.breeds.ui.viewModels

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.tipolisto.breeds.data.database.records.RecordDao
import es.tipolisto.breeds.data.repositories.RecordsRepository
import es.tipolisto.breeds.data.repositories.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val recordDao: RecordDao):ViewModel() {
    private val _name=MutableLiveData<String>()
    val name:LiveData<String> = _name
    private val _password=MutableLiveData<String>()
    val password:LiveData<String> = _password
    //private val _messageLiveData = MutableLiveData<String>()
    //val messageLiveData: LiveData<String> = _messageLiveData
    var message by mutableStateOf<String>("")
    private val _loginEnable=MutableLiveData<Boolean>()
    val loginEnable:LiveData<Boolean> = _loginEnable

    /*private fun isValidPassword(password: String): Boolean = password.length > 6
    private fun isValidString(cadena: String):String{
        //Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if(cadena.isEmpty()))
            return "la cadena no puede estar vacia"
    } */
/*
(1, 'kike', '1c558dfd6f4148767d40386fa7b59c18e3b8627e', 1, 'kikemadrigal@hotmail.com', 'Enrique', 'Madrigal', 'tipolisto.es', '1', 0, '', 1, '', ''),
(2, 'ada', '1c558dfd6f4148767d40386fa7b59c18e3b8627e', 3, 'userada@test.es', '', '', '', '1', 0, '', 1, '', ''),
(3, 'lucas', '8b08a87c980d75add89798754899184c196b1a50', 3, 'userlucas@test2.es', '', '', '', '1', 0, '', 1, '', ''),
(4, 'maria', '3885b8a5e5c5087b42086a494b7cc26210721602', 3, 'usermariao@test3.es', '', '', '', '1', 0, '11/01/2018', 1, '', ''),
(5, 'juan', '58746b54a4c7e856562f17e9bc6d2a07861da891', 3, 'userjuan@test4.es', ' ', ' ', ' ', '1', 0, '29/04/2022', 1, '', '');
 */

    fun onNameChange(name:String){
        _name.value=name
        if(name.isEmpty()){
            //_messageLiveData.value= "la cadena no puede estar vacia"
            message="la cadena no puede estar vacia"
            _loginEnable.value=false
        }else{
            _loginEnable.value=true
        }
    }
    fun onPasswordChange(password: String){
        _password.value=password
        if(password.isEmpty()) {
            //_messageLiveData.value = "la cadena no puede estar vacia"
            message="la cadena no puede estar vacia"
            _loginEnable.value = false
        }else{
            _loginEnable.value = true
        }
    }
    fun getRecordMix():Int{
        return RecordsRepository.getRecordMix(recordDao)
    }

    fun saveScore(context: Context, name: String, password: String, score: Int){
        viewModelScope.launch {
            //_messageLiveData.value=UserRepository.saveScore(name, password, score)
            message=UserRepository.saveScore(name, password, score)
            when (message) {
                "0" -> Toast.makeText( context,"El usuario no existe", Toast.LENGTH_LONG).show()
                "1" -> Toast.makeText( context,"Nuevo record salvado en breeds.tipolisto.es", Toast.LENGTH_LONG).show()
                "2" -> Toast.makeText( context,"El ususario o el password son incorrectos", Toast.LENGTH_LONG).show()
                "3" -> Toast.makeText( context,"El usuario necesita ser validado", Toast.LENGTH_LONG).show()
                "4" -> Toast.makeText( context,"Hubo un problema con la base de datos", Toast.LENGTH_LONG).show()
                "5" -> Toast.makeText( context,"Otra puntuación más alta encontrada", Toast.LENGTH_LONG).show()
                else-> Toast.makeText( context,"Problema no encontrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}