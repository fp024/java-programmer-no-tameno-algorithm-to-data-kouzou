package org.fp024.study.algorithm.part02.chapter05;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 순환 리스트의 셀
 */
@Getter
@Setter
@ToString(exclude = "next") // (참고) 마지막 요소가 처음을 다시바라보게되서, next를 제외처리하지 않으면
                            // ToString()이 무한 재귀 호출되어 StackOverflow 예외가 발생한다.
class CellCircular<T extends Comparable<T>> {
    private CellCircular<T> next;
    private T value;

    CellCircular(T aValue) {
        next = null;
        value = aValue;
    }
}
