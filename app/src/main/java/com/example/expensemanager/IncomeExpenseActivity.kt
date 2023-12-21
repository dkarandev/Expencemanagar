package com.example.expensemanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import com.example.expensemanager.Adapter.ExpenseAdapter
import com.example.expensemanager.Adapter.ModeAdapter
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.Model.ExpenseModel
import com.example.expensemanager.Model.ModeModel
import com.example.expensemanager.databinding.ActivityExpenseBinding
import java.util.Calendar

class IncomeExpenseActivity : AppCompatActivity()
{
    lateinit var binding:ActivityExpenseBinding
    lateinit var databaseHelper: DatabaseHelper
    lateinit var c:String
    lateinit var s:String
     private var categorylist:ArrayList<ExpenseModel> = ArrayList()
     private var modellist:ArrayList<ModeModel>  = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
        pickDate()
        spinner()
    }

    private fun spinner() {

        modellist=databaseHelper.Paymentmode()
        binding.modespinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                s = modellist[p2].mode

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val adapter = ModeAdapter(this,modellist)
        binding.modespinner.adapter = adapter
    }

    private fun initview() {

         databaseHelper=DatabaseHelper(this,"category.tb",null,1)

        binding.imgback.setOnClickListener {
            onBackPressed()
        }

        val data = intent.getIntExtra("expense",-1)

        if (data == 1)
        {

            binding.txtexpense.text = "Add Expense"
            binding.rbexpeense.isChecked =true
        }
        else
        {
            binding.txtexpense.text="Add Income"
            binding.rbincome.isChecked = true
        }

        databaseHelper = DatabaseHelper(this, "category.db", null, 1)

        categorylist = databaseHelper.CategorydisplayRecord()

        binding.categoryspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                c = categorylist[p2].categoryname

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        var adapter = ExpenseAdapter(this@IncomeExpenseActivity, categorylist)
        binding.categoryspinner.adapter = adapter

    }
    private fun pickDate() {

        binding.txtdate.setOnClickListener {

            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    binding.txtdate.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        binding.txttime.setOnClickListener {

            val calendar = Calendar.getInstance()
            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = calendar.get(Calendar.MINUTE)

            val textView: TextView = findViewById(R.id.txttime)


            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    val selectedTime = String.format("%02d:%02d", currentHour, minute)
                    textView.text = selectedTime
                },
                currentHour,
                currentMinute,
                false
            )
            timePickerDialog.show()
        }
        binding.btnsubmit.setOnClickListener {

            var amount=binding.edtamount.text.toString().toInt()
            var category=c
            var date=binding.txtdate.text.toString()
            var time=binding.txttime.text.toString()
            var mode=s
            var note=binding.edtnote.text.toString()

        databaseHelper.ExpenseeditData(amount,category,date,time,mode,note)

            var i = Intent(this, ViewtransactionActivity::class.java)
            startActivity(i)

        }
    }
}