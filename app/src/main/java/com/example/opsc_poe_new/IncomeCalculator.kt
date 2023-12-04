package com.example.opsc_poe_new

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class IncomeCalculator : AppCompatActivity() {

    private var a: Double = 0.0
    private var b: Double = 0.0
    private var c: Double = 0.0
    private var d: Double = 0.0
    private var e: Double = 0.0
    private var f: Double = 0.0
    private var g: Double = 0.0
    private var h: Double = 0.0

    private var answer1: Double = 0.0
    private var answer2: Double = 0.0
    private var answer3: Double = 0.0
    private var answer4: Double = 0.0
    private var answerFinal: Double = 0.0

    lateinit var calculate : Button
    //lateinit var backBtn : Button
    lateinit var paymentPerHour: EditText
    lateinit var numberOfHours: EditText
    lateinit var paymentPerHour2: EditText
    lateinit var numberOfHours2: EditText
    lateinit var paymentPerHour3: EditText
    lateinit var numberOfHours3: EditText
    lateinit var paymentPerHour4: EditText
    lateinit var numberOfHours4: EditText
    lateinit var result: TextView



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.calculator)

        calculate = findViewById(R.id.btnCalculate)

        paymentPerHour = findViewById(R.id.paymentperhourinput)
        numberOfHours = findViewById(R.id.numberofhoursinput)

        paymentPerHour2 = findViewById(R.id.paymentperhourinput2)
        numberOfHours2 = findViewById((R.id.numberofhoursinput2))

        paymentPerHour3 = findViewById(R.id.paymentperhourinput5)
        numberOfHours3 = findViewById(R.id.numberofhoursinput5)

        paymentPerHour4 = findViewById(R.id.paymentperhourinput4)
        numberOfHours4 = findViewById(R.id.numberofhoursinput4)

        result = findViewById(R.id.totalIncomeView)
        //backBtn = findViewById(R.id.btnBack)

        paymentPerHour.setText("0")
        numberOfHours.setText("0")
        paymentPerHour2.setText("0")
        numberOfHours2.setText("0")
        paymentPerHour3.setText("0")
        numberOfHours3.setText("0")
        paymentPerHour4.setText("0")
        numberOfHours4.setText("0")


        /*calculate.setOnClickListener({




            a = Integer.parseInt(paymentPerHour.text.toString()).toDouble()
            b = Integer.parseInt(numberOfHours.text.toString()).toDouble()

            c = Integer.parseInt(paymentPerHour2.text.toString()).toDouble()
            d = Integer.parseInt(numberOfHours2.text.toString()).toDouble()

            e = Integer.parseInt(paymentPerHour3.text.toString()).toDouble()
            f = Integer.parseInt(numberOfHours3.text.toString()).toDouble()

            g = Integer.parseInt(paymentPerHour4.text.toString()).toDouble()
            h = Integer.parseInt(numberOfHours4.text.toString()).toDouble()


            answer1 = (a * b)
            answer2 = (c * d)
            answer3 = (e * f)
            answer4 = (g * h)
            answerFinal = answer1 + answer2 + answer3 + answer4

            result.setText((answerFinal.toString()))
        })*/

        /*backBtn.setOnClickListener({
            val intent = Intent(this,SelectPage::class.java)
            startActivity(intent)
        })*/


    }
}