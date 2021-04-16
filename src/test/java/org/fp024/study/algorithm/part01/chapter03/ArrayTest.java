package org.fp024.study.algorithm.part01.chapter03;

import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 3.2.3 배열
 */
class ArrayTest {
    @Test
    void testArrayReferenceCopy() {
        int[] a = new int[5];
        // 배열 초기화
        IntStream.range(0, a.length).forEach(i -> a[i] = i);

        int[] b = a;  // 참조의 복사
        b[3] = 200;

        assertEquals(200, a[3]);
        assertArrayEquals(a, b);
    }


    @Test
    void testArrayClone() {
        int[] a = new int[5];
        // 배열 초기화
        IntStream.range(0, a.length).forEach(i -> a[i] = i);

        int[] b = a.clone();  // clone 할때 강제 형변환을 하지않아도 됨.
        b[3] = 200;
        assertEquals(3, a[3]); // b[3]에의 200 할당이 a[]에 영향을 미치지 않음.s
    }


    @Test
    void testArrayCopy() {
        int[] a = new int[5];
        // 배열 초기화
        IntStream.range(0, a.length).forEach(i -> a[i] = i);

        int[] b = new int[a.length];

        System.arraycopy(a, 0, b, 0, a.length);
        assertArrayEquals(a, b);
    }


    @Getter
    @ToString
    class MyData {
        private String name;
        private int age;

        void setData(String aName, int anAge) {
            name = aName;
            age = anAge;
        }
    }


    @Test
    void testMyDataNPE() {
        MyData[] data = new MyData[5];
        // 객체 타입 배열 초기화시 초기값는 null이다.
        assertThrows(NullPointerException.class, () -> data[0].setData("J.S Bach", 100));
    }

    @Test
    void testMyDataInit() {
        MyData[] data = new MyData[5];
        IntStream.range(0, data.length).forEach(i -> data[i] = new MyData());
        data[0].setData("J.S Bach", 100);

        assertEquals("J.S Bach",data[0].getName());
    }
}
