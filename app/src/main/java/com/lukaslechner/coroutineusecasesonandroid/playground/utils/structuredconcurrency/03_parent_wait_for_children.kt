package com.lukaslechner.coroutineusecasesonandroid.playground.utils.structuredconcurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val scope = CoroutineScope(Dispatchers.Default)

   val parentCoroutine = scope.launch {
        launch {
            delay(100)
            println("Child Coroutine 1 has completed")
        }
        launch {
            delay(100)
            println("Child Coroutine 2 has completed")
        }


    }
    parentCoroutine.join()
    println("Parent coroutine has completed")

}