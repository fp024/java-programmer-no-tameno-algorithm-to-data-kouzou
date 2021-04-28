package org.fp024.study.algorithm.part02.chapter05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 이중 연결 리스트의 셀 테스트
 */
class CellDoubleTest {

    @Test
    void testCreateHead() {
        CellDouble<Integer> head = createHead();
        assertEquals(head, head.getNext());
        assertEquals(head, head.getPrev());
    }

    <T> CellDouble<T> createHead() {
        CellDouble<T> head = new CellDouble<>(null);
        head.setNext(head);
        head.setPrev(head);
        return head;
    }

    @Test
    void testInsertNext() {
        CellDouble<Integer> head = createHead();
        assertEquals(head, head.getNext());
        assertEquals(head, head.getPrev());


        CellDouble<Integer> a = new CellDouble<>(1);
        insertNext(head, a);

        CellDouble<Integer> b = new CellDouble<>(2);
        insertNext(a, b);

        CellDouble<Integer> c = new CellDouble<>(3);
        insertNext(b, c);

        assertEquals(head, a.getPrev());
        assertEquals(b, a.getNext());

        assertEquals(a, b.getPrev());
        assertEquals(c, b.getNext());

        assertEquals(b, c.getPrev());

        // 마지막 요소의 next는 head를 참조
        assertEquals(head, c.getNext());
        assertEquals(a, c.getNext().getNext());
    }


    <T> void insertNext(CellDouble<T> position, CellDouble<T> newX) {
        newX.setPrev(position);
        newX.setNext(position.getNext());
        position.getNext().setPrev(newX);
        position.setNext(newX);
    }

    @Test
    void testRemove() {
        CellDouble<Integer> head = createHead();
        assertEquals(head, head.getNext());
        assertEquals(head, head.getPrev());

        // 결과적으로는 아무일도 일어나지 않음
        // 내부적으로는 head 참조의 prev 와 next 에 head를 할당하는 동작 뿐임.
        assertEquals(head, remove(head), "빈리스트를 지움");

        // 데이터가 있는 상태에서 head를 지우면 참조를 할 수 없게 되어버리는데,
        // (head참조만 사용해서 줄줄이 만들었을 경우, 테스트코드에서는 생성한 셀에 대한 개별참조가 있어서 문제는 없었다.)
        // 이때는 삭제할 위치가 head인지 검사하는 검사하는 코드가 필요하다.

        CellDouble<Integer> a = new CellDouble<>(1);
        insertNext(head, a);

        CellDouble<Integer> b = new CellDouble<>(2);
        insertNext(a, b);

        CellDouble<Integer> c = new CellDouble<>(3);
        insertNext(b, c);

        assertEquals(b, remove(b), "a<->b<->c 에서 중간의 b를 지움");

        assertEquals(head, a.getPrev());
        assertEquals(c, a.getNext());

        assertEquals(a, c.getPrev());
        assertEquals(head, c.getNext(), "c의 다음은 head");
    }


    <T> CellDouble<T> remove(CellDouble<T> target) {
        target.getPrev().setNext(target.getNext());
        target.getNext().setPrev(target.getPrev());

        return target;
    }


}