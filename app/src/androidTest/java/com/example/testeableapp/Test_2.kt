package com.example.testeableapp

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeRight
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class Test_2 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun roundedTip_displayCorrectText(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("billTextInput").performTextInput("30")
        composeTestRule.onNodeWithTag("roundTipCheckbox").performClick()
        composeTestRule.onNodeWithTag("tipText").assertExists().assertTextEquals("Propina: $5.00")
    }

    @Test
    fun changeSliderValue(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("billTextInput").performTextInput("30")
        composeTestRule.onNodeWithTag("roundTipCheckbox").performClick()
        composeTestRule.onNodeWithTag("tipPercentageSlider").performTouchInput { swipeRight() }
        composeTestRule.onNodeWithTag("tipText").assertExists().assertTextEquals("Propina: $15.00")

    }

}