package edu.uw.echee.recyclerviewexamplespr21

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
        val id: String,
        val name: String,
        val age: Int
): Parcelable
