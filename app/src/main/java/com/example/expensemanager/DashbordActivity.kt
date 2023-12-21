package com.example.expensemanager

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import com.example.expensemanager.databinding.ActivityDashbordBinding

class DashbordActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashbordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityDashbordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

        binding.imgmenu.setOnClickListener {

           binding.drawerlayout.openDrawer(binding.navigation)
        }

        binding.category.setOnClickListener {

            var i=Intent(this@DashbordActivity,CategoryActivity::class.java)
            startActivity(i)

        }
        binding.expense.setOnClickListener {

            var i=Intent(this@DashbordActivity,IncomeExpenseActivity::class.java)
            i.putExtra("expense",1)
            startActivity(i)

        }
        binding.income.setOnClickListener {

            var i=Intent(this,IncomeExpenseActivity::class.java)
            i.putExtra("expense",0)
            startActivity(i)

        }
        binding.viewtransaction.setOnClickListener {

            var i=Intent(this@DashbordActivity,ViewtransactionActivity::class.java)
            startActivity(i)

        }
        binding.linrate.setOnClickListener {

            var i=Intent(this@DashbordActivity,RateActivity::class.java)
            startActivity(i)


        }
        binding.linpayment.setOnClickListener {

            var i=Intent(this@DashbordActivity,DashbordActivity::class.java)
            startActivity(i)
        }

        binding.linhome.setOnClickListener {

            var i=Intent(this@DashbordActivity,DashbordActivity::class.java)
            startActivity(i)

        }

        binding.linaddcatagory.setOnClickListener {

            var i=Intent(this@DashbordActivity,CategoryActivity::class.java)
            startActivity(i)

        }
        binding.lincalender.setOnClickListener {
            binding.datepicker.visibility=View.GONE
            datepicker()
        }

        binding.imgdate.setOnClickListener {
            binding.datepicker.visibility=View.GONE
            datepicker()
        }

        binding.datepicker.init(2023,0,1,

            DatePicker.OnDateChangedListener{ view,year,month,dayofmonth->
                val selectdate ="$dayofmonth/${month+1}/$year"
            })
    }

    private fun datepicker() {

        var initialYear =2023
        var initialMonth=0
        var initialDay=1

        var DatePickerDialog=DatePickerDialog(
            this,

            DatePickerDialog.OnDateSetListener{ view,year,month,dayofmonth ->
                val selectdate ="$dayofmonth/${month+1}/$year"

            },

            initialYear,
            initialMonth,
            initialDay,
        )
        DatePickerDialog.show()

    }
}