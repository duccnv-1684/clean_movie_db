package com.duccnv.cleanmoviedb.di.component

import com.duccnv.cleanmoviedb.MainApplication
import com.duccnv.cleanmoviedb.di.builder.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MainApplication>
}