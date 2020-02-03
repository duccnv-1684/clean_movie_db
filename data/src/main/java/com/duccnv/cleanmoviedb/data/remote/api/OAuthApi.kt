package com.duccnv.cleanmoviedb.data.remote.api

import com.duccnv.cleanmoviedb.data.model.Token
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface OAuthApi {

    @POST("/oauth/token")
    @FormUrlEncoded
    fun refreshToken(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String
    ): Call<Token>
}