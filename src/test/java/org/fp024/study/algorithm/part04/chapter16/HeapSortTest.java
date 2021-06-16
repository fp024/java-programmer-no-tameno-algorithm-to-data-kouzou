package org.fp024.study.algorithm.part04.chapter16;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.fp024.study.algorithm.part04.common.SortTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 개선된 Heap 소트 테스트
 * <p>
 * 기본은 역순 정렬
 */
@Slf4j
class HeapSortTest {
    private static final int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(1_000_000);
    private final static SortTestHelper util = SortTestHelper.getInstance();

    /**
     * 입력 배열 자체를 힙으로서 정렬하는 방식이고, 1번 인덱스 기준으로 다루기 때문에... 0번 인덱스는 사용하지 않는다.
     */
    @Test
    void testHeapSort() {
        String[] stringArray = new String[]{null, "C", "B", "Z", "Y", "D", "P"};
        HeapSort.sort(stringArray);
        assertArrayEquals(new String[]{null, "Z", "Y", "P", "D", "C", "B"}, stringArray);
    }


    /**
     * HeapSort 구현이 ...
     * 배열의 a[1] ~ a[n] 범위만 정렬하고 a[0]을 사용하지 않으므로
     * 랜덤 배열 결과 값에 앞에 0을 붙여 새로운 테스트용 배열을 만들어 테스트
     */
    @Test
    void testHeapSortLargeIntegerArray() {
        int[] intArray = new int[ORIGIN_INT_ARRAY.length + 1];
        // 0번 인덱스를 사용하지 않는 값으로 처리하기 위해
        System.arraycopy(ORIGIN_INT_ARRAY, 0, intArray, 1, ORIGIN_INT_ARRAY.length);

        Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        // Heap 정렬 수행
        util.processSortOnlyTime((Consumer<Integer[]>) HeapSort::sort, integerArray);

        // 정렬 검증, 역순 정렬이기 때문에, 1부터 시작하는 j변수를 따로 뒀다.
        for (int i = ORIGIN_INT_ARRAY.length, j = 1; i > 0; i--, j++) {
            assertEquals(j, integerArray[i].intValue());
        }
    }
}