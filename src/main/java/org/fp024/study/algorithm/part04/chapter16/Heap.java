package org.fp024.study.algorithm.part04.chapter16;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 힙
 */
@ToString
class Heap<E extends Comparable<E>> {
    private final List<E> a;        // 힙의 역할을 하는 배열
    private final int maxHeapSize;  // 일반 배열 대신 ArrayList를 사용했기 때문에, 최대 크기를 설정해둘 필요가 있다.
    private int n;                  // 힙에 들어있는 요소의 개수

    /**
     * 힙을 생성한다.
     *
     * @param size 힙에 등록할 수 있는 요소의 최대 개수
     */
    public Heap(int size) {
        this.maxHeapSize = size;
        // 배열 a에서 a[1] ~ a[size+1]을 사용한다.
        // a[0]은 사용하지 않으므로 size+1 개의 요소를 확보할 필요가 있다.

        this.a = initNull(new ArrayList<>(size + 1), size + 1); // 그런데... ArrayList 로 쓸경우 초과시 내부 배열의 크기를 자동 증가 시키긴함.
        this.n = 0;  // int[] 대신 ArrayList 를 써서 a.size()로 해도 될 것 같은데...
    }

    // 배열 처럼 사용하려면 빈 배열처럼 리스트를 채워 넣어야한다.
    private List<E> initNull(List<E> list, int size) {
        IntStream.range(0, size).forEach(i -> list.add(null));
        return list;
    }

    /**
     * 힙의 x번째 요소를 필요한 장소까지 끌어 올린다.
     *
     * @param x 끌어올릴 요소의 첨자
     */
    private void upHeap(int x) {
        // 끌어올릴 요소의 값을 value에 넣어둔다.
        E value = a.get(x);

        // 요소의 루트까지 올라오지 않았으며
        // "부모가 자식보다 크다"라는 조건을 만족할 때까지 반복한다.
        while (x > 1 && a.get(x / 2).compareTo(value) > 0) {
            // 부모 값을 자식으로 옮긴다
            a.set(x, a.get(x / 2));

            // 처리할 노드를 부모로 한다.
            x /= 2;
        }

        // 최종적으로 옮겨져야할 장소가 정해짐
        a.set(x, value);
    }


    /**
     * 힙에 요소를 등록한다.
     *
     * @param element 등록할 요소
     */
    void insert(E element) {
        // 힙에 등록할 수 있는 여유가 있는지 확인한다.
        if (n >= this.maxHeapSize) {
            throw new IllegalStateException("더 이상 힙에 요소를 등록할 수 없습니다.");
        }

        // 일단 힙의 마지막에 넣는다.  list의 add를 해도 될것 같긴한데...
        a.set(++n, element);

        // 추가한 요소를 끌어올린다.
        upHeap(n);
    }


    /**
     * 힙의 처음 요소 a[1]을 필요한 곳 까지 내려 보낸다.
     */
    private void downHeap() {
        // 내려보낼 요소의 값을 value에 저장해둔다.
        E value = a.get(1);

        // 루트에서 시작하여 노드 i가 자식을 가지고 있는 한 반복한다.
        int i = 1;
        while (i <= n / 2) { // TODO:
            // 노도 i의 자식 중 작은 쪽을 노드 j로 한다.
            int j = i * 2;
            if (j + 1 <= n && a.get(j).compareTo(a.get(j + 1)) > 0) {
                j++;
            }

            // 만약 부모가 자식보다 크지 않다는 관계가 성립하면
            // 이 이상 내려보낼 필요가 없다.
            if (value.compareTo(a.get(j)) <= 0) {
                break;
            }

            // 노드 i에 노드 j의 값을 넣고, 다음은 노드 j를 처리하도록 한다.
            a.set(i, a.get(j));
            i = j;
        }

        // 원래 처음 요소의 값을 노드 i에 넣는다.
        a.set(i, value);
    }

    /**
     * 힙에서 가장 작은 요소를 삭제한다.
     * 요소의 값을 반환
     *
     * @return 삭제한 요소의 값
     */
    E deleteMin() {
        // 힙이 비어있는지 확인한다.
        if (n < 1) {
            throw new IllegalStateException("힙이 비어있습니다.");
        }

        // 루트 요소를 리턴 값으로 한다.
        // (힙의 처음 요소가 루트에 해당)
        E value = a.get(1);

        // 힙의 마지막 요소를 제일 처음으로 이동한다.
        a.set(1, a.get(n--));

        // 앞으로 이동한 요소를 적절한 위치까지 내려보낸다.
        downHeap();

        return value;
    }
}
