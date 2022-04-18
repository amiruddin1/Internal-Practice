package com.dp.demosqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Refresh()
        Insert.setOnClickListener {
            if(edtname.text.toString().equals("") || edtAge.text.toString().equals(""))
            {
                Toast.makeText(this,"Insert Data Accurately",Toast.LENGTH_LONG).show()
            }
            else
            {
                var name = edtname.text.toString()
                var age = edtAge.text.toString().toInt()

                var st = Student(name,age)

                var db = DBHelper(this)
                var res = db.insert(st)
                if(res>0)
                {
                    Toast.makeText(this,"Insert Data Successfully",Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(this,"Got error!!",Toast.LENGTH_LONG).show()
            }


        }

    }
    fun Refresh()
    {
        var db = DBHelper(this)
        var st = db.RetrieveData()

        var ad = MyAdapter(this,st)
        myrecyclerOP.adapter = ad
    }
}