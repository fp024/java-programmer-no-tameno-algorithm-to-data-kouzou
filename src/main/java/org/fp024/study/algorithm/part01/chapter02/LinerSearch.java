package org.fp024.study.algorithm.part01.chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LinerSearch<T> {
    /**
     * 테이블의 엔트리
     */
    class Entry {
        // 비교 대상이 되는 키
        final int key;
        // 그 외의 정보
        final T data;

        /**
         * 엔트리 생성
         *
         * @param key  키
         * @param data key에 대응하는 데이터
         */
        Entry(int key, T data) {
            this.key = key;
            this.data = data;
        }
    }

    // 데이터의 최대 개수
    final static int MAX = 100;

    // 데이터를 저장할 배열
    final List<Entry> table = new ArrayList<>(MAX);

    /**
     * 데이터를 등록한다
     *
     * @param key  키
     * @param data key에 대응하는 데이터
     */
    public void add(int key, T data) {
        if (table.size() >= MAX) {
            logger.error("데이터의 개수가 너무 많습니다.");
            // 상태코드 1은 이상 종료를 의미
            System.exit(1); // 이부분이 JUnit 에서 잘될려나?
        }
        table.add(new Entry(key, data));
    }

    /**
     * key에 대응하는 데이터를 찾는다.
     */
    public T search(int key) {
        int i;

        i = 0;                          // (1)                  O(1)
        while (i < table.size()) {                 // (2)       O(n)
            if (table.get(i).key == key) {   // (3)             O(n)
                return table.get(i).data;   // (4) 발견했다      O(1)
            }
            i++;                        // (5)                  O(n)
        }
        return null;                    // (6) 발견하지 못함      O(1)
    }

    public int size() {
        return table.size();
    }
}
