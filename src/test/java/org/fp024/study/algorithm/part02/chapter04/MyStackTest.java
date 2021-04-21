package org.fp024.study.algorithm.part02.chapter04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MyStack 테스트
 * 90쪽의 main 메서드 내용을 JUnit 테스트 코드로 변경
 */
@Slf4j
class MyStackTest {
    @Test
    void testMyStack() {
        MyStack myStack = new MyStack();

        myStack.push("a");
        myStack.push("b");
        myStack.push("c");

        assertEquals("MyStack=[a,b,c]", myStack.toString());
        assertEquals("c", myStack.pop());

        myStack.push("d");
        myStack.push("e");
        myStack.push("f");

        assertEquals("MyStack=[a,b,d,e,f]", myStack.toString());

        while (!myStack.isEmpty()) {
            logger.info("pop: {}", myStack.pop());
        }

        assertEquals("MyStack=[]", myStack.toString());
    }
}