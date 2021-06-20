package org.fp024.study.algorithm.part04.chapter17;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 기수 소트에 사용할 데이터 형
 */
@EqualsAndHashCode
class RadixSortData {
    final static int KEY_MAX = 0xffff; // 키 최대 값

    @Getter
    private final int key; // 정렬 키, 0 ~ 65535 (0xffff) 범위 내에 있어야한다.

    @Getter
    private final Object data; // 그외의 정보

    /**
     * 정렬할 데이터를 생성한다.
     *
     * @param key  키
     * @param data 그외의 정보
     */
    RadixSortData(int key, Object data) {
        // 키가 범위 내에 있는 지 체크 한다.
        if (key < 0 || key > KEY_MAX) {
            throw new IllegalArgumentException("키" + key + "가 지정된 범위 밖에 있다.");
        }
        this.key = key;
        this.data = data;
    }
}
