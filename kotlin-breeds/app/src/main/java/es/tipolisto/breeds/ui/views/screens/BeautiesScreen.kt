package es.tipolisto.breeds.ui.views.screens


import android.Manifest
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import es.tipolisto.breeds.R
import es.tipolisto.breeds.data.preferences.PreferenceManager
import es.tipolisto.breeds.ui.components.MyCircularProgressIndicatorWithoutText
import es.tipolisto.breeds.ui.components.getMyNaimalsAnnotated
import es.tipolisto.breeds.ui.components.getRateBeautiesAnnotated
import es.tipolisto.breeds.ui.components.getRegisterAnnotated
import es.tipolisto.breeds.ui.theme.BreedsTheme
import es.tipolisto.breeds.ui.viewModels.BeautyViewModel
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun BeautiesScreen(navController: NavController, beautyViewModel: BeautyViewModel){
    //Solicitamos los permisos
    val permissions= rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    )
    //Definimos la corrutina para que el usuario acepte o deniegue los permisos
    LaunchedEffect(Unit){
        permissions.launchMultiplePermissionRequest()
    }

    val context= LocalContext.current
    val isDarkMode by remember {mutableStateOf(PreferenceManager.readPreferenceThemeDarkOnOff(context))}

    BreedsTheme(darkTheme = isDarkMode) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Beauty ranking",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        ) {
            Beauty(it, permissions, beautyViewModel)
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Beauty(it: PaddingValues, permissions: MultiplePermissionsState, beautyViewModel: BeautyViewModel) {
    val context= LocalContext.current
    var name by remember {mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.name)}
    val radioOptions = listOf("Cat", "Dog", "Fish")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.type) }


    var breed by remember {mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.breed)}
    var description by remember {mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.description)}
    var family by remember {mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.family)}
    var year_of_birth by remember {mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.year_of_birth)}
    var sex by remember {mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.sex)}
    var address by remember {mutableStateOf(PreferenceManager.readPreferenceAnimal(context)?.address)}

    //Log.d("TAG","Name: $name, Description: $description, Breed: $breed, Family: $family, Year of birth: $year_of_birth, Sex: $sex, Address: $address")
    var animal by remember { mutableStateOf(PreferenceManager.readPreferenceAnimal(context)) }
    var user by remember { mutableStateOf(PreferenceManager.readPreferenceUser(context)) }
    var nameUser by remember {mutableStateOf(PreferenceManager.readPreferenceUser(context)?.name)}
    var password by remember {mutableStateOf(PreferenceManager.readPreferenceUser(context)?.password)}


/*

*/
    val uriHandler= LocalUriHandler.current
    val rateBeautiesAnnotated= getRateBeautiesAnnotated()
    val registerAnnotated = getRegisterAnnotated()
    val myAnimalesAnnotated = getMyNaimalsAnnotated()

    var bitmap by remember { mutableStateOf<Bitmap?>(loadImageFromStorage(context)) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    //El camara controller lo necesitamos para guardar la foto
    val launcherCamera= rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ){
        bitmap=it
        val result=saveToInternalStorage(context,bitmap)
        Log.d("TAG","BeautyScreen dice: Path: $result")
    }
    val launcherGetContent= rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ){
        if(it!=null){
            imageUri=it
            if(Build.VERSION.SDK_INT < 28)
                bitmap=MediaStore.Images.Media.getBitmap(context.contentResolver,imageUri)
            else{
                val source= ImageDecoder.createSource(context.contentResolver,imageUri!!)
                bitmap=ImageDecoder.decodeBitmap(source)
            }
        }
    }







    Column(
        modifier = Modifier
            .padding(it)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = rateBeautiesAnnotated,
            onClick = { offset ->
                val uri= rateBeautiesAnnotated.getStringAnnotations(tag = "Beauties", start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en puntuar")
            },
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = stringResource(R.string.you_can_see_your_animals_at))
        ClickableText(
            text = myAnimalesAnnotated,
            onClick = { offset ->
                val uri= myAnimalesAnnotated.getStringAnnotations(tag = "My animals", start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en register")
            }
        )


        Spacer(modifier = Modifier.size(10.dp))
        TextField(
            value = name?:"",
            onValueChange = {
                    name = it
                    animal!!.name=it
                    PreferenceManager.savePreferenceAnimal(context,animal)
             },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Name animal") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){

            radioOptions.forEach { text ->
                Column(
                    Modifier
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge.merge(),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                            animal!!.type=text
                            PreferenceManager.savePreferenceAnimal(context,animal)
                        }
                    )
                }
            }
        }


        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = breed?:"",
            onValueChange = {
                breed = it
                animal!!.breed = it
                PreferenceManager.savePreferenceAnimal(context, animal)

             },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "breed") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Breed") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = family?:"",
            onValueChange = {
                family = it
                animal!!.family = it
                PreferenceManager.savePreferenceAnimal(context, animal)

             },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "family") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Family") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = description?:"",
            onValueChange = {
                description = it
                animal!!.description=it
                PreferenceManager.savePreferenceAnimal(context,animal)


            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Description") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Description") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = year_of_birth?:"",
            onValueChange = {
                year_of_birth = it
                animal!!.year_of_birth=it
                PreferenceManager.savePreferenceAnimal(context,animal)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Year of birth") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Year of birth") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = sex?:"",
            onValueChange = {
                sex = it
                animal!!.sex=it
                PreferenceManager.savePreferenceAnimal(context,animal)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Sex") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Sex") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = address?:"",
            onValueChange = {
                address = it
                animal!!.address=it
                PreferenceManager.savePreferenceAnimal(context,animal)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Address") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        if (bitmap==null){
            Image(
                modifier = Modifier
                    .height(300.dp),
                painter = painterResource(id = R.drawable.photo_dog),
                contentDescription = "Photo animal",
            )
        }else{
            bitmap?.let {
                Image(
                    bitmap = it.asImageBitmap()!!,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier= Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                    )
            }

        }
        if(beautyViewModel.isLoading) MyCircularProgressIndicatorWithoutText(isDisplayed = true)
        else MyCircularProgressIndicatorWithoutText(isDisplayed = false)
        Spacer(modifier = Modifier.padding(4.dp))
        Row (modifier=Modifier.fillMaxWidth()){
            IconButton(
                onClick = {
                    if(permissions.allPermissionsGranted) {
                        launcherGetContent.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    }else{
                        Toast.makeText(context,context.getString(R.string.you_do_not_have_permissions), Toast.LENGTH_LONG).show()
                    }
                 },
                modifier=Modifier.weight(1f),
                enabled = true
            ) {
                Icon(imageVector = Icons.Filled.PhotoLibrary, contentDescription = "")
            }
            IconButton(
                onClick = {
                    if(permissions.allPermissionsGranted){
                        launcherCamera.launch()

                    }else{
                        Toast.makeText(context,
                            context.getString(R.string.you_do_not_have_permissions), Toast.LENGTH_LONG).show()
                    }
               },
                modifier=Modifier.weight(1f),
                enabled = true
            ) {
                Icon(imageVector = Icons.Filled.CameraAlt, contentDescription = "")
            }

        }

        Spacer(modifier = Modifier.size(10.dp))
        Text(text = stringResource(R.string.you_need_to_register))
        ClickableText(
            text = registerAnnotated,
            onClick = { offset ->
                val uri= registerAnnotated.getStringAnnotations(tag = "Register", start = offset, end = offset).firstOrNull()?.item
                if(uri!=null)
                    uriHandler.openUri(uri)
                Log.d("TAG","Click en register")
            }
        )


        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = nameUser?:"",
            onValueChange = {
                nameUser = it
                user!!.name=it
                PreferenceManager.savePreferenceUser(context,user)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "User") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Name user") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = password?:"",
            onValueChange = {
                password = it
                user!!.password=it
                PreferenceManager.savePreferenceUser(context,user)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Password") }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Button( modifier = Modifier.fillMaxWidth(),
            onClick = {
                if(bitmap==null) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.you_must_select_a_photo), Toast.LENGTH_LONG
                    ).show()
                    beautyViewModel.isLoading=false
                }else{
                    animal?.image = convertBase64(bitmap)
                    if (animal?.type.isNullOrEmpty()){
                        Toast.makeText(context,
                            context.getString(R.string.you_must_select_whether_it_is_a_cat_dog_or_fish),Toast.LENGTH_LONG).show()
                        beautyViewModel.isLoading=false
                    }
                    else {
                        if (name.isNullOrEmpty()) {
                            Toast.makeText(context,
                            context.getString(R.string.you_must_write_the_name_of_the_animal),Toast.LENGTH_LONG).show()
                            beautyViewModel.isLoading=false
                        } else {
                            if (nameUser!!.isNotEmpty() && nameUser != null && password!!.isNotEmpty() && password != null)
                                beautyViewModel.insertBeauty(
                                    context,
                                    nameUser!!.trim(),
                                    password!!.trim(),
                                    animal
                                )
                            else{
                                Toast.makeText(context,
                                    context.getString(R.string.you_must_enter_the_username_and_password), Toast.LENGTH_LONG).show()
                                beautyViewModel.isLoading=false
                            }

                        }//Final de animal name
                    }//Final de animal type
                }//Final de image
            }) {
         Text(text = stringResource(R.string.Upload_beauty))
        }


    }
}//Final de la funcion


@OptIn(ExperimentalPermissionsApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BeautyPreview(){
    val paddingValues=PaddingValues(10.dp)
    //Beauty(paddingValues)
}
/*
@Composable
fun CamaraComposable(
    camaraController: LifecycleCameraController,
    lifecycleOwner: LifecycleOwner,
    modifier: Modifier
){
    camaraController.bindToLifecycle(lifecycleOwner)
    AndroidView(
        modifier = modifier,
        factory = {
            val previeView=PreviewView(it).apply {
                layoutParams=ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
            previeView.controller=camaraController
            previeView
        }
    )
}

private fun tomarFoto(
    camaraController: LifecycleCameraController,
    executor: Executor,
    directory: File
){

    val image=File.createTempFile("img_", ".png", directory)
    val outputDirectory=ImageCapture.OutputFileOptions.Builder(image).build()
    camaraController.takePicture(
        outputDirectory,
        executor,
        object:ImageCapture.OnImageSavedCallback{
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
               // Toast.makeText(LocalContext.current, "Foto salvada en: "+outputFileResults.savedUri, Toast.LENGTH_LONG).show()
                Log.d("TAG","Foto salvada: "+outputFileResults.savedUri)
            }

            override fun onError(exception: ImageCaptureException) {
                //Toast.makeText(context, "Hubo un error: "+exception.message, Toast.LENGTH_LONG).show()
                Log.d("TAG","Hubo un error: "+exception.message)
            }

        }
    )
}
*/
/*
@Composable
fun hasREquiredPermission():Boolean{
    return CAMERAX_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            LocalContext.current,
            it,
            ) == PackageManager.PERMISSION_GRANTED
    }
}*/

private fun saveToInternalStorage(context: Context, bitmapImage: Bitmap?): String {
    val cw = ContextWrapper(context)
    // path to /data/data/yourapp/app_data/imageDir
    val directory = cw.getDir("imageDir", Context.MODE_PRIVATE)
    // Create imageDir
    val mypath = File(directory, "animal.jpg")

    var fos: FileOutputStream? = null
    try {
        fos = FileOutputStream(mypath)
        // Use the compress method on the BitMap object to write image to the OutputStream
        bitmapImage?.compress(Bitmap.CompressFormat.PNG, 100, fos)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fos!!.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    return directory.absolutePath
}

private fun loadImageFromStorage(context: Context):Bitmap? {
    try {
        val cw = ContextWrapper(context)
        // path to /data/data/yourapp/app_data/imageDir
        val directory = cw.getDir("imageDir", Context.MODE_PRIVATE)
        val f = File(directory, "animal.jpg")
        val b = BitmapFactory.decodeStream(FileInputStream(f))
        return b
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
        return null
    }
}
private fun convertBase64(bitmap: Bitmap?): String {
    if(bitmap!=null){
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
    }else{
        return ""
    }
}











