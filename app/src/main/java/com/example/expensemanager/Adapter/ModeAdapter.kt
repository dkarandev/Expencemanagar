package com.example.expensemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.expensemanager.IncomeExpenseActivity
import com.example.expensemanager.Model.ModeModel
import com.example.expensemanager.R

class ModeAdapter(var DataDisplayActivity: IncomeExpenseActivity,var modelist:ArrayList<ModeModel>):BaseAdapter() {

    override fun getCount(): Int {

        return modelist.size

    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view:View=LayoutInflater.from(DataDisplayActivity).inflate(R.layout.mode_item,null)
        val modeTextView=view.findViewById<TextView>(R.id.txtmode)
        modeTextView.text= modelist[position].toString()
        return view
    }
}