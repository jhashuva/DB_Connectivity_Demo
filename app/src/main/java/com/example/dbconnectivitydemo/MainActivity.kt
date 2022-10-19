package com.example.dbconnectivitydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var sl: ArrayList<Student>
    lateinit var adapter: StudentAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = DBHelper(this, null)
        var rv = findViewById<RecyclerView>(R.id.rv)
        var rno = findViewById<EditText>(R.id.rollNo)
        var name = findViewById<EditText>(R.id.name)
        var button = findViewById<Button>(R.id.btn)
        adapter = StudentAdaptor()


        button.setOnClickListener(){
            db.insert(rno.text.toString(), name.text.toString())
            sl = db.get()!!
            adapter.addList(sl)
        }
        sl = db.get()!!
        adapter.addList(sl)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter


    }
}