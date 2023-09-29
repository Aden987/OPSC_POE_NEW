package com.example.opsc_poe_new

import android.app.Application

class GlobalClass: Application() {
    var personalTime: Int? = 0
    var workTime: Int? = 0
    var overTime: Int? = 0

    fun incrementPersonal()
    {
        personalTime = personalTime!! + 1
    }
}