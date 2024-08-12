package es.tipolisto.breeds.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import es.tipolisto.breeds.data.models.animal.Animal
import es.tipolisto.breeds.data.models.cat.Cat
import es.tipolisto.breeds.data.models.user.User

class PreferenceManager {
    companion object{
        private lateinit var sharedPref: SharedPreferences
        const val PREFS_NAME="sharedPref"
        const val MUSICONOFF = false
        const val THEMEDARKONOFF = false
        private val gson= Gson()
        fun savePreferenceMusicOnOff(context:Context,value:Boolean){
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putBoolean("musicOnOff", value)
                apply()
            }
        }
        fun readPreferenceMusicOnOff(context:Context):Boolean{
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            return sharedPref.getBoolean("musicOnOff", true)
        }

        fun savePreferenceThemeDarkOnOff(context:Context,value:Boolean){
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putBoolean("ThemeDarkOnOff", value)
                apply()
            }
        }

        fun readPreferenceThemeDarkOnOff(context: Context):Boolean{
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            return sharedPref.getBoolean("ThemeDarkOnOff",false)
        }

        fun savePreferenceAnimal(context:Context,animal: Animal?){
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                var stringAnimal=""
                if(animal!=null)
                    stringAnimal=gson.toJson(animal)
                else{
                    val animal=Animal()
                    stringAnimal=gson.toJson(animal)
                }
                Log.d("TAG","Preferencemanager dice: Guardado en preferencias Animal: $stringAnimal")
                putString("Animal", stringAnimal)
                apply()
            }
        }
        fun readPreferenceAnimal(context:Context):Animal?{
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            val stringAnimal=sharedPref.getString("Animal", "")
            Log.d("TAG","Preferencemanager dice: Leido de preferencias Animal: $stringAnimal")
            val animal=gson.fromJson(stringAnimal,Animal::class.java)
            if(animal==null)
                return Animal()
            else
                return animal
        }
        fun savePreferenceUser(context:Context,user: User?){
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                var stringUser=""
                if(user!=null)
                    stringUser=gson.toJson(user)
                else{
                    val animal=Animal()
                    stringUser=gson.toJson(user)
                }
                Log.d("TAG","Preferencemanager dice: Guardado en preferencias User: $stringUser")
                putString("User", stringUser)
                apply()
            }
        }
        fun readPreferenceUser(context:Context):User?{
            sharedPref = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
            val stringUser=sharedPref.getString("User", "")
            Log.d("TAG","Preferencemanager dice: Leido de preferencias User: $stringUser")
            val user=gson.fromJson(stringUser,User::class.java)
            if(user==null)
                return User()
            else
                return user
        }
    }




}