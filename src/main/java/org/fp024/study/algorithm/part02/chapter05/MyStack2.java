package org.fp024.study.algorithm.part02.chapter05;

/**
 * 이중 연결 리스트를 이용하여 구현한 스택
 */
class MyStack2<T> {
    // 스택의 역활을 하는 이중 연결리스트
    private MyDoublyLinkedList<T> stack;

    // 스택에 들어있는 요소의 개수,
    // <?> 요소의 수도 MyDoublyLinkedList 가 내부 처리해주는게 나아보이긴함.
    private int nElements;

    /**
     * 스택을 생성한다.
     */
    public MyStack2() {
        // 스택의 역활을 하는 이중 연결 리스트를 할당한다.
        this.stack = new MyDoublyLinkedList<>();

        // 요소의 개수를 0으로 한다.
        this.nElements = 0;
    }

    /**
     * 스택의 내용을 비우고 빈상태로 한다.
     * <p>
     * 이부분이 좀 ...
     * <?> MyDoublyLinkedList 자체 내에서 클리어가 있어야할 것 같은데...
     */
    public void clear() {
        // 이중 연결 리스트를 다시 만든다.
        this.stack = new MyDoublyLinkedList<>();
        // 요소의 개수를 0으로 한다.
        this.nElements = 0;
    }


    /**
     * 스택에 데이터를 쌓는다.
     *
     * @param x 쌓을 데이터
     */
    public void push(T x) {
        stack.insertLast(x);
        nElements++;
    }

    /**
     * 스택에서 데이터를 꺼낸다.
     *
     * @return 스택에서 꺼낸 데이터
     */
    public T pop() {
        T x = stack.removeLast();
        if (x == null) {
            throw new IllegalStateException("stack underflow");
        }
        nElements--;
        return x;
    }


    /**
     * 스택이 비어있는지 조사한다
     *
     * @return 비어있다면 true, 비어있지 않다면 false 를 반환
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * 스택의 내용을 문자열로 반환
     *
     * @return 스택의 내용
     */
    @Override
    public String toString() {
        return "요소의 수=" + nElements + " " + stack.toString();
    }
}

