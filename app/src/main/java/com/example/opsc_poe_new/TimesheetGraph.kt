package com.example.opsc_poe_new

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet


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
        xvalue.add("Sun")
        xvalue.add("Mon")
        xvalue.add("Tue")
        xvalue.add("Wed")
        xvalue.add("Thurs")
        xvalue.add("Fri")
        xvalue.add("Sat")

        val lineentry = ArrayList<Entry>()
        lineentry.add(Entry(1.5f, 0))
        lineentry.add(Entry(3.5f,1))
        lineentry.add(Entry(8.5f,2))
        lineentry.add(Entry(4.5f,3))
        lineentry.add(Entry(5.5f,4))

        val lineentry1 = ArrayList<Entry>()
        lineentry1.add(Entry(0.5f, 0))
        lineentry1.add(Entry(0.5f,1))
        lineentry1.add(Entry(0.5f,2))
        lineentry1.add(Entry(0.5f,3))
        lineentry1.add(Entry(0.5f,4))

        val linedataset = LineDataSet(lineentry, "First")
        linedataset.color = resources.getColor(R.color.green)

        val linedataset1 = LineDataSet(lineentry1, "Second")
        linedataset.color = resources.getColor(R.color.blue)

        val finaldataset = ArrayList<LineDataSet>()
        finaldataset.add(linedataset)
        finaldataset.add(linedataset1)



        val data = LineData(xvalue, finaldataset as List<ILineDataSet>?)
        lineChart?.data = data
    }
}