package com.dp.demosqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    companion object{
        private val DB_NAME = "StudentDB"
        private val TB_NAME ="Student"
        private val DB_VER = 1

        private val S1  = "Id"
        private val S2  = "Name"
        private val S3  = "Age"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "create table $TB_NAME ($S1 Integer Primary key AUTOINCREMENT, $S2 text, $S3 Integer)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun insert(st:Student) : Long
    {
        var db = writableDatabase
        var cv=   ContentValues()
        cv.put(S2,st.name)
        cv.put(S3,st.age)

        var result = db.insert(TB_NAME,null,cv)
        return result
    }
    fun RetrieveData() : ArrayList<Student>
    {
        var db = readableDatabase
        var arr = ArrayList<Student>()

        var cursor = db.query(TB_NAME,null,null,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var Age = cursor.getInt(2)

            var st = Student(id,name,Age)
            arr.add(st)
        }

        return arr
    }
}