package org.fp024.study.algorithm.part03.chapter08;

import java.util.Objects;

/**
 * 해시 표에서 사용하는 키
 */
class MyKey {
    // 키로 사용할 문자열
    private final String keyString;

    /**
     * 키를 생성한다
     *
     * @param keyString 키로 사용할 문자열
     */
    public MyKey(String keyString) {
        this.keyString = keyString;
    }

    /**
     * 키를 비교한다.
     * 저자님은 keyString의 동일여부만 검사하긴 했는데...
     * IntelliJ 가 만들어주는 equals를 사용해보자.
     * Object의 equals를 오버라이드 했기 때문에 인자를 MyKey로 사용할 수는 없다.
     * Object로 선언해야한다.
     *
     * @param x 비교할 키
     * @return 이 키와 키 x가 같다면 true, 같지 않다면 false
     */
    @Override
    public boolean equals(Object x) {
        if (this == x) {
            return true;
        }
        if (x == null || getClass() != x.getClass()) {
            return false;
        }
        MyKey myKey = (MyKey) x;
        return Objects.equals(keyString, myKey.keyString);
    }

    /**
     * 키의 해시 값을 반환
     *
     * @return 이 키의 해시값
     */
    @Override
    public int hashCode() {
        int sum = 0;
        // 문자열에 포함되어 있는 모든 문자 코드의 합을 구한다.
        for (int i = 0; i < keyString.length(); i++) {
            sum += keyString.charAt(i); // 암묵적으로 int 형으로 형변환드므로 명시적 형변환은 필요없다.
        }
        return sum;
    }

    /**
     * 키를 문자열 형태로 변환
     * (실은 키가 문자열이기 때문에 그대로 변환)
     *
     * @return 키를 문자열로 표시한 것
     */
    @Override
    public String toString() {
        return keyString;
    }
}
