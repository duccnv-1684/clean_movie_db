package com.duccnv.cleanmoviedb.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.duccnv.cleanmoviedb.data.local.db.dao.UserDao
import com.duccnv.cleanmoviedb.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}