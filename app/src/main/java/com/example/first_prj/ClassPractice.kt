package com.example.first_prj

//파일이름과 클래스가 달라도 됨.
//여러 클래스를 한 파일에 넣어도 됨


class human constructor(name : String ) { //생성자는 함수명에 사용된다. 또한 constructor은 생략가능, val name : String 처럼 선언과 동시에 초기화 할 수 있다.

    val new_name = name

    fun eatingCake(){
        println("Eat Cake!")
    }
}

class default_human (val name : String = "Anonymous"){ // default값을 줄 수 있다.

    fun print_human_name(){
        println(name)
    }
}

open class start_human (val name : String = "Anonymous") { //주 생성자

    constructor(name : String, age : Int) : this(name) { //부 생성자, 주 생성자의 위임을 받아야한다.
        println("name is ${name} , ${age} years old")
    }

    init{ //주 생성자, 생성됨과 동시에 실행되는것
        println("new human has been born! ${name}")
    }

    open fun singASong(){
        println("lalala")
    }
}


//상속, 상속을 할려면 부모 클래스의 앞에 open키워드를 사용해주어야한다

class korean : start_human() {
    override fun singASong(){
        super.singASong()
        println("라라라~")
        println("my name is : ${name}")
    }
}

fun main(){
    val human1 = human("Minsu")
    human1.eatingCake()
    println("this human's name is ${human1.new_name}")

    val human2 = default_human("jennie")
    val human3 = default_human()
    human2.print_human_name()
    human3.print_human_name()

    val human4 = start_human("james")
    val human5 = start_human("jisoo",21) // 주 생성자 -> 부 생성자 순서로 진행된다.

    println()

    val kor_human1 = korean()
    kor_human1.singASong()
}