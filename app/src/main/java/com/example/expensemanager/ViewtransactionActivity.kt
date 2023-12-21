package com.example.expensemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensemanager.Adapter.TransactionAdapter
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.Model.TransctionModel
import com.example.expensemanager.databinding.ActivityViewtransactionBinding

class ViewtransactionActivity : AppCompatActivity() {

    lateinit var binding:ActivityViewtransactionBinding

    lateinit var databaseHelper: DatabaseHelper
    lateinit var myadapter:TransactionAdapter
    lateinit var list:ArrayList<TransctionModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityViewtransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {


        databaseHelper= DatabaseHelper(this,"category.db",null,1)

        list=databaseHelper.Transactiondisplay()

        myadapter= TransactionAdapter(list)


        val manager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerview.layoutManager=manager

        binding.recyclerview.adapter=myadapter

    }
}