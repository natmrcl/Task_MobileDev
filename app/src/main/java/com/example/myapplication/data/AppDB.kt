package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)

abstract class AppDB : RoomDatabase() {
    abstract fun userDao(): UserDAO
}