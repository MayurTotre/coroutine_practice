package com.lukaslechner.coroutineusecasesonandroid.playground.utils

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Main Starts")
    joinAll(async { coRoutinesWithThreadInfo(1, 500) },
            async { coRoutinesWithThreadInfo(2, 300) })
    println("Main Ends")
}

suspend fun coRoutinesWithThreadInfo(number: Int, delay: Long) {
    println("Coroutine $number starts work ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has stopped ${Thread.currentThread().name}")
}