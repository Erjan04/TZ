import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object AndroidConfig {
    const val compileSdk = 32
    const val minSdk = 26
    const val targetSdk = 32
}

object Dependency {

    object Application {
        const val application = "com.android.application"
        const val library = "com.android.library"
        const val javaLibrary = "java-library"
    }

    object Kotlin {
        const val kotlinAndroidJetBrains = "org.jetbrains.kotlin.android"
        const val kotlinJvm = "org.jetbrains.kotlin.jvm"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
    }

    object Coroutine {
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1"
    }

    object Dagger2 {
        const val dagger = "com.google.dagger:dagger-android:2.43.2"
        const val daggerKaptCompiler = "com.google.dagger:dagger-compiler:2.43.2"
        const val daggerInject = "javax.inject:javax.inject:1"
    }

    object Test {
        const val jUnit = "org.junit.jupiter:junit-jupiter:5.8.2"
        const val mockitoCore = "org.mockito:mockito-core:4.0.0"
        const val mockito = "org.mockito.kotlin:mockito-kotlin:4.0.0"
        const val mockitoInline = "org.mockito:mockito-inline:3.11.2"
    }

    object lifecycle {
        private const val version = "2.4.0"

        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
    }

    object androidx {
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
        const val material = "com.google.android.material:material:1.3.0"
    }

    object Navigation {
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.5.1"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.5.1"
    }

    object Gson {
        const val gson = "com.google.code.gson:gson:2.8.8"
    }

    object Coil {
        const val coil = "io.coil-kt:coil:2.2.0"
    }

    inline val DependencyHandler.core get() = project(":core")
    inline val DependencyHandler.domain get() = project(":domain")
    inline val DependencyHandler.data get() = project(":data")


}