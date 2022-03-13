
package com.whiterabbit.machinetest.data.localDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.whiterabbit.machinetest.data.models.Employee
import androidx.room.OnConflictStrategy




@Dao
interface EmployeeDoe {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(employees: List<Employee>)

    @Query("SELECT * FROM employee")
    fun getEmployeesFromDb(): List<Employee>

}
