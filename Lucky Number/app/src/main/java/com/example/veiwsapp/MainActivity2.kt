package com.example.veiwsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val luck : TextView = findViewById(R.id.luck)
        val btn : Button = findViewById(R.id.share)

        val name = recieveName()
        Toast.makeText(this, "Get your lucky number " + name, Toast.LENGTH_LONG).show()

        val num = randomNum()

        luck.setText(""+num)

        btn.setOnClickListener(){
            shareData(name, num)
        }


    }

    fun recieveName():String{
        var bundle: Bundle?  = intent.extras
        var name = bundle?.get( "name").toString()
        return name
    }

    fun randomNum():Int{
        val random = Random.nextInt(1000)
        return random
    }

    fun shareData(username: String, num: Int){

        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is $num")
        startActivity(i)

    }

}