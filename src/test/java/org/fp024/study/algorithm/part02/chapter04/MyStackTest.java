package org.fp024.study.algorithm.part02.chapter04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MyStack 테스트
 * 90쪽의 main 메서드 내용을 JUnit 테스트 코드로 변경
 */
@Slf4j
class MyStackTest {
    @Test
    void testMyStack() {
        MyStack<String> myStack = new MyStack<>();

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

        new ArrayList<String>();

        assertEquals("MyStack=[]", myStack.toString());
    }


    @Test
    void testClear() {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals("MyStack=[1,2,3]", myStack.toString());

        myStack.clear();
        assertEquals("MyStack=[]", myStack.toString());
    }

    /**
     * clear()를 하더라도 내부 Object[]에는 그대로 요소가 있기 때문에 null로 끊어줄 필요가 있긴하다.
     */
    @Test
    void testNullClear() {
        MyStack<String> myStack = new MyStack<>();

        myStack.push("a");
        myStack.push("b");
        myStack.push("c");

        myStack.nullClear();

        assertEquals("MyStack=[]", myStack.toString());
    }

}