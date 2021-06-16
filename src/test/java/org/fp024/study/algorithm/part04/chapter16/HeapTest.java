package org.fp024.study.algorithm.part04.chapter16;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 힙 클래스 테스트
 */
@Slf4j
class HeapTest {
    private final Heap<Integer> heap = new Heap<>(15);

    /**
     * Fig. 16.5 에 나타난 데이터로 넣어보자
     *                5
     *             /    \
     *           9      15
     *         /   \    /   \
     *       12   13   21   18
     *      / \   /
     *    17  25 20
     */
    @Test
    void testInsertAndDelete() {
        heap.insert(5);
        heap.insert(9);
        heap.insert(15);
        heap.insert(12);

        heap.insert(13);
        heap.insert(21);
        heap.insert(18);
        heap.insert(17);

        heap.insert(25);
        heap.insert(20);

        logger.info("{}", heap);

        assertEquals(5, heap.deleteMin());
        assertEquals(9, heap.deleteMin());
        assertEquals(12, heap.deleteMin());
        assertEquals(13, heap.deleteMin());
        assertEquals(15, heap.deleteMin());
        assertEquals(17, heap.deleteMin());
        assertEquals(18, heap.deleteMin());
        assertEquals(20, heap.deleteMin());
        assertEquals(21, heap.deleteMin());
        assertEquals(25, heap.deleteMin());

    }
}