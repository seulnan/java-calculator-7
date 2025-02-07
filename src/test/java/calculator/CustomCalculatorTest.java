package calculator;

import calculator.model.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomCalculatorTest {
    @Test
    void 기본_구분자_테스트() {
        assertThat(Calculator.processSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_테스트() {
        assertThat(Calculator.processSum("//;\\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 기본_구분자_혼합사용_테스트() {
        assertThat(Calculator.processSum("//;\\n1;2,3:4")).isEqualTo(10);
    }
}
