package org.fp024.study.algorithm.part02.chapter05;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 이중 연결 리스트의 셀
 */
@Getter
@Setter
@ToString(exclude = {"prev", "next"})
class CellDouble<T> {
    private CellDouble<T> prev;
    private CellDouble<T> next;
    private T data;

    public CellDouble(T data) {
        this.data = data;
    }
}
