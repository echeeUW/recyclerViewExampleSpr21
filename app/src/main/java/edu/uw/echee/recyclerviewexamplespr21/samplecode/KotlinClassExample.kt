package edu.uw.echee.recyclerviewexamplespr21

import android.graphics.Point

// Properties (setter getters), null/lateinit, constructors, lazy,


//class Car {
//
//    val model: String
//    private val year: Int
//
//    constructor(model: String, year: Int = 1234) {
//        this.model = model
//        this.year = year
//    }
//}


open class Car(var model: String, var year: Int)

class ElectricCar(model: String, year: Int, var batteryCapacity: Long): Car(model, year) {

    fun startEngine() {

    }

}




fun main() {

    val myCar = Car("Corolla", 2007)

    val myTesla = ElectricCar("Model X", 2014, 9001L).apply {
        startEngine()
        batteryCapacity = 12343454566
    }

    myTesla.model
    myTesla.year
    myTesla.batteryCapacity

    with(myTesla) {
        model
        year
        startEngine()
        batteryCapacity = 123214235
    }




}



