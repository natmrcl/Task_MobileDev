package com.example.myapplication.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.presentation.viewmodel.ViewModel

import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding
    private lateinit var vm: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        vm = ViewModelProvider(this)[ViewModel::class.java]

        viewBinding.btnLogin.setOnClickListener{
            val uname = viewBinding.etUname.text.toString()
            val pass = viewBinding.etPassword.text.toString()
            login(uname,pass)

        }
    }

    private fun login(username: String, password: String) {
        lifecycleScope.launch {
            val user = vm.checkUser(username, password)
            if (user != null) {
                showMessage("Login successful!")
                navigateToHome()
            } else {
                showMessage("Login failed. Invalid credentials!")
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomepageActivity::class.java)
        startActivity(intent)
        finish()
    }
}