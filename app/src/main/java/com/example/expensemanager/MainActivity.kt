package com.example.expensemanager

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initview()
    }

    private fun initview() {

        Handler().postDelayed({
            val i = Intent(this@MainActivity, DashbordActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)

    }
}