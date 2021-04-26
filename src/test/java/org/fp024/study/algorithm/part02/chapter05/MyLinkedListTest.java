package org.fp024.study.algorithm.part02.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MyLinkedListTest {
    @Test
    void test() {
        MyLinkedList<Integer> myList = new MyLinkedList<Integer>();

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



}