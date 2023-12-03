package com.example.opsc_poe_new

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


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
    //var floatValue : Float? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet_graph)
        lineChart = findViewById(R.id.lineChart)
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


        lineentry.add(Entry(1.5f, 0))
        lineentry.add(Entry(3.5f,1))
        lineentry.add(Entry(8.5f,2))
        lineentry.add(Entry(4.5f,3))
        lineentry.add(Entry(5.5f,4))


        /*database = FirebaseDatabase.getInstance().getReference("Goals")
        database.child("minmaxgoals").get().addOnSuccessListener {
            val mingoalSnapshot = it.child("minGoal").getValue(Float::class.java)
            floatValue = mingoalSnapshot

            Toast.makeText(this, "Successfully read min goals " , Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{
            Toast.makeText(this, "Failed to read min goals", Toast.LENGTH_SHORT).show()
        }

        //min Goals

        lineentry1.add(Entry(floatValue!!.toFloat(), 0))
        lineentry1.add(Entry(1.5f, 1))
        lineentry1.add(Entry(1.5f ,2))
        lineentry1.add(Entry(1.5f,3))
        lineentry1.add(Entry(1.5f,4))
        lineentry1.add(Entry(1.5f,5))
        lineentry1.add(Entry(1.5f,6))*/

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



        //val linedataset = LineDataSet(lineentry, "First")
        //linedataset.color = resources.getColor(R.color.green)

        //val linedataset1 = LineDataSet(lineentry1, "Second")
        //linedataset.color = resources.getColor(R.color.blue)

        //val finaldataset = ArrayList<LineDataSet>()
        //finaldataset.add(linedataset)
        //finaldataset.add(linedataset1)



        //val data = LineData(xvalue, finaldataset as List<ILineDataSet>?)
       // lineChart?.data = data
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

        val linedataset = LineDataSet(lineentry, "First")
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
}