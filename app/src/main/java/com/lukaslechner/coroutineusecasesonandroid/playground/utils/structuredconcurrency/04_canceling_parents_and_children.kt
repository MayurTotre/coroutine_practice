package com.lukaslechner.coroutineusecasesonandroid.playground.utils.structuredconcurrency

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    val scope = CoroutineScope(Dispatchers.Default)

    scope.coroutineContext[Job]!!.invokeOnCompletion {
        if (scope is CancellationException){
            println("Parent Job has Cancelled")
        }
    }

    val childCoroutine1 = scope.launch {
        delay(1000)
        println("Coroutine 1 completed")
    }
        childCoroutine1.invokeOnCompletion { throwable ->
        if(throwable is CancellationException){
            println("Coroutine 1 was cancelled!")
        }
    }

    scope.launch {
        delay(1000)
        println("Coroutine 2 completed")
    }.invokeOnCompletion { throwable ->
    if(throwable is CancellationException){
        println("Coroutine 2 was cancelled!")
    }
}
//    scope.cancel()
//    scope.coroutineContext[Job]!!.join()
    delay(200)
    childCoroutine1.cancelAndJoin()
}