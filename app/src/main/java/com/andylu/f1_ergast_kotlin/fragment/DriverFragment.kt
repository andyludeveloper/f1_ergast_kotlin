package com.andylu.f1_ergast_kotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.andylu.f1_ergast_kotlin.databinding.FragmentDataBinding
import com.andylu.f1_ergast_kotlin.viewmodel.DriverViewModel

class DriverFragment : Fragment() {
    private var binding : FragmentDataBinding? = null
    private val dataViewModel: DriverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDataBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = dataViewModel
        }
    }
}