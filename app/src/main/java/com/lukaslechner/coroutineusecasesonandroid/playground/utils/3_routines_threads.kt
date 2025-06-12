package com.lukaslechner.coroutineusecasesonandroid.playground.utils

import kotlinx.coroutines.delay
import kotlin.concurrent.thread

fun main(){
    println("Main starts")
    routineThreads(1, 500)
    routineThreads(2, 300)
    Thread.sleep(1000)
    println("Main ends")
}

fun routineThreads(number: Int, delay: Long){
    thread {
        println("Routine $number starts work")
        Thread.sleep(delay)
        println("Routine $number has finished")
    }
}