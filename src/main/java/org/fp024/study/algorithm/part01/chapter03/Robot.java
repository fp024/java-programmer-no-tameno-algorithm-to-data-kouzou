package org.fp024.study.algorithm.part01.chapter03;

import lombok.Getter;

/**
 * 로봇
 */
public class Robot {
    // 현재 좌표
    @Getter
    private Position position;
    // 이름
    @Getter
    private String name;

    /**
     * 로봇을 생성한다
     *
     * @param position 로봇이 있는 위치
     * @param name     로봇의 이름
     */
    public Robot(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    /**
     * X방향으로 xDelta만큼 이동한다
     *
     * @param xDelta X방향의 이동거리
     */
    public void moveX(int xDelta) {
        position.moveX(xDelta);
    }

    /**
     * Y방향으로 yDelta만큼 이동한다
     *
     * @param yDelta Y방향의 이동거리
     */
    public void moveY(int yDelta) {
        position.moveY(yDelta);
    }

    /**
     * X방향으로 xDelta, Y방향으로 yDelta만큼 이동한다.
     *
     * @param xDelta X방향의 이동 거리
     * @param yDelta Y방향의 이동 거리
     */
    public void moveXY(int xDelta, int yDelta) {
        position.moveXY(xDelta, yDelta);
    }

    /**
     * 로봇의 클론을 만든다.
     * 저자님이 얕은 복사와 깊은 복사에 대해 설명을 하셨음,
     */
    public Robot makeClone() {
        return new Robot(new Position(position.getX(), position.getY()), name + " 클론");
    }

    @Override
    public String toString() {
        return "name:" + name + ", position:" + position;
    }
}
