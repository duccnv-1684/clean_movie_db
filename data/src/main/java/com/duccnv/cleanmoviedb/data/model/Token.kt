package com.duccnv.cleanmoviedb.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Token(
    @Expose @SerializedName("token") val token: String,
    @Expose @SerializedName("expires_in") val expireIn: Long
)