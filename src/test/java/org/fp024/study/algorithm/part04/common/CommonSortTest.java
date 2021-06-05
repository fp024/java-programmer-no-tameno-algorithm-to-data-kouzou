package org.fp024.study.algorithm.part04.common;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public abstract class CommonSortTest {

    protected void processSort(Runnable r, int[] intArray) {
        processSort(r, intArray, IntStream.rangeClosed(1, intArray.length).toArray());
    }

    protected void processSort(Runnable r, int[] intArray, int[] expectArray) {
        logger.info("\n정렬 전: {}", intArray);
        long start = System.nanoTime();
        r.run();
        long elapsed = System.nanoTime() - start;
        logger.info("\n정렬 후: {}", intArray);
        logger.info("수행시간: {} seconds", elapsed / 1_000_000_000.0);
        assertArrayEquals(expectArray, intArray);
    }
}
