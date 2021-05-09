package org.fp024.study.algorithm.part03.chapter08;

/**
 * 오픈 어드레스 법을 이용한 해시표
 */
class HashOpenAddress {
    /**
     * 해시 표의 요소 (버킷)
     */
    private static class Bucket {
        // 키
        MyKey key;
        // 키에 대응되는 데이터
        Object data;

        /**
         * 버킷을 생성한다.
         *
         * @param key  키
         * @param data 데이터
         */
        private Bucket(MyKey key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    // 해시 표의 역활을 하는 배열
    private final Bucket[] table;
    // 버킷의 개수
    private final int bucketSize;
    // 등록되어 있는 데이터의 개수
    private int nElements;

    // 삭제가 완료되었다는 것을 나타내는 특별한 키 값
    private static final MyKey DELETED = new MyKey(null);

    // 비어있다는 것을 나타내는 특별한 키 값
    private static final MyKey EMPTY = new MyKey(null);

    // (참고) : DELETED하고, EMPTY과 오버라이드한 equals 관점에서는 동일하지만, == 로 비교시는 다르다,
    //          저자님 이후 코드를 보니, != 로 비교하여 차이를 구분하고 있다.

    // 해시 표의 기본 크기 (소수로 하는 것이 좋다)
    private static final int DEFAULT_BUCKET_SIZE = 53;

    /**
     * 해시 표를 생성한다. (크기는 DEFAULT_BUCKET_SIZE)
     */
    public HashOpenAddress() {
        this(DEFAULT_BUCKET_SIZE);
    }

    /**
     * 해시 표를 생성한다.
     *
     * @param bucketSize 해시 표의 크기
     */
    public HashOpenAddress(int bucketSize) {
        // 해시 표의 역활을 하는 배열을 할당하고 모든 요소의 키를
        // EMPTY로 초기화 시켜둔다.
        this.table = new Bucket[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            table[i] = new Bucket(EMPTY, null);
        }

        // 해시 표의 버킷 개수를 기록해 둔다.
        this.bucketSize = bucketSize;

        // 요소의 개수를 0으로 해둔다.
        this.nElements = 0;
    }


    /**
     * 해시 함수
     * 키로 이용되는 객체의 hashCode 메서드가 반환한 값을
     * 버킷의 개수로 나눈 나머지를 반환
     *
     * @param key 키
     * @return 주어진 키에 대한 해시 값
     */
    private int hash(MyKey key) {
        return key.hashCode() % bucketSize;
    }

    /**
     * 재해싱을 한다
     */
    private int rehash(int hash) {
        return (hash + 1) % bucketSize;
    }

    /**
     * 해시 표를 탐색한다.
     *
     * @param key 찾을 키
     * @return 데이터를 발견하면 그것을 반환
     *         발견하지 못했으면 null을 반환
     */
    public Object find(MyKey key) {
        int count = 0;
        int h = hash(key);

        MyKey k;
        while ((k = table[h].key) != EMPTY) {
            if (k != DELETED && key.equals(k)) {
                return table[h].data;
            }
            if (++count > bucketSize) {
                return null;
            }
            h = rehash(h);
        }
        return null;
    }

    /**
     * 해시 표에 데이터를 삽입한다.
     *
     * @param key  키
     * @param data 등록할 데이터
     * @return 등록에 성공하면 true,
     *         실패하면 (이미 같은 키를 가지는 데이터가 있으면) false를 반환
     * @throws IllegalStateException 해시 표가 가득차서 더이상 등록을 할 수 없을 때, 예외발생
     */
    public boolean insert(MyKey key, Object data) {
        int count = 0;
        int h = hash(key);

        MyKey k;
        while ((k = table[h].key) != EMPTY && k != DELETED) {
            // 이미 등록되어 있는 경우
            if (key.equals(k)) {
                return false;
            }

            // 더 이상 신규 값을 추가할 수 없는 경우
            if (++count > bucketSize) {
                throw new IllegalStateException("더 이상 해시 표에 데이터를 등록할 수 없습니다.");
            }
            h = rehash(h);
        }

        table[h].key = key;
        table[h].data = data;
        nElements++;
        return true;
    }


    /**
     * 해시 표에서 데이터를 삭제한다.
     *
     * @param key 삭제할 데이터의 키
     * @return 삭제에 성공 true, 실패 했다면 false를 반환
     */
    public boolean delete(MyKey key) {
        int count = 0;
        int h = hash(key);

        MyKey k;
        while ((k = table[h].key) != EMPTY) {
            if (k != DELETED && key.equals(k)) {
                table[h].key = DELETED;
                table[h].data = null;
                nElements--;
                return true;
            }


            if (++count > bucketSize) {
                return false;
            }
            h = rehash(h);
        }
        return false;
    }


    /**
     * 해시 표의 내용을 문자열로 반환
     *
     * @return 해시 표의 내용
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            s.append("버킷 ").append(i).append(": ");
            MyKey k = table[i].key;
            if (k == EMPTY) {
                s.append("비어있음\n");
            } else if (k == DELETED) {
                s.append("삭제 되었음\n");
            } else {
                s.append("key=[").append(k).append("] data=[").append(table[i].data).append("]\n");
            }
        }
        // 등록되어 있는 요소의 개수를 추가한다
        s.append("요소의 개수:").append(nElements).append("\n");
        return s.toString();
    }
}