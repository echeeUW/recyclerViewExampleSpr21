package edu.uw.echee.recyclerviewexamplespr21

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.echee.recyclerviewexamplespr21.data.PeopleProvider
import edu.uw.echee.recyclerviewexamplespr21.databinding.ActivityListOfPeopleBinding

fun navigateToListOfPeopleActivity(context: Context) = with(context) {
    val intent = Intent(this, ListOfPeopleActivity::class.java)
    startActivity(intent)
}


class ListOfPeopleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListOfPeopleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityListOfPeopleBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
            val people = PeopleProvider.allPeople

            // Set Adapter to Recycler View with data
            val adapter = PeopleAdapter(people)
            rvPeople.adapter = adapter

            // Handle code when clicking item
            adapter.onPersonClickListener = { pos: Int, person: Person ->
                // make phone call of number(name)
                // tag Person in photo with name....

                // We want to launch the PersonDetailActivity
                navigateToPersonDetailActivity(this@ListOfPeopleActivity, person)
            }

            btnRefresh.setOnClickListener {
                // On Refresh Click, update the list
                adapter.updatePeople(people.toMutableList().shuffled())
            }
        }
    }
}

