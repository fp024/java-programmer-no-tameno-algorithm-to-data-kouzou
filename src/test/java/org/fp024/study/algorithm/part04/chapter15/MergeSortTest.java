package org.fp024.study.algorithm.part04.chapter15;

import org.fp024.study.algorithm.part04.common.CommonSortTest;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MergeSortTest extends CommonSortTest {
    private final static int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(10000);

    private final static int[] BOOK_EXAMPLE_ARRAY = new int[]{55, 13, 3, 45, 74, 87, 46, 30};
    private final static int[] BOOK_EXAMPLE_ARRAY_EXPECT = new int[]{3, 13, 30, 45, 46, 55, 74, 87};

    /**
     * 배열을 사용한 퀵소트 테스트
     */
    @Test
    void testQuickSortByRecursive() {
        // 정렬할 랜덤 배열을 한번만 만들고, 그것을 복제해서 정렬 테스트를 수행하자.
        int[] intArray = Arrays.copyOf(BOOK_EXAMPLE_ARRAY, BOOK_EXAMPLE_ARRAY.length);
        processSort(() -> MergeSortArray.sort(intArray), intArray, BOOK_EXAMPLE_ARRAY_EXPECT, true);
    }

    @Test
    void testQuickSortByRecursiveLargeArray() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        processSort(() -> MergeSortArray.sort(intArray), intArray);
    }



}