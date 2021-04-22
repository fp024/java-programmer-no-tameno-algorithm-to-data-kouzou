package org.fp024.study.algorithm.part02.chapter04;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 역 폴란드 계산기 동작 테스트
 */
class CalculatorTest {
    /**
     * 테스트시 System.in의 내용을 변경하므로 일단 원래내용을 백업해둠.
     */
    private final static InputStream ORIGIN_STDIN = System.in;

    /**
     * 연속적인 테스트는 아니여서, 복구가 필수는 아닌데, 테스트가 끝나면 복구 코드는 추가함.
     */
    @AfterAll
    static void AfterAll() {
        System.setIn(ORIGIN_STDIN);
    }

    /**
     * 결과확인하려고 메시지 변수를 사용하여, 결과 확인이 끝날 때마다 메시지를 초기화한다.
     */
    @AfterEach
    void AfterEach() {
        Calculator.clearMessage();
    }

    @Test
    void testMain() throws IOException {
        String keyboardInput = "5 7 +\r\n5 7 + 2 *\r\n5 7 2 +*\n";
        System.setIn(new ByteArrayInputStream((keyboardInput.getBytes())));

        Calculator.main(null);
        assertEquals("답은 12 입니다.\r\n답은 24 입니다.\r\n답은 45 입니다.\r\n", Calculator.getResultMessage());
    }


    @Test
    void testMulti() throws IOException {
        String keyboardInput = "44 4 /\r\n";
        System.setIn(new ByteArrayInputStream((keyboardInput.getBytes())));

        Calculator.main(null);
        assertEquals("답은 11 입니다.\r\n", Calculator.getResultMessage());
    }


    @Test
    void testError() throws IOException {
        String keyboardInput = "1 a +\r\n";
        System.setIn(new ByteArrayInputStream((keyboardInput.getBytes())));

        Calculator.main(null);
        assertEquals("올바르지 않은 문자 a가 있습니다.\r\n다시 입력해 주십시오.\r\n", Calculator.getResultMessage());
    }

}