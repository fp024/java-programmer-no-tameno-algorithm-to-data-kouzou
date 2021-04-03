package org.fp024.study.algorithm.part01.chapter02;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * 2.2.2 이진 탐색 테스트
 * 이진탐색 대상은 오름차순 정렬된 상태여야한다.
 * 책의 예제에서 값의 크기를 (<, > ==) 수식으로 비교할 수 있어야하므로, 키의 타입은 숫자형이여야겠다.
 *
 * 값을 추가하는 add 구현에 대해서는 이후 설명할 것 같다. 우선은 정렬된 배열을 미리 넣어서 기능 확인.
 */
@Slf4j
class BinarySearchTest {
    // 저자님이 Add 메서드 작성 없이 미리 설명만 하셔서, 동작 확인에 필요한 데이터를 미리 전달해줬다
    private static final List<BinarySearch.Entry> ENTRY_LIST = Stream.of(1, 3, 4, 8, 13, 14, 18, 20, 21, 25)
            .sorted()
            .map(i -> new BinarySearch.Entry(i, i + "값"))
            .collect(Collectors.toUnmodifiableList());

    private BinarySearch binarySearch = new BinarySearch(ENTRY_LIST);

    @BeforeEach
    void before() {

    }

    @Test
    void testSearch() {
        assertEquals(ENTRY_LIST.size() , binarySearch.getSize());
        assertEquals("3값", binarySearch.search(3));
        assertEquals("25값", binarySearch.search(25));
        assertNull(binarySearch.search(-1));
    }
}