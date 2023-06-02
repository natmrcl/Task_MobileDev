package com.example.myapplication.data

import android.content.Context
import androidx.room.Room

object Database {
    private var instance: AppDB? = null

    fun getInstance(context: Context): AppDB {
        return instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                context.applicationContext, AppDB::class.java, "app_db"
            ).build().also {
                return it
            }
        }
    }

}