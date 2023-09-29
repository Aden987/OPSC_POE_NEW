package com.example.opsc_poe_new

import android.annotation.SuppressLint
import android.content.Intent
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



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

            loginButton.setOnClickListener({
                if(username.text.toString() == "user" && password.text.toString() == "1234")
                {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    //setContentView(R.layout.selection_page)
                    val intent = Intent(this,SelectPage::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                }

            })



    }
}