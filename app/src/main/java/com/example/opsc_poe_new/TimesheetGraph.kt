package com.example.opsc_poe_new

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class TimesheetGraph : AppCompatActivity() {

    private lateinit var binding: TimesheetGraph
    var lineChart: LineChart? = null
    private  lateinit var database : DatabaseReference
    var floatValue: Float? = null
    val lineentry2 = ArrayList<Entry>()
    val lineentry1 = ArrayList<Entry>()
    val lineentry = ArrayList<Entry>()
    val xvalue = ArrayList<String>()
    val finaldataset = ArrayList<LineDataSet>()
    lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet_graph)
        lineChart = findViewById(R.id.lineChart)
        backButton = findViewById(R.id.back_btn)
        backButton.setOnClickListener({
            deleteMonEntries()
            deleteTueEntries()
            deleteWedEntries()
            deleteThursEntries()
            deleteFriEntries()
            deleteSatEntries()
            deleteSunEntries()
            val intent = Intent(this,SelectPage::class.java)
            startActivity(intent)
        })
        setLineChartData()
    }


    fun setLineChartData()
    {

        xvalue.add("Sun")
        xvalue.add("Mon")
        xvalue.add("Tue")
        xvalue.add("Wed")
        xvalue.add("Thurs")
        xvalue.add("Fri")
        xvalue.add("Sat")

        countSunEntries()
        countMonEntries()
        countTueEntries()
        countWedEntries()
        countThursEntries()
        countFriEntries()
        countSatEntries()


        /*lineentry.add(Entry(1.5f,1))
        lineentry.add(Entry(1.5f,2))
        lineentry.add(Entry(1.5f,3))
        lineentry.add(Entry(1.5f,4))*/


        val database = FirebaseDatabase.getInstance().getReference("Goals")
        database.child("minmaxgoals").get().addOnSuccessListener { dataSnapshot ->
            val mingoalSnapshot = dataSnapshot.child("minGoal").getValue(Float::class.java)

            if (mingoalSnapshot != null) {
                // Successfully read minGoal
                val floatValue = mingoalSnapshot

                // Continue with your code here, for example, update the line chart
                updateMinLineChart(floatValue)

                Toast.makeText(this, "Successfully read min goals", Toast.LENGTH_SHORT).show()
            } else {
                // Handle the case where minGoal is null
                Toast.makeText(this, "minGoal is null", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            // Handle the failure to read minGoal
            Toast.makeText(this, "Failed to read min goals", Toast.LENGTH_SHORT).show()
        }

        database.child("minmaxgoals").get().addOnSuccessListener { dataSnapshot ->
            val maxgoalSnapshot = dataSnapshot.child("maxGoal").getValue(Float::class.java)

            if (maxgoalSnapshot != null) {
                // Successfully read minGoal
                val floatValue = maxgoalSnapshot

                // Continue with your code here, for example, update the line chart
                updateMaxLineChart(floatValue)

                Toast.makeText(this, "Successfully read max goals", Toast.LENGTH_SHORT).show()
            } else {
                // Handle the case where minGoal is null
                Toast.makeText(this, "maxGoal is null", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            // Handle the failure to read minGoal
            Toast.makeText(this, "Failed to read min goals", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateMinLineChart(floatValue: Float) {
        //val lineentry1 = ArrayList<Entry>()
        lineentry1.add(Entry(floatValue, 0))
        lineentry1.add(Entry(floatValue, 1))
        lineentry1.add(Entry(floatValue, 2))
        lineentry1.add(Entry(floatValue, 3))
        lineentry1.add(Entry(floatValue, 4))
        lineentry1.add(Entry(floatValue, 5))
        lineentry1.add(Entry(floatValue, 6))

        // Assuming you have a LineChart view in your layout with the ID "lineChart"
        val lineChart: LineChart = findViewById(R.id.lineChart)

        // Create a LineDataSet with the entries
        val dataSet = LineDataSet(lineentry1, "Min Goals")

        // Create a List of LineDataSets
        val dataSets: MutableList<ILineDataSet> = mutableListOf()
        dataSets.add(dataSet)


        // Create a LineData object with the data sets
        //val lineData = LineData(dataSets)

        // Set the LineData to the LineChart
        //lineChart.data = lineData

        val linedataset = LineDataSet(lineentry, "User Progress")
        linedataset.color = resources.getColor(R.color.green)

        //val linedataset1 = LineDataSet(lineentry1, "Second")
        dataSet.color = resources.getColor(R.color.blue)


        finaldataset.add(linedataset)
        finaldataset.add(dataSet)



        //al data = LineData(xvalue, finaldataset as List<ILineDataSet>?)
        //lineChart?.data = data

        // Refresh the chart
        //lineChart.invalidate()
    }

    private fun updateMaxLineChart(floatValue: Float) {
        //val lineentry1 = ArrayList<Entry>()
        lineentry2.add(Entry(floatValue, 0))
        lineentry2.add(Entry(floatValue, 1))
        lineentry2.add(Entry(floatValue, 2))
        lineentry2.add(Entry(floatValue, 3))
        lineentry2.add(Entry(floatValue, 4))
        lineentry2.add(Entry(floatValue, 5))
        lineentry2.add(Entry(floatValue, 6))

        // Assuming you have a LineChart view in your layout with the ID "lineChart"
        val lineChart: LineChart = findViewById(R.id.lineChart)

        // Create a LineDataSet with the entries
        val dataSet = LineDataSet(lineentry2, "Max Goals")

        // Create a List of LineDataSets
        val dataSets: MutableList<ILineDataSet> = mutableListOf()
        dataSets.add(dataSet)

        dataSet.color = resources.getColor(R.color.purple_200)


        finaldataset.add(dataSet)



        val data = LineData(xvalue, finaldataset as List<ILineDataSet>?)
        lineChart?.data = data

        // Refresh the chart
        lineChart.invalidate()
    }

    private fun countSunEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Sun")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get the count of entries
                val entryCount = dataSnapshot.childrenCount.toFloat()
                lineentry.add(Entry(entryCount, 0))
                //println("Number of entries: $entryCount")

                // Now you have the count, you can use it as needed
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                println("Failed to count entries: ${databaseError.message}")
            }

        })
    }
    private fun countMonEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Mon")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get the count of entries
                val entryCount = dataSnapshot.childrenCount.toFloat()
                lineentry.add(Entry(entryCount, 1))
                //println("Number of entries: $entryCount")

                // Now you have the count, you can use it as needed
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                println("Failed to count entries: ${databaseError.message}")
            }

        })
    }
    private fun countTueEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Tue")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get the count of entries
                val entryCount = dataSnapshot.childrenCount.toFloat()
                lineentry.add(Entry(entryCount, 2))
                //println("Number of entries: $entryCount")

                // Now you have the count, you can use it as needed
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                println("Failed to count entries: ${databaseError.message}")
            }

        })
    }
    private fun countWedEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Wed")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get the count of entries
                val entryCount = dataSnapshot.childrenCount.toFloat()
                lineentry.add(Entry(entryCount, 3))
                //println("Number of entries: $entryCount")

                // Now you have the count, you can use it as needed
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                println("Failed to count entries: ${databaseError.message}")
            }

        })
    }
    private fun countThursEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Thurs")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get the count of entries
                val entryCount = dataSnapshot.childrenCount.toFloat()
                lineentry.add(Entry(entryCount, 4))
                //println("Number of entries: $entryCount")

                // Now you have the count, you can use it as needed
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                println("Failed to count entries: ${databaseError.message}")
            }

        })
    }
    private fun countFriEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Fri")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get the count of entries
                val entryCount = dataSnapshot.childrenCount.toFloat()
                lineentry.add(Entry(entryCount, 5))
                //println("Number of entries: $entryCount")

                // Now you have the count, you can use it as needed
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                println("Failed to count entries: ${databaseError.message}")
            }

        })
    }
    private fun countSatEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Sat")

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get the count of entries
                val entryCount = dataSnapshot.childrenCount.toFloat()
                lineentry.add(Entry(entryCount, 6))
                //println("Number of entries: $entryCount")

                // Now you have the count, you can use it as needed
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors here
                println("Failed to count entries: ${databaseError.message}")
            }

        })
    }

    private fun deleteMonEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Mon")

        reference.removeValue()
            .addOnSuccessListener {
                // Deletion successful
                println("All entries deleted successfully.")
            }
            .addOnFailureListener { exception ->
                // Handle errors here
                println("Failed to delete entries: ${exception.message}")
            }
    }
    private fun deleteTueEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Tue")

        reference.removeValue()
            .addOnSuccessListener {
                // Deletion successful
                println("All entries deleted successfully.")
            }
            .addOnFailureListener { exception ->
                // Handle errors here
                println("Failed to delete entries: ${exception.message}")
            }
    }
    private fun deleteWedEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Wed")

        reference.removeValue()
            .addOnSuccessListener {
                // Deletion successful
                println("All entries deleted successfully.")
            }
            .addOnFailureListener { exception ->
                // Handle errors here
                println("Failed to delete entries: ${exception.message}")
            }
    }
    private fun deleteThursEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Thurs")

        reference.removeValue()
            .addOnSuccessListener {
                // Deletion successful
                println("All entries deleted successfully.")
            }
            .addOnFailureListener { exception ->
                // Handle errors here
                println("Failed to delete entries: ${exception.message}")
            }
    }
    private fun deleteFriEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Fri")

        reference.removeValue()
            .addOnSuccessListener {
                // Deletion successful
                println("All entries deleted successfully.")
            }
            .addOnFailureListener { exception ->
                // Handle errors here
                println("Failed to delete entries: ${exception.message}")
            }
    }
    private fun deleteSatEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Sat")

        reference.removeValue()
            .addOnSuccessListener {
                // Deletion successful
                println("All entries deleted successfully.")
            }
            .addOnFailureListener { exception ->
                // Handle errors here
                println("Failed to delete entries: ${exception.message}")
            }
    }
    private fun deleteSunEntries() {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = database.getReference("Sun")

        reference.removeValue()
            .addOnSuccessListener {
                // Deletion successful
                println("All entries deleted successfully.")
            }
            .addOnFailureListener { exception ->
                // Handle errors here
                println("Failed to delete entries: ${exception.message}")
            }
    }
}