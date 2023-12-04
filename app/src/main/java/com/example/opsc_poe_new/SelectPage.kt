package com.example.opsc_poe_new

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.Firebase
import com.google.firebase.database.database

class SelectPage : AppCompatActivity() {

    lateinit var  timesheetBtn : Button
    lateinit var  dailyGoalBtn : Button
    lateinit var  aBtn : Button
    lateinit var  payCalcu : Button
    lateinit var  profileBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selection_page)
        timesheetBtn = findViewById(R.id.timesheetBtn)
        timesheetBtn.setOnClickListener({
            val intent = Intent(this,TimesheeyEntry::class.java)
            startActivity(intent)}
        )
        dailyGoalBtn = findViewById(R.id.goalBtn)
        dailyGoalBtn.setOnClickListener({
            val intent = Intent(this,DailyGoal::class.java)
            startActivity(intent)}
        )

        aBtn = findViewById(R.id.ach)
        aBtn.setOnClickListener({
            val intent = Intent(this,TimesheetGraph::class.java)
            startActivity(intent)}
        )

        payCalcu = findViewById(R.id.payCalc)
        payCalcu.setOnClickListener({
            val intent = Intent(this,PaymentCalc::class.java)
            startActivity(intent)
        })

        profileBtn = findViewById(R.id.profileBtn)
        profileBtn.setOnClickListener({
            val intent = Intent(this,UserProfile::class.java)
            startActivity(intent)
        })
    }
}