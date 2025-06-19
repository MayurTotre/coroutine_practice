package com.lukaslechner.coroutineusecasesonandroid.playground.utils.structuredconcurrency

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
        println("Caught Exception $throwable")
    }
    val scope = CoroutineScope(SupervisorJob() + exceptionHandler)

    scope.launch {
        println("Coroutine 1 starts")
        delay(50)
        println("Coroutine 1 fails")
        throw RuntimeException()
    }

    scope.launch {
        println("Coroutine 2 starts")
        delay(500)
        println("Coroutine 2 completed")
    }.invokeOnCompletion {throwable ->
        if (throwable is CancellationException){
            println("Coroutine 2 got cancelled")
        }
    }
    Thread.sleep(1000)
}
