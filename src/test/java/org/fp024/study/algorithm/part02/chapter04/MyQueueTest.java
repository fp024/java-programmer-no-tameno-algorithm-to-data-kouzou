package org.fp024.study.algorithm.part02.chapter04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MyQueue 테스트
 */
class MyQueueTest {
    @Test
    void testQueue() {
        MyQueue<String> queue = new MyQueue<>(5);

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        assertEquals("MyQueue=[a b c ] front=0 rear=3", queue.toString());

        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());

        assertEquals("MyQueue=[c ] front=2 rear=3", queue.toString());

        queue.enqueue("d");
        queue.enqueue("e");

        assertEquals("MyQueue=[c d e ] front=2 rear=0", queue.toString());

        queue.enqueue("f");   // f 2, r 1
        assertEquals("c", queue.dequeue());
        assertEquals("d", queue.dequeue());

        assertEquals("MyQueue=[e f ] front=4 rear=1", queue.toString());

        queue.clear();
        assertEquals("MyQueue=[] front=0 rear=0", queue.toString());

        queue.enqueue("g");
        queue.enqueue("h");

        assertEquals("MyQueue=[g h ] front=0 rear=2", queue.toString());
    }

    @Test
    void testQueueOverflow() {
        MyQueue<String> queue = new MyQueue<>(5);

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("e");

        // queue의 마지막 한칸은 비워둔다고 하여, 큐 사이즈를 5로 설정했을 때, Queue에 넣을 수 있는 최대 데이터는 4개
        assertThrows(IllegalStateException.class, () -> queue.enqueue("f"));

    }

    @Test
    void testQueueEmpty() {
        MyQueue<String> queue = new MyQueue<>();
        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);
    }

}