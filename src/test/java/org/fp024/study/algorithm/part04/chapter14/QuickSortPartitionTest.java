package org.fp024.study.algorithm.part04.chapter14;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 퀵정렬 구성 메서드 테스트
 *
 * 중간값을 취하는 부분에 대해서는 저자님이 따로 코드 구현없이 설명만 하셨는데,
 * 요구사항대로 해보았다.
 */
@Slf4j
class QuickSortPartitionTest {

    @Test
    void testMedianOfTree() {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6};
        int pivot = QuickSortPartition.medianOfTree(intArray, 0, 5);
        logger.info("{}", intArray);
        assertEquals(3, pivot);
    }

}