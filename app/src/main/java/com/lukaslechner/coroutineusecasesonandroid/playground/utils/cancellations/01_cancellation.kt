package com.lukaslechner.coroutineusecasesonandroid.playground.utils.cancellations

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    val job = launch(Dispatchers.Default) {
        repeat(10) {index ->
            println("operation number $index")
            try {
                delay(100)
            }catch (e: CancellationException){
                println("Cancellation was thrown!")
                throw CancellationException()
            }
        }
    }
    delay(250)
    println("Cancelling Coroutine")
    job.cancel()
}