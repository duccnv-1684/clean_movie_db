package com.duccnv.cleanmoviedb.data.local.pref

import com.duccnv.cleanmoviedb.data.model.Token

interface PrefHelper {
    fun isFirstRun(): Boolean

    fun setFirstRun(boolean: Boolean)

    fun getToken(): Token?

    fun setToken(token: Token)
}