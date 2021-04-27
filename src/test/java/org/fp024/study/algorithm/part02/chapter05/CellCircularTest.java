package org.fp024.study.algorithm.part02.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 순환리스트 조작 테스트
 *
 * 리스트의 헤드를 사용하는 순환리스트
 */
@Slf4j
class CellCircularTest {
    private CellCircular<Integer> head;

    /**
     * 순환 리스트의 초기화 (리스트의 헤드를 이용)
     */
    <T extends Comparable<T>> CellCircular<T> createHead() {
        CellCircular<T> head = new CellCircular<>(null);
        head.setNext(head);
        return head;
    }

    /**
     * 순환 리스트의 방문 (리스트의 헤드를 이용)
     */
    <T extends Comparable<T>> void printCircular(CellCircular<T> circularHead) {
        for (CellCircular<T> p = circularHead.getNext(); p != circularHead; p = p.getNext()) {
            logger.info(p.toString());
        }
    }

    @BeforeEach
    void beforeEach() {
        head = createHead();
        head.setNext(new CellCircular<>(1));
        head.getNext().setNext(new CellCircular<>(5));
        head.getNext().getNext().setNext(new CellCircular<>(83));
        head.getNext().getNext().getNext().setNext(new CellCircular<>(-2));

        // 마지막 셀의 next를 head로 설정
        head.getNext().getNext().getNext().getNext().setNext(head);
    }

    @Test
    void testVisitCircularList() {
        printCircular(head);
    }


}