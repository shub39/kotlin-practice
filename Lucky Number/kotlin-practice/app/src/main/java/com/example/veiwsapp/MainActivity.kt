package com.example.veiwsapp

import android.content.Intent
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

        val name : TextView = findViewById(R.id.input)
        val luckbtn : Button = findViewById(R.id.btn1)

        luckbtn.setOnClickListener(){

            val name = name.text
            var i = Intent(this, MainActivity2::class.java)

            i.putExtra("name", name)
            startActivity(i)

        }


    }
}


