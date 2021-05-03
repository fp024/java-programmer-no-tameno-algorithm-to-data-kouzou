package org.fp024.study.algorithm.part02.chapter06;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Fig 6.6 의 그림 내용대로 구현
 */
@Slf4j
class BinaryTreeNodeTest {
    @Test
    void testBinaryTree() {
        BinaryTreeNode<String> a = new BinaryTreeNode<>("A");

        BinaryTreeNode<String> b = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> h = new BinaryTreeNode<>("H");

        BinaryTreeNode<String> c = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> d = new BinaryTreeNode<>("D");

        BinaryTreeNode<String> e = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> f = new BinaryTreeNode<>("F");

        BinaryTreeNode<String> g = new BinaryTreeNode<>("G");

        a.setLeft(b);
        a.setRight(h);

        b.setLeft(c);
        b.setRight(d);

        d.setLeft(e);
        d.setRight(f);

        e.setLeft(g);
        logger.info("{}", a);
        /*
         BinaryTreeNode(
            left=BinaryTreeNode(
                left=BinaryTreeNode(
                    left=null,
                    right=null, label=C),
                right=BinaryTreeNode(
                    left=BinaryTreeNode(
                        left=BinaryTreeNode(
                            left=null,
                            right=null, label=G),
                        right=null, label=E),
                    right=BinaryTreeNode(
                        left=null,
                        right=null, label=F),
                label=D),
            label=B),
            right=BinaryTreeNode(
                left=null,
                right=null, label=H),
        label=A)
        */
        assertEquals("G", a.getLeft().getRight().getLeft().getLeft().getLabel());
    }


    /**
     * 6.4.5 이진 트리의 순회 메서드 테스트
     * 테스트 데이터 생성 - 트리 모양
     *
     *             A
     *           /  \
     *          B    D
     *         /
     *        C
     */
    private BinaryTreeNode<String> createTestTree() {
        BinaryTreeNode<String> a = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> b = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> c = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> d = new BinaryTreeNode<>("D");

        a.setLeft(b);
        a.setRight(d);

        b.setLeft(c);

        return a;
    }


    /**
     * 전위 순회
     */
    @Test
    void testTraversePreorder() {
        BinaryTreeNode<String> testTree = createTestTree();
        List<String> labelList = new ArrayList<>();
        BinaryTreeNode.traversePreorder(testTree, labelList);
        assertEquals(Arrays.asList("A", "B", "C", "D"), labelList);
    }

    /**
     * 중위 순회
     */
    @Test
    void testTraverseInorder() {
        BinaryTreeNode<String> testTree = createTestTree();
        List<String> labelList = new ArrayList<>();
        BinaryTreeNode.traverseInorder(testTree, labelList);
        assertEquals(Arrays.asList("C", "B", "A", "D"), labelList);
    }


    /**
     * 후위 순회
     */
    @Test
    void testTraversePostorder() {
        BinaryTreeNode<String> testTree = createTestTree();
        List<String> labelList = new ArrayList<>();
        BinaryTreeNode.traversePostorder(testTree, labelList);
        assertEquals(Arrays.asList("C", "B", "D", "A"), labelList);
    }
}