package org.fp024.study.algorithm.part04.chapter15;

import lombok.extern.slf4j.Slf4j;
import org.fp024.study.algorithm.part04.common.CommonSortTest;
import org.fp024.study.algorithm.part04.common.RandomArrayUtil;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
class MergeSortListTest extends CommonSortTest {
    private final static int[] ORIGIN_INT_ARRAY = RandomArrayUtil.createRandomArrayWithoutSet(100_000);
    private final MergeSortList<Integer> mergeSortList = new MergeSortList<>();

    @Test
    void testMergeList() {
        // 머지에 들어오는 연결리스트 각각은 정렬이 되어있는 것으로 간주된다.
        Cell<Integer> a = createTestLinkCell(List.of(1, 3, 5));
        Cell<Integer> b = createTestLinkCell(List.of(2, 4, 6));
        final Cell<Integer> expect = createTestLinkCell(List.of(1, 2, 3, 4, 5, 6)).next; // 더미를 제외하기 때문에 다음 요소부터 처리
        Cell<Integer> c = ReflectionTestUtils.invokeMethod(mergeSortList, "mergeList", a.next, b.next);

        assertEquals(expect, c);
    }


    @Test
    void testCreateTestLinkCell() {
        Cell<Integer> a = createTestLinkCell(Arrays.asList(1, 2, 3));
        assertEquals(1, a.next.data);
        assertEquals(2, a.next.next.data);
        assertEquals(3, a.next.next.next.data);
        assertNull(a.next.next.next.next);
    }

    /**
     * 연결리스트를 만들어 그 연결 리스트의 헤드를 반환
     *
     * @param elements 요소 값들..
     * @param <E>      셀의 요소 타입
     * @return 연결리스트의 머리 반환
     */
    private <E extends Comparable<E>> Cell<E> createTestLinkCell(List<E> elements) {
        final Cell<E> head = new Cell<>(null);
        Cell<E> p = head;
        Cell<E> newCell;
        for (E e : elements) {
            newCell = new Cell<>(e);
            p.next = newCell;
            p = newCell;
        }
        return head;
    }

    @Test
    void testMergeSortList() {
        int[] intArray = Arrays.copyOf(ORIGIN_INT_ARRAY, ORIGIN_INT_ARRAY.length);
        List<Integer> list = Arrays.stream(intArray).boxed().collect(toList());

        // 무작위 배열을 연결 리스트 형식으로 변환
        Cell<Integer> unsortedCell = createTestLinkCell(list);

        // 정렬 수행
        Cell<Integer> result = processSortOnlyTime(mergeSortList::mergeSortList, unsortedCell.next);

        // 정렬 검증
        Arrays.sort(intArray); // 비교 대상 배열을 Java 에서 제공하는 sort()를 실행하여 정렬된 내용으로 만든다.

        // 머지소트로 정렬된 연결리스트 결과의 정렬을 검증한다.
        Cell<Integer> current = result;
        for (int i : intArray) {
            assertEquals(i, current.data);
            current = current.next;
        }
    }

}