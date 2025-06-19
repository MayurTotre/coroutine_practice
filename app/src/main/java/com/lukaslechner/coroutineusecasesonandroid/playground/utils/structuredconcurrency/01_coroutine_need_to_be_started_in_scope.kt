package com.lukaslechner.coroutineusecasesonandroid.playground.utils.structuredconcurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val scope = CoroutineScope(Dispatchers.Default)

fun main() = runBlocking{
    scope.launch {
        delay(100)
        println("Coroutine completed")
    }
    delay(500)
    onDestroy()
}

fun onDestroy(){
    println("Lifetime Scope ends")
    scope.cancel()
}