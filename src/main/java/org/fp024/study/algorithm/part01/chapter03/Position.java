package org.fp024.study.algorithm.part01.chapter03;

import lombok.Getter;

import java.util.Objects;

/**
 * 위치
 */
public class Position {
    // x 좌표
    @Getter
    private final int x;

    // y 좌표
    @Getter
    private final int y;

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
     * @return 새로운 좌표
     */
    public Position moveX(int xDelta) {
        return new Position(x + xDelta, y);
    }

    /**
     * Y방향으로 yDelta만큼 이동한다
     *
     * @param yDelta Y방향의 이동거리
     * @return 새로운 좌표
     */
    public Position moveY(int yDelta) {
        return new Position(x, y + yDelta);
    }

    /**
     * X뱡향으로 xDelta, Y방향으로 yDelta만큼 이동한다.
     *
     * @param xDelta X방향의 이동거리
     * @param yDelta Y방향의 이동거리
     * @return 새로운 좌표
     */
    public Position moveXY(int xDelta, int yDelta) {
        return new Position(x + xDelta, y + yDelta);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    /**
     * IntelliJ에서 Java 7+ 이상 버전으로 equals & hashCode를 생성했을 때..
     * @param o  비교대상 오브젝트
     * @return 동등여부
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    /**
     * Objects 클래스가 Java 1.7 부터 추가되었다.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
