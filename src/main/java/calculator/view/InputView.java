package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getInput() {
        System.out.println("문자열을 입력하세요:");
        String userInputValue = Console.readLine();

        return userInputValue;
    }
}