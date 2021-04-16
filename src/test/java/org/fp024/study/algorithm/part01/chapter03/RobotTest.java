package org.fp024.study.algorithm.part01.chapter03;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 로봇 클래스 테스트
 */
@Slf4j
class RobotTest {

    @Test
    void testRobot() {
        Robot robita = new Robot(new Position(10, 20), "로비타");

        logger.info("{}", robita);
        assertEquals(10, robita.getPosition().getX());
        assertEquals(20, robita.getPosition().getY());


        Robot robitaClone = robita.makeClone();
        robitaClone.moveXY(5, 5);

        assertEquals(10, robita.getPosition().getX());
        assertEquals(20, robita.getPosition().getY());

        assertEquals(15, robitaClone.getPosition().getX());
        assertEquals(25, robitaClone.getPosition().getY());


        robita.moveXY(3, 3);

        assertEquals(13, robita.getPosition().getX());
        assertEquals(23, robita.getPosition().getY());

        assertEquals(15, robitaClone.getPosition().getX());
        assertEquals(25, robitaClone.getPosition().getY());
    }
}
