package com.example.calculator.controllers;

import com.example.calculator.services.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String add(@RequestParam Double num1, @RequestParam Double num2) {
        return String.format("%s + %s = %s", num1, num2, calculatorService.add(num1, num2));
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam Double num1, @RequestParam Double num2) {
        return String.format("%s - %s = %s", num1, num2, calculatorService.subtract(num1, num2));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Double num1, @RequestParam Double num2) {
        return String.format("%s * %s = %s", num1, num2, calculatorService.multiply(num1, num2));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Double num1, @RequestParam Double num2) {
        try {
            return String.format("%s / %s = %s", num1, num2, calculatorService.divide(num1, num2));
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
