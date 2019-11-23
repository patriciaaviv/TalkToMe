package com.example.clientapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.*

import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    var countHappy = 0
    var countSad = 0
    var countAngry = 0
    var countNeutral = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val happyButton = findViewById<Button>(R.id.button_happy)
        val sadButton = findViewById<Button>(R.id.button_sad)
        val angryButton = findViewById<Button>(R.id.button_angry)
        val neutralButton = findViewById<Button>(R.id.button_neutral)


        happyButton.setOnClickListener {
            countHappy++
        }

        sadButton.setOnClickListener {
            countSad++
        }

        angryButton.setOnClickListener {
            countAngry++
        }

        neutralButton.setOnClickListener {
            countNeutral
        }
    }

}
