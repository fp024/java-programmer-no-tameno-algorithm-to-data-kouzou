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
        for (Cell<Integer> p = header.getNext(); p != null; p = p.getNext()) {
            logger.info(p.toString());
            last = p;
        }
        assertEquals(d, last);
    }

    /**
     * 요소의 삭제
     * 변수 x가 가리키고 있는 셀의 바로 다음 요소를 삭제한다.
     * x -> y -> z
     */
    @Test
    void testRemoveCell() {
        Cell<String> header = new Cell<>(null);

        Cell<String> x = new Cell<>("x");
        header.setNext(x);

        Cell<String> y = new Cell<>("y");
        x.setNext(y);

        Cell<String> z = new Cell<>("z");
        y.setNext(z);

        // x 다음 y를 제거  ==>  header -> x -> z
        assertEquals("y", removeNext(x));

        // z 다음을 제거 시도, 다음이 없기 때문에 예외..
        assertThrows(IllegalArgumentException.class, () -> removeNext(z));

        // x로 부터 시작하는 연결리스트만 끊겼을 뿐, y의 참조는 그대로 남아있음
        // y: Cell(next=Cell(next=null, data=z), data=y)
        logger.info("y: {}", y);


        // 처음요소 삭제...  List 5.5에 해당.
        //   header -> x -> z  에서  x를 삭제
        assertEquals("x", removeNext(header));
        logger.info("header: {}", header);

        //   header -> z  에서  z를 삭제
        assertEquals("z", removeNext(header));

        // 연결리스트가 빈 상황에서 삭제시도 하여 오류
        assertThrows(IllegalArgumentException.class, () -> removeNext(header));

        // 저자님이 부분 코드만 주셔서, 상상해서 상황 코드를 만들었음.
    }


    <T extends Comparable<T>> T removeNext(Cell<T> current) {
        Cell<T> p = current.getNext();

        if (p == null) {
            throw new IllegalArgumentException("다음 셀이 없기 때문에 삭제 할 수 없음");
        }

        current.setNext(p.getNext());
        return p.getData(); // 삭제된 셀의 데이터를 변수 data 에 보관
    }

}


