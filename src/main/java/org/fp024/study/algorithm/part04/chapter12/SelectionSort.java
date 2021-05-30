package org.fp024.study.algorithm.part04.chapter12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 선택 소트
 * <p>
 * (1) a[0] ~ a[n-1]에서 가장 작은 요소를 찾아, 그것을 a[0]과 교환한다.
 * (2) a[1] ~ a[n-1]에서 가장 작은 요소를 찾아, 그것을 a[1]과 교환한다.
 * (3) a[2] ~ a[n-1]에서 가장 작은 요소를 찾아, 그것을 a[2]과 교환한다.
 * (4) 마찬가지로 되풀이한다.
 */
class SelectionSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(SelectionSort.class);

    /**
     * 선택 소트를 이용하여 배열을 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static void sort(int[] a) {
        final int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int lowest = i;
            int lowKey = a[i];

            for (int j = i + 1; j < n; j++) {
                if (a[j] < lowKey) {
                    lowest = j;
                    lowKey = a[j];
                }
            }
            int temp = a[i];
            a[i] = a[lowest];
            a[lowest] = temp;
            LOGGER.info("{}번째:{}", i + 1, a);
        }
    }
}
