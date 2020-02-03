package com.duccnv.cleanmoviedb.di.builder

import android.content.Context
import com.duccnv.cleanmoviedb.MainApplication
import com.duccnv.cleanmoviedb.data.di.NetworkModule
import com.duccnv.cleanmoviedb.data.di.RepositoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, FragmentBuildersModule::class, NetworkModule::class, RepositoryModule::class])
class AppModule {

    @Singleton
    @Provides
    fun providerContext(application: MainApplication): Context {
        return application.applicationContext
    }
}