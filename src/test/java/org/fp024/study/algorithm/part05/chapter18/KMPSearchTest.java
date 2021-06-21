package org.fp024.study.algorithm.part05.chapter18;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * KMP 탐색 테스트
 * <p>
 * 이차원이상 배열을 출력할 때는 Arrays.deepToString() 을 사용.
 */
@Slf4j
class KMPSearchTest {
    private final static String TEXT = "AABRAACADABRAACAADABRA";

    @Test
    void testSort() {
        String pattern = "AACAA";
        int[][] dfa = KMPSearch.createDFA(pattern);

        logger.info("dfa: {}", Arrays.deepToString(dfa));
        assertEquals(12, KMPSearch.sort(TEXT, pattern, dfa));
    }

    @Test
    void testSortNotFound() {
        String pattern = "AACAZ";
        int[][] dfa = KMPSearch.createDFA(pattern);

        logger.info("dfa: {}", Arrays.deepToString(dfa));
        assertEquals(-1, KMPSearch.sort(TEXT, pattern, dfa));
    }

}