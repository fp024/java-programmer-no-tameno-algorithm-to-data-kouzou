package org.fp024.study.algorithm.part04.chapter17;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 기수 정렬 테스트
 */
@Slf4j
class RadixSortTest {
    @Test
    void testSort() {
        RadixSortData[] array = createUnsortedArray();

        logger.info("정렬하기전...");
        RadixSort.dumpArray(array);

        RadixSort.sort(array);

        assertArrayEquals(createSortedArray(), array);
    }

    /**
     * 정렬 전 데이터
     */
    private RadixSortData[] createUnsortedArray() {
        return new RadixSortData[]{
                new RadixSortData(0x2f38, "요소0"),
                new RadixSortData(0x2fb7, "요소1"),
                new RadixSortData(0x9328, "요소2"),
                new RadixSortData(0xa400, "요소3"),
                new RadixSortData(0x000f, "요소4"),
                new RadixSortData(0x0002, "요소5"),
                new RadixSortData(0x0844, "요소6"),
                new RadixSortData(0xef85, "요소7"),
                new RadixSortData(0x289a, "요소8"),
                new RadixSortData(0x2f30, "요소9")
        };
    }

    /**
     * 정렬 후 데이터
     */
    private RadixSortData[] createSortedArray() {
        return new RadixSortData[]{
                new RadixSortData(0x0002, "요소5"),
                new RadixSortData(0x000f, "요소4"),
                new RadixSortData(0x0844, "요소6"),
                new RadixSortData(0x289a, "요소8"),
                new RadixSortData(0x2f30, "요소9"),
                new RadixSortData(0x2f38, "요소0"),
                new RadixSortData(0x2fb7, "요소1"),
                new RadixSortData(0x9328, "요소2"),
                new RadixSortData(0xa400, "요소3"),
                new RadixSortData(0xef85, "요소7")
        };
    }

    /*
        실행결과

        2021-06-20 21:46:34,413  INFO [RadixSortTest] 정렬하기전...
        2021-06-20 21:46:34,428  INFO [RadixSort] key=2f38 data=요소0
        2021-06-20 21:46:34,428  INFO [RadixSort] key=2fb7 data=요소1
        2021-06-20 21:46:34,428  INFO [RadixSort] key=9328 data=요소2
        2021-06-20 21:46:34,428  INFO [RadixSort] key=a400 data=요소3
        2021-06-20 21:46:34,429  INFO [RadixSort] key=   f data=요소4
        2021-06-20 21:46:34,429  INFO [RadixSort] key=   2 data=요소5
        2021-06-20 21:46:34,429  INFO [RadixSort] key= 844 data=요소6
        2021-06-20 21:46:34,429  INFO [RadixSort] key=ef85 data=요소7
        2021-06-20 21:46:34,430  INFO [RadixSort] key=289a data=요소8
        2021-06-20 21:46:34,430  INFO [RadixSort] key=2f30 data=요소9
        2021-06-20 21:46:34,430  INFO [RadixSort] Pass 1 ---------------
        2021-06-20 21:46:34,430  INFO [RadixSort] key=a400 data=요소3
        2021-06-20 21:46:34,430  INFO [RadixSort] key=2f30 data=요소9
        2021-06-20 21:46:34,430  INFO [RadixSort] key=   2 data=요소5
        2021-06-20 21:46:34,431  INFO [RadixSort] key= 844 data=요소6
        2021-06-20 21:46:34,431  INFO [RadixSort] key=ef85 data=요소7
        2021-06-20 21:46:34,431  INFO [RadixSort] key=2fb7 data=요소1
        2021-06-20 21:46:34,431  INFO [RadixSort] key=2f38 data=요소0
        2021-06-20 21:46:34,431  INFO [RadixSort] key=9328 data=요소2
        2021-06-20 21:46:34,431  INFO [RadixSort] key=289a data=요소8
        2021-06-20 21:46:34,431  INFO [RadixSort] key=   f data=요소4
        2021-06-20 21:46:34,431  INFO [RadixSort] Pass 2 ---------------
        2021-06-20 21:46:34,431  INFO [RadixSort] key=a400 data=요소3
        2021-06-20 21:46:34,432  INFO [RadixSort] key=   2 data=요소5
        2021-06-20 21:46:34,432  INFO [RadixSort] key=   f data=요소4
        2021-06-20 21:46:34,432  INFO [RadixSort] key=9328 data=요소2
        2021-06-20 21:46:34,432  INFO [RadixSort] key=2f30 data=요소9
        2021-06-20 21:46:34,432  INFO [RadixSort] key=2f38 data=요소0
        2021-06-20 21:46:34,432  INFO [RadixSort] key= 844 data=요소6
        2021-06-20 21:46:34,432  INFO [RadixSort] key=ef85 data=요소7
        2021-06-20 21:46:34,432  INFO [RadixSort] key=289a data=요소8
        2021-06-20 21:46:34,432  INFO [RadixSort] key=2fb7 data=요소1
        2021-06-20 21:46:34,433  INFO [RadixSort] Pass 3 ---------------
        2021-06-20 21:46:34,433  INFO [RadixSort] key=   2 data=요소5
        2021-06-20 21:46:34,433  INFO [RadixSort] key=   f data=요소4
        2021-06-20 21:46:34,433  INFO [RadixSort] key=9328 data=요소2
        2021-06-20 21:46:34,433  INFO [RadixSort] key=a400 data=요소3
        2021-06-20 21:46:34,433  INFO [RadixSort] key= 844 data=요소6
        2021-06-20 21:46:34,433  INFO [RadixSort] key=289a data=요소8
        2021-06-20 21:46:34,433  INFO [RadixSort] key=2f30 data=요소9
        2021-06-20 21:46:34,433  INFO [RadixSort] key=2f38 data=요소0
        2021-06-20 21:46:34,433  INFO [RadixSort] key=ef85 data=요소7
        2021-06-20 21:46:34,434  INFO [RadixSort] key=2fb7 data=요소1
        2021-06-20 21:46:34,434  INFO [RadixSort] Pass 4 ---------------
        2021-06-20 21:46:34,434  INFO [RadixSort] key=   2 data=요소5
        2021-06-20 21:46:34,434  INFO [RadixSort] key=   f data=요소4
        2021-06-20 21:46:34,434  INFO [RadixSort] key= 844 data=요소6
        2021-06-20 21:46:34,434  INFO [RadixSort] key=289a data=요소8
        2021-06-20 21:46:34,434  INFO [RadixSort] key=2f30 data=요소9
        2021-06-20 21:46:34,434  INFO [RadixSort] key=2f38 data=요소0
        2021-06-20 21:46:34,435  INFO [RadixSort] key=2fb7 data=요소1
        2021-06-20 21:46:34,435  INFO [RadixSort] key=9328 data=요소2
        2021-06-20 21:46:34,435  INFO [RadixSort] key=a400 data=요소3
        2021-06-20 21:46:34,435  INFO [RadixSort] key=ef85 data=요소7
    */
}