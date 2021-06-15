package org.fp024.study.algorithm.part04.chapter15;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 연결 리스트의 셀
 *
 * @param <E> 저장할 데이터 타입
 *
 * (참고) 양방향 연결리스트는 아니여서,
 */
@EqualsAndHashCode
@ToString
public class Cell<E extends Comparable<E>> {
    Cell<E> next;       // 다음 셀로의 링크
    E data;             // 이 셀의 데이터

    /**
     * 셀을 생성한다.
     */
    Cell(E data) {
        this.next = null;
        this.data = data;
    }
}
