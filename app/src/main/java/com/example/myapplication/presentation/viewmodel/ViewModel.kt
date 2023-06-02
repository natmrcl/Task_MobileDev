package com.example.myapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Database
import com.example.myapplication.data.User

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val userDAO = Database.getInstance(application).userDao()

    val allUsers: LiveData<List<User>> = userDAO.getAllUsers()


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDAO.addUser(user)
        }
    }

    suspend fun checkUser(username: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            userDAO.login(username, password)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDAO.deleteUser(user)
        }
    }
}