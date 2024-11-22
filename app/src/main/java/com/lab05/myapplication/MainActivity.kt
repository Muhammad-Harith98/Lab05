package com.harith.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harith.myapplication.databinding.ActivityMainBinding
import com.lab05.myapplication.R
import com.lab05.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeOrderButton.setOnClickListener {
            var pizzaSizePrice = 0.0
            var toppingsPrice = 0.0

            // Determine pizza size price
            when {
                binding.smallRadioBtn.isChecked -> pizzaSizePrice = 5.0
                binding.mediumRadioBtn.isChecked -> pizzaSizePrice = 7.0
                binding.largeRadioBtn.isChecked -> pizzaSizePrice = 10.0
            }

            // Calculate toppings price
            if (binding.onionBox.isChecked) toppingsPrice += 1.0
            if (binding.olivesBox.isChecked) toppingsPrice += 2.0
            if (binding.tomatoesBox.isChecked) toppingsPrice += 3.0

            // Calculate total price
            val totalPrice = pizzaSizePrice + toppingsPrice

            // Display total price
            binding.totalTextView.text = getString(R.string.total_price) + " RM %.2f".format(totalPrice)
        }
    }
}
