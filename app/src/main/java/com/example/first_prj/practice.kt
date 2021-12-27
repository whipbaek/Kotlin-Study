package com.example.first_prj

fun main() {
    println("Hello Kotlin!")
    temp_func()
    println(add(1,2));

    //3. String Template

    val name = "whip"
    val lastname = "baek"
    println("my name is $name !")  //변수를 출력하고 싶을때 $ 표현을 사용하면 된다.
    println("my name is ${name + lastname}!") // 정확히 변수의 range를 명시할때에는 {} 써주자!
    println("this is 2\$") // 백슬래쉬를 쓰면 단순 문자로 취급할 수 있다.

}

//1. 함수

fun temp_func() { //return type이 없는 경우 , : Unit 을 해줘도 되지만 없어도 무관하다.
    println("this is temp_func")
}

fun add(a : Int, b : Int) : Int { // Int a, b parameter(변수 : 자료형) 2개와 Int형을 return
    return a+b;
}

//2. val vs var
// val = value (값, 바뀌지 않는 값 )

fun t_func() {
    val a : Int = 10 //변할 수 없는 값(val)
    var b : Int = 9 // 변할 수 있는 값(var)
    // a = 100 -> Error 발생
    // b = 15 -> 문제 없음

    val c = 100 // 이렇게 써주면 알아서 Int형으로 정해준다. (자동추론)
    var d = 100 // var또한 같음

    var name1 : String = "hello"
    var name2 = "Hello" // 자료형 명시하지않아도 알아서 설정해준다.
    //대신 '자동추론'은 선언과 동시에 초기화 할때만 의미가 있는것이지, 변수만 먼저 선언할때는 자료형 명시는 필수이다.

}

//4. 조건식

fun maxBy(a : Int, b : Int) : Int {
    if (a > b) {
        return a
    }
    else {
        return b
    }
}

fun maxBy2(a : Int, b : Int) : Int = if(a>b) a else b // 이와같이 return키워드를 쓰지않을 수 있다. 대신 삼항연산자는 없음!

fun checkNum(score : Int) {
    when (score) {//switch의 역할
        0 -> println("this is zero")
        1 -> println("this is one")
        2,3 -> println("this is two or three")
        else -> println("I don't know") //else가 필수는 아니다.
    }

    var b = when(score) { //when을 return하는데 사용이 가능하다.
        1 ->1
        2-> 2
        else -> 3 // 이렇게 변수값을 return 하는 경우에는 else는 "필수적"으로 사용되어야 한다.
    }

    when (score) {
        in 90..100 -> println("Good")
        in 10..80 -> println("not bad")
        else -> println("okay") // else는 필수가 아님!
    }
}




