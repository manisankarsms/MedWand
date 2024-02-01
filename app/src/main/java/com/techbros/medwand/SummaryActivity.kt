package com.techbros.medwand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val returnBtn = findViewById<Button>(R.id.btnReturn)
        val exitBtn = findViewById<Button>(R.id.btnExit)

        val thermVal = findViewById<TextView>(R.id.thermValTv)
        val bpVal = findViewById<TextView>(R.id.bpValTv)

        thermVal.text = MainActivity.temperature.toString()
        bpVal.text = MainActivity.diastolic.toString() + " / " + MainActivity.systolic.toString()

        returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}