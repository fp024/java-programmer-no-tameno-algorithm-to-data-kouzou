package org.fp024.study.algorithm.part06.chapter19;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * NQueen 테스트
 */
@Slf4j
class NQueenTest {
    private static final int N = 8;
    private final NQueen nQueen = new NQueen(N);

    @Test
    void testTryQueen() {
        assertTrue(nQueen.tryQueen(0), "답을 구했다.");

        logger.info("\n---8 퀸 위치---\n{}\n---------------", nQueen);
        final String expect =
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n";
        assertEquals(expect, nQueen.toString());

        // 체스판 초기화
        nQueen.reset();
        final String emptyExpect =
                ". . . . . . . . \n" +
                ". . . . . . . . \n" +
                ". . . . . . . . \n" +
                ". . . . . . . . \n" +
                ". . . . . . . . \n" +
                ". . . . . . . . \n" +
                ". . . . . . . . \n" +
                ". . . . . . . . \n";
        assertEquals(emptyExpect, nQueen.toString());

        // 다시 구하기
        assertTrue(nQueen.tryQueen(0));
        assertEquals(expect, nQueen.toString());
    }


    @Test
    void testTryQueenAll() {
        logger.info("\n---8 퀸 모든 위치---\n{}", nQueen.tryQueenAll(0));
        String expect =
                "Q . . . . . . . \n" +  // 0, 0
                ". . . . Q . . . \n" +  // 1, 4
                ". . . . . . . Q \n" +  // 2, 7
                ". . . . . Q . . \n" +  // 3, 5
                ". . Q . . . . . \n" +  // 4, 2
                ". . . . . . Q . \n" +  // 5, 6
                ". Q . . . . . . \n" +  // 6, 1
                ". . . Q . . . . \n" +  // 7, 3
                "---------------\n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                ". Q . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . Q . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". . . . Q . . . \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                ". . Q . . . . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . . Q \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . . Q \n" +
                ". . . . . Q . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . Q . . . \n" +
                "---------------\n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . . . . Q \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                ". . . . . Q . . \n" +
                "---------------\n" +
                ". . . . . . . Q \n" +
                ". . Q . . . . . \n" +
                "Q . . . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . Q . . . \n" +
                ". . . . . . Q . \n" +
                ". . . Q . . . . \n" +
                "---------------\n" +
                ". . . . . . . Q \n" +
                ". . . Q . . . . \n" +
                "Q . . . . . . . \n" +
                ". . Q . . . . . \n" +
                ". . . . . Q . . \n" +
                ". Q . . . . . . \n" +
                ". . . . . . Q . \n" +
                ". . . . Q . . . \n" +
                "---------------\n";

        assertEquals(expect, nQueen.tryQueenAll(0));
    }

}