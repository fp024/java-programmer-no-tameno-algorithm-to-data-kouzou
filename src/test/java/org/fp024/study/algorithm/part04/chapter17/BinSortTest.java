package org.fp024.study.algorithm.part04.chapter17;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 빈 소트 테스트
 */
@Slf4j
class BinSortTest {
    /**
     * 빈 소트 과정을 보여준다.
     */
    @Test
    void testSort() {

        // 소트할 배열을 초기화
        BinSortData[] array = new BinSortData[]{
                new BinSortData(13, "요소0")
                , new BinSortData(24, "요소1")
                , new BinSortData(15, "요소2")
                , new BinSortData(5, "요소3")
                , new BinSortData(98, "요소4")
                , new BinSortData(44, "요소5")
                , new BinSortData(35, "요소6")
                , new BinSortData(96, "요소7")
                , new BinSortData(82, "요소8")
                , new BinSortData(73, "요소8")
        };

        // 배열 array의 내용을 표시한다.
        logger.info("정렬하기 전...");
        Arrays.stream(array).forEach(
                a -> logger.info("{}", a)
        );

        // 배열 array를 빈 소트한다.
        BinSort.sort(array);


        // 정렬 후의 배열 array의 내용을 표시한다.
        logger.info("정렬한 후...");
        Arrays.stream(array).forEach(
                a -> logger.info("{}", a)
        );

        assertArrayEquals(expectArray(), array);
    }

    private BinSortData[] expectArray() {
        return new BinSortData[]{
                new BinSortData(5, "요소3")
                , new BinSortData(13, "요소0")
                , new BinSortData(15, "요소2")
                , new BinSortData(24, "요소1")
                , new BinSortData(35, "요소6")
                , new BinSortData(44, "요소5")
                , new BinSortData(73, "요소8")
                , new BinSortData(82, "요소8")
                , new BinSortData(96, "요소7")
                , new BinSortData(98, "요소4")
        };
    }
}