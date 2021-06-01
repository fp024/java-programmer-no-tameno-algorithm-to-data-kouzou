package org.fp024.study.algorithm.part04.chapter13;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
class ShellSortTest {
    private static final int MAX_VALUE = 10000;

    // 테스트 클래스의 일반 맴버이면, 개별 테스트 메서드가 실행될 때마다 초기화 된다.
    private final int[] intArray = RandomArrayUtil.createRandomArray(MAX_VALUE);

    void processSort(Runnable r, int[] intArray) {
        processSort(r, intArray, IntStream.rangeClosed(1, MAX_VALUE).toArray());
    }

    void processSort(Runnable r, int[] intArray, int[] expectArray) {
        logger.info("\n정렬 전: {}", intArray);
        r.run();
        logger.info("\n정렬 후: {}", intArray);
        assertArrayEquals(expectArray, intArray);
    }

    @Test
    void testBubbleSort() {
        processSort(() -> ShellSort.sort(intArray), intArray);
    }

}
