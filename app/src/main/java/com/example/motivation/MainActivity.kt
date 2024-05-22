package com.example.motivation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = SharedPreferences(this).getString("USER_NAME")
        binding.textHelloUser.text = "Olá, $name!"

        binding.buttonNewPhrase.setOnClickListener { newPhrase() }
    }

    private fun newPhrase() {
        Toast.makeText(this, "Estou funcionando", Toast.LENGTH_SHORT).show()
    }
}