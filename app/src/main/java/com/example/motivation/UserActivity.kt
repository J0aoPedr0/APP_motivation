package com.example.motivation
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSave.setOnClickListener {verification() }
    }

    private fun verification() {
        val userName = binding.editUserName.text.toString()
        if (userName != "") {

            SharedPreferences(this).storeString("USER_NAME", userName)

            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Por favor coloque um nome.", Toast.LENGTH_SHORT).show()
        }
    }
}

