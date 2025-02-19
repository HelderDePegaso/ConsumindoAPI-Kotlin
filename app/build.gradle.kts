plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.tarefa.com"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.tarefa.com"
        minSdk = 30
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildToolsVersion = "34.0.0"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.play.services.wearable)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Necessários para o APP

    implementation("io.coil-kt:coil-compose:2.4.0")
//
//
//
//
//
//    implementation("androidx.compose.ui:ui:1.5.1")
//    implementation ("androidx.compose.material:material:1.5.1")
//    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.1")
//    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation ("io.coil-kt:coil-compose:2.4.0")
//
//    implementation("androidx.activity:activity-compose:1.8.1") // Or latest version
//    implementation("androidx.compose.ui:ui:1.5.1")            // Or latest version
//    implementation("androidx.compose.ui:ui-graphics:1.5.1")      // Or latest version
//    implementation("androidx.compose.ui:ui-tooling-preview:1.5.1") // Or latest version
//    implementation("androidx.compose.material3:material3:1.2.0-alpha10") // Or latest version
//
//
//    implementation("androidx.core:core-ktx:1.15.0")
//
//
//    implementation("androidx.activity:activity-compose:1.8.0")
//
//    debugImplementation("androidx.compose.ui:ui-tooling:1.5.1")
//    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.1")
//
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation("androidx.compose.ui:ui:1.5.1")
//    implementation("androidx.compose.material:material:1.5.1")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.5.1")
//    implementation("io.coil-kt:coil-compose:2.4.0") // Para carregar imagens
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(libs.kotlinx.coroutines.android)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}