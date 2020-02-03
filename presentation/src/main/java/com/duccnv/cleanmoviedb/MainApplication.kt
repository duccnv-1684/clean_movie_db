package com.duccnv.cleanmoviedb

import com.crashlytics.android.Crashlytics
import com.duccnv.cleanmoviedb.crashlytics.CrashlyticsTree
import com.duccnv.cleanmoviedb.data.BuildConfig
import com.duccnv.cleanmoviedb.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric

class MainApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<MainApplication> = DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        val crashlytics = CrashlyticsCore.Builder()
            .disabled(BuildConfig.DEBUG)
            .build()
        Fabric.with(this, Crashlytics.Builder().core(crashlytics).build())

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.plant(CrashlyticsTree())
    }
}