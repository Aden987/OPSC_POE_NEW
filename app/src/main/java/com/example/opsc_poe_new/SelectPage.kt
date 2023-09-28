package com.example.opsc_poe_new

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectPage : AppCompatActivity() {

    lateinit var  timesheetBtn : Button
    lateinit var  GoalButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selection_page)
        timesheetBtn = findViewById(R.id.timesheetBtn)
        timesheetBtn.setOnClickListener({
            val intent = Intent(this,TimesheeyEntry::class.java)
            startActivity(intent)}
        )
        GoalButton = findViewById(R.id.goalButton)
        GoalButton.setOnClickListener({
            val intent = Intent(this,DailyGoals::class.java)
            startActivity(intent)}
        )
    }
}