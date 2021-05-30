package org.fp024.study.algorithm.part04.chapter11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 11.5의 java.util.Arrays 클래스의 sort 메서드 테스트
 */
@Slf4j
class SortTest {
    private final Random random = new Random();

    @Test
    void testSort() {
        int maxValue = 100;
        int[] randomArray = createRandomArray(maxValue);

        logger.info("\n정렬 전: {}", randomArray);

        Arrays.sort(randomArray);

        logger.info("\n정렬 후: {}", randomArray);
        assertEquals(maxValue, randomArray[maxValue - 1]);

        assertEquals(1, randomArray[0]);
    }

    /**
     * 중복 검사를 Set에 넣고 검사하는 식으로 해서, 대용량으로는 못쓴다.
     */
    private int[] createRandomArray(final int maxValue) {
        int[] intArray = new int[maxValue];
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < maxValue) {
            int randomValue = random.nextInt(maxValue) + 1;
            if (set.add(randomValue)) {
                intArray[i++] = randomValue;
            }
        }
        return intArray;
    }

}
