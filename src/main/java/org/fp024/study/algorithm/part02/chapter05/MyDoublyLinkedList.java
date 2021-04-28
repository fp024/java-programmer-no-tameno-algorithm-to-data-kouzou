package org.fp024.study.algorithm.part02.chapter05;

/**
 * 이중 연결 리스트
 */
class MyDoublyLinkedList<T> {
    // 리스트 헤드로의 링크
    private final CellDouble<T> head;

    /**
     * 이중 연결 리스트를 생성한다.
     * 생성된 이중 연결 리스트는 비어있다.
     */
    public MyDoublyLinkedList() {
        // 리스트의 헤더를 할당한다.
        this.head = new CellDouble<>(null);

        // 리스트 헤더의 prev와 next가 자기자신을 가리키도록 한다.
        head.setPrev(head);
        head.setNext(head);
    }


    /**
     * 이중 연결 리스트의 셀 p의 바로 다음에 데이터 data를 삽입한다.
     *
     * @param p    이 셀의 바로 다음에 데이터를 삽입한다.
     * @param data 삽입할 데이터
     */
    private void insertAfter(CellDouble<T> p, T data) {
        CellDouble<T> newCell = new CellDouble<>(data);

        newCell.setPrev(p);
        newCell.setNext(p.getNext());
        p.getNext().setPrev(newCell); // 다음줄보다 이걸 먼저해야한다. 안그럼 원래의 p 다음 참조를 잃어버림
        p.setNext(newCell);
    }


    /**
     * 이중 연결 리스트의 처음에 데이터 data를 삽입한다.
     *
     * @param data 삽입할 데이터
     */
    public void insertFirst(T data) {
        // 리스트 헤드 다음에 입력한다.
        insertAfter(head, data);
    }

    /**
     * 이중 연결리스트의 마지막에 데이터 x를 삽입한다.
     *
     * @param data 삽입할 데이터
     */
    public void insertLast(T data) {
        insertAfter(head.getPrev(), data);
    }

    /**
     * 지정된 셀 삭제
     */
    private void removeCell(CellDouble<T> p) {
        if (p == head) {
            throw new IllegalStateException("리스트의 헤드는 삭제할 수 없음.");
        }
        p.getPrev().setNext(p.getNext());
        p.getNext().setPrev(p.getPrev());
    }

    /**
     * 이중 연결 리스트의 처음 데이터를 삭제한다.
     *
     * @return 삭제한 요소를 반환, 단 요소가 없다면 null을 반환
     */
    public T removeFirst() {
        // 요소가 없다면 null 반환
        if (isEmpty()) {
            return null;
        }
        CellDouble<T> cell = head.getNext();
        removeCell(cell);
        return cell.getData();
    }

    /**
     * 이중 연결 리스트의 마지막 데이터를 삭제한다.
     *
     * @return 삭제한 요소를 반환. 단, 요소가 없다면 null을 반환
     */
    public T removeLast() {
        // 요소가 없다면 null 반환
        if (isEmpty()) {
            return null;
        }

        CellDouble<T> cell = head.getPrev();
        removeCell(cell);
        return cell.getData();
    }


    /**
     * 이중 연결 리스트가 비어있는지를 체크한다.
     *
     * @return 비어있다면 true, 비어있지 않다면 false반환
     */
    public boolean isEmpty() {
        return head.getNext() == head;
        // head의 prev가 head도 빈것으로 판단.
    }

    /**
     * 이중 연결 리스트의 내용을 문자열로 반환
     *
     * @return 이 이중 연결 리스트의 내용  [a b c ... ]
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");

        for (CellDouble<T> p = head.getNext(); p != head; p = p.getNext()) {
            s.append(p.getData()).append(" ");
        }
        s.append("]");
        return s.toString();
    }

}
