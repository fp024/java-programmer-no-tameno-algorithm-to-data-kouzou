package org.fp024.study.algorithm.part04.chapter16;

/**
 * 힙 소트
 * <p>
 * 하향식으로 부분 순서 트리 구축 방식
 */
class HeapSort {

    /**
     * 힙의 처음 요소를 필요한 곳 까지 내려보낸다.
     * 단, a[from]을 힙의 처음 요소, a[to]를 힙의 마지막 요소로 한다.
     *
     * @param a    힙이 들어있는 배열
     * @param from 힙의 처음 요소의 첨자
     * @param to   힙의 마지막 요소의 첨자
     */
    private static <E extends Comparable<E>> void downHeap(E[] a, int from, int to) {
        // 내려보낼 요소의 값을 value에 저장해둔다.
        E value = a[from];

        // 루트에서 시작하여 노드 i가 자식을 가지고 있는 한 반복 한다.
        int i = from;
        while (i <= to / 2) {
            // 노드 i의 자식 중 작은 쪽을 노드 j로 한다.
            int j = i * 2;
            if (j + 1 <= to && a[j].compareTo(a[j + 1]) > 0) {
                j++;
            }

            // 만약 부모가 자식보다 크지 않다는 관계가 성립하면
            // 이 이상 내려보낼 필요가 없다.
            if (value.compareTo(a[j]) <= 0) {
                break;
            }

            // 노드 i에 노드 j의 값을 넣고, 다음은 노드 j를 처리하도록 한다.
            a[i] = a[j];
            i = j;
        }

        // 원래 처음 요소를 노드 i에 넣는다.
        a[i] = value;
    }

    /**
     * 힙소트를 이용하여 배열을 정렬한다.
     * 지정된 배열 a에서 a[1]부터 a[n] 까지 내림차순으로 정렬한다.
     *
     * @param a 정렬할 배열
     */
    static <E extends Comparable<E>> void sort(E[] a) {
        int n = a.length - 1;

        for (int i = n / 2; i >= 1; i--) {
            downHeap(a, i, n);
        }

        for (int i = n; i >= 2; i--) {
            E temp = a[1];
            a[1] = a[i];
            a[i] = temp;
            downHeap(a, 1, i - 1);
        }
    }
}
