package org.fp024.study.algorithm.part01.chapter03;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 3.2.4 열거형
 */
@Slf4j
class EnumTest {
    @Test
    void testFruit() {
        Fruit myFavorite = Fruit.BANANA;

        Fruit f;
        f = Fruit.ORANGE;

        if (f == myFavorite) {
            logger.info("나는 {}을 정말 좋아합니다.", f);
        } else {
            logger.info("나는 {}을 그다지 좋아하지 않습니다.", f);
        }

    }

    /**
     * Java 1.5 부터는 enum을 정의할 수 있다.
     * switch 에서도 enum사용이 가능하다.
     *
     * switch에 enum 사용은  1.5 부터 가능했고, 1.7부터 switch에 String이 허용됐다.
     *
     * String type is available in the switch statement starting with Java 7.
     * enum type was introduced in Java 5 and has been available in the switch statement since then.
     * 참고) https://www.baeldung.com/java-switch
     */
    @Test
    void testFruitEnum() {
        FruitEnum myFavorite = FruitEnum.BANANA;
        FruitEnum f = FruitEnum.ORANGE;

        switch (f) {
            case BANANA:
                logger.info("나는 {}을 정말 좋아합니다.", f);
            default:
                logger.info("나는 {}을 그다지 좋아하지 않습니다.", f);
        }
    }

}
