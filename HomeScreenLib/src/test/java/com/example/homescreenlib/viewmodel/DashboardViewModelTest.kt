package com.example.homescreenlib.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.homescreenlib.R
import com.example.homescreenlib.data.DashboardItems
import com.example.homescreenlib.getOrAwaitValueTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DashboardViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setup() {
        val dashboardItems = DashboardItems()
        viewModel = DashboardViewModel(dashboardItems)
    }

    @Test
    fun testItemsAvailability() {
        viewModel.getDashboardItems()
        val result = viewModel.itemsList.getOrAwaitValueTest()
        assertTrue("Contains Data", result?.size != 0)
    }

    @Test
    fun `test there are only 6 items in the HomeScreen`() {
        viewModel.getDashboardItems()
        val result = viewModel.itemsList.getOrAwaitValueTest()
        assertTrue(result.size == 6)
    }

    @Test
    fun `test first item is Walking or not`() {
        viewModel.getDashboardItems()
        val index = 0
        val result = viewModel.itemsList.getOrAwaitValueTest().get(index = index)
        assertTrue(result.title == "Walking")
    }

    @Test
    fun `test first item image is ic_directions_walk`() {
        viewModel.getDashboardItems()
        val index = 0
        val result = viewModel.itemsList.getOrAwaitValueTest().get(index = index)
        assertTrue(result.image == R.drawable.ic_directions_walk)
    }

    @Test
    fun `test whether the dashboard contains gym` (){
        viewModel.getDashboardItems()
        val result = viewModel.itemsList.getOrAwaitValueTest().find {
            it.title == "Gym"
        }
        assertTrue(result != null)
    }
}