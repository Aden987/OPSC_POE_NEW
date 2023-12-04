package com.example.opsc_poe_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class UserProfile : AppCompatActivity() {
    private lateinit var userProfile: UserProfileImproved

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userprofile)

        // Initialize the user profile (you can load it from preferences or elsewhere)
        userProfile = UserProfileImproved("John", "Doe", "Software Engineer", "Example Company")

        // Update UI with the current user profile
        updateUI()

        // Set up onClickListener for the Edit Profile button
        val btnEditProfile: Button = findViewById(R.id.btnEditProfile)
        btnEditProfile.setOnClickListener {
            // You can navigate to the edit profile screen/activity here
            // For simplicity, we will just print a log message for now
            println("Edit Profile button clicked")
        }
    }

    private fun updateUI() {
        val tvName: TextView = findViewById(R.id.tvName)
        tvName.text = "Name: ${userProfile.firstName} ${userProfile.lastName}"
    }

    // Uncomment and implement this function when you want to save changes made by the user
    /*
    private fun saveUserProfile() {
        // Save the changes made by the user
        // userProfile.firstName = etFirstName.text.toString()
        // userProfile.lastName = etLastName.text.toString()
        // userProfile.jobTitle = etJobTitle.text.toString()
        // userProfile.company = etCompany.text.toString()

        // You can save the updated user profile to preferences or a database here
    }
    */
}
