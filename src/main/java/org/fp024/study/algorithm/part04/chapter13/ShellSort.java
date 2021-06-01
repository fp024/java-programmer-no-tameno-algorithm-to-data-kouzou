package org.fp024.study.algorithm.part04.chapter13;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 쉘 소트
 */
@Slf4j
class ShellSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShellSort.class);

    /**
     * 쉘 소트를 이용하여 배열을 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static void sort(int[] a) {
        int n = a.length;   // 배열의 요소수
        int h = makeFirstH(n);

        for (; h > 0; h /= 3) {  // 여기서 그대로 역순처리가 됨. 1093, 364, 121, 40, 13, 4, 1
            for (int i = h; i < n; i++) {
                int j = i;
                while (j >= h && a[j - h] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                    j -= h;
                }
            }
        }
    }


    /**
     * 요소 1만개일 때 h의 처리순서는 아래와 같아짐.
     * h:[1093, 364, 121, 40, 13, 4, 1]
     *
     * @param elementAllCount 정렬할 요소의 전체 카운트
     * @return 최종 h값
     */
    static int makeFirstH(int elementAllCount) {
        int h;
        List<Integer> hListLog = new ArrayList<>();
        for (h = 1; h < elementAllCount / 9; h = h * 3 + 1) {
            hListLog.add(h);
        }
        Collections.reverse(hListLog);
        LOGGER.info("h:{}", hListLog);
        return h;
    }
}
