package com.example.myapplication.presentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.User
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.register.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        viewBinding.login.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}
