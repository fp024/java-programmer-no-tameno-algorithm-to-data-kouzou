package org.fp024.study.algorithm.part01.chapter02;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public BinarySearch() {
    }

    public BinarySearch(List<Entry> entries) {
        this.n = entries.size();
        for (int i = 0; i < entries.size(); i++) {
            table[i] = entries.get(i);
        }
    }

    static class Entry {
        // 비교대상이 되는 키
        int key;
        // 그외의 정보
        Object data;

        /**
         * 요소를 생성한다.
         *
         * @param key  키
         * @param data key에 대응하는 데이터
         */
        public Entry(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    // 데이터의 최대 개수
    private final static int MAX = 100;

    // 데이터를 저장할 배열
    private final Entry[] table = new Entry[MAX];

    // table에 등록되어있는 데이터의 개수
    private int n = 0;


    public Object search(int key) {
        int low, high, middle;

        low = 0;                // (1)      O(1)
        high = n - 1;           // (2)      O(1)

        while (low <= high) {                          // (3)      O(log n)
            middle = (low + high) / 2;                 // (4)        ""
            if (key == table[middle].key) {            // (5)        ""
                return table[middle].data;             // (6) 찾음    ""
            } else if (key < table[middle].key) {      // (7)        ""
                high = middle - 1;                     // (8)        ""
            } else { // key > table[middle].key 임.                  ""
                low = middle + 1;                      // (9)        ""
            }
        }
        return null;                                   // (10) 찾지 못함.    O(1)
    }

    public int getSize () {
        return n;
    }


    // TODO 이진 탐색시 데이터 등록
    public void add(int key, Object data) {
        int pos;

        // pos = 데이터를 삽입할 위치;   // (1)         O(log n)

        // 배열에서 pos보다 뒤에 있는 요소들을 모두 1씩 민다   // (2)  O(n)

        // table[pos] =new Entry(key, data);        // (3)  O(1)

        // 위의 내용을 다 더하면 O(n)

    }



}
