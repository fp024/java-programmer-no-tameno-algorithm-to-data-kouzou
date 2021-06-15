package org.fp024.study.algorithm.part04.chapter15;

/**
 * 연결 리스트 버전 머지 소트
 * <p>
 * 동작을 확인하기 위한 목적이니 저자님 처럼 반드시 모든 메서드들을 static 으로 할 필요는 없을 것 같다.
 */
class MergeSortList<E extends Comparable<E>> {
    /**
     * 2개의 연결리스트 a와 b를 머지한다.
     * 머지된 연결 리스트의 선두 요소로의 링크를 반환
     */
    private Cell mergeList(Cell<E> a, Cell<E> b) {
        // 변수 head는 머지 완료된 연결리스트의 처음 요소(더미 셀)를 가리킨다. // 이전 예제의 workingArray 배열에 해당.
        Cell<E> head = new Cell<>(null);

        // 변수 p는 머지 완료 연결리스트의 마지막 요소를 가리킨다.
        Cell<E> p = head;

        // 연결리스트 a, b 중 어느 한 쪽이 비게 될 때 까지 반복한다.
        while (a != null && b != null) {
            // 연결 리스트 a와 b의 처음 요소를 비교 한다.
            if (a.data.compareTo(b.data) <= 0) {  // a.data <= b.data
                // 연결 리스트 a의 처음요소를 제거하여
                // 머지 완료 연결 리스트의 마지막에 연결한다.
                p.next = a;
                p = a;
                a = a.next;
            } else {
                // 연결 리스트의 b의 처음 요소를 제거하여
                // 머지 완료 연결 리스트의 마지막에 연결한다.
                p.next = b;
                p = b;
                b = b.next;
            }
        }

        // 남아 있는 요소를 머지로 연결리스트의 마지막에 연결한다.
        if (a == null) {
            p.next = b;
        } else {
            p.next = a;
        }

        // 머지 완료 연결 리스트의 처음을 반환. (단 더미를 제외하고 데이터의 처음)
        return head.next;
    }


    /**
     * 연결 리스트 버전 머지 소트
     * 연결 리스트 x를 정렬한다.
     *
     * @param x 정렬할 연결리스트 (구현상 더미가 제외하고 처음요소가 들어오길 기대한다.)
     * @return 정렬된 연결리스트의 처음 요소로의 링크를 반환
     */
    Cell<E> mergeSortList(Cell<E> x) {
        // 연결 리스트의 요소가 없거나 하나 밖에 없을 때는
        // 그대로 돌아간다.
        if (x == null || x.next == null) {
            return x;
        }

        // 연결 리스트를 스캔할 변수를 초기화한다.

        // a는 첫 번째 요소를 가리킨다.
        Cell<E> a = x;

        // b는 세번째 요소 (만약 연결 리스트의 길이가 2일 때는 두번째 요소)를 가리킨다.
        Cell<E> b = x.next;
        if (b != null) {
            b = b.next;
        }

        // 변수 b가 연결리스트의 마지막에 도달할 때까지 변수 a를 1씩 이동
        // 변수 b를 2씩 이동시킨다. 변수 b가 마지막에 도달 했을 때, 변수 a는
        // 연결 리스트의 거의 정 중앙 요소를 가리키고 있을 것임.
        // (한번의 반복으로 중간 위치를 찾으려고 이렇게하신 것 같다.)
        while (b != null) {
            a = a.next;
            b = b.next;
            if (b != null) {
                b = b.next;
            }
        }

        // 연결 리스트를 변수 a가 가리키는 요소의 바로 다음에서 둘로 분할 한다.
        Cell<E> p = a.next;      // 뒷쪽 연결리스트의 처음
        a.next = null;           // 앞쪽 연결리스트의 끝 설정

        // 분할할 연결 리스트를 각각 개별적으로 정렬하여, 그 결과를 머지한다.
        return mergeList(mergeSortList(x), mergeSortList(p));
    }
}
