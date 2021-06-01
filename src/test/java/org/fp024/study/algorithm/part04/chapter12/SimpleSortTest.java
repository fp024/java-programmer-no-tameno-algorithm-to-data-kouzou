package org.fp024.study.algorithm.part04.chapter12;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 단순 소트 테스트
 */
@Slf4j
class SimpleSortTest {
    private static final int MAX_VALUE = 10;

    // 테스트 클래스의 일반 맴버이면, 개별 테스트 메서드가 실행될 때마다 초기화 된다.
    private final int[] intArray = RandomArrayUtil.createRandomArray(MAX_VALUE);

    // 저자님 예시 배열
    private final int[] bookExampleArray = new int[]{20, 6, 55, 74, 3, 45, 13, 87, 46, 30};
    private final int[] bookExampleResultArray = new int[]{3, 6, 13, 20, 30, 45, 46, 55, 74, 87};

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
        processSort(() -> BubbleSort.sort(intArray), intArray);
    }

    @Test
    void testSelectionSort() {
        processSort(() -> SelectionSort.sort(intArray), intArray);
    }

    @Test
    void testInsertionSort() {
        processSort(() -> InsertionSort.sort(bookExampleArray), bookExampleArray, bookExampleResultArray);
    }

    @Test
    void testInsertionSortOfAuthor() {
        processSort(() -> InsertionSort.sortOfAuthor(bookExampleArray), bookExampleArray, bookExampleResultArray);
    }


}