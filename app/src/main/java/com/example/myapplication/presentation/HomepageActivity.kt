package com.example.myapplication.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityHomepageBinding


class HomepageActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.exit.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}