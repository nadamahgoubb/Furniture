package com.example.furniture.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.furniture.R
import com.example.furniture.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private  lateinit  var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        }


}