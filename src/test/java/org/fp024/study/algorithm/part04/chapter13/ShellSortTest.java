package org.fp024.study.algorithm.part04.chapter13;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.CommonSortTest;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
class ShellSortTest extends CommonSortTest {
    private final static int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(10);

    @Test
    void testBubbleSort() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        processSort(() -> ShellSort.sort(intArray), intArray);
    }
}
