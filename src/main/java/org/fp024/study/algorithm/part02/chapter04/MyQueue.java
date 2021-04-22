package org.fp024.study.algorithm.part02.chapter04;

import lombok.extern.slf4j.Slf4j;

/**
 * 배열로 구현한 큐
 *
 * @param <T> 큐에 저장될 요소의 타입
 */
@Slf4j
class MyQueue<T> {
    // 큐
    private final Object[] queue;

    // 큐 크기
    private final int queueSize;

    // 큐의 프론트
    private int front;

    // 큐의 리어 (정확하게 이야기하면, 리어 다음 요소를 가리킴)
    private int rear;

    // 큐의 기본 크기
    private final static int DEFAULT_QUEUE_SIZE = 100;

    /**
     * 큐를 생성한다 (크기는 DEFAULT_QUEUE_SIZE)
     */
    public MyQueue() {
        this(DEFAULT_QUEUE_SIZE);
    }

    /**
     * 크기를 지정하여 큐를 생성한다.
     *
     * @param queueSize 큐의 크기
     */
    public MyQueue(int queueSize) {
        this.queueSize = queueSize;
        this.queue = new Object[queueSize];
        front = rear = 0;
    }

    /**
     * 에러처리
     * 메시지 S를 표시하고 프로그램을 종료시킴
     * (예외 발생으로 수정)
     *
     * @param s 메시지
     */
    private void error(String s) {
        logger.error(s);
        throw new IllegalStateException(s);
    }

    /**
     * 다음 요소의 첨자를 구한다
     *
     * @param a 현재 요소의 첨자
     */
    private int next(int a) {
        return (a + 1) % queueSize;
    }

    /**
     * 큐를 비운다
     */
    public void clear() {
        front = rear = 0;
    }

    /**
     * 큐에 데이터를 넣는다
     */
    public void enqueue(T x) {
        if (next(rear) == front) {
            error("이 이상 큐에 요소를 추가할 수 없습니다.");
        }
        queue[rear] = x;
        rear = next(rear);
    }

    /**
     * 큐에서 데이터를 꺼낸다
     *
     * @return 큐에서 꺼낸 데이터
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (front == rear) {
            error("큐가 비어있기 때문에 요소를 꺼낼 수 없습니다.");
        }
        T x = (T) queue[front];
        front = next(front);
        return x;
    }


    /**
     * 큐가 비어있는지 조사
     *
     * @return 비어있다면 true, 비어있지 않다면 false 반환
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 큐의 내용을 문자열로 표시
     *
     * @return 큐의 내용
     */
    public String toString() {
        StringBuilder s = new StringBuilder("MyQueue=[");

        for (int i = front; i != rear; i = next(i)) {
            s.append(queue[i]).append(" ");
        }
        s.append("] front=").append(front).append(" rear=").append(rear);
        return s.toString();
    }
}
