package kg.erjan.tz.di

import dagger.Component
import kg.erjan.tz.presentation.activity.MainActivity
import kg.erjan.tz.presentation.fragment.gallery.GalleryFragment
import kg.erjan.tz.presentation.fragment.user_about.UserAboutFragment

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: UserAboutFragment)

    fun inject(fragment: GalleryFragment)

}