package org.fp024.study.algorithm.part02.chapter04;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 배열로 구현한 스택
 * <p>
 * MyStack 을 Generic으로 바꿀 때, 저장 배열은 그대로 Object[] 로 두고...
 * push도 T타입을 그대로 Object[]에 넣으면 되고...
 * pop일 때는 Object[]에서 꺼낸 Object를 T강제 형변환 해야하는데...
 * ArrayList의 get()부분을 보았을 때도  @SuppressWarnings("unchecked") 이게 붙어있다. ㅎㅎ
 */
class MyStack<T> {
    // 스택의 본체
    private final Object[] stack;
    // 스택의 크기
    private final int stackSize;
    // 스택 포인터
    private int sp;

    // 기본 스택 크기
    private static final int DEFAULT_STACK_SIZE = 100;

    /**
     * 스택을 생성한다 (DEFAULT_STACK_SIZE)
     */
    public MyStack() {
        this(DEFAULT_STACK_SIZE);
    }

    /**
     * 크기를 지정하여 스택생성
     *
     * @param size 스택의 크기
     */
    public MyStack(int size) {
        stack = new Object[size];
        stackSize = size;
        sp = 0;
    }

    /**
     * 에러 처리
     * 메시지 s를 표시하고 프로그램을 종료시킨다.
     * (JUnit 에서 수행할 것이니.. 예외를 발생시키자!)
     *
     * @param s 메시지
     */
    private void error(String s) {
        throw new IllegalStateException(s);
    }

    /**
     * 스택의 내용을 모두 버린다
     * 버퍼 내용의 null 같은 처리없이 포인터만 0으로 하더라도
     * pop 동작상에서 sp 0일 때 pop을 하려하면 예외를 발생시키기 때문에,
     * 동작에는 문제 없음.
     */
    public void clear() {
        // 스택 포인터를 0으로 함
        sp = 0;
    }

    /**
     * null 로 클리어
     */
    public void nullClear() {
        IntStream.range(0, sp).forEach(i -> stack[i] = null);
        clear();
    }

    /**
     * 스택에 데이터를 쌓는다
     *
     * @param x 쌓을 데이터
     */
    public void push(T x) {
        if (sp >= stackSize) {
            error("Stack overflow");
        }
        stack[sp++] = x;
    }

    /**
     * 스택에서 데이터를 꺼낸다
     *  T 타입으로 강제 형변환 필요.
     * @return 스택에서 꺼낸 데이터
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (sp <= 0) {
            error("Stack underflow");
        }
        return (T) stack[--sp];
    }

    /**
     * 스택이 비어있는지 조사한다.
     *
     * @return 비어있다면 true, 비어있지 않다면 false 를 반환
     */
    public boolean isEmpty() {
        return sp == 0;
    }

    /**
     * 스택의 내용을 문자열로 반환
     * (여기는 Java 8의 스트림을 써보자...)
     *
     * @return 스택의 내용
     */
    @Override
    public String toString() {
        return "MyStack=[" + IntStream.range(0, sp)
                .mapToObj(i -> stack[i].toString())
                .collect(Collectors.joining(",")) + "]";
    }
}
