package com.example.veiwsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name : EditText = findViewById(R.id.editTextText)
        val btn = findViewById<Button>(R.id.button)


        btn.setOnClickListener(){
            var text = name.text

            Toast.makeText(this,
                "Hello "+ text,
                Toast.LENGTH_LONG).show()

        }
    }
}


