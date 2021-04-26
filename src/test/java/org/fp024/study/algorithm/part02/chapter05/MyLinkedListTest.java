package org.fp024.study.algorithm.part02.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MyLinkedListTest {
    @Test
    void testMyLinkedList() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.insert(5);
        assertEquals("[5 ]", myList.toString());
        myList.insert(7);
        assertEquals("[5 7 ]", myList.toString());
        myList.insert(2);
        assertEquals("[2 5 7 ]", myList.toString());
        myList.insert(12);
        assertEquals("[2 5 7 12 ]", myList.toString());
        myList.insert(4);
        assertEquals("[2 4 5 7 12 ]", myList.toString());
    }

    @Test
    void testMyLinkedListIterator() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.insert(20);
        myList.insert(15);
        myList.insert(18);
        myList.insert(37);
        myList.insert(3);
        assertEquals("[3 15 18 20 37 ]", myList.toString());

        Iterator<Integer> iterator = myList.iterator();

        int count = 1;
        while (iterator.hasNext()) {
            logger.info("{}번째 요소: {}", count++, iterator.next());
        }
    }
}