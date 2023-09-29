package com.example.opsc_poe_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CategoryHours : AppCompatActivity() {

    var catBackBtn: Button? = null
    //var pInt: Int = getIntent().getIntExtra("personalTime")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.total_categories)

        val Per = findViewById(R.id.Personal2) as TextView
        val Work = findViewById(R.id.Work2) as TextView
        val Overtime = findViewById(R.id.Overtime2) as TextView
        catBackBtn = findViewById(R.id.CatBackBtn)

        Per.text = (getIntent().getIntExtra("personalTime", 0) * 0.5).toString()
        Work.text = (getIntent().getIntExtra("workTime", 0) * 0.5).toString()
        Overtime.text = (getIntent().getIntExtra("overTime", 0) * 0.5).toString()

        catBackBtn!!.setOnClickListener({
            //setContentView()
            val intent = Intent(this,TimesheeyEntry::class.java)
            startActivity(intent)
        })

    }
}