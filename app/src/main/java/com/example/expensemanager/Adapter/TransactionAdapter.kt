package com.example.expensemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensemanager.Model.TransctionModel
import com.example.expensemanager.R

class TransactionAdapter(val list:ArrayList<TransctionModel>):RecyclerView.Adapter<TransactionAdapter.MyviewHolder>(){

    class MyviewHolder(v: View):RecyclerView.ViewHolder(v){

        val txtamount:TextView=v.findViewById(R.id.txtamuont)
        val txtcategory:TextView=v.findViewById(R.id.txtcategory)
        val txtdate:TextView=v.findViewById(R.id.txtdate)
        val txttime:TextView=v.findViewById(R.id.txttime)
        val txtmode:TextView=v.findViewById(R.id.txtmode)
        val txtnote:TextView=v.findViewById(R.id.txtnote)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyviewHolder {

        val v =LayoutInflater.from(parent.context).inflate(R.layout.transaction_item,parent,false)
        val holder=MyviewHolder(v)

        return holder
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        holder.txtamount.text=list.get(position).amount.toString()
        holder.txtcategory.text=list.get(position).category
        holder.txtdate.text=list.get(position).date
        holder.txttime.text=list.get(position).time
        holder.txtmode.text=list.get(position).mode
        holder.txtnote.text=list.get(position).note

    }
    override fun getItemCount(): Int {
        return list.size
    }
}