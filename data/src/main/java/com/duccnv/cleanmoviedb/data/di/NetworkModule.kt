package com.duccnv.cleanmoviedb.data.di

import com.duccnv.cleanmoviedb.data.remote.api.ContributorApi
import com.duccnv.cleanmoviedb.data.remote.api.ItemApi
import com.duccnv.cleanmoviedb.data.remote.api.UserApi
import com.duccnv.cleanmoviedb.data.remote.builder.RetrofitBuilder
import com.duccnv.cleanmoviedb.data.remote.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(retrofitBuilder: RetrofitBuilder, headerInterceptor: HeaderInterceptor): Retrofit = retrofitBuilder
        .addInterceptors(headerInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideUsersApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideItemsApi(retrofit: Retrofit): ItemApi = retrofit.create(ItemApi::class.java)

    @Provides
    @Singleton
    fun provideContributorApi(retrofit: Retrofit): ContributorApi = retrofit.create(ContributorApi::class.java)
}