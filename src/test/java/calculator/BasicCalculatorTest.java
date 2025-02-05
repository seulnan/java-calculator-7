package calculator;

import calculator.model.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicCalculatorTest {  // ✅ 더 명확한 이름으로 변경

    @Test
    void 빈문자열_테스트() {
        assertThat(Calculator.processSum("")).isEqualTo(0);
    }

    @Test
    void 기본_구분자_테스트() {
        assertThat(Calculator.processSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 하나의_숫자만_입력() {
        assertThat(Calculator.processSum("5")).isEqualTo(5);
    }

}
