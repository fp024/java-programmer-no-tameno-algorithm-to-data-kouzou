package org.fp024.study.algorithm.part04.chapter15;

import org.fp024.study.algorithm.part04.common.CommonSortTest;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;

class MergeSortArrayTest extends CommonSortTest {
     private final static int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(100_000);

    private final static int[] BOOK_EXAMPLE_ARRAY = new int[]{55, 13, 3, 45, 74, 87, 46, 30};
    private final static int[] BOOK_EXAMPLE_ARRAY_EXPECT = new int[]{3, 13, 30, 45, 46, 55, 74, 87};

    /**
     * 배열을 사용한 머지 소트 테스트
     */
    @Test
    void testMergeSortArrayByRecursive() {
        // 정렬할 랜덤 배열을 한번만 만들고, 그것을 복제해서 정렬 테스트를 수행하자.
        int[] intArray = Arrays.copyOf(BOOK_EXAMPLE_ARRAY, BOOK_EXAMPLE_ARRAY.length);
        processSort(() -> MergeSortArray.sort(intArray), intArray, BOOK_EXAMPLE_ARRAY_EXPECT, true);
    }

    /**
     * 배열 버전의 머지소트 수행시간이 상당히 길다.
     *      수행시간: 7.2461178 seconds
     * 연결리스트를 사용한 수행시간은 ...
     *      수행시간: 0.0285856 seconds
     *
     * 제일 문제가 되는 부분이... 아래 배열을 생성하는 부분과... 복사하는 부분이 분할마다 호출되서 문제가 되는 것 같다.
     *     int[] workingArray = new int[a.length];
     */
    @Test
    void testMergeSortArrayByLargeArray() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        processSort(() -> MergeSortArray.sort(intArray), intArray, false);
    }


}