package org.fp024.study.algorithm.part03.chapter10;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * B 트리의 테스트 메인루틴 관련 테스트를 여기서 진행한다.
 */
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BTreeTest {
    private BTree tree;

    private final List<Integer> initDataList = List.of(1, 100, 27, 45, 3, 135, 13);

    private final List<Integer> extraDataList = List.of(5, 90, 35, 25, 17, 120, 55);

    @BeforeEach
    void beforeEach() {
        tree = new BTree();
        initDataList.forEach(data -> tree.insert(data, String.format("[%s]", data)));
    }


    @Order(1)
    @Test
    void testSearch() {
        logger.info("\n{}", tree.toString());
        initDataList.forEach(data -> assertTrue(tree.search(data)));
    }

    @Order(2)
    @Test
    void testDelete() {
        initDataList.forEach(data -> {
            assertTrue(tree.delete(data));
            assertFalse(tree.search(data));
        });
        assertEquals("<트리는 비어있다>", tree.toString());
    }

    /**
     * 키는 변화 없이 데이터만 검색된 리프의 데이터만 바꾸는 동작 확인
     */
    @Order(3)
    @Test
    void testGetAndSetData() {
        assertTrue(tree.search(100));
        assertEquals("[100]", tree.getData());
        // 100의 키에 데이타를 55를 설정
        assertTrue(tree.setData("[55]"));

        assertTrue(tree.search(100));
        assertEquals("[55]", tree.getData());
    }

    @Order(4)
    @Test
    void testInsert() {
        initDataList.forEach(data -> assertFalse(tree.insert(data, String.format("[%s]", data))));
        logger.info("### 초기 데이터 중복 저장되지 않는 것 확인 이후 ###\n{}", tree);

        extraDataList.forEach(data -> assertTrue(tree.insert(data, String.format("[%s]", data))));
        logger.info("### 추가 데이터 저장 이후 ###\n{}", tree);
    }
    /* // 실행 결과 참고
       // 초기 데이터 1, 100, 27, 45, 3, 135, 13
        ### 초기 데이터 중복 저장되지 않는 것 확인 이후 ###
        Node #8 (2 children): #2 [45] #7
        Node #2 (4 children): #0 [3] #5 [13] #9 [27] #3
        Leaf #0 key=1
        Leaf #5 key=3
        Leaf #9 key=13
        Leaf #3 key=27

        Node #7 (3 children): #4 [100] #1 [135] #6
        Leaf #4 key=45
        Leaf #1 key=100
        Leaf #6 key=135


        ### 추가 데이터 저장 이후 ###
        Node #8 (4 children): #2 [13] #13 [45] #7 [100] #18
        Node #2 (3 children): #0 [3] #5 [5] #10
        Leaf #0 key=1
        Leaf #5 key=3
        Leaf #10 key=5

        Node #13 (5 children): #9 [17] #15 [25] #14 [27] #3 [35] #12
        Leaf #9 key=13
        Leaf #15 key=17
        Leaf #14 key=25
        Leaf #3 key=27
        Leaf #12 key=35

        Node #7 (3 children): #4 [55] #17 [90] #11
        Leaf #4 key=45
        Leaf #17 key=55
        Leaf #11 key=90

        Node #18 (3 children): #1 [120] #16 [135] #6
        Leaf #1 key=100
        Leaf #16 key=120
        Leaf #6 key=135

     */
}
