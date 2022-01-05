package com.example.first_prj

class Book private constructor(val id : Int, val name : String){ //private constructor : 다른곳에서 생성하지 못하게 함

    companion object{ //companion object는 private propertie에 접근을 가능하게 해준다.
        fun create() = Book(0, "animal farm")
    }

}

fun main(){
    val book = Book.create()

    println("${book.id}, ${book.name}")
}