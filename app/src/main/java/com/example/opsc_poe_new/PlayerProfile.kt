package com.example.opsc_poe_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PlayerProfile : AppCompatActivity() {

    lateinit var backBtn: Button
    lateinit var saveBtn: Button
    lateinit var nametext: EditText
    lateinit var surnametext: EditText
    lateinit var companytext: EditText
    lateinit var jobtext: EditText
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_profile)

        nametext = findViewById(R.id.nameTxt)
        surnametext = findViewById(R.id.surnameTxt)
        companytext = findViewById(R.id.companyTxt)
        jobtext = findViewById(R.id.jobTitleTxt)
        backBtn = findViewById(R.id.backBtn)
        saveBtn = findViewById(R.id.saveBtn)

        backBtn.setOnClickListener({
            val intent = Intent(this,SelectPage::class.java)
            startActivity(intent)
        })

        saveBtn.setOnClickListener({
            database = FirebaseDatabase.getInstance().getReference("User")
            val User = User(nametext.text.toString(), surnametext.text.toString(), companytext.text.toString(),jobtext.text.toString())
            database.child(nametext.text.toString()).setValue(User).addOnSuccessListener {
                Toast.makeText(this, "Successfully Saved.", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failed to save.", Toast.LENGTH_SHORT).show()
            }
        })


    }

}

    //}
