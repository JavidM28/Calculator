package com.example.calculator.controllers;

import com.example.calculator.services.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CalculatorControllerTest {

    private final CalculatorService calculatorService = mock(CalculatorService.class);
    private final CalculatorController calculatorController = new CalculatorController(calculatorService);

    @Test
    void welcomeTest() {
        String result = calculatorController.welcome();
        assertEquals("Добро пожаловать в калькулятор", result);
    }

    @Test
    void addTest() {
        when(calculatorService.add(5.0, 5.0)).thenReturn(10.0);

        String result = calculatorController.add(5.0, 5.0);
        assertEquals("5.0 + 5.0 = 10.0", result);

        verify(calculatorService, times(1)).add(5.0, 5.0);
    }

    @Test
    void divideByZeroTest() {
        when(calculatorService.divide(5.0, 0.0)).thenThrow(new IllegalArgumentException("Деление на 0 невозможно"));

        String result = calculatorController.divide(5.0, 0.0);
        assertEquals("Деление на 0 невозможно", result);

        verify(calculatorService, times(1)).divide(5.0, 0.0);
    }
}
