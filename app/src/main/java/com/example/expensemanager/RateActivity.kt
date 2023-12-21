package com.example.expensemanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expensemanager.databinding.ActivityRateBinding

class RateActivity : AppCompatActivity() {

    lateinit var binding: ActivityRateBinding

    var ratingvalue:Float=0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityRateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

        binding.submit.setOnClickListener {

            ratingvalue=binding.ratingBar.rating


            Toast.makeText(this, "Rating"+ratingvalue,Toast.LENGTH_SHORT).show()

            var i= Intent(this@RateActivity,DashbordActivity::class.java)
            startActivity(i)
        }

    }
}