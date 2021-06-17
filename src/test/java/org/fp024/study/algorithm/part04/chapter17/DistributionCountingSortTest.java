package org.fp024.study.algorithm.part04.chapter17;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 분포수 세기 소트 테스트
 */
@Slf4j
class DistributionCountingSortTest {

    @Test
    void testSort() {
        BinSortData[] array = inputArray();

        // 배열 array의 내용을 표시한다.
        logger.info("정렬하기 전...");
        Arrays.stream(array).forEach(
                a -> logger.info("{}", a)
        );
        DistributionCountingSort.sort(array);
        // 배열 array의 내용을 표시한다.
        logger.info("정렬하기 전...");
        Arrays.stream(array).forEach(
                a -> logger.info("{}", a)
        );
        assertArrayEquals(expectArray(), array);
    }

    /**
     * 책과 비교하기 쉽게... 중복이 존재하는 Fig 17.2의 데이터로 사용했다.
     */
    private BinSortData[] inputArray() {
        return new BinSortData[]{
                new BinSortData(7, "요소0")
                , new BinSortData(4, "요소1")
                , new BinSortData(1, "요소2")
                , new BinSortData(2, "요소3")
                , new BinSortData(7, "요소4")
                , new BinSortData(8, "요소5")
                , new BinSortData(2, "요소6")
        };
    }

    /**
     * 안정적인 정렬을 하므로, 요소순서도 맞아야한다.
     */
    private BinSortData[] expectArray() {
        return new BinSortData[]{
                new BinSortData(1, "요소2")
                , new BinSortData(2, "요소3")
                , new BinSortData(2, "요소6")
                , new BinSortData(4, "요소1")
                , new BinSortData(7, "요소0")
                , new BinSortData(7, "요소4")
                , new BinSortData(8, "요소5")
        };
    }
}