package es.tipolisto.breeds.ui.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.models.animal.Animal
import es.tipolisto.breeds.data.repositories.BeautyRepository
import es.tipolisto.breeds.data.repositories.UserRepository
import kotlinx.coroutines.launch

class BeautyViewModel: ViewModel()  {
    var isLoading by mutableStateOf(false)

    fun insertBeauty(context: Context,nameUser: String, password: String,animal: Animal? ){
        viewModelScope.launch {
            isLoading=true
            val message= UserRepository.checkUser(nameUser, password)
            when (message) {
                "0" -> Toast.makeText( context,"El usuario no existe", Toast.LENGTH_LONG).show()
                "1" -> Toast.makeText( context,"Nuevo record salvado en breeds.tipolisto.es", Toast.LENGTH_LONG).show()
                "2" -> Toast.makeText( context,"El ususario o el password son incorrectos", Toast.LENGTH_LONG).show()
                "3" -> Toast.makeText( context,"El usuario necesita ser validado", Toast.LENGTH_LONG).show()
                "4" -> Toast.makeText( context,"Hubo un problema con la base de datos", Toast.LENGTH_LONG).show()
                "5" -> Toast.makeText( context,"Otra puntuación más alta encontrada", Toast.LENGTH_LONG).show()
                "10"->{
                    val chechExistImage= BeautyRepository.checkExistImage(nameUser,animal)
                    Log.d("TAG4","BeautyViewModel dice: el resultado es: $chechExistImage")
                    if (chechExistImage=="1"){
                        Toast.makeText( context,
                            context.getString(R.string.the_image_already_exists_in_your_account_it_has_not_been_saved), Toast.LENGTH_LONG).show()
                    }else{
                        val result=BeautyRepository.insertBeautyOnInternet(nameUser,animal)
                        //Log.d("TAG4","BeautyViewModel dice: el resultado es: $result")
                        if(result=="true")
                            Toast.makeText( context,"Saved!!", Toast.LENGTH_LONG).show()
                    }

                }
                else-> Toast.makeText( context,"Problema no encontrado", Toast.LENGTH_LONG).show()
            }
            isLoading=false
        }

    }
}