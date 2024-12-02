package com.cacttus.android_gr2

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatButton


class MainActivity : ComponentActivity() {
//    private lateinit var editText : EditText
//    private lat(einit var button : AppCompatButton
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.calculator_layout)
//
//
//        editText = findViewById(R.id.number)
//        button = findViewById(R.id.btn1)
//
//
//        button.setOnClickListener {
//            editText.setText(button.text)
//        }
//    }

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: AppCompatButton
    private lateinit var forgotPassword: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()


        login.setOnClickListener {
            if (username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && validatePassword(password.text.toString())
            ) {
                Toast.makeText(this, "Please enter your credentials!", Toast.LENGTH_LONG).show()

                Log.d("TAG", "onCreate: $this")


                var intent = Intent(this@MainActivity, ProfileActivity::class.java);
                intent.putExtra("username", username.text.toString())
                startActivity(intent)

            } else {
                Toast.makeText(this, "Logged in successfully!", Toast.LENGTH_LONG).show()
            }
        }

        forgotPassword.setOnClickListener {
            createDialog(
                "Reset password",
                "Are you sure you want to reset your password?",
                "Ok",
                "A reset link had been sent to your account!", "Cancel",
                "Canceled"
            )
        }
    }

    private fun createDialog(
        title: String,
        message: String,
        positiveButtonText: String,
        positiveToastMessage: String,
        neutralButtonText: String,
        neutralToastMessage: String
    ) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(positiveButtonText) { _, _ ->
            Toast.makeText(
                this,
                positiveToastMessage,
                Toast.LENGTH_LONG
            ).show()
        }
        builder.setNeutralButton(neutralButtonText) { _, _ ->
            Toast.makeText(this, neutralToastMessage, Toast.LENGTH_SHORT).show()
        }

        var alertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun bindViews() {
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        forgotPassword = findViewById(R.id.forgotPassword)
    }

    fun validatePassword(input: String): Boolean = input.length >= 8 && input[0].isUpperCase()


}

