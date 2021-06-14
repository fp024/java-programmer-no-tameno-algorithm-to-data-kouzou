package org.fp024.study.algorithm.part04.chapter15;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 배열 버전 머지 소트
 */
@Slf4j
class MergeSortArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeSortArray.class);

    /**
     * 배열을 머지 소트 한다.
     * a[low] ~ a[high] 요소를 정렬한다.
     *
     * @param a    정렬할 배열
     * @param low  정렬범위의 하한
     * @param high 정렬범위의 상한
     */
    private static void mergeSortArray(int[] a, int low, int high) {
        // 만약 요소가 하나뿐이라면 바로 돌아간다.
        if (low >= high) {
            return;
        }

        // 열을 2개로 분할할 장소 mid를 구한다.
        int mid = low + (high - low) / 2;

        // 앞쪽 반 요소 a[low] ~ a[mid] 를 정렬한다.
        mergeSortArray(a, low, mid);

        // 뒤쪽 반 요소 a[mid+1] ~ a[high] 를 정렬한다.
        mergeSortArray(a, mid + 1, high);

        // 작업용 배열
        int[] workingArray = new int[a.length];
        // 앞쪽 반요소를 그대로 작업용 배열에 복사한다.

        /*
        for(int i = low; i <= mid; i++) {
            workingArray[i] = a[i];
        }
        */
        // low~high 인덱스 만큼을 작업 배열에 복사하는 작업, 위의 반복 코드와 동작이 동일하다.
        System.arraycopy(a, low, workingArray, low, (mid - low) + 1);

        // 뒤쪽 반요소를 반대 순서로 작업용 배열에 복사한다.
        // 반대 순서로 복사는 힘들 것 같다.
        for (int i = mid + 1, j = high; i <= high; i++, j--) {
            workingArray[i] = a[j];
        }

        // 작업용 배열 b의 양끝에서 꺼낸 데이터를 머지하여 배열 a에 넣는다.
        int i = low;
        int j = high;
        for (int k = low; k <= high; k++) {
            if (workingArray[i] <= workingArray[j]) {
                a[k] = workingArray[i++];
            } else {
                a[k] = workingArray[j--];
            }
        }
    }

    /**
     * 머지 소트를 이용하여 배열을 정렬한다
     *
     * @param a 정렬할 배열
     */
    static void sort(int[] a) {
        mergeSortArray(a, 0, a.length - 1);
    }

}
