package org.fp024.study.algorithm.part04.chapter11;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 11.5의 java.util.Arrays 클래스의 sort 메서드 테스트
 */
@Slf4j
class SortTest {
    @Test
    void testSort() {
        int maxValue = 100;
        int[] randomArray = RandomArrayUtil.createRandomArray(maxValue);

        logger.info("\n정렬 전: {}", randomArray);

        Arrays.sort(randomArray);

        logger.info("\n정렬 후: {}", randomArray);
        assertEquals(maxValue, randomArray[maxValue - 1]);

        assertEquals(1, randomArray[0]);
    }


}
