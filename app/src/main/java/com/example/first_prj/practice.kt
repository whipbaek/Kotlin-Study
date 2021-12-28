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

    forAndWhile()

    nullcheck()

    ignoreNulls("hello")
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

//Expression vs Statement
/*
Expression : 값을 만드는 문법들 (단 함수에 반환형이 없어도 Kotlin에서는 Unit을 return 하기에 모든 함수는 Expression이다.)
             if문이나 when 문법이 statement가 될수도 expression이 될 수 있다. (java와 차이점)

Statement : 그 외의 문법들
 */

// 5. Array and List

// Array : 처음에 크기를 설정함.
// List
// 1. List : 수정이 불가능한 리스트
// 2. MutableList : 수정이 가능한 리스트

fun array(){
    val array = arrayOf(1,2,3) // val을 쓰는이유 ? 주소값은 바뀌지않기에 val을 씀!! 단, 주소값을 바꿀때는 var을 사용해야함.
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3.4f) // Any 타입으로 지정됨

    array[0] = 3 // array는 기본적으로 mutable, 수정이 가능!

    // list[0] = 3 list는 기본적으로 immutable 이다, 수정이 불가능
    var result = list.get(0) // 값을 가져올수만 있다.

    val arraylist = arrayListOf<Int>() //mutable
    arraylist.add(10)
    arraylist.add(20)


}

// 6. 반복문

fun forAndWhile(){
    val student = arrayListOf("joyce","james","jennie","jennifer")

    for( name : String in student) {
        println("${name}")
    }


    for((index, name) in student.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }
    println()
    println()

    for((tempindx, name) in student.withIndex()){
        println("${tempindx+1}번째 학생 : ${name}")
    }


    var sum = 0
    for( i : Int in 1..10) {
        sum += i
    }
    println(sum)
    sum = 0
    for( i : Int in 1..10 step 2) {
        sum += 1
    }
    println(sum)

    sum = 0
    for( i : Int in 10 downTo 1) {
        sum += 1
    }
    println(sum)

    sum = 0
    for( i : Int in 1 until 100) { // 1..100 과 다른것은 100을 포함하지 않음! (1 부터 99 까지)
        sum += 1
    }
    println(sum)

    var index = 0
    while(index < 10){
        println("current indx : ${index} ")
        index++
    }


}

// 7. Nullable , NonNull

fun nullcheck() {
    //NPE : NULL pointer Exception
    // java는 npe를 런타임에서 잡으나, 코틀린은 컴파일때 잡을수 있게 개선하였다.

    var name = "wihp" //NonNull type

    var nullName : String? = null // nullable type -> null일 수도 있어! ,  물음표를 붙여주면 된다.

    var nameInUpperCase : String = name.uppercase()

    var nullNameInUpperCase : String? = nullName?.uppercase()// null일 경우 null을 반환

    // ?:  엘비스 연산자

    val lastName : String? = null

    val fullName = name +" "+ (lastName?: "No lastName") //null일 경우 No lastName 을 출력해줌
    println(fullName)
}

fun ignoreNulls(str : String?){
   val mNotNull : String = str!! // !!은 절대 null이 아니야 일때 사용하는 연산자
   val upper : String = mNotNull.uppercase()

    val email : String? = "xxxx@gmail.com"
    email?.let{ //email 이 null인 경우 println은 실행되지 않는다.
        println("my email is ${email}")
    }
}