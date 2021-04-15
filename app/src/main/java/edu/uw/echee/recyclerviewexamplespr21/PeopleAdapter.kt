package edu.uw.echee.recyclerviewexamplespr21

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import edu.uw.echee.recyclerviewexamplespr21.databinding.ItemPersonBinding

class PeopleAdapter(private var listOfPeople: List<Person>): RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {

    var onPersonClickListener: (position: Int, person: Person) -> Unit = { position, person -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context))
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person: Person = listOfPeople[position]
        with(holder.binding) {

            tvName.text = root.context.getString(R.string.name_with_age_format, person.name, person.age)

            root.setOnClickListener {
                onPersonClickListener(position, person)
            }
        }
    }

    override fun getItemCount(): Int = listOfPeople.size


    fun updatePeople(newListOfPeople: List<Person>) {

        val callback = PeopleDiffCallback(newListOfPeople, listOfPeople)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)

        this.listOfPeople = newListOfPeople
    }

    class PersonViewHolder(val binding: ItemPersonBinding): RecyclerView.ViewHolder(binding.root)
}
