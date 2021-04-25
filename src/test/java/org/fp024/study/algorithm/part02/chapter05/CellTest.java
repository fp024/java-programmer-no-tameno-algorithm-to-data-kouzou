package org.fp024.study.algorithm.part02.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CellTest {
    /**
     * List 5.2의 코드가 중간에 삽입하는 것에 대해, 완전한 코드로 설명을 하진 않아서
     * y라는 셀을 추가해보자.
     */
    @Test
    void testIntermediateInsertion() {
        // x -> y 환경에서 중간에 p를 넣어보자
        // x -> p -> y
        Cell<String> x = new Cell<>("x");
        Cell<String> y = new Cell<>("y");
        x.setNext(y);

        assertNull(x.getNext().getNext());
        assertEquals("y", x.getNext().getData());

        // p요소를 연결리스트 중간에 삽입
        Cell<String> p = new Cell<>("p");
        p.setNext(x.getNext());
        x.setNext(p);


        assertNotNull(x.getNext().getNext());
        assertEquals("p", x.getNext().getData());
        assertEquals("y", x.getNext().getNext().getData());
    }


    /**
     * List 5.3 선두 삽입
     * x(header)
     * p -> x
     */
    @Test
    void testHeaderInsertion() {
        Cell<String> header = new Cell<>("x");

        Cell<String> p = new Cell<>("p");
        p.setNext(header);
        // p.next에 기존 header 참조를 넣고 header의 의미를 p가 갖도록 header 변수에 p참조를 할당
        header = p;

        assertEquals("p", header.getData());
        assertEquals("p", p.getData());
        assertEquals("x", header.getNext().getData());
    }


    /**
     * 연결리스트에 Dummy cell을 하나 두고 사용한다면.
     */
    @Test
    void testDummyCell() {
        // 요소가 없는 Dummy cell ...
        Cell<Integer> header = new Cell<>(null);

        // 2 ,5, 12 , -4 를 순서대로 넣어보자
        Cell<Integer> a = new Cell<>(2);
        header.setNext(a);

        Cell<Integer> b = new Cell<>(5);
        a.setNext(b);

        Cell<Integer> c = new Cell<>(12);
        b.setNext(c);

        Cell<Integer> d = new Cell<>(-4);
        c.setNext(d);

        Cell<Integer> last = null;
        // 최초의 요소를 header.next로 취급
        for(Cell<Integer> p = header.getNext(); p != null; p = p.getNext()) {
            logger.info(p.toString());
            last = p;
        }
        assertEquals(d, last);
    }

    /**
     * 요소의 삭제
     *
     */
    @Test
    void testRemoveCell() {

    }


}


