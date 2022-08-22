import Dependency.core
import Dependency.data
import Dependency.domain

plugins {
    id(Dependency.Application.application)
    id(Dependency.Kotlin.kotlinAndroid)
    id(Dependency.Kotlin.kotlinKapt)
    id(Dependency.Kotlin.kotlinAndroidJetBrains)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "kg.erjan.tz"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    viewBinding {
        isEnabled = true
    }
}

dependencies {

    //Module
    implementation(domain)
    implementation(core)
    implementation(data)

    implementation(Dependency.androidx.coreKtx)
    implementation(Dependency.androidx.appCompat)
    implementation(Dependency.androidx.constraintLayout)
    implementation(Dependency.androidx.material)

    //Navigation
    implementation(Dependency.Navigation.navigationUiKtx)
    implementation(Dependency.Navigation.navigationFragmentKtx)

    //Coroutine
    implementation(Dependency.Coroutine.coroutine)

    //Dagger
    implementation(Dependency.Dagger2.dagger)
    kapt(Dependency.Dagger2.daggerKaptCompiler)
    implementation(Dependency.Dagger2.daggerInject)

    //Coil
    implementation(Dependency.Coil.coil)

}