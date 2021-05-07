package org.fp024.study.algorithm.part03.chapter08;

/**
 * 체인화를 이용한 해시 테이블
 */
class HashChaining {
    /**
     * 연결 리스트의 셀
     */
    private class Cell {
        // 키
        MyKey key;
        // 데이터
        Object data;

        // 다음 셀
        Cell next;

        /**
         * 셀을 생성한다.
         *
         * @param aKey  키
         * @param aData 데이터
         */
        private Cell(MyKey aKey, Object aData) {
            this.key = aKey;
            this.data = aData;
        }
    }

    // 해시 표
    Cell[] table;

    // 버킷의 개수
    int bucketSize;

    // 등록되어 있는 데이터의 개수
    int nElements;

    // 해시 표의 크기 (기본 값)
    static final int DEFAULT_BUCKET_SIZE = 50;

    /**
     * 해시표를 생성한다. (크기는 DEFAULT_BUCKET_SIZE)
     */
    public HashChaining() {
        this(DEFAULT_BUCKET_SIZE);
    }

    /**
     * 해시표를 생성한다.
     *
     * @param bucketSize 해시 표의 크기
     */
    public HashChaining(int bucketSize) {
        // 해시 표의 역할을 하는 배열을 할당
        this.table = new Cell[bucketSize];

        // 해시 표의 버킷 개수를 기록해둔다.
        this.bucketSize = bucketSize;

        // 요소의 개수를 0으로 해둔다
        this.nElements = 0;
    }


    /**
     * 해시 함수
     * 키가 되는 객체의 hashCode 메서드가 반환한 값을
     * 버킷의 개수로 나눈 나머지를 반환
     */
    private int hash(MyKey key) {
        return key.hashCode() % bucketSize;
    }

    /**
     * 해시 표를 탐색한다.
     *
     * @param key 탐색할 키
     * @return 키가 발견되면 그것을 반환
     * 발견되지 않았으면 null을 반환
     */
    public Object find(MyKey key) {
        for (Cell p = table[hash(key)]; p != null; p = p.next) {
            if (key.equals(p.key)) {
                return p.data;
            }
        }
        return null;
    }

    /**
     * 해시 표에 데이터를 삽입한다
     *
     * @param key  키
     * @param data 등록할 데이터
     * @return 등록에 성공하면 true,
     * 실패하면(이미 키 값이 같은 데이터가 있으면) false 반환
     */
    public boolean insert(MyKey key, Object data) {
        if (find(key) != null) {
            return false;
        }

        Cell p = new Cell(key, data);
        int h = hash(key);

        // 새로운 값을 연결리스트에 앞쪽에 추가해나감.
        p.next = table[h];
        table[h] = p;

        // 요소의 개수를 1증가
        nElements++;
        return true;
    }


    /**
     * 해시 표에서 데이터를 삭제한다.
     *
     * @param key 삭제할 데이터의 키
     * @return 삭제에 성공하면 true, 데이터를 찾지 못하면 false를 반환
     */
    public boolean delete(MyKey key) {
        int hash = hash(key);

        // 버킷이 비어있는가?
        if (table[hash] == null) {
            return false;
        }

        // 리스트의 선두 셀이 삭제할 데이터인가?
        if (table[hash].key.equals(key)) {
            Cell firstCell = table[hash];
            table[hash] = firstCell.next;
            nElements--;    // 요소의 개수를 1 감소
            return true;
        }

        // 첫번 째 셀부터 진행.
        Cell current;
        Cell next;
        // 리스트의 두 번째 셀 이후부터 순서대로 체크한다.
        for (current = table[hash], next = current.next; next != null; current = next, next = next.next) {
            // 첫번 째 셀부터 진행하지만 next와 비교하는 이유는, 첫 번째는 직전 if문에서 삭제 대상인지 검사를 했다.
            if (key.equals(next.key)) {
                current.next = next.next;
                nElements--;
                return true;
            }
        }
        return false;
    }

    /**
     * 해시 표의 내용을 문자열로 반환
     *
     * @return 해시 표의 내용
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            s.append("버킷").append(i).append(":");
            for (Cell p = table[i]; p != null; p = p.next) {
                s.append("[").append(p.key).append(":").append(p.data).append("] ");
            }
            s.append("\n");
        }
        s.append("요소의 개수:").append(nElements).append("\n");
        return s.toString();
    }
}