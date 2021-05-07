package org.fp024.study.algorithm.part03.chapter08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashFunctionTest {
    /**
     * List. 8.1 문자열용 해시 함수
     */
    static int hash(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }

        return sum % 100;
    }

    @Test
    void testHash() {
        assertEquals(22, hash("one"));
        assertEquals(46, hash("two"));
        assertEquals(36, hash("three"));
        assertEquals(44, hash("four"));
        assertEquals(26, hash("five"));         //  five, nine에 대해 충돌
        assertEquals(40, hash("six"));
        assertEquals(45, hash("seven"));
        assertEquals(29, hash("eight"));
        assertEquals(26, hash("nine"));         //  ""
        assertEquals(27, hash("ten"));
    }

}
