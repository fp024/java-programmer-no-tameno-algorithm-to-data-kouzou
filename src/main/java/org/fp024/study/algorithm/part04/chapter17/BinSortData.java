package org.fp024.study.algorithm.part04.chapter17;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 빈 소트와 분포수세기 소트에서 사용하는 데이터 형
 */
@EqualsAndHashCode
class BinSortData {
    // 키는 0부터 M 까지의 정수
    static final int M = 100;

    @Getter
    private final int key; // 정렬키, 0부터 M까지의 범위내에 있어야한다.

    @Getter
    private final Object data; // 그외의 정보

    /**
     * 정렬할 데이터를 생성한다.
     */
    BinSortData(int key, Object data) {
        // 키가 범위 내에 있는 지 체크한다.
        if (key < 0 || key > M) {
            throw new IllegalArgumentException("키" + key + "가 지정된 범위 밖에 있다.");
        }
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("key=%s, data=%s", key, data);
    }
}
