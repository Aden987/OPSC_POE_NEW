package com.example.opsc_poe_new

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DailyGoal : AppCompatActivity() {
    lateinit var  BackButton : Button
    private lateinit var database: DatabaseReference
    lateinit var  dataname : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_goal)

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val minGoalEditText = findViewById<EditText>(R.id.editTextMinGoal)
        val maxGoalEditText = findViewById<EditText>(R.id.editTextMaxGoal)
        val saveButton = findViewById<Button>(R.id.saveButton)
        dataname = "minmaxgoals"

        // Retrieve user's goals from SharedPreferences
        val minGoal = sharedPreferences.getFloat("minGoal", 0.0f)
        val maxGoal = sharedPreferences.getFloat("maxGoal", 0.0f)

        // Display the retrieved goals in EditText fields
        minGoalEditText.setText(minGoal.toString())
        maxGoalEditText.setText(maxGoal.toString())

        saveButton.setOnClickListener {
            // Get user's input from EditText fields
            val minGoalText = minGoalEditText.text.toString()
            val maxGoalText = maxGoalEditText.text.toString()

            // Convert input to float, default to 0.0 if conversion fails
            val minGoalValue = minGoalText.toFloatOrNull() ?: 0.0f
            val maxGoalValue = maxGoalText.toFloatOrNull() ?: 0.0f

            // Validate user's input (optional)
            if (minGoalValue < 0.0 || maxGoalValue < 0.0 || minGoalValue > maxGoalValue) {
                // Display an error message to the user
                // Prompt the user to correct their input
                Toast.makeText(this, "Invalid input. Please check your values.", Toast.LENGTH_SHORT).show()
            } else {
                // Save the valid input to SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putFloat("minGoal", minGoalValue)
                editor.putFloat("maxGoal", maxGoalValue)
                editor.apply()

                // Notify the user that the goals are saved
                //Toast.makeText(this, "Goals saved successfully.", Toast.LENGTH_SHORT).show()
                database = FirebaseDatabase.getInstance().getReference("Goals")
                val Goals = Goals(minGoalValue,maxGoalValue,dataname)
                database.child(dataname).setValue(Goals).addOnSuccessListener {
                    Toast.makeText(this, "Successfully Saved.", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this, "Failed to save.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        BackButton = findViewById(R.id.back)
        BackButton.setOnClickListener({
            val intent = Intent(this,SelectPage::class.java)
            startActivity(intent)}
        )
    }
}