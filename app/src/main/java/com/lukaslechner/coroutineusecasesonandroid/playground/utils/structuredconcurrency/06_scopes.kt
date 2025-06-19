package com.lukaslechner.coroutineusecasesonandroid.playground.utils.structuredconcurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    doSomething()
    launch {
        println("Starting Task 3")
        delay(1000)
        println("Task 3 Completed")
    }

}

suspend fun doSomething() = coroutineScope{
    launch {
        println("Starting Task 1")
        delay(1000)
        println("Task 1 Completed")
    }

    launch {
        println("Starting Task 2")
        delay(1000)
        println("Task 2 Completed")
    }

}