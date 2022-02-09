package com.example.homescreenlib.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.homescreenlib.R
import com.example.homescreenlib.data.DashboardItems
import com.example.homescreenlib.databinding.ActivityHomeBinding
import com.example.homescreenlib.viewmodel.DashboardViewModel
import com.example.homescreenlib.viewmodel.ViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    //private lateinit var viewModel: DashboardViewModel
    val viewModel: DashboardViewModel by viewModel()
    private val adapter: HomeAdapter = HomeAdapter()
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        initViewModels()
        observedashboardItems()
    }
    private fun initViewModels() {
        /*viewModel = ViewModelProvider(
            this,
            ViewModelFactory(DashboardItems())
        )[DashboardViewModel::class.java]*/
        viewModel.getDashboardItems()

    }

    private fun observedashboardItems() {
        binding.recyclerView.adapter = adapter
        viewModel.itemsList.observe(this, Observer {
            println("Dashboard items $it")
            it?.let {
                adapter.submitList(it)
            }

        })
    }


}