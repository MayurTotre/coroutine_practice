package com.lukaslechner.coroutineusecasesonandroid.playground.utils

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Main Starts")
    joinAll(async { coRoutines(1, 500) },
            async { coRoutines(2, 300) })
    println("Main Ends")
}

suspend fun coRoutines(number: Int, delay: Long) {
    println("Coroutine $number starts work")
    delay(delay)
    println("Coroutine $number has stopped")
}