package com.andylu.f1_ergast_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andylu.f1_ergast_kotlin.adapter.DriverAdapter
import com.andylu.f1_ergast_kotlin.databinding.FragmentDriversBinding
import com.andylu.f1_ergast_kotlin.viewmodel.DriverViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DriverFragment : Fragment() {
    private var binding: FragmentDriversBinding? = null
    private val driverViewModel: DriverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentDriversBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val driverAdapter = DriverAdapter()
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            adapter = driverAdapter
            driverViewModel.data.observe(viewLifecycleOwner, {
                it.let(driverAdapter::submitList)
            })
        }

    }
}