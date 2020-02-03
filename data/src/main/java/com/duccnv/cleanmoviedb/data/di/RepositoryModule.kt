package com.duccnv.cleanmoviedb.data.di

import androidx.room.Room
import android.content.Context
import com.duccnv.cleanmoviedb.data.Constants
import com.duccnv.cleanmoviedb.data.ContributorRepositoryImpl
import com.duccnv.cleanmoviedb.data.ItemRepositoryImpl
import com.duccnv.cleanmoviedb.data.UserRepositoryImpl
import com.duccnv.cleanmoviedb.data.local.db.AppDatabase
import com.duccnv.cleanmoviedb.data.local.pref.AppPrefs
import com.duccnv.cleanmoviedb.data.local.pref.PrefHelper
import com.duccnv.cleanmoviedb.domain.repository.ContributorRepository
import com.duccnv.cleanmoviedb.domain.repository.ItemRepository
import com.duccnv.cleanmoviedb.domain.repository.UserRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @DatabaseInfo
    fun providerDatabaseName(): String {
        return Constants.DATABASE_NAME
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun providePrefHelper(appPrefs: AppPrefs): PrefHelper {
        return appPrefs
    }

    @Provides
    @Singleton
    fun providerAppPrefs(context: Context): AppPrefs {
        return AppPrefs(context, Gson())
    }

    @Provides
    @Singleton
    fun providerUserRepository(repository: UserRepositoryImpl): UserRepository {
        return repository
    }

    @Provides
    @Singleton
    fun providerItemRepository(repository: ItemRepositoryImpl): ItemRepository {
        return repository
    }

    @Provides
    @Singleton
    fun providerContributorRepository(repository: ContributorRepositoryImpl): ContributorRepository {
        return repository
    }
}
