package com.whiterabbit.machinetest.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.whiterabbit.machinetest.R
import com.whiterabbit.machinetest.databinding.EmployeeDetailFragmentBinding

class EmployeeDetailFragment : Fragment() {

    private val viewModel: EmployeeDetailViewModel by viewModels()

    private var _binding: EmployeeDetailFragmentBinding? = null
    private val binding get() = _binding!!

    private val args: EmployeeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EmployeeDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        val employee = args.employee

        binding.apply {
            tvEmployeeName.text = employee?.name
            tvUserName.text = employee?.username
            tvEmployeeEmail.text = employee?.email
            tvEmployeePhone.text = employee?.phone
            tvEmployeeWebsite.text = employee?.website
            "${employee?.employeeAddress?.street}, ${employee?.employeeAddress?.city}".also { tvEmployeeAddress.text = it }
            "${employee?.employeeCompany?.companyName}, ${employee?.employeeCompany?.bs}".also { tvEmployeeCompany.text = it }
            Glide.with(requireContext())
                .load(employee?.profileImage)
                .centerCrop()
                .placeholder(
                    ContextCompat.getDrawable(requireContext(),
                        R.drawable.ic_round_person_outline_24))
                .error(R.drawable.ic_round_person_outline_24)
                .into(ivEmployeeImg)
        }
    }

}