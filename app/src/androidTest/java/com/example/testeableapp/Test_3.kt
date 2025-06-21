package com.example.testeableapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import androidx.compose.ui.test.performTextInput

class Test_3 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun billTextField_withInvalidCharacters_resultsInZeroTotal() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }
        //Algunos caracteres especiales que no deberían de ser válidas en el monto de la cuenta
        val invalidInputs = listOf("A","$", "%", "L", "#","@","^","*","(","()",")",".")

        invalidInputs.forEach { input ->
            composeTestRule
                .onNodeWithTag("billTextInput")
                .assertExists()
                .performTextInput(input)

            composeTestRule
                .onNodeWithText("Total por persona: \$0.00")
                .assertExists()
        }
    }

    @Test
    fun billTextField_withThreeDecimals_resultsInRoundedTotal() {
        // Mostrar la pantalla
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        // Ingresar valor con más de 2 decimales
        composeTestRule
            .onNodeWithTag("billTextInput")
            .performTextInput("20.126")

        // Verificar que el resultado esté redondeado a 2 decimales
        composeTestRule
            .onNodeWithText("Total por persona: \$20.12")
            .assertExists()
    }

}
