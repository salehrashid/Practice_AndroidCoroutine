package com.app.coroutinedemo.unstructured_concurrency

import kotlinx.coroutines.*

class UserDataManager1 {
    suspend fun getTotalUserCount(): Int {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

        //disini kita running maka nilai count akan bernilai 0
        //karena coroutine scope akan membuat scope bari
        //unstructured konkarensi tidak memberikan garansi kepada kita
        //untuk menyelesaikan semua tugas sebuah fungsi suspend

        val deffer = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }

        return count + deffer.await()
    }
}