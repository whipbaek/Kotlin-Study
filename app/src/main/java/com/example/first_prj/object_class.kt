package com.example.first_prj

//Singleton Pattern
object CarFactory { //객체를 딱 한번만 만든다.
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car{
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main(){
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}