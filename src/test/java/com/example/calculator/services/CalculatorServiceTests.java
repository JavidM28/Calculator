package com.example.calculator.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void addTest() {
        assertEquals(10, calculatorService.add(5, 5));
        assertEquals(0, calculatorService.add(-5, 5));
    }

    @Test
    void subtractTest() {
        assertEquals(0, calculatorService.subtract(5, 5));
        assertEquals(-10, calculatorService.subtract(-5, 5));
    }

    @Test
    void multiplyTest() {
        assertEquals(25, calculatorService.multiply(5, 5));
        assertEquals(-25, calculatorService.multiply(-5, 5));
    }

    @Test
    void divideTest() {
        assertEquals(1, calculatorService.divide(5, 5));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(5, 0));
    }
}
