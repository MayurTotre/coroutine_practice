package com.lukaslechner.coroutineusecasesonandroid.playground.utils.structuredconcurrency

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){
    val scopeJob = Job()
    val scope = CoroutineScope(Dispatchers.Default + scopeJob)

    var childCoroutineJob: Job? = null
    val passedJob = Job()
    val coroutineJob = scope.launch {
        childCoroutineJob = scope.launch {
            println("Starting Child Coroutine")
            delay(1000)
        }
        println("Starting Coroutine")
        delay(1000)
    }
    Thread.sleep(1000)

    println("Is coroutineJob and parentsJob are referenced to the same object => ${passedJob == coroutineJob}")
    println("Is coroutineJob a child of scopeJob => ${ scopeJob.children.contains(coroutineJob)}")
}