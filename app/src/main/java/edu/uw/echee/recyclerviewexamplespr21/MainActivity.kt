package edu.uw.echee.recyclerviewexamplespr21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMessage = findViewById<TextView>(R.id.tvMessage)
    }
}

/**
 * ...
 * vlistOf("Spongebob", "Squidward", "Lady Gaga", "Clint", "Thanos", "Stark", "Winter Soldier", "Patrick", "Justin Bieber", "Baby Yoda", "Dave", "Godzilla", "King Kong", "Falcon", "Bucky", "Wanda", "Vision")
 */
