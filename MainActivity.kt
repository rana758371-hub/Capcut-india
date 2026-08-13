package com.example.maira_ai

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var btnPickVideo: Button

    // ফোন থেকে ভিডিও সিলেক্ট করার লঞ্চার
    private val selectVideoLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            videoView.setVideoURI(it)
            videoView.start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoView)
        btnPickVideo = findViewById(R.id.btnPickVideo)

        btnPickVideo.setOnClickListener {
            selectVideoLauncher.launch("video/*")
        }
    }
}
