package com.example.motivation.UserInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.R
import com.example.motivation.infrastructure.MotivationConstants
import com.example.motivation.infrastructure.SharedPreferences
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

            MotivationConstants()

            SharedPreferences(this).storeString(MotivationConstants.KEY.User_Name, userName)

            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, getString(R.string.Please_put_a_name), Toast.LENGTH_SHORT).show()
        }
    }
}

