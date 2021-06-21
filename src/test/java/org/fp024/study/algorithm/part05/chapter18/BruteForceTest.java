package org.fp024.study.algorithm.part05.chapter18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 주먹구구식 방법을 이용한 문자열 탐색 테스트
 */
class BruteForceTest {
    /**
     * 저자님 코드 테스트
     */
    @Test
    void testSearchByAuthor() {
        assertEquals(-1, BruteForce.searchByAuthor("012345", "678"));

        assertEquals(0, BruteForce.searchByAuthor("012345012345", "0"));

        assertEquals(5, BruteForce.searchByAuthor("012345012345", "5012"));

        assertEquals(10, BruteForce.searchByAuthor("012345012345A", "45A"));

        assertEquals(-1, BruteForce.searchByAuthor("012345012345A", "45AB"));
    }


    /**
     * 메서드 정의만 보고 구현 해본 메서드 테스트
     */
    @Test
    void testSearch() {
        assertEquals(-1, BruteForce.search("012345", "678"));

        assertEquals(0, BruteForce.search("012345012345", "0"));

        assertEquals(5, BruteForce.search("012345012345", "5012"));

        assertEquals(10, BruteForce.search("012345012345A", "45A"));

        assertEquals(-1, BruteForce.search("012345012345A", "45AB"));
    }
}