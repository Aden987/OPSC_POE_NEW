package com.example.opsc_poe_new

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class TimesheetGraph : AppCompatActivity() {

    private lateinit var binding: TimesheetGraph
    var lineChart: LineChart? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet_graph)
        lineChart = findViewById(R.id.lineChart)
        setLineChartData()
    }

    fun setLineChartData()
    {
        val xvalue = ArrayList<String>()
        xvalue.add("11:00 AM")
        xvalue.add("12:00 AM")
        xvalue.add("1:00 PM")
        xvalue.add("3:00 PM")
        xvalue.add("4:00 PM")

        val lineentry = ArrayList<Entry>()
        lineentry.add(Entry(20f, 0))
        lineentry.add(Entry(50f,1))
        lineentry.add(Entry(60f,2))
        lineentry.add(Entry(30f,3))
        lineentry.add(Entry(10f,4))

        val linedataset = LineDataSet(lineentry, "First")
        linedataset.color = resources.getColor(R.color.green)

        val data = LineData(xvalue,linedataset)
        lineChart?.data = data
    }
}