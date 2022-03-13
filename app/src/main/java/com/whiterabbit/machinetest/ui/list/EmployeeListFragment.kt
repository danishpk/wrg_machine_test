package com.whiterabbit.machinetest.ui.list

import EmployeeListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.whiterabbit.machinetest.data.models.Employee
import com.whiterabbit.machinetest.data.models.Resource
import com.whiterabbit.machinetest.databinding.EmployeeListFragmentBinding

class EmployeeListFragment : Fragment() {

    private val viewModel: EmployeeListViewModel by viewModels()

    private var _binding: EmployeeListFragmentBinding? = null
    private val binding get() = _binding!!

    private val employeeListAdapter = EmployeeListAdapter {
        employee: Employee ->  findNavController().navigate(
        EmployeeListFragmentDirections.actionEmployeeListFragmentToEmployeeDetailFragment(
            employee
        ))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EmployeeListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.rvEmployees.adapter = employeeListAdapter
        viewModel.employees.observe(viewLifecycleOwner, {
            binding.pbLoading.isVisible = it is Resource.Loading
            binding.rvEmployees.isVisible = it is Resource.Success
            if (it is Resource.Success) {
                binding.tvEmptyText.isVisible = it.data.isNullOrEmpty()
                employeeListAdapter.submitList(it.data)
            }
        })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}