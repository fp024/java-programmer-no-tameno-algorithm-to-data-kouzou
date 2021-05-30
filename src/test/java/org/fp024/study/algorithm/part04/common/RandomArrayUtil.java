package org.fp024.study.algorithm.part04.common;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomArrayUtil {
    private static final Random RANDOM = new Random();

    /**
     * 중복 검사를 `Set`에 넣고 검사하는 식으로 해서, 대용량으로는 못쓴다.
     */
    public static int[] createRandomArray(final int maxValue) {
        int[] intArray = new int[maxValue];
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < maxValue) {
            int randomValue = RANDOM.nextInt(maxValue) + 1;
            if (set.add(randomValue)) {
                intArray[i++] = randomValue;
            }
        }
        return intArray;
    }
}
