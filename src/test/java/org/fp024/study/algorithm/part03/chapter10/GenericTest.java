package org.fp024.study.algorithm.part03.chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTest {
    static class Box<T> {
        private final T t;

        public Box(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        @Override
        public String toString() {
            return t.getClass().getCanonicalName() + ":" + t;
        }
    }

    // 01
    static <T> String outBox01(Box<? extends T> box) {
        // 컴파일 시점에는 box가 Number인지 알 수 없으므로, 실체를 확인한 후
        // 강제 형변환해서 사용 해야함.
        if (box.getT() instanceof Number) {
            ((Number) box.getT()).floatValue();
        }
        return box.toString();
    }

    // 02
    static <T extends Number> String outBox02(Box<T> box) {
        // box에 대해 T가 Number를 상속하는 타입임은 컴파일 시점에 알고 있으므로,
        // Number의 메서드를 바로 사용가능
        box.getT().floatValue();
        return box.toString();
    }

    // 03
    static <T> String outBox03(Box<? extends T> box) {
        return box.toString();
    }

    // 04: 컴파일 오류, 와일드 카드를 앞에 정의할 수 없음.
    //      "Cannot resolve symbol 'T'"
    /*
    static <? extends T> void outBox04(Box<T> box) {
        System.out.println(box.toString());
    }
    */

    @Test
    void testGeneric() {
        assertEquals("java.lang.Integer:1", outBox01(new Box<>(1)));
        assertEquals("java.lang.Long:1", outBox01(new Box<>(1L)));
        assertEquals("java.lang.Double:0.1", outBox01(new Box<>(0.1)));

        assertEquals("java.lang.Integer:1", outBox02(new Box<>(1)));
        assertEquals("java.lang.Long:1", outBox02(new Box<>(1L)));
        assertEquals("java.lang.Double:0.1", outBox02(new Box<>(0.1)));

        assertEquals("java.lang.Integer:1", outBox03(new Box<>(1)));
        assertEquals("java.lang.Long:1", outBox03(new Box<>(1L)));
        assertEquals("java.lang.Double:0.1", outBox03(new Box<>(0.1)));
    }
}
