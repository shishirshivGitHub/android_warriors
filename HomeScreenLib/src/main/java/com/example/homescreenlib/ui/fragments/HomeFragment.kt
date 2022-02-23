package com.example.homescreenlib.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.homescreenlib.R
import com.example.homescreenlib.databinding.FragmentHomeBinding
import com.example.homescreenlib.ui.HomeAdapter
import com.example.homescreenlib.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    val viewModel: DashboardViewModel by viewModel()
    private val adapter: HomeAdapter = HomeAdapter()
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home,
            container, false
        )
        initViewModels()
        observedashboardItems()
        adapter.setOnItemClickListener {
            when (it.title) {
                "Walking" -> {
                    findNavController().navigate(R.id.action_homeFragment_to_walkingFragment)
                }
                "Treadmill" -> {
                    findNavController().navigate(R.id.action_homeFragment_to_treadmillFragment)
                }
                "Running" -> {
                    findNavController().navigate(R.id.action_homeFragment_to_runningFragment)
                }
                "Cycling" -> {
                    findNavController().navigate(R.id.action_homeFragment_to_cyclingFragment)
                }
                "Gym" -> {
                    findNavController().navigate(R.id.action_homeFragment_to_gymFragment)
                }
                "Yoga" -> {
                    findNavController().navigate(R.id.action_homeFragment_to_yogaFragment)
                }
            }

        }
        return binding.root
    }

    private fun initViewModels() {
        viewModel.getDashboardItems()
    }

    private fun observedashboardItems() {
        binding.recyclerView.adapter = adapter
        viewModel.itemsList.observe(requireActivity(), Observer { event ->
            event?.getContentIfNotHandledOrReturnNull()?.let {
                it?.let {
                    adapter.submitList(it)
                }
            }
        })
    }


}