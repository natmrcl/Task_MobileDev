package com.example.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.User
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.example.myapplication.presentation.viewmodel.ViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityRegisterBinding
    private lateinit var vm: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        vm = ViewModelProvider(this)[ViewModel::class.java]

//        vm.addUser(User(0, "COdebot", "Email.com"))
        viewBinding.btnRegister.setOnClickListener{
            val uname = viewBinding.etUname.text.toString()
            val pass = viewBinding.etPassword.text.toString()

            vm.addUser(User(0,uname,pass))
        }

//        vm.allUsers.observe(this) {
//            viewBinding.txtHello.text = it[0].username
//        }


    }
}