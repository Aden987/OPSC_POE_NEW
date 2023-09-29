package com.example.opsc_poe_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EntryTable : AppCompatActivity() {
    var eBack: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_table)

        val e1 = findViewById(R.id.Entry1) as TextView
        val e2 = findViewById(R.id.Entry2) as TextView
        val e3 = findViewById(R.id.Entry3) as TextView
        val e4 = findViewById(R.id.Entry4) as TextView
        val e5 = findViewById(R.id.Entry5) as TextView
        val e6 = findViewById(R.id.Entry6) as TextView

        val c1 = findViewById(R.id.Cat1) as TextView
        val c2 = findViewById(R.id.Cat2) as TextView
        val c3 = findViewById(R.id.Cat3) as TextView
        val c4 = findViewById(R.id.Cat4) as TextView
        val c5 = findViewById(R.id.Cat5) as TextView
        val c6 = findViewById(R.id.Cat6) as TextView

        val d1 = findViewById(R.id.Dat1) as TextView
        val d2 = findViewById(R.id.Dat2) as TextView
        val d3 = findViewById(R.id.Dat3) as TextView
        val d4 = findViewById(R.id.Dat4) as TextView
        val d5 = findViewById(R.id.Dat5) as TextView
        val d6 = findViewById(R.id.Dat6) as TextView

        e1!!.text = getIntent().getStringExtra("e1")
        c1!!.text = getIntent().getStringExtra("c1")
        d1!!.text = getIntent().getStringExtra("d1")

        e2!!.text = getIntent().getStringExtra("e2")
        c2!!.text = getIntent().getStringExtra("c2")
        d2!!.text = getIntent().getStringExtra("d2")

        e3!!.text = getIntent().getStringExtra("e3")
        c3!!.text = getIntent().getStringExtra("c3")
        d3!!.text = getIntent().getStringExtra("d3")

        e4!!.text = getIntent().getStringExtra("e4")
        c4!!.text = getIntent().getStringExtra("c4")
        d4!!.text = getIntent().getStringExtra("d4")

        e5!!.text = getIntent().getStringExtra("e5")
        c5!!.text = getIntent().getStringExtra("c5")
        d5!!.text = getIntent().getStringExtra("d5")

        e6!!.text = getIntent().getStringExtra("e6")
        c6!!.text = getIntent().getStringExtra("c6")
        d6!!.text = getIntent().getStringExtra("d6")
        eBack = findViewById(R.id.eTabBackBtn)

        eBack!!.setOnClickListener({
            //setContentView(R.layout)
            val intent = Intent(this,TimesheeyEntry::class.java)
            startActivity(intent)
        })
    }
}