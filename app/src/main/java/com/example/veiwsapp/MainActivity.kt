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

        val name : EditText = findViewById(R.id.namebox)
        val btn = findViewById<Button>(R.id.toastbtn)
        val sins : TextView = findViewById(R.id.textView3)
        val btn2 = findViewById<Button>(R.id.button2)

        btn.setOnClickListener() {
            val text = name.text
            val sons = sins.text

            Toast.makeText(
                this,
                "Hello " + text + ", You have committed " + sons + " Sins.",
                Toast.LENGTH_LONG
            ).show()
        }

        btn2.setOnClickListener(){
            sins.setText(""+increasecounter())

        }

    }

    fun increasecounter(): Int{
        counter++
        return counter

    }


}


