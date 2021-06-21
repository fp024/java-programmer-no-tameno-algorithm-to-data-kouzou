package org.fp024.study.algorithm.part05.chapter18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BM 법 프로그램 테스트
 */
class BoyerMooreTest {

    @Test
    void testSearch() {
        // Fig 18.3
        assertEquals(-1, BoyerMoore.search("abdefgh", "abc"));

        // Fig 18.4
        assertEquals(3, BoyerMoore.search("abaabcd", "abc"));

        // Fig 18.5
        assertEquals(3, BoyerMoore.search("xyzabcabcde", "abcab"));

        // Fig 18.6
        assertEquals(1, BoyerMoore.search("aabcabcabc", "abcab"));

        // Fig 18.7
        assertEquals(-1, BoyerMoore.search("xxxxdcdexxxx", "abcdab"));

        // Fig 18.8
        assertEquals(14, BoyerMoore.search("storage for strings", "ring"));
    }


    @Test
    void testSearchSimple() {
        assertEquals(3, BoyerMoore.search("012345", "34"));
    }
}