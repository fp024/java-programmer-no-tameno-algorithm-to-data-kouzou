package org.fp024.study.algorithm.part03.chapter08;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 연결리스트로 충돌을 해결한 HashChaining 클래스 테스트
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HashChainingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HashChainingTest.class);

    private static final HashChaining HASH_CHAINING = new HashChaining(15);

    private static final String[] WORDS = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "one", // 중복으로 등록실패
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };

    private static final String[] KEYS = {"ten", "thirteen", "one", "ones", "five"};

    @BeforeAll
    static void insertData() {
        LOGGER.info("======= << 1단계 >> ===[등록]======= ");
        for (int i = 0; i < WORDS.length; i++) {
            boolean result = HASH_CHAINING.insert(new MyKey(WORDS[i]), "순서=" + (i + 1));
            if (!result) {
                assertEquals("one", WORDS[i], "등록실패한 단어" + WORDS[i] + ", 인덱스번호:" + i);
            }
        }
        LOGGER.info(HASH_CHAINING.toString());
    }


    @Order(1)
    @Test
    void testFind() {
        LOGGER.info("======= << 2단계 >> ===[탐색]======= ");
        Arrays.stream(KEYS).forEach(key -> {
            Object result = HASH_CHAINING.find(new MyKey(key));
            if (result == null) {
                LOGGER.info("키[{}] 의 값은 발견하지 못했다.", key);
                assertEquals("ones", key, "검색 실패한 단어");
            } else {
                LOGGER.info("키[{}] 의 값은 [{}] 이다.", key, result);
            }
        });
    }


    @Order(2)
    @Test
    void testRemoveAndReFind() {
        LOGGER.info("======= << 3단계 >> ===[삭제]=======");
        // 배열 KEYS 에 있는 모든 단어를 삭제한다.
        Arrays.stream(KEYS).forEach(key -> {
            if (HASH_CHAINING.delete(new MyKey(key))) {
                LOGGER.info("키[{}]을 삭제 하였다.", key);
            } else {
                LOGGER.info("키[{}]의 삭제에 실패하였다. (등록되어있지 않음)", key);
                assertEquals("ones", key, "삭제 실패한 키");
            }
        });

        LOGGER.info("======= << 4단계 >> ===[탐색]=======");
        Arrays.stream(KEYS).forEach(key -> {
            Object result = HASH_CHAINING.find(new MyKey(key));
            if (result != null) {
                fail("해당 키가 전부 지워저서 검색 결과가 항상 없어야한다.");
            } else {
                LOGGER.info("키[{}] 의 값은 발견하지 못했다.", key);
            }
        });

        LOGGER.info("======= << 5단계 >> ==========");
        LOGGER.info(HASH_CHAINING.toString());
    }


}