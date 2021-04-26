package org.fp024.study.algorithm.part02.chapter05;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 연결 리스트의 셀
 */
@Getter
@Setter
@ToString
class Cell<T extends Comparable<T>> {
    private Cell<T> next;
    private T data;

    Cell(T aData) {
        next = null;
        data = aData;
    }
}
