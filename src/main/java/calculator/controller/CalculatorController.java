package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void startCalculator() {
        String input = InputView.getInput();
        int result = Calculator.processSum(input);
        OutputView.printResult(result);
    }
}