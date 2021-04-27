package org.fp024.study.algorithm.part02.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * List 5.8, 5.9에서의 저자님이 말하고자 하는 의도 확인
 * 
 * 순환 리스트에서 head를 사용하지 않고 ptr이라는 참조가 순환 리스트의 처음을 참조한다.
 */
@Slf4j
class PureCellCircularTest {
    private CellCircular<Integer> ptr;

    @BeforeEach
    void beforeEach() {
        ptr = new CellCircular<>(1);
        ptr.setNext(new CellCircular<>(5));
        ptr.getNext().setNext(new CellCircular<>(83));
        ptr.getNext().getNext().setNext(new CellCircular<>(-2));

        // 마지막 셀이 ptr 참조로 설정
        ptr.getNext().getNext().getNext().setNext(ptr);
    }

    /**
     * 5.8 순환 리스트 방문
     */
    @Test
    void testVisitCircularList() {
        CellCircular<Integer> p = ptr;
        do {
            logger.info("{}", p.getValue());
            p = p.getNext();
        } while (p != ptr);
    }
}
