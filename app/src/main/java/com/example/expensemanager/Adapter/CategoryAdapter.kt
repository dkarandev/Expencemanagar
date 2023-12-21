package com.example.expensemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.expensemanager.DataDisplayActivity
import com.example.expensemanager.Model.ExpenseModel
import com.example.expensemanager.R


class CategoryAdapter(var dataDisplayActivity: DataDisplayActivity, var categorylist:ArrayList<ExpenseModel>):BaseAdapter()
{
    override fun getCount(): Int {

        return categorylist.size

    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val view: View = LayoutInflater.from(dataDisplayActivity).inflate(R.layout.category_item, null)
        val Category = view.findViewById<TextView>(R.id.txtname)
        Category.text = categorylist[p0].categoryname
        return view

    }
}
