package com.example.motivation.UserInterface

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.Phrases.Mock
import com.example.motivation.R
import com.example.motivation.infrastructure.MotivationConstants
import com.example.motivation.infrastructure.SharedPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveData()
        handleFilter(R.id.image_infinity)
        handleNextPhrase()
        // Clicks eventes
        binding.buttonNewPhrase.setOnClickListener { view -> handleClicks(view) }
        binding.imageInfinity.setOnClickListener { view -> handleClicks(view) }
        binding.imageSmile.setOnClickListener { view -> handleClicks(view) }
        binding.imageBrightness.setOnClickListener { view -> handleClicks(view) }
    }


    private fun saveData() {
        val name = SharedPreferences(this).getString(MotivationConstants.KEY.User_Name)
        binding.textHelloUser.text = "Olá, $name!"
    }

    private fun handleClicks(view: View) {
        if (view.id == R.id.button_new_phrase) {
            handleNextPhrase()
        }else if (view.id in listOf
                (
                R.id.image_infinity,
                R.id.image_smile,
                R.id.image_brightness
            )
        ) {
            handleFilter(view.id)
        }
    }

    private fun handleNextPhrase() {
        binding.textMotivationPhrase.text = Mock().getPhrase(categoryId)
    }

    private fun handleFilter(id: Int) {
        binding.imageBrightness.setColorFilter(ContextCompat.getColor(this, R.color.purple))
        binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.purple))
        binding.imageInfinity.setColorFilter(ContextCompat.getColor(this, R.color.purple))

        when (id) {
            R.id.image_infinity -> {
                binding.imageInfinity.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }

            R.id.image_smile -> {
                binding.imageSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SMILE
            }

            else -> {
                binding.imageBrightness.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.BRIGHTNESS
            }
        }
    }
}