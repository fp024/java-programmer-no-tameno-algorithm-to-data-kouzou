package org.fp024.study.algorithm.part04.common;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class RandomArrayUtilTest {

    @Test
    void testCreateRandomArrayWithoutSet() {
        int maxValue = 100;
        int[] intArray = RandomArrayUtil.createRandomArrayWithoutSet(maxValue);
        logger.info("{}", intArray);
        Arrays.sort(intArray);

        assertEquals(1, intArray[0]);
        assertEquals(maxValue, intArray[maxValue - 1]);
    }

}