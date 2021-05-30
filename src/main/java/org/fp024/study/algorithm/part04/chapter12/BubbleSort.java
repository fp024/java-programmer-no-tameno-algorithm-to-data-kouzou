package org.fp024.study.algorithm.part04.chapter12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 버블 소트
 */
class BubbleSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(BubbleSort.class);

    /**
     * 버블 소트를 이용하여 배열을 정렬한다.
     * <p>
     * 1. n-1번째 요소부터 처음 0번째 요소까지 스캔해서 가장 작은 수를 첫번째에 둠
     * 2. n-1번째 요소부터 1번째 요소까지 스캔해서 가장 작은수를 1번째에 둠
     * 3. n-1, n-2를 스캔해서 가장작은수를 n-2에 두면 정렬이 완료됨
     *
     * @param a 정렬할 배열
     */
    static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            LOGGER.info("{}번째:{}", i + 1, a);
        }
    }
}
