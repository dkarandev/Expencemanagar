package com.example.expensemanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    lateinit var  binding:ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }
    private fun initview() {

        var databaseHelper=DatabaseHelper(this,"category.db",null,1)
        binding.btninsert.setOnClickListener {

            val categoryname=binding.edtcategory.text.toString()


            var i=Intent(this@CategoryActivity,DashbordActivity::class.java)
            startActivity(i)

            databaseHelper.CategoryInsertData(categoryname)
            Log.e("TAG", "initview: "+categoryname)
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()

        }


        binding.btnmodeinsert.setOnClickListener {

            val mode=binding.edtpaymentmode.text.toString()


            var i=Intent(this@CategoryActivity,DashbordActivity::class.java)
            startActivity(i)

            databaseHelper.modedata(mode)
            Log.e("TAG", "initview: "+mode)
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()

        }


    }
}