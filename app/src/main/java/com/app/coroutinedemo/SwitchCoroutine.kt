package com.app.coroutinedemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.coroutinedemo.databinding.ActivityMainBinding
import com.app.coroutinedemo.databinding.ActivitySwitchCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SwitchCoroutine : AppCompatActivity() {

    private lateinit var binding: ActivitySwitchCoroutineBinding
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = score++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadData()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private suspend fun downloadData() {
        for (i in 1..20000){
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text = "Download $i ${Thread.currentThread().name}"
            }
        }
    }
}