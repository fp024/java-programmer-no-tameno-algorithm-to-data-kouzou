package org.fp024.study.algorithm.part04.chapter14;

/**
 * 14장 퀵소트의 분할 함수는 코드가 동일하다.
 */
class QuickSortPartition {
    /**
     * 너무 작은 배열에 대해서는 할 필요가 없을 것 같다.
     * 특정 수 이하의 거리에 대해서는 끝값을 반환하자
     */
    static int medianOfTree(int[] a, int l, int r) {
        if (r - l < 2) {
            return a[r];
        }

        int left = a[l];
        int midIndex = l + (r - l) / 2;
        int middle = a[midIndex];
        int right = a[r];

        int targetIndex;

        // left > middle > right 이런 모양을 생각하면서 수식을 만들면 되겠다.
        if (left > middle) {
            if (middle > right) {
                targetIndex = midIndex;
            } else if (right > left) {
                targetIndex = l;
            } else {
                targetIndex = r;
            }
        } else { // left < middle
            if (right < left) {
                targetIndex = l;
            } else if (middle < right) {
                targetIndex = midIndex;
            } else {
                targetIndex = r;
            }
        }

        int temp = a[targetIndex];
        a[targetIndex] = a[r];
        a[r] = temp;
        return a[r];
    }

    /**
     * 배열 a[l] ~ a[r] 을 분할한다., 추측의 첨자를 반환
     */
    static int partition(int[] a, int l, int r) {

        // 포인터 i와 j를 추가한다.
        int i = l - 1; // <?> 여기 -1을 왜?하나?  왠지 추측이 제외되는 r에 -1을 해줘야할 것 같은데...
        int j = r;     //     아래 i, j의 증감식을 전위식으로 해서 이런 방식으로 하신 것 같다.

        // 오른쪽 끝 요소를 추축으로 한다.
        // int pivot = a[r];
        // 피벗을 중간값으로 설정한다.
        int pivot = medianOfTree(a, l, r) ;

        // 포인터 i와 j가 충돌할 때까지 반복한다.
        while (true) {
            // 포인터 i를 오른쪽으로 이동시킨다.
            while (a[++i] < pivot)
                ;

            // 포인터 j를 왼쪽으로 이동시킨다.
            while (i < --j && pivot < a[j])
                ;

            // 포인터 i와 j가 충돌하면 루프를 빠져나감
            if (i >= j) {
                break;
            }

            // i와 j가 가리키는 곳을 교환한다.
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        // a[i]와 추축을 교환한다.
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        return i;
    }
}
