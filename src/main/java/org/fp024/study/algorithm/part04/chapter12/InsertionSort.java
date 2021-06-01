package org.fp024.study.algorithm.part04.chapter12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 삽입 소트
 * <p>
 * 첫번째 원소가 정렬된 상태로 가정하고 이후 원소를 정렬된 부분에 알맞은 위치로 삽입해가며 정렬함
 */
class InsertionSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(InsertionSort.class);

    /**
     * 삽입 소트를 이용하여 배열을 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static void sort(int[] a) {
        final int n = a.length;
        int innerCount = 0;

        for (int i = 1; i < n; i++) {

//            for (int j = 0; j < i; j++) {
//                if (a[j] > a[i]) {
//                    int temp = a[j];
//                    a[j] = a[i];
//                    a[i] = temp;
//                }
//                innerCount++;
//            }

            for (int j = i; j >= 1 && a[j - 1] > a[j]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                innerCount++;
            }
            LOGGER.info("{}번째:{}", i, a);
        }
        LOGGER.info("내부 반복 횟수:{}", innerCount);
    }


    /**
     * 저자님 구현
     * 저자님 구현이 내부 반복 횟수가 적음.
     * 역순으로 정렬된 배열을 오름차순으로 정렬하는 것이라면이라면 내가 한것이나 저자님이나 같음.
     * <p>
     * 나는 정렬된 영역에 대한 고려가 없어서 무조건 한바뀌 다도는 문제가 있는데.
     * 정렬영역을 내부 for 루프릍 거꾸로 반복하고
     *
     * @param a 정렬할 배열
     */
    static void sortOfAuthor(int[] a) {
        final int n = a.length;
        int innerCount = 0;

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j >= 1 && a[j - 1] > a[j]) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
                innerCount++;
            }
            LOGGER.info("{}번째:{}", i, a);
        }
        LOGGER.info("내부 반복 횟수:{}", innerCount);
    }

}
