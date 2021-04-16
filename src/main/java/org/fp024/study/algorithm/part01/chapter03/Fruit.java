package org.fp024.study.algorithm.part01.chapter03;

/**
 * Enum 을 사용할 수 없는 Java 1.4 환경에서는 아래와 같이 대안 방법을 통해 구현
 */
public class Fruit {
    public static final Fruit APPLE = new Fruit("APPLE");
    public static final Fruit ORANGE = new Fruit("ORANGE");
    public static final Fruit BANANA = new Fruit("BANANA");
    public static final Fruit MELON = new Fruit("MELON");

    private Fruit(String kind) {
        this.kind = kind;
    }

    private final String kind;

    public String toString() {
        return kind;
    }
}
