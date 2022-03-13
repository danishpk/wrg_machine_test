package com.whiterabbit.machinetest

import android.app.Application

class WRMachineTestApp : Application() {

    companion object {
        private lateinit var instance: WRMachineTestApp

        fun get() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}