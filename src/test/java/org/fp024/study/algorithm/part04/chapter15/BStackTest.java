/**
 * Deque 를 사용한 스택 구현 관련해서 질문글이 있어 테스트 진행해 봄.
 */
package org.fp024.study.algorithm.part04.chapter15;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 스택 인터페이스
 */
interface BStack<E> {
    boolean push(E item);
    E pop();
}

/**
 * 스택 구현
 */
class DStack<E> implements BStack<E> {
    private Deque<E> deq;

    public DStack(Deque<E> deq) {
        this.deq = deq;
    }

    @Override
    public E pop() {
        return deq.pollFirst();
    }

    @Override
    public boolean push(E item) {
        return deq.offerFirst(item);
    }
}

/**
 * 테스트
 */
class BStackTest {
    @Test
    void test() {
        DStack<String> dStack = new DStack<>(new ArrayDeque<>());

        // 스택에 "1" ~ "5" 값 쌓기
        assertTrue(dStack.push("1"));
        assertTrue(dStack.push("2"));
        assertTrue(dStack.push("3"));
        assertTrue(dStack.push("4"));
        assertTrue(dStack.push("5"));

        // 스택에서 값 꺼내기
        assertEquals("5", dStack.pop());
        assertEquals("4", dStack.pop());
        assertEquals("3", dStack.pop());
        assertEquals("2", dStack.pop());
        assertEquals("1", dStack.pop());

        assertNull(dStack.pop(), "스택이 비어있는 상태에선 null 반환");
    }
}

