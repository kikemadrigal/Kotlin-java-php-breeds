plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id ("kotlin-kapt")
    id("com.google.devtools.ksp")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "es.tipolisto.breeds"
    compileSdk = 36

    defaultConfig {
        applicationId = "es.tipolisto.breeds"
        minSdk = 24
        targetSdk = 36
        versionCode = 5
        versionName = "3.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    //Corrutinas de las activities
    implementation(libs.androidx.lifecycle.runtime.ktx)
    //Aki detro está el image picker selector de fotos
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // PERMISOS
    implementation(libs.accompanist.permissions)
    implementation(libs.androidx.appcompat)
    //CameraX:https://developer.android.com/jetpack/androidx/releases/camera?hl=es-419
    // CameraX core library using the camera2 implementation
    //val camerax_version = "1.4.0-alpha04"
    //val cameraxVersion = "1.4.2"
    // The following line is optional, as the core library is included indirectly by camera-camera2
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    // If you want to additionally use the CameraX Lifecycle library
    implementation(libs.androidx.camera.lifecycle)
    // If you want to additionally use the CameraX VideoCapture library
    implementation(libs.androidx.camera.video)
    // If you want to additionally use the CameraX View class
    implementation(libs.androidx.camera.view)
    // If you want to additionally add CameraX ML Kit Vision Integration
    //implementation("androidx.camera:camera-mlkit-vision:${camerax_version}")
    // If you want to additionally use the CameraX Extensions library
    implementation(libs.androidx.camera.extensions)
    //Para recortar la imagen del animal en beauties
    //implementation("com.vanniktech:android-image-cropper:4.6.0")

    //LiveData para engancharse desde el composable screen al viewModel
    //Si no lo pones, esto no los puedes hacer: val email: String by loginViewModel.email.observeAsState(initial = "")
    implementation (libs.androidx.runtime.livedata)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //implementation ("com.squareup.okhttp3:logging-interceptor:4.4.0")
    //implementation ("com.squareup.okhttp3:okhttp:4.12.0")
    //implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    //implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    //Iconos a tope
    implementation (libs.androidx.material.icons.extended)

    //Tabs
    //implementation("com.google.accompanist:accompanist-pager:0.20.0")
    //implementation("com.google.accompanist:accompanist-pager-indicators:0.20.0")

    //Para ver las afotos
    //implementation ("com.squareup.picasso:picasso:2.71828")
    //Imágenes: https://developer.android.com/jetpack/compose/graphics/images?hl=es-419
    //Cargar imágenes con internet:
    //Recuerda poner en el manifest: <uses-permission android:name="android.permission.INTERNET"/>
    //La librería de coil nos va a permitir cargar imágenes de forma muy sencilla desde internet
    //Coil: https://github.com/coil-kt/coil#jetpack-compose
    implementation(libs.coil.compose)

    //Navegación:https://developer.android.com/codelabs/jetpack-compose-navigation?hl=es-419#3
    /*
    1.Añade la dependencia
    2.Crea un archivo AppNavigation, dentro crea una clase un NaController y un NavHost dentro del navHost les defines las ventanas:
    @Composable
    fun AppNavigation(catsViewModel:CatsViewModel){
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = AppScreens.SplashScreen.route
        ) {
            composable("destino1"){
                GameCatScreen(navController,catsViewModel)
            }
            composable("destino2"){
                ListCatsScreen(navController,catsViewModel)
            }
            composable(
                route="destino_con_argumentos"+"/{reference_image_id}",
                arguments = listOf(
                    navArgument(name="reference_image_id"){type= NavType.StringType})
            )
            {
                val referenceImageId:String?=it.arguments?.getString("reference_image_id")
                requireNotNull(referenceImageId, { "No puede ser nulo" })
                DetailCatScreen(navController,catsViewModel,referenceImageId)
            }
       }
   }
    3.Para navegar a las pantallas desde los eventos on click pon :
    navController.navigate("destino")
    y si tiene argumentos pon:
     Column(modifier= Modifier
        .clickable {
            navController.navigate("destino"+"/${cat.reference_image_id}")
        }
      ){}
     */
    //val navVersion = "2.9.0"
    //noinspection GradleDependency
    implementation(libs.androidx.navigation.compose)

    //Room
    //https://developer.android.com/training/data-storage/room?hl=es-419#kts
    /*
    1. se añade el pluging kotlin-kapt y las dependecias
    2 .Se crea la entidad, en nuestro caso crearemos RecordEntity como data class
    3 .Se crea el modelo dao de cada entidad que es un interfaz, en nuestro caso RecordDao
    4. Se crea la base de datos que es una clase abstracta que tiene de mienbro una función que devuelve la interface RecordDao
    5. Se crea en el main:
         val dataBase= Room.databaseBuilder(this, UserDatabase::class.java, "db_users" ).build()
         val dao=dataBase.UserDao()
         debes de usar un viewModel(dao)
         val viewModel=UsersViewModel(dao)
         y un navManager para la navegación
         NavManager(viewModel = viewModel)
     */
    //val roomersion = "2.7.2"
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.room.compiler)
    // To use Kotlin annotation processing tool (kapt)
    //kapt("androidx.room:room-compiler:$room_version")
    ksp(libs.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)



    testImplementation(libs.junit)
    //androidTestImplementation(libs.androidx.junit)
    //androidTestImplementation(libs.androidx.espresso.core)
    //androidTestImplementation(platform(libs.androidx.compose.bom))
    //androidTestImplementation(libs.androidx.ui.test.junit4)
    //debugImplementation(libs.androidx.ui.tooling)
    //debugImplementation(libs.androidx.ui.test.manifest)
}