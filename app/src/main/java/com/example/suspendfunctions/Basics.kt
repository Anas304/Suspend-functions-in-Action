package com.example.suspendfunctions

import kotlinx.coroutines.delay

suspend fun DoSomethingOnce() : String{
    delay(1000L)
    return "This is a long running task"
}

suspend fun DoSomethingTwice() : String{
    delay(4000L)
    return "This is a long running task too"
}