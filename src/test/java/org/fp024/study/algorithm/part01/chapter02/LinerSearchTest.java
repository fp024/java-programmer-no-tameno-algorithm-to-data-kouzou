package org.fp024.study.algorithm.part01.chapter02;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * 기존 예제코드에서 제네릭과 ArrayList로 변경하면서 진행했는데,
 * 기존 코드 커밋을 그대로 한번하고 동작확인 후 바꿔보는게 좋을 것 같다.
 */
@Slf4j
class LinerSearchTest {
    LinerSearch<String> table = new LinerSearch<>();

    @BeforeEach
    void before() {
        table.add(1, "one");
        table.add(10, "ten");
        table.add(2, "two");
    }

    @Test
    void testSearch() {
        String x;
        x = table.search(10); // 탐색한다.

        if (x != null) {
            logger.info("value={}", x);
        } else {
            logger.info("Not found");
        }

        assertEquals(3, table.size());
        assertEquals(x, "ten");
        assertNull(table.search(-1));
    }
}