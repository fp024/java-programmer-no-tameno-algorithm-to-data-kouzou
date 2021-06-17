package org.fp024.study.algorithm.part04.chapter17;

/**
 * 분포수 세기 소트를 수행한다.
 */
class DistributionCountingSort {

    /**
     * 분포수 세기 소트를 수행한다. 배열 a의 내용을 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static void sort(BinSortData[] a) {
        final int N = a.length; // 배열의 요소수
        final int M = BinSortData.M; // 키는 0부터 M까지

        // 카운터로 사용할 배열을 할당한다.
        //   (요소는 자동적으로 0으로 초기화됨)
        int[] count = new int[M + 1];

        // 키를 센다.
        for (int i = 0; i < N; i++) {
            count[a[i].getKey()]++;
        }

        // count[M+1] {0:0, 1:(1), 2:(2), 3:0, 4:(1), 5:0, 6:0, 7:(2), 8:(1)   , .... M:0}


        // 키의 누적 도수 분포를 구한다.
        for (int i = 0; i < M; i++) {
            count[i + 1] += count[i];
        }

        // count[M+1] {0:-, 1:(1), 2:(3), 3:-, 4:(4), 5:-, 6:-, 7:(6), 8:(7)   , .... M:-}

        // 도수 분포에 따라 데이터를 배열 a에서 작업용 배열 b로 복사한다.
        BinSortData[] b = new BinSortData[N];

        for (int i = N - 1; i >= 0; i--) {
            b[--count[a[i].getKey()]] = a[i];
        }

        // N: 7, 시작 i 값 = 6
        // a[] { 7, 1, 4, 2, 7, 8, 2 }
        //
        // b[] { 1, 2, 2, 4, 7, 7, 8 }
        //
        // 코드를 보고 검산했을 때.. 안정적인 정렬이 되는 것은 보았는데,
        // 처음부터 코드를 만들수 있어야하는 부분이 중요한 것 같다.

        // 배열 b에 들어있는 정렬된 데이터를 배열 a로 복사한다.
        System.arraycopy(b, 0, a, 0, N);
    }
}
