plugins {
    id("com.android.application")
    //id("com.google.gms.google-services") version "4.3.10" // Remplacez la version par la version actuelle
}




android {
    namespace = "com.example.temphumgeolocalisation"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.temphumgeolocalisation"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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
}

dependencies {
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("com.squareup.retrofit:retrofit:2.0.0-beta2")
    implementation ("com.squareup.retrofit:converter-gson:2.0.0-beta2")
    implementation ("com.jjoe64:graphview:4.2.2")
    implementation ("com.google.android.gms:play-services-maps:17.0.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    //implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Dans le bloc dependencies
    /*implementation ("androidx.camera:camera-camera2:1.1.0")
    implementation ("androidx.camera:camera-lifecycle:1.1.0")
    implementation ("androidx.camera:camera-view:1.0.0-alpha30")


    implementation ("androidx.camera:camera-core:1.1.0")
    implementation ("androidx.camera:camera-camera2:1.1.0")


    implementation ("androidx.camera:camera-core:1.1.0")
    implementation ("androidx.camera:camera-camera2:1.1.0")
    implementation ("androidx.camera:camera-lifecycle:1.1.0")
    implementation ("androidx.camera:camera-view:1.0.0-alpha30")
    implementation ("androidx.camera:camera-extensions:1.0.0-alpha30")

*
/
     */

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation ("androidx.appcompat:appcompat:1.3.1")

}