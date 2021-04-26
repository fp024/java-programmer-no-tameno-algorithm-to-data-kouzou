package org.fp024.study.algorithm.part02.chapter05;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 연결 리스트
 * 항상 요소(정수)가 오름차순이 되도록 한다.
 * <p>
 * 처음에 그냥 Cell<T>를 쓰고, 외곽의 MyLinkedList 에도 Generic 을 사용하려했는데,
 * 저자님 구현 코드를 보니, insert 할 때, 입력되는 정수에 대한 대소 비교를 해서 오름 차순 정렬이 되는 식으로
 * 처리를 하고있다.  일단은 Cell의 T 제네릭 파라미터가 Comparable 을 구현하도록해보자.
 * (그런데 문제는 있는 거 같음... 관계된 클래스에 줄줄이 제네릭 파라미터를 선언하게됨)
 */
class MyLinkedList<T extends Comparable<T>> {
    // 리스트의 헤드로의 링크
    private final Cell<T> header;

    /**
     * 연결 리스트를 생성한다.
     * 생성된 연결리스트는 비어있다.
     * <p>
     * 저자님은 제네릭을 사용할 수 없는 환경이였고,
     * Cell 에 Object로서 아무것이나 넣을수 있는 상태이고, header 에다 "**List Head**" 란 문자열을 넣으셨는데,
     * 나는 이미 제네릭을 사용하므로 null을 넣어야겠다.
     */
    public MyLinkedList() {
        this.header = new Cell<>(null); // 리스트의 헤드를 작성한다.
    }

    /**
     * 연결 리스트에 요소 num을 삽입한다.
     * 요소는 연결리스트가 오름차순이 되는 장소에 삽입된다.
     *
     * @param num 삽입할 요소 (비교가능한 타입)
     */
    public void insert(T num) {
        // 삽입할 장소를 찾는다.
        Cell<T> p = header.getNext();
        Cell<T> q = header;

        while (p != null && num.compareTo(p.getData()) > 0) {
            q = p;
            p = p.getNext();
        }

        // 셀을 삽입한다.
        Cell<T> newCell = new Cell<>(num);
        newCell.setNext(p);
        q.setNext(newCell);
    }

    /**
     * iterator를 얻는다
     *
     * @return 이 연결리스트에 대한 iterator
     */
    public MyLinkedListIterator iterator() {
        return new MyLinkedListIterator(this);
    }


    /**
     * 연결리스트의 내용을 문자열로 반환
     *
     * @return 연결 리스트의 내용
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (Cell<T> p = header.getNext(); p != null; p = p.getNext()) {
            s.append(p.getData()).append(" ");
        }
        s.append("]");
        return s.toString();
    }

    /**
     * MyLinkedList의 Iterator 구현
     */
    class MyLinkedListIterator implements Iterator<T> {
        // 현재 셀
        private Cell<T> p;

        /**
         * 이터레이터를 생성한다.
         *
         * @param list 이터레이터의 대상이 되는 MyLinkedList 객체
         */
        public MyLinkedListIterator(MyLinkedList<T> list) {
            // 현재 셀을 리스트의 더미 셀로 설정함
            p = list.header;
        }

        /**
         * 다음 요소가 있다면 true를 반환한다.
         *
         * @return 다음 요소가 있다면 true, 없다면 false
         */
        @Override
        public boolean hasNext() {
            return p.getNext() != null;
        }

        /**
         * 다음 요소를 반환한다.
         *
         * @return 다음 요소의 값
         */
        @Override
        public T next() {
            // 다음 요소가 존재하지 않는 다면 예외 NoSuchElementException 을 던진다.
            if (p.getNext() == null) {
                throw new NoSuchElementException();
            }

            p = p.getNext();
            return p.getData();
        }

        /**
         * 바로 전에 next가 반환한 요소를 삭제한다.
         * 
         * Iterator 인터페이스에 default 메서드로서 remove() 가 있는데, 거기서도 UnsupportedOperationException 예외를 던진다
         * 반드시 구현할 필요는 없는 메서드.
         */
        @Override
        public void remove() {
            // 이 메서드는 구현하지 않았음.
            throw new UnsupportedOperationException();
        }
    }
}