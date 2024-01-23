package com.example.veiwsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input1 : EditText = findViewById(R.id.input)
        val btn : Button = findViewById(R.id.btn1)
        val result1 : TextView = findViewById(R.id.text1)

        btn.setOnClickListener(){
            val kilos:Double = input1.text.toString().toDouble()

            result1.setText(""+convert(kilos))
        }

    }

    fun convert(kilos:Double):Double{
        var pounds = kilos * 2.2
        return pounds
    }

}


