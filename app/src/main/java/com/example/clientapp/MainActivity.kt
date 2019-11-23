package com.example.clientapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.clientapp.ui.ChatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diaryButton = findViewById<Button>(R.id.button_diary)
        diaryButton.setOnClickListener {
            val intent = Intent(this@MainActivity, DiaryActivity::class.java)
            startActivity(intent)
        }

        val historyButton = findViewById<Button>(R.id.button_history)
        historyButton.setOnClickListener {
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        val chatButton = findViewById<Button>(R.id.button_chat)
        chatButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ChatActivity::class.java)
            startActivity(intent)
        }


    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }






}
