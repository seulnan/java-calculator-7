package calculator.model;

import java.util.Arrays;

public class Calculator {
    public static int processSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        return Arrays.stream(input.split("[,|:]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}