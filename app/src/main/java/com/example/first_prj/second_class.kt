package com.example.first_prj

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄수가 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수가 있다.

//람다의 기본정의
// val lamdaName : Type = {argumentList -> codeBody}


val square : (Int) -> (Int) = {number -> number*number}
//Int로 input, Int로 return 하는 람다식(Int로 형식을 적어줘서 body에서 자료형 추론이 가능하다.)
//number : 인풋, number*number : 아웃풋

val nameAge = {name : String, age : Int ->
    "my name is ${name} and I'm ${age}"
}

fun main(){
    println(square(12))
    println(nameAge("whipbaek",27))

    val str : String = "Domino "
    println(str.pizzaIsGreat()) //String class에 확장된 함수를 추가해서 사용 가능하다.

    println(extendString("ariana",27))
    println(calculateGrad(100))
    println(calculateGrad(2000))

    val lamda = {number : Double ->
        number == 4.3213
    }

    println(invokeLamda(lamda))
    println(invokeLamda({it > 3.22})) //lamda literal
    invokeLamda { it > 3.22 } // 마지막 parameter(=it) 가 람다식일때 이렇게 소괄호 생략 가능


}

// 2.확장함수

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"} // 파라미터가 하나일 경우 it으로 대체 가능하다.
    return name.introduceMyself(age)
}

//람다의 Return

val calculateGrad : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "another value"
    }
}

// 람다를 표현하는 여러가지 방법

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean{ //lamda식을 파라미터로 받는다.
    return lamda(5.2343)
}
