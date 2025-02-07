package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void startCalculator() {
        try {
            String input = InputView.getInput();
            int result = Calculator.processSum(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            throw e;
        }
    }
}