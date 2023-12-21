package com.example.expensemanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.expensemanager.Adapter.CategoryAdapter
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.Model.ExpenseModel
import com.example.expensemanager.databinding.ActivityDataDisplayBinding

class DataDisplayActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataDisplayBinding
    var categorylist = ArrayList<ExpenseModel>()
    var id :Int=0
    lateinit var c:String
    lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_display)
        binding=ActivityDataDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    @SuppressLint("Range")
    private fun initview() {
         databaseHelper = DatabaseHelper(this, "category.db", null, 1)

        categorylist = databaseHelper.CategorydisplayRecord()

        binding.spinnercategory.onItemSelectedListener =object :

            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                c=categorylist[p2].categoryname

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        var adapter=CategoryAdapter(this,categorylist)
        binding.spinnercategory.adapter=adapter

    }

}