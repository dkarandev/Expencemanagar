package com.example.expensemanager.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.expensemanager.Model.ExpenseModel
import com.example.expensemanager.Model.ModeModel
import com.example.expensemanager.Model.TransctionModel

class DatabaseHelper (context: Context,name:String,factory: CursorFactory?,version:Int):SQLiteOpenHelper(context,name,factory,version) {

    override fun onCreate(db: SQLiteDatabase?) {

        val sql="create table CategoryTb (categoryid integer primary key autoincrement,categoryname text)"
        db?.execSQL(sql)

        val sql2="create table modeTb (categoryid integer primary key autoincrement,mode text)"
        db?.execSQL(sql2)

        val sql1="create table ExpenseTb (expenseid integer primary key autoincrement,amount integer,category text,date text,time text,mode text,note text)"
        db?.execSQL(sql1)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun CategoryInsertData(categoryname:String)
    {
        val db=writableDatabase

        val c=ContentValues()

        c.put("categoryname",categoryname)

        val k=db.insert("CategoryTb",null,c)
        Log.e("TAG", "insertData: "+k)
    }

    fun modedata(mode:String)
    {
        val db=writableDatabase

        val c=ContentValues()

        c.put("mode",mode)

        val k=db.insert("modeTb",null,c)
        Log.e("TAG", "insertData: "+k)
    }

    fun ExpenseeditData(amount:Int,category:String,date:String,time:String,mode:String,note:String)
    {
        val db=writableDatabase
        val k=ContentValues()
        k.put("amount",amount)
        k.put("category",category)
        k.put("date",date)
        k.put("time",time)
        k.put("mode",mode)
        k.put("note",note)

        val a=db.insert("ExpenseTb",null,k)
        Log.e("TAG", "editData: "+a )

    }

    fun CategorydisplayRecord ():ArrayList<ExpenseModel>{

        var list= ArrayList<ExpenseModel>()
        list.clear()
        var db=readableDatabase
        var sql="select * from CategoryTb"
        var cursor:Cursor=db.rawQuery(sql,null)

        if (cursor.moveToFirst())
        {

            do {

                var id=cursor.getInt(0)
                var categoryname=cursor.getString(1)

                Log.e("TAG", "displayRecord: "+categoryname)
                list.add(ExpenseModel(id,categoryname))

            }while (cursor.moveToNext())

        }
        return list

    }

    fun Paymentmode ():ArrayList<ModeModel>{

        var list= ArrayList<ModeModel>()
        list.clear()
        var db=readableDatabase
        var sql="select * from modeTb"
        var cursor:Cursor=db.rawQuery(sql,null)

        if (cursor.moveToFirst())
        {

            do {

                var id=cursor.getInt(0)
                var mode=cursor.getString(1)

                Log.e("TAG", "displayRecord: "+mode)
                list.add(ModeModel(id,mode))

            }while (cursor.moveToNext())

        }
        return list

    }


    fun Transactiondisplay():ArrayList<TransctionModel>{

        val list=ArrayList<TransctionModel>()
        list.clear()
        val db=readableDatabase
        val sql="select * from ExpenseTb"
        val cursor:Cursor=db.rawQuery(sql,null)

        if (cursor.moveToFirst()){
            do{

                val id=cursor.getInt(0)
                val amount=cursor.getInt(1)
                val category=cursor.getString(2)
                val date=cursor.getString(3)
                val time=cursor.getString(4)
                val mode=cursor.getString(5)
                val note=cursor.getString(6)

                val model=TransctionModel(id,amount,category,date,time,mode,note)
                list.add(model)

            }while (cursor.moveToNext())
        }
        return list
    }

}