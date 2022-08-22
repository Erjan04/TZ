package kg.erjan.tz.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kg.erjan.data.repository.GalleryRepositoryImpl
import kg.erjan.data.repository.UserRepositoryImpl
import kg.erjan.domain.repository.GalleryRepository
import kg.erjan.domain.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun provideUserRepositoryImpl(context: Context): UserRepository {
        return UserRepositoryImpl(context)
    }

    @Provides
    fun provideGalleryRepositoryImpl(context: Context): GalleryRepository {
        return GalleryRepositoryImpl(context)
    }

}