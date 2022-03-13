package com.whiterabbit.machinetest.data.api
import com.whiterabbit.machinetest.data.models.Employee
import retrofit2.http.*

interface EmployeeApi {

    @GET("5d565297300000680030a986")
    suspend fun getEmployees(
    ): List<Employee>

}