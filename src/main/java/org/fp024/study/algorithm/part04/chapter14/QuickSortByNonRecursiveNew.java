package org.fp024.study.algorithm.part04.chapter14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class QuickSortByNonRecursiveNew {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSortByNonRecursiveNew.class);

    // 분할 함수는 QuickSortPartition.partition 클래스 참조

    /**
     * 퀵소트를 이용해 배열을 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static void sort(int[] a, boolean displayLog) {
        int n = a.length;
        int[] low = new int[30];
        int[] high = new int[30];
        int sp;

        // 스택을 초기화한다.
        low[0] = 0;
        high[0] = n - 1;
        sp = 1;

        // 스택이 빌 때 가지 반복한다.
        while (sp > 0) {
            // 스택에서 정렬할 범위를 꺼낸다.
            int l = low[--sp];
            int r = high[sp];

            if (displayLog) {
                LOGGER.info("l:{}, r:{}", l, r);
            }

            // 정렬할 요소가 하나라면 아무것도 하지 않는다.
            // (다시 while문을 실행한다.)
            if (l >= r) {
                // 아무것도 하지 않는다.
            } else {
                // 추축 v를 기준으로 분할 한다.
                int v = QuickSortPartition.partition(a, l, r);

                // 좌우 부분 배열 중 짦은 쪽을 먼저 처리한다.
                if (v - l < r - v) {
                    // 왼쪽 부분 배열을 정렬한다.
                    // (스택이기 때문에 "오른쪽 -> 왼쪽" 순으로 쌓는 것에 주의)
                    low[sp] = v + 1;
                    high[sp++] = r;

                    low[sp] = l;
                    high[sp++] = v - 1;
                } else {
                    // 오른쪽 부분 배열을 정렬한다.
                    // (스택이기 때문에 "왼쪽 -> 오른쪽" 순으로 쌓는 것에 주의)
                    low[sp] = l;
                    high[sp++] = v - 1;

                    low[sp] = v + 1;
                    high[sp++] = r;
                }


            }
        }
    }
}
