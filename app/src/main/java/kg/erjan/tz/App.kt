package kg.erjan.tz

import android.app.Application
import android.content.Context
import kg.erjan.tz.di.AppComponent
import kg.erjan.tz.di.AppModule
import kg.erjan.tz.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }