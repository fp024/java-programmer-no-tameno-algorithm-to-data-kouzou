package org.fp024.study.algorithm.part04.chapter14;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.CommonSortTest;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * QuickSort 테스트
 */
@Slf4j
class QuickSortTest extends CommonSortTest {
    private final static int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(10000);

    /**
     * 재귀 버전 퀵소트 테스트
     */
    @Test
    void testQuickSortByRecursive() {
        // 정렬할 랜덤 배열을 한번만 만들고, 그것을 복제해서 정렬 테스트를 수행하자.
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        processSort(() -> QuickSortByRecursive.sort(intArray), intArray);
    }

    /**
     * 재귀를 사용하지 않고 배열로 스택 구현해서 직접 제어한 버전
     */
    @Test
    void testQuickSortByNonRecursive() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        processSort(() -> QuickSortByNonRecursive.sort(intArray, false), intArray);
    }


    /**
     * 재귀를 사용하지 않고 배열로 스택 구현해서 직접 제어한 버전에서 스택 오버플로우 대책 추가
     */
    @Test
    void testQuickSortByNonRecursiveNew() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        processSort(() -> QuickSortByNonRecursiveNew.sort(intArray, false), intArray);
    }

    /**
     * 정렬된 배열을 썼을 때...
     *
     * 중간값 알고리즘을 쓰지 않을 때...
     * 수행시간: 1.3650545 seconds
     *
     * 중간값 알고리즘을 쓸때...
     * 수행시간: 0.0103953 seconds
     */
    @Test
    void testQuickSortByNonRecursiveNewWithOrderedArray() {
        int[] intArray = IntStream.rangeClosed(1, 100000).toArray();
        processSort(() -> QuickSortByNonRecursiveNew.sort(intArray, false), intArray);
    }


}
