package org.fp024.study.algorithm.part04.chapter14;

/**
 * 퀵소트 (재귀버전)
 */
class QuickSortByRecursive {
    /**
     * 실제로 퀵 소트를 수행한다.
     * 배열 a에서 a[l] ~ a[r]을 정렬한다.
     */
    private static void quickSort(int[] a, int l, int r) {
        // 정렬할 요소가 1개라면 아무것도 하지 않고 돌아간다.
        if (l >= r) {
            return;
        }

        // 추축을 v기준으로 분할
        int v = QuickSortPartition.partition(a, l, r);

        // 왼쪽 부분 배열 a[l] ~ a[v-1]을 정렬한다.
        quickSort(a, l, v - 1);

        // 오른쪽 부분 배열 a[v + 1] ~ a[r]을 정렬한다.
        quickSort(a, v + 1, r);
    }


    /**
     * 퀵 소트를 이용하여 배열을 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }


}
