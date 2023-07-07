package com.example.suspendfunctions

import kotlinx.coroutines.delay

suspend fun DoSomethingOnce() : String{
    delay(3000L)
    return "This is a long running task"
}

suspend fun DoSomethingTwice() : String{
    delay(6000L)
    return "This is a long running task too"
}