package com.lukaslechner.coroutineusecasesonandroid.playground.utils

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{

    val startTime = System.currentTimeMillis()


    val deffered1 = async {
        val result = networkCall(1)
        println("Result received $result after: ${elapsedMillis(startTime)}")
        result
    }

    val deffered2 = async {
        val result2 = networkCall(2)
        println("Result received $result2 after: ${elapsedMillis(startTime)}")
        result2
    }
    val resultList = listOf(deffered1.await(), deffered2.await())
    print("Result list: $resultList after ${elapsedMillis(startTime)}")

}

suspend fun networkCall(number: Int): String{
    delay(500)
    return "Result: $number"
}

fun elapsedMillis(startTime: Long) = System.currentTimeMillis() - startTime