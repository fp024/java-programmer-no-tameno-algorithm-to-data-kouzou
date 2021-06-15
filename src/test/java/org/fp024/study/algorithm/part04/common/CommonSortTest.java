package org.fp024.study.algorithm.part04.common;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public abstract class CommonSortTest {
    protected void processSort(Runnable r, int[] intArray) {
        processSort(r, intArray, IntStream.rangeClosed(1, intArray.length).toArray(), true);
    }

    protected void processSort(Runnable r, int[] intArray, boolean showElementLog) {
        processSort(r, intArray, IntStream.rangeClosed(1, intArray.length).toArray(), showElementLog);
    }

    protected void processSort(Runnable r, int[] intArray, int[] expectArray, boolean showElementLog) {
        if (showElementLog) {
            logger.info("\n정렬 전: {}", intArray);
        }
        long start = System.nanoTime();
        r.run();
        long elapsed = System.nanoTime() - start;
        if (showElementLog) {
            logger.info("\n정렬 후: {}", intArray);
        }
        logger.info("수행시간: {} seconds", elapsed / 1_000_000_000.0);
        assertArrayEquals(expectArray, intArray);
    }


    /**
     * 정렬 코드의 수행 시간만 재는 메서드
     * <p>
     * 연결리스트를 이용한 머지 소트에서는 기본 배열형을 안쓰다보니 기존 코드를 쓰기가 어려웠다.
     * 시간만 재는 부분을 두고, 결과값을 리턴 받아 호출처에서 검증함.
     *
     * @param f   실행 함수
     * @param <T> 함수 입력값 타입
     * @return 정렬된 결과
     */
    protected <T, R> R processSortOnlyTime(Function<T, R> f, T t) {
        long start = System.nanoTime();
        R r = f.apply(t);
        long elapsed = System.nanoTime() - start;
        logger.info("수행시간: {} seconds", elapsed / 1_000_000_000.0);
        return r;
    }

}
