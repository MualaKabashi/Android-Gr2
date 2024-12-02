package com.cacttus.android_gr2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatButton

class ProfileActivity : ComponentActivity() {
    private lateinit var username: TextView
    private lateinit var likeButton: AppCompatButton
    private lateinit var commentButton: AppCompatButton
    private lateinit var shareButton: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        username = findViewById(R.id.username1)

        var passedArgument = intent.getStringExtra("username")
        username.text = passedArgument


        likeButton = findViewById(R.id.btn_like)
        commentButton = findViewById(R.id.btn_comment)
        shareButton = findViewById(R.id.btn_share)

        likeButton.setOnClickListener {
            Toast.makeText(this, "Like button clicked", Toast.LENGTH_LONG).show()
        }
    }
}