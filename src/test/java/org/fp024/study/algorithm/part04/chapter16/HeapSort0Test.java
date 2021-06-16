package org.fp024.study.algorithm.part04.chapter16;

import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.fp024.study.algorithm.part04.common.SortTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * HeapSort 테스트
 */
class HeapSort0Test {
    private static final int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(1_000_000);
    private final static SortTestHelper util = SortTestHelper.getInstance();

    @Test
    void testHeapSort() {
        String[] stringArray = new String[]{"C", "B", "Z", "Y", "D", "P"};
        HeapSort0.sort(stringArray);
        assertArrayEquals(new String[]{"B", "C", "D", "P", "Y", "Z"}, stringArray);
    }

    @Test
    void testHeapSortLargeIntegerArray() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        // Heap 정렬 수행
        util.processSortOnlyTime((Consumer<Integer[]>) HeapSort0::sort, integerArray);

        // 정렬 검증 (정렬전 상태의 배열이 1씩 증가하는 배열을 섞어둔 것이기 때문에 아래와 같이 검증해보면 된다.)
        for (int i = 0; i < intArray.length; i++) {
            assertEquals(i + 1, integerArray[i].intValue());
        }
    }
}