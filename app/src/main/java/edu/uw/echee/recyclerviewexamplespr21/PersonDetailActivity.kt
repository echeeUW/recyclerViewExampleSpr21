package edu.uw.echee.recyclerviewexamplespr21

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.echee.recyclerviewexamplespr21.databinding.ActivityPersonDetailBinding

private const val PERSON_NAME_KEY = "person_name"
private const val PERSON_AGE_KEY = "person_age"
private const val PERSON_KEY = "person"

fun navigateToPersonDetailActivity(context: Context, person: Person) = with(context) {
    // take the person object send it to

    val intent = Intent(this, PersonDetailActivity::class.java).apply { // declare to launch PersonDetailActivity
        val bundle = Bundle().apply {
            putString(PERSON_NAME_KEY, person.name)
            putInt(PERSON_AGE_KEY, person.age)

            // Use parcelable for passing custom objects
            putParcelable(PERSON_KEY, person)
        }
        putExtras(bundle)
    }

    startActivity(intent)
}

class PersonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonDetailBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
            val personName: String? = intent.extras?.getString(PERSON_NAME_KEY)
            val age: Int? = intent.extras?.getInt(PERSON_AGE_KEY, 0)

            val person: Person? = intent.getParcelableExtra<Person>(PERSON_KEY)

            tvPerson.text = "${person?.name} - their ${person?.age} years old"  // TODO Should update this to string resource format
        }




    }
}
