package org.fp024.study.algorithm.part03.chapter09;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.fp024.study.algorithm.part03.chapter09.BinarySearchTree.Node;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * 이진 탐색트리 테스트
 */
@Slf4j
class BinarySearchTreeTest {
    @Test
    void testBinarySearchTreeA() {
        BinarySearchTree<Integer> bSearchTreeA = new BinarySearchTree<>(createNodeFig_9_1_a());

        Node<Integer> foundRoot = bSearchTreeA.search(13);
        assertEquals(13, foundRoot.data);

        Node<Integer> found3 = bSearchTreeA.search(6);
        assertEquals(6, found3.data);

        Node<Integer> found15 = bSearchTreeA.search(15);
        assertEquals(15, found15.data);

        Node<Integer> found2 = bSearchTreeA.search(2);
        assertEquals(2, found2.data);

        Node<Integer> notFound3 = bSearchTreeA.search(3);
        assertNull(notFound3);

        logger.info(bSearchTreeA.toString());
    }

    @Test
    void testBinarySearchTreeB() {
        BinarySearchTree<Integer> bSearchTreeB = new BinarySearchTree<>(createNodeFig_9_1_b());

        Node<Integer> foundRoot = bSearchTreeB.search(6);
        assertEquals(6, foundRoot.data);

        Node<Integer> found7 = bSearchTreeB.search(7);
        assertEquals(7, found7.data);

        Node<Integer> found2 = bSearchTreeB.search(2);
        assertEquals(2, found2.data);

        Node<Integer> notFound3 = bSearchTreeB.search(3);
        assertNull(notFound3);

        logger.info(bSearchTreeB.toString());
    }

    /**
     * 교제 219 쪽의 Fig 9.1 (a)에 해당하는 이진 트리 노드
     */
    Node<Integer> createNodeFig_9_1_a() {
        Node<Integer> root = new Node<>(13);
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(21);
        Node<Integer> c = new Node<>(2);
        Node<Integer> d = new Node<>(7);
        Node<Integer> e = new Node<>(15);
        Node<Integer> f = new Node<>(6);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;
        b.left = e;
        d.left = f;

        return root;
    }

    /**
     * 교제 219 쪽의 Fig 9.1 (b)에 해당하는 이진 트리 노드
     */
    Node<Integer> createNodeFig_9_1_b() {
        Node<Integer> root = new Node<>(6);
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(21);
        Node<Integer> c = new Node<>(2);
        Node<Integer> d = new Node<>(15);
        Node<Integer> e = new Node<>(13);
        Node<Integer> f = new Node<>(7);

        root.left = a;
        root.right = b;

        a.left = c;
        b.left = d;

        d.left = e;
        e.left = f;

        return root;
    }

    /**
        책 내용 안보고 생각대로 하긴했는데, 8의 입력은 제대로 되었다.

        [ 5 || 13 || 21 ]
        [ 2 || 5 || 7 ]
        [ null || 2 || null ]
        [ 6 || 7 || 8 ]
        [ null || 6 || null ]
        [ null || 8 || null ]
        [ 15 || 21 || null ]
        [ null || 15 || null ]


        * Fig.9.2 (b)

                  13
               /     \
              5       21
            /  \      /
           2    7    15
               /  \
              6    8

     */
    @Test
    void testBinarySearchTreeAInsert() {
        BinarySearchTree<Integer> bSearchTreeA = new BinarySearchTree<>(createNodeFig_9_1_a());
        Node<Integer> node8 = bSearchTreeA.insert(8);
        assertEquals(8 , node8.data);

        assertNull(bSearchTreeA.insert(8));

        logger.info(bSearchTreeA.toString());
    }

    /**
        책 내용 안보고 생각대로 하긴했는데, 8의 입력은 제대로 되었다.

        [ 5 || 6 || 21 ]
        [ 2 || 5 || null ]
        [ null || 2 || null ]
        [ 15 || 21 || null ]
        [ 13 || 15 || null ]
        [ 7 || 13 || null ]
        [ null || 7 || 8 ]
        [ null || 8 || null ]


        * Fig.9.2 (d)

                  6
                 / \
                5   21
               /    /
              2    15
                  /
                 13
                /
               7
                \
                 8
     */
    @Test
    void testBinarySearchTreeBInsert() {
        BinarySearchTree<Integer> bSearchTreeA = new BinarySearchTree<>(createNodeFig_9_1_b());
        Node<Integer> node8 = bSearchTreeA.insert(8);
        assertEquals(8 , node8.data);

        assertNull(bSearchTreeA.insert(8));

        logger.info(bSearchTreeA.toString());
    }


    /**
     * 빈 루트 부터 시작해서 입력한다면?
        [ 1 || 8 || 10 ]
        [ null || 1 || null ]
        [ null || 10 || null ]

                8
              /   \
            1     10

     */
    @Test
    void testBinarySearchTreeFirstInsert() {
        BinarySearchTree<Integer> bSearchTreeFirst = new BinarySearchTree<>();
        Node<Integer> node8 = bSearchTreeFirst.insert(8);
        assertEquals(8 , node8.data);

        Node<Integer> node1 = bSearchTreeFirst.insert(1);
        assertEquals(1 , node1.data);

        Node<Integer> node10 = bSearchTreeFirst.insert(10);
        assertEquals(10 , node10.data);

        assertNull(bSearchTreeFirst.insert(10));

        logger.info(bSearchTreeFirst.toString());
    }

}