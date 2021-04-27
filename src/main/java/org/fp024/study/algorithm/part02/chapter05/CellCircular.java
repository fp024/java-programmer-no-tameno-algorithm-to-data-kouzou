package org.fp024.study.algorithm.part02.chapter05;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 순환 리스트의 셀
 */
@Getter
@Setter
@ToString(exclude = "next")
class CellCircular<T extends Comparable<T>> {
    private CellCircular<T> next;
    private T value;

    CellCircular(T aValue) {
        next = null;
        value = aValue;
    }
}
