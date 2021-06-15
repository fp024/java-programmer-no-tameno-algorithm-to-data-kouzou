package org.fp024.study.algorithm.part04.chapter14;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.fp024.study.algorithm.part04.common.SortTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * QuickSort 테스트
 */
@Slf4j
class QuickSortTest {
    private final static SortTestHelper util = SortTestHelper.getInstance();
    private final static int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(10000);

    /**
     * 재귀 버전 퀵소트 테스트
     */
    @Test
    void testQuickSortByRecursive() {
        // 정렬할 랜덤 배열을 한번만 만들고, 그것을 복제해서 정렬 테스트를 수행하자.
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        util.processSort(() -> QuickSortByRecursive.sort(intArray), intArray);
    }

    /**
     * 재귀를 사용하지 않고 배열로 스택 구현해서 직접 제어한 버전
     */
    @Test
    void testQuickSortByNonRecursive() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        util.processSort(() -> QuickSortByNonRecursive.sort(intArray, false), intArray);
    }


    /**
     * 재귀를 사용하지 않고 배열로 스택 구현해서 직접 제어한 버전에서 스택 오버플로우 대책 추가
     */
    @Test
    void testQuickSortByNonRecursiveNew() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        util.processSort(() -> QuickSortByNonRecursiveNew.sort(intArray, false), intArray);
    }

    /**
     * 정렬된 배열을 썼을 때...
     * (참고): logger로 너무 많은 텍스트를 출력하면 출력오류가 발생한다.  100,000 개까지 요소는 한번에 출력할 수 있지만,
     * 그이상은 안된다. showElementLog 인자를 그때는 false로 줘서 로그를 출력하지 말자.
     * <p>
     * === 사양: Ryzen 3700x (100,000 오름차순 배열 기준)
     * 중간값 알고리즘을 쓰지 않을 때...
     * 수행시간: 1.3650545 seconds
     * <p>
     * 중간값 알고리즘을 쓸때... (정렬범위 6이상일 때만 중간 값 구함, 그 미만은 정렬범위 마지막 값을 pivot으로 정함)
     * 수행시간: 0.0103953 seconds
     * <p>
     * === 사양: Ryzen Threadripper 2950x (1,000,000 오름차순 배열 기준)
     * 중간값 알고리즘을 쓰지 않을 때...
     * 수행시간: 111.3393297 seconds
     * <p>
     * 중간값 알고리즘을 쓸때...  (정렬범위 3이상일 때 중간 값 구함, 그 미만은 정렬범위 마지막 값을 pivot으로 정함)
     * 수행시간: 0.0307669 seconds
     * <p>
     * 요소가 100만개일 때는 수행시간이 꽤 많이 차이가 난다.
     */
    @Test
    void testQuickSortByNonRecursiveNewWithOrderedArray() {
        int[] intArray = IntStream.rangeClosed(1, 1_000_000).toArray();
        util.processSort(() -> QuickSortByNonRecursiveNew.sort(intArray, false), intArray, false);
    }

}
