package org.fp024.study.algorithm.part02.chapter06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 먼저 예제로 만들었던 {@link BinaryTreeNode} 를 사용하여 수식을 저장해보고,
 * 순회를 해보자. 순회 메서드는 여기 테스트 코드 클래스에 직접 만들었었는데,
 * 기존에 했던 메서드를 그대로 사용해서 전위식, 후위식을 얻을 수 있었다.
 */
class FormulaTreeTest {
    private BinaryTreeNode<String> formulaTree;

    /**
     *  테스트 수식 트리
     *               *
     *             /   \
     *            +     -
     *          /   \  /  \
     *         a    b  c   d
     */
    @BeforeEach
    void beforeEach() {
        formulaTree = new BinaryTreeNode<>("*");

        BinaryTreeNode<String> plusOperator = new BinaryTreeNode<>("+");

        BinaryTreeNode<String> minusOperator = new BinaryTreeNode<>("-");

        BinaryTreeNode<String> a = new BinaryTreeNode<>("a");
        BinaryTreeNode<String> b = new BinaryTreeNode<>("b");
        BinaryTreeNode<String> c = new BinaryTreeNode<>("c");
        BinaryTreeNode<String> d = new BinaryTreeNode<>("d");


        formulaTree.setLeft(plusOperator);
        formulaTree.setRight(minusOperator);

        plusOperator.setLeft(a);
        plusOperator.setRight(b);

        minusOperator.setLeft(c);
        minusOperator.setRight(d);
    }


    /**
     * 전위 순회로 전치 표기를 얻음.
     */
    @Test
    void testTraversePreorder() {
        List<String> labelList = new ArrayList<>();
        BinaryTreeNode.traversePreorder(formulaTree, labelList);
        assertEquals(Arrays.asList("*", "+", "a", "b", "-", "c", "d"), labelList);
    }

    /**
     * 중위 순회는 수식 처리로 사용하기에 별 의미는 없는 것 같다.
     * 저자님도 중위 식 결과대해선 특별히 언급이 없다.
     *
     * 그런데 출력 모양은 그대로 출력한다.
     *      a + b * c + d
     */
    @Test
    void testTraverseInorder() {
        List<String> labelList = new ArrayList<>();
        BinaryTreeNode.traverseInorder(formulaTree, labelList);
        assertEquals(Arrays.asList("a", "+", "b", "*", "c", "-", "d"), labelList);
    }

    /**
     * 후위 순회로 후치 표기법을 얻음.
     */
    @Test
    void testTraversePostorder() {
        List<String> labelList = new ArrayList<>();
        BinaryTreeNode.traversePostorder(formulaTree, labelList);
        assertEquals(Arrays.asList("a", "b", "+", "c", "d", "-", "*"), labelList);
    }
}
