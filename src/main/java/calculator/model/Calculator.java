package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        String delimiterRegex = String.join("|", delimiters);

        return Arrays.stream(numbers.split(delimiterRegex))
                .map(String::trim)
                .filter(num -> !num.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}