package com.example.opsc_poe_new

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectPage : AppCompatActivity() {

    lateinit var  timesheetBtn : Button
    lateinit var  dailyGoalBtn : Button
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
    }
}