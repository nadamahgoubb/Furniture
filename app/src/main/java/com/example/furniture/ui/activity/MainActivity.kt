package com.example.furniture.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.furniture.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, com.example.furniture.R.layout.activity_main)
        bottomNavigationView=binding.bottomNavigationView
        initNav()
    }



    private fun initNav() {

        var navController =
            supportFragmentManager.findFragmentById(com.example.furniture.R.id.navHostFragment)
                ?.findNavController()

        if (navController != null) {
            bottomNavigationView.setupWithNavController(navController)
        }

    }
}