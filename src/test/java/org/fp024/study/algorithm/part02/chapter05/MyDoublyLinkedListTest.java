package org.fp024.study.algorithm.part02.chapter05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 이중 연결 리스트 테스트
 */
class MyDoublyLinkedListTest {
    private MyDoublyLinkedList<String> myList;

    @BeforeEach
    void beforeEach() {
        myList = new MyDoublyLinkedList<>();

    }

    /**
     * 저자님은 삭제할 때 반복변수가 짝수일 때(0포함)는 first,
     * 홀수일 때는 last 삭제를 하면서 sysout 하는 처리를 하셨는데,
     * 여기선 동작의 결과를 검증하므로.. 검증코드를 명시했다.
     */
    @Test
    void testInsertToString() {
        // 빈 리스트
        assertEquals("[]", myList.toString());

        myList.insertFirst("a");
        assertEquals("[a ]", myList.toString());

        myList.insertLast("b");
        assertEquals("[a b ]", myList.toString());

        myList.insertFirst("c");
        assertEquals("[c a b ]", myList.toString());

        myList.insertFirst("d");
        assertEquals("[d c a b ]", myList.toString());

        myList.insertLast("e");


        assertEquals("[d c a b e ]", myList.toString());
        assertEquals("d", myList.removeFirst());


        assertEquals("[c a b e ]", myList.toString());
        assertEquals("e", myList.removeLast());


        assertEquals("[c a b ]", myList.toString());
        assertEquals("c", myList.removeFirst());


        assertEquals("[a b ]", myList.toString());
        assertEquals("b", myList.removeLast());


        assertEquals("[a ]", myList.toString());
        assertEquals("a", myList.removeFirst());


        assertEquals("[]", myList.toString());
        assertTrue(myList.isEmpty());
    }
}