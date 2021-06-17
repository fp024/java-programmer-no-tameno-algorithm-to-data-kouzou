package org.fp024.study.algorithm.part04.chapter17;

/**
 * 빈 소트를 수행한다
 */
class BinSort {
    /**
     * 빈 소트를 수행한다. 전달받은 배열 a의 내용을 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static void sort(BinSortData[] a) {
        final int M = BinSortData.M;    // 키는 0부터 M까지

        // 빈을 할당한다.
        // 할당한 후에는 모든 빈에 비어있다는 것을 나타내는 null이 저장된다.
        // 0번 인덱스는 사용되지 않고 1~ M 까지 사용된다.
        BinSortData[] bin = new BinSortData[M + 1];

        // 배열 a의 데이터를 순서대로 빈에 넣는다.
        for (BinSortData binSortData : a) {
            bin[binSortData.getKey()] = binSortData;
        }

        // 데이터를 빈에서 (오름차순으로) 꺼내 배열 a에 되돌린다.
        int j = 0;
        for (int i = 0; i < M; i++) {
            if (bin[i] != null) {
                a[j++] = bin[i];
            }
        }
    }
}
