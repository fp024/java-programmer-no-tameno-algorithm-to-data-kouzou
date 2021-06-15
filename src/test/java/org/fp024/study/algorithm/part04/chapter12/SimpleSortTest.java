package org.fp024.study.algorithm.part04.chapter12;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.fp024.study.algorithm.part04.common.SortTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 단순 소트 테스트
 * <p>
 * 성능을 정확하게 보려면 정렬 로직 내부에 logger로 찍은부분을 제외하고 보도록 하자.
 */
@Slf4j
class SimpleSortTest {
    private final static int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(10);
    private final static SortTestHelper util = SortTestHelper.getInstance();
    // 저자님 예시 배열
    private final int[] bookExampleArray = new int[]{20, 6, 55, 74, 3, 45, 13, 87, 46, 30};
    private final int[] bookExampleResultArray = new int[]{3, 6, 13, 20, 30, 45, 46, 55, 74, 87};

    @Test
    void testBubbleSort() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        util.processSort(() -> BubbleSort.sort(intArray), intArray);
    }

    @Test
    void testSelectionSort() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        util.processSort(() -> SelectionSort.sort(intArray), intArray);
    }

    @Test
    void testInsertionSort() {
        util.processSort(() -> InsertionSort.sort(bookExampleArray), bookExampleArray, bookExampleResultArray, true);
    }

    @Test
    void testInsertionSortOfAuthor() {
        util.processSort(() -> InsertionSort.sortOfAuthor(bookExampleArray), bookExampleArray, bookExampleResultArray, true);
    }
}