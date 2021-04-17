package org.fp024.study.algorithm.part01.chapter03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Foo 타입을 요소로 하는 양방향 리스트
 * <p>
 * 저자님이 MyDoublyLinkedList를 5장에서 구현 및 설명을 진행한다고 하시니,
 * 그 때 진행하자!, 지금은 코드상으로 위임을 해서 해결한 것에 대해서만 생각하면 되겠다.
 */
class FooList {
    // 양방향 리스트
    private final MyDoublyLinkedList list;

    /**
     * 양방향 리스트를 생성한다.
     * 생성된 양방향 리스트는 비어있다.
     */
    public FooList() {
        this.list = new MyDoublyLinkedList();
    }

    /**
     * 양방향 리스트의 처음에 data를 삽입한다.
     *
     * @param data 삽입할 데이터
     */
    public void insertFirst(Foo data) {
        list.insertFirst(data);
    }

    /**
     * 양방향 리스트의 마지막에 data를 삽입한다.
     *
     * @param data 삽입할 데이터
     */
    public void insertLast(Foo data) {
        list.insertLast(data);
    }


    /**
     * 양방향 리스트의 처음 데이터를 삭제한다.
     *
     * @return 삭제한 요소를 반환. 단, 요소가 없다면 null을 반환
     */
    public Foo removeFirst() {
        return (Foo) list.removeFirst();
    }

    /**
     * 양뱡항 리스트의 마지막 데이터를 삭제한다.
     *
     * @return 삭제한 요소를 반환. 단, 요소가 없다면 null을 반환
     */
    public Foo removeLast() {
        return (Foo) list.removeLast();
    }

    /**
     * 양방향 리스트가 비어있는지를 체크한다.
     *
     * @return 비었다면 true, 비어있지 않다면 false를 반환
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 양방향 리스트의 내용을 문자열로 반환
     *
     * @return 양방향 리스트의 내용
     */
    public String toString() {
        return list.toString();
    }
}


/**
 * 아래 양방향 링크드 리스트는 5장에서 구현 설명을 하는데,
 * Mock 형식으로만 메서드 구현을 해둔다.
 * <p>
 * Generic을 사용하지 못했을 것으로 가정해서
 * MyDoublyLinkedList는 Object 객체를 처리한다.
 */
class MyDoublyLinkedList {
    public void insertFirst(Object data) {
        // TODO 구현 필요
    }

    public void insertLast(Object data) {
        // TODO 구현 필요
    }

    public Object removeFirst() {
        // TODO 구현 필요
        return null;
    }

    public Object removeLast() {
        // TODO 구현 필요
        return null;
    }

    public boolean isEmpty() {
        // TODO 구현 필요
        return true;
    }
}


/**
 * Foo 타입
 */
@Getter
@Setter
@ToString
class Foo {
    private String value;
}

