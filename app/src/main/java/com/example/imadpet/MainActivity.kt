package com.example.imadpet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnStartGame =findViewById<Button>(R.id.btnStartGame)
        var message = findViewById<TextView>(R.id.result)
        btnStartGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            message.text = "we are almost there"
        }
    }
}
