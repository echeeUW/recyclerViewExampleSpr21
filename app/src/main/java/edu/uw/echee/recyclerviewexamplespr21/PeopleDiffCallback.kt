package edu.uw.echee.recyclerviewexamplespr21

import androidx.recyclerview.widget.DiffUtil

class PeopleDiffCallback(private val newPeople: List<Person>, private val oldPeople: List<Person>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldPeople.size

    override fun getNewListSize(): Int = newPeople.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newPerson = newPeople[newItemPosition]
        val oldPerson = oldPeople[oldItemPosition]

        return newPerson.id == oldPerson.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newPerson = newPeople[newItemPosition]
        val oldPerson = oldPeople[oldItemPosition]
        return newPerson.age == oldPerson.age && newPerson.name == oldPerson.name
    }
}
