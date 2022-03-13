package com.whiterabbit.machinetest.data.localDb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.whiterabbit.machinetest.data.models.Employee

@Database(entities = [Employee::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDoe
}