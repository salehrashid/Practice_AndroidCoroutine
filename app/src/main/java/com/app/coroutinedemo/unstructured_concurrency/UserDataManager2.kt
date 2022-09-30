package com.app.coroutinedemo.unstructured_concurrency

import kotlinx.coroutines.*

class UserDataManager2 {

    var count = 0
    lateinit var defferd: Deferred<Int>

    suspend fun getTotalUserCount(): Int {

       // CoroutineScope() merupakan sebuah interface
       // coroutineScope {  } merupakan sebuah suspend function

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(3000)
                count = 50
            }
            defferd = async(Dispatchers.IO) {
                delay(1000)
                return@async 50
            }
        }
        return count + defferd.await()
    }

}