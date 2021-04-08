package edu.uw.echee.recyclerviewexamplespr21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import edu.uw.echee.recyclerviewexamplespr21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
            val people = listOf("White Walker", "Spongebob", "Squidward", "Lady Gaga", "Clint", "Thanos", "Stark", "Winter Soldier", "Patrick", "Justin Bieber", "Baby Yoda", "Dave", "Godzilla", "King Kong", "Falcon", "Bucky", "Wanda", "Vision")

            // Set Adapter to Recycler View with data
            val adapter = PeopleAdapter(people)
            rvPeople.adapter = adapter

            // Handle code when clicking item
            adapter.onPersonClickListener = { position, name ->
                Toast.makeText(this@MainActivity, "You clicked at pos: $position for $name", Toast.LENGTH_SHORT).show()
            }

            btnRefresh.setOnClickListener {
                // On Refresh Click, update the list
                adapter.updatePeople(people.toMutableList().shuffled())
            }
        }
    }






}

/**
 * ...
 * listOf("Spongebob", "Squidward", "Lady Gaga", "Clint", "Thanos", "Stark", "Winter Soldier", "Patrick", "Justin Bieber", "Baby Yoda", "Dave", "Godzilla", "King Kong", "Falcon", "Bucky", "Wanda", "Vision")
 */
