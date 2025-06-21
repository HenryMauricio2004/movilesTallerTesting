package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import com.example.testeableapp.ui.Screens.calculateTotalPerPerson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test
import kotlin.math.ceil
import org.junit.Assert.assertEquals
import org.junit.Before

class Test_1
{

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp()
    {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown()
    {
        Dispatchers.resetMain()
    }


    @Test
    fun calculateTip_withRounding_isCorrect() {


        val result = calculateTip(20.00, 37, true)

        val trueApproxResult = ceil(7.4)

        assertEquals(trueApproxResult, result, 0.001)
    }

    @Test
    fun calculateTip_negativeAmount_returnsZero() {

        val result = calculateTip(-20.0, 15, true)

        assertEquals(0.0, result, 0.001)
    }

    @Test
    fun calculateTotalPerPerson_isCorrect() {
        val result = calculateTotalPerPerson (20.00, 37, true, 2)

        val trueApproxResult = ceil(13.7)

        assertEquals(trueApproxResult, result, 0.001)//
    }

}

