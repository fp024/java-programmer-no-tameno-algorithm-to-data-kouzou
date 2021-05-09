package org.fp024.study.algorithm.part03.chapter08;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HashOpenAddressTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HashChainingTest.class);

    private static final HashOpenAddress HASH_OPEN_ADDRESS = new HashOpenAddress(15);

    private static final String[] WORDS = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "one", // 이미 입력이 되었었기 때문에 등록 실패
    };

    private static final String[] KEYS = {"ten", "one", "ones", "five"};

    @BeforeAll
    static void insertData() {
        LOGGER.info("======= << 1단계 >> ===[등록]=======");
        for (int i = 0; i < WORDS.length; i++) {
            boolean status = HASH_OPEN_ADDRESS.insert(new MyKey(WORDS[i]), "순서=" + (i + 1));
            if (!status) {
                LOGGER.info("{}의 등록에 실패 하였다. (중복됨)", WORDS[i]);
                assertEquals("one", WORDS[i]);
            }
        }
        LOGGER.info("\n{}", HASH_OPEN_ADDRESS);
    }


    @Order(1)
    @Test
    void testFind() {
        LOGGER.info("======= << 2단계 >> ===[탐색]=======");


        for (String key : KEYS) {
            Object result = HASH_OPEN_ADDRESS.find(new MyKey(key));
            if (result == null) {
                LOGGER.info("키[{}]를 발견하지 못했다.", key);
                assertEquals("ones", key);
            } else {
                LOGGER.info("키[{}]의 값은 [{}]이다.", key, result);
            }
        }
    }

    @Order(2)
    @Test
    void testRemoveAndFind() {
        LOGGER.info("======= << 3단계 >> ===[삭제]=======");
        for (String key : KEYS) {
            if (HASH_OPEN_ADDRESS.delete(new MyKey(key))) {
                LOGGER.info("키[{}]을 삭제 하였다.", key);
            } else {
                LOGGER.info("키[{}]의 삭제에 실패하였다. (등록되어있지 않음)", key);
                assertEquals("ones", key);
            }
        }

        LOGGER.info("======= << 4단계 >> ===[탐색: 모두 실패한다]=======");
        for (String key : KEYS) {
            Object result = HASH_OPEN_ADDRESS.find(new MyKey(key));

            if (result == null) {
                LOGGER.info("키[{}]를 발견하지 못했다.", key);
            } else {
                fail("검색할 키를 다 지운 상태이기 때문에 검색이 되어서는 안된다.");
            }
        }

        LOGGER.info("======= << 5단계 >> ==========");
        LOGGER.info("\n{}", HASH_OPEN_ADDRESS);
    }

    @Order(3)
    @Test
    void testOverflowInsert() {
        final HashOpenAddress hashOpenAddress = new HashOpenAddress(15);
        final String[] overFlowWords = {
                "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen"  // 해시테이블 꽉차는 지점
        };

        assertThrows(IllegalStateException.class, () -> {
                    for (int i = 0; i < overFlowWords.length; i++) {
                        boolean status = hashOpenAddress.insert(new MyKey(overFlowWords[i]), "순서=" + (i + 1));
                        if (status) {
                            LOGGER.info("{}의 등록에 성공 하였다.", overFlowWords[i]);
                        } else {
                            LOGGER.info("{}의 등록에 실패 하였다. (중복됨)", overFlowWords[i]);
                        }
                    }
                }
        , "버킷 크기를 초과되는 입력이 일어나서 초과되는 부분에서 등록 실패");
        LOGGER.info("\n{}", hashOpenAddress);
    }
}