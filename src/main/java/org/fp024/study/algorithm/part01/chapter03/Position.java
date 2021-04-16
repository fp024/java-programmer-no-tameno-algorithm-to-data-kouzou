package org.fp024.study.algorithm.part01.chapter03;

import lombok.Getter;

/**
 * 위치
 */
public class Position {
    // x 좌표
    @Getter
    private int x;

    // y 좌표
    @Getter
    private int y;

    /**
     * 위치를 생성한다.
     *
     * @param xPos x좌표
     * @param yPos y좌표
     */
    public Position(int xPos, int yPos) {
        this.x = xPos;
        this.y = yPos;
    }

    /**
     * X방향으로 xDelta만큼 이동한다.
     *
     * @param xDelta X방향의 이동거리
     */
    public void moveX(int xDelta) {
        this.x += xDelta;
    }

    /**
     * Y방향으로 yDelta만큼 이동한다
     *
     * @param yDelta Y방향의 이동거리
     */
    public void moveY(int yDelta) {
        this.y += yDelta;
    }

    /**
     * X뱡향으로 xDelta, Y방향으로 yDelta만큼 이동한다.
     *
     * @param xDelta X방향의 이동거리
     * @param yDelta Y방향의 이동거리
     */
    public void moveXY(int xDelta, int yDelta) {
        moveX(xDelta);
        moveY(yDelta);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
