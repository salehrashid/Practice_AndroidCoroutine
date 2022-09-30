package com.app.coroutinedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AsyncAwaitDecomposition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_await_decomposition)

        CoroutineScope(IO).launch {
            val stock1 = async { getStock1() }
            val stock2 = async { getStock2() }

//            val total = stock1 + stock2

            val total = stock1.await() + stock2.await()
            Log.d("TAG", "Result Stock: $total")
        }
    }
}

private suspend fun getStock1(): Int {
    delay(10000)
    Log.d("TAG", "getStock1: finished")
    return 50000
}

private suspend fun getStock2(): Int {
    delay(8000)
    Log.d("TAG", "getStock2: finished")
    return 60000
}