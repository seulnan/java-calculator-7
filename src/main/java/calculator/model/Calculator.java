package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int processSum(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            return 0;
        }

        List<String> delimiters = Arrays.asList(",", ":");

        Matcher matcher = Pattern.compile("^//(.)\\\\n(.*)").matcher(numbers);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            delimiters = Arrays.asList(customDelimiter, ",", ":");
            numbers = matcher.group(2);
        }

        if (numbers.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자 이후 숫자가 없습니다.");
        }

        String delimiterRegex = String.join("|", delimiters);

        return Arrays.stream(numbers.split(delimiterRegex))
                .map(String::trim)
                .filter(num -> !num.isEmpty())
                .mapToInt(Calculator::parseValidation)
                .sum();
    }

    private static int parseValidation(String num) {
        try {
            int value = Integer.parseInt(num);
            if (value < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력: " + num);
        }
    }
}