package org.fp024.study.algorithm.part02.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MyStack2Test {
    @Test
    void testMyStack2() {
        MyStack2<String> myStack = new MyStack2<>();
        assertTrue(myStack.isEmpty());

        myStack.push("a");
        assertEquals("요소의 수=1 [a ]", myStack.toString());

        myStack.push("b");
        assertEquals("요소의 수=2 [a b ]", myStack.toString());

        myStack.push("c");
        assertEquals("요소의 수=3 [a b c ]", myStack.toString());

        assertEquals("c" , myStack.pop());
        assertEquals("요소의 수=2 [a b ]", myStack.toString());

        myStack.push("d");
        assertEquals("요소의 수=3 [a b d ]", myStack.toString());

        myStack.push("e");
        assertEquals("요소의 수=4 [a b d e ]", myStack.toString());

        myStack.push("f");
        assertEquals("요소의 수=5 [a b d e f ]", myStack.toString());

        assertEquals("f" , myStack.pop());

        while(!myStack.isEmpty()) {
            logger.info("{}을 꺼냄", myStack.pop());
            logger.info(myStack.toString());
        }

        assertTrue(myStack.isEmpty());
    }
}