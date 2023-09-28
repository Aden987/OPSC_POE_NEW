package com.example.opsc_poe_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var  loginButton : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        if(loginButton.isActivated)
        {
            if(username.text.toString() = "user")
            {
                setContentView(R.layout.selection_page)
            }
        }

    }
}