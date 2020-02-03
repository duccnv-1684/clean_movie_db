package com.duccnv.cleanmoviedb.di.builder

import com.duccnv.cleanmoviedb.MainActivity
import com.duccnv.cleanmoviedb.ui.contributor.ContributorFragment
import com.duccnv.cleanmoviedb.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeRepoDetailFragment(): ContributorFragment
}
