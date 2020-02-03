package com.duccnv.cleanmoviedb.domain.repository

import com.duccnv.cleanmoviedb.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository : Repository {
    fun getUser(id: String, fromServer: Boolean): Single<User>

    fun signin(userName: String, password: String): Completable

    fun saveUser(user: User)
}