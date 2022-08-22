import Dependency.core
import Dependency.domain

plugins {
    id(Dependency.Application.library)
    id(Dependency.Kotlin.kotlinAndroidJetBrains)
    id(Dependency.Kotlin.kotlinKapt)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //Module
    implementation(domain)
    implementation(core)

    implementation(Dependency.androidx.coreKtx)
    implementation(Dependency.androidx.appCompat)
    implementation(Dependency.androidx.material)

    //Coroutine
    implementation(Dependency.Coroutine.coroutine)

    //Gson
    implementation(Dependency.Gson.gson)
}