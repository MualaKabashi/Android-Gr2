package com.cacttus.android_gr2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class ProfileActivity : ComponentActivity() {
    private lateinit var username: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        username = findViewById(R.id.username1)

        var passedArgument = intent.getStringExtra("username")
        username.text = passedArgument

    }
}