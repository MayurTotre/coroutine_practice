package com.lukaslechner.coroutineusecasesonandroid.playground.utils

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Main Starts")
    joinAll(
        async { suspendingCoroutines(1, 500) },
        async { suspendingCoroutines(2, 300) },
        async {
            repeat(5) {
                println("Other task is running on ${Thread.currentThread()}")
                delay(100)
            }
        }
        )
    println("Main Ends")
}

suspend fun suspendingCoroutines(number: Int, delay: Long) {
    println("Coroutine $number starts work ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has stopped ${Thread.currentThread().name}")
}