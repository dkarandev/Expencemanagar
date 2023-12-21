package com.example.expensemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.expensemanager.IncomeExpenseActivity
import com.example.expensemanager.Model.ExpenseModel
import com.example.expensemanager.R

class ExpenseAdapter(var ExpenseActivity: IncomeExpenseActivity, var categorylist:ArrayList<ExpenseModel>):BaseAdapter()
{
    override fun getCount(): Int {

        return  categorylist.size

    }

    override fun getItem(p0: Int): Any? {

        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val view:View=LayoutInflater.from(ExpenseActivity).inflate(R.layout.expense_item,null)
        val expense =view.findViewById<TextView>(R.id.txtexpense)
        expense.text=categorylist[p0].categoryname
        return view
    }
}