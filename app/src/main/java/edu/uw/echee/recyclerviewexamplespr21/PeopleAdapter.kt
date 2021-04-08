package edu.uw.echee.recyclerviewexamplespr21

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uw.echee.recyclerviewexamplespr21.databinding.ItemPersonBinding

class PeopleAdapter(private var listOfPeople: List<String>): RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {

    var onPersonClickListener: (position: Int, name: String) -> Unit = { _, _ ->  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context))
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = listOfPeople[position]
        with(holder.binding) {
            tvName.text = person

            itemRoot.setOnClickListener {
               onPersonClickListener(position, person)
            }
        }
    }

    override fun getItemCount(): Int = listOfPeople.size


    fun updatePeople(newListOfPeople: List<String>) {
        this.listOfPeople = newListOfPeople

        notifyDataSetChanged()
    }

    class PersonViewHolder(val binding: ItemPersonBinding): RecyclerView.ViewHolder(binding.root)
}
