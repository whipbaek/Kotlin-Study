package com.example.first_prj

//pojo class
data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// 위의 클래스를 compile하면 만들어지는 것들 -> toString(), hashCode(), equals(), copy()
// 자바와 다르게 몸체없이도 기본적인 클래스 기능을 할 수 있다.

class TicketNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main(){
    val ticketA = Ticket("KoreanAir","whipbaek","2022-02-01",38)
    val ticketB = TicketNormal("KoreanAir","whipbaek","2022-02-01",38)

    println(ticketA)
    println(ticketB)
    //출력의 결과가 다른것을 볼 수 있다.
}
