package org.fp024.study.algorithm.part06.chapter19;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class EtcTest {
    @Test
    void test() {
        logger.info("8^8: {}", Math.pow(8, 8));
        assertEquals(16_777_216, (int)Math.pow(8, 8));
    }
}
