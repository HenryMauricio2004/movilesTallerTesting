package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class Test_4 {


    private val dispatcher = StandardTestDispatcher()
    val tolerance = 0.001

    @Before
    fun setUp(){
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }


    @Test
    fun calculateNoTip(){
        val numberOfPeople = 1
        val tipPercentage = 0
        val bill: Double = 100.00
        val rounded = true

        val tip = calculateTip(bill, tipPercentage, rounded)

        val results = if (numberOfPeople > 0) (bill + tip) / numberOfPeople else 0.0

        assertEquals(100.0, results)
    }

    @Test
    fun calculateMinimunAmountToPay(){
        val numberOfPeople = 1000
        val tipPercentage = 0
        val bill: Double = 1.00
        val rounded = false

        val tip = calculateTip(bill, tipPercentage, rounded)

        val results = if (numberOfPeople > 0) (bill + tip) / numberOfPeople else 0.0

        assertEquals(0.01, results)
    }


}