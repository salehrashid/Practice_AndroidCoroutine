package com.app.coroutinedemo

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThreadName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_name)

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("TAG", "onCreate: Hello from one ${Thread.currentThread().name}")
        }
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("TAG", "onCreate: Hello from two ${Thread.currentThread().name}")
        }
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("TAG", "onCreate: Hello from three ${Thread.currentThread().name}")
        }
    }
}