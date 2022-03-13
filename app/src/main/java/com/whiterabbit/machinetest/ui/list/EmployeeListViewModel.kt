package com.whiterabbit.machinetest.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.whiterabbit.machinetest.WRMachineTestApp
import com.whiterabbit.machinetest.data.localDb.DatabaseBuilder
import com.whiterabbit.machinetest.data.models.Employee
import com.whiterabbit.machinetest.data.models.Resource
import com.whiterabbit.machinetest.internals.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeListViewModel : BaseViewModel() {
    private val _employees = MutableLiveData<Resource<List<Employee>>>()
    val employees: LiveData<Resource<List<Employee>>> = _employees

    private val _employeesLocal = MutableLiveData<Resource<List<Employee>>>()
    val employeesLocal: LiveData<Resource<List<Employee>>> = _employeesLocal

    init {
        fetchEmployeesFromDb()
    }

    fun fetchEmployeesFromApi() {
        fetchListData(_employees) {
            Api.EMPLOYEE_API_API.getEmployees()
        }
    }

    fun fetchEmployeesFromDb() {
        fetchListData(_employeesLocal) {
            DatabaseBuilder.getInstance(WRMachineTestApp.get()).employeeDao().getEmployeesFromDb()
        }
    }

    fun insertData(employees: List<Employee>){
        viewModelScope.launch(Dispatchers.IO) {
            DatabaseBuilder.getInstance(WRMachineTestApp.get()).employeeDao().insertItems(employees)
        }
    }
}