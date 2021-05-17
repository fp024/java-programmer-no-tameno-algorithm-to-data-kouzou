package org.fp024.study.algorithm.part03.chapter09;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.fp024.study.algorithm.part03.chapter09.BinarySearchTree.Node;
import static org.junit.jupiter.api.Assertions.*;


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


    /**
       9.4 자식이 없는 노드(리프)의 삭제
                9
               /
              5
            /   \
          1     7


     */
    Node<Integer> createNodeFig_9_4_a() {
        Node<Integer> root = new Node<>(9);
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(1);
        Node<Integer> c = new Node<>(7);

        root.left = a;
        a.left = b;
        a.right = c;
        return root;
    }
    /**
        [ 5 || 9 || null ]
        [ null || 5 || 7 ]
        [ null || 7 || null ]

                9
              /
            5
             \
              7
     */
    @Test
    void testBinarySearchTreeDeleteNoChildNode() {
        BinarySearchTree<Integer> bSearchTree = new BinarySearchTree<>(createNodeFig_9_4_a());
        bSearchTree.delete(1);
        logger.info(bSearchTree.toString());
        assertNull(bSearchTree.search(1));
    }


    /**
        9.5 자식이 하나인 노드를 삭제  (5를 삭제하면..)
                9
              /  \
             5   14
            /
           3
          /  \
         1   4

     */
    Node<Integer> createNodeFig_9_5_a() {
        Node<Integer> root = new Node<>(9);
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(14);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(1);
        Node<Integer> e = new Node<>(4);

        root.left = a;
        root.right = b;

        a.left = c;

        c.left = d;
        c.right = e;

        return root;
    }

    /**
         [ 3 || 9 || 14 ]
         [ 1 || 3 || 4 ]
         [ null || 1 || null ]
         [ null || 4 || null ]
         [ null || 14 || null ]

                 9
               /  \
              3   14
            /  \
           1    4

     */
    @Test
    void testBinarySearchTreeDeleteHasOneChildNode() {
        BinarySearchTree<Integer> bSearchTree = new BinarySearchTree<>(createNodeFig_9_5_a());
        bSearchTree.delete(5);
        logger.info(bSearchTree.toString());
        assertNull(bSearchTree.search(5));
    }



    /**
        9.6 자식이 하나인 노드를 삭제  (7를 삭제하면..)

                         20
                       /   \
                     7      23
                   /  \       \
                 4    18       29
               /  \     \
              2   5     10
                         \
                          15

     */
    Node<Integer> createNodeFig_9_6_a() {
        Node<Integer> root = new Node<>(20);
        Node<Integer> a = new Node<>(7);
        Node<Integer> b = new Node<>(23);
        Node<Integer> c = new Node<>(4);
        Node<Integer> d = new Node<>(18);
        Node<Integer> e = new Node<>(29);
        Node<Integer> f = new Node<>(2);
        Node<Integer> g = new Node<>(5);
        Node<Integer> h = new Node<>(10);
        Node<Integer> i = new Node<>(15);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        b.right = e;

        c.left = f;
        c.right = g;

        d.left = h;
        h.right = i;

        return root;
    }

    /**
     [ 10 || 20 || 23 ]
     [ 4 || 10 || 18 ]
     [ 2 || 4 || 5 ]
     [ null || 2 || null ]
     [ null || 5 || null ]
     [ 15 || 18 || null ]
     [ null || 15 || null ]
     [ null || 23 || 29 ]
     [ null || 29 || null ]

                  20
                /    \
               10    23
             /   \     \
            4     18    29
          /  \    /
         2   5   15

     */
    @Test
    void testBinarySearchTreeDeleteHasTwoChildNode() {
        BinarySearchTree<Integer> bSearchTree = new BinarySearchTree<>(createNodeFig_9_6_a());
        bSearchTree.delete(7);
        logger.info(bSearchTree.toString());
        assertNull(bSearchTree.search(7));

        assertFalse(bSearchTree.delete(7));
    }


    /**
     9.10 자식이 하나인 노드를 삭제  (5를 삭제하면..)
                9
               /
              5
            /  \
           1   7
              / \
             6   8
     */
    Node<Integer> createNodeFig_9_10_a() {
        Node<Integer> root = new Node<>(9);
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(1);
        Node<Integer> c = new Node<>(7);
        Node<Integer> d = new Node<>(6);
        Node<Integer> e = new Node<>(8);

        root.left = a;

        a.left = b;
        a.right = c;

        c.left = d;
        c.right = e;
        return root;
    }

    /**
        [ 6 || 9 || null ]
        [ 1 || 6 || 7 ]
        [ null || 1 || null ]
        [ null || 7 || 8 ]
        [ null || 8 || null ]

                     9
                   /
                  6
                /  \
               1   7
                    \
                     8
     */
    @Test
    void testBinarySearchTreeDeleteHasTwoChildNode02() {
        BinarySearchTree<Integer> bSearchTree = new BinarySearchTree<>(createNodeFig_9_10_a());
        bSearchTree.delete(5);
        logger.info(bSearchTree.toString());
        assertNull(bSearchTree.search(5));
    }

    /**
     * 이진 트리를 중위순회하면 모든 요소를 오름차순으로 표시할 수 있다.
     */
    @Test
    void testShowAll() {
        BinarySearchTree<Integer> bSearchTree = new BinarySearchTree<>(createNodeFig_9_6_a());
        assertEquals(":2::4::5::7::10::15::18::20::23::29:",bSearchTree.showAll());
    }



    /**
     deleteMin 함수에서 isLeftChild 가 아닐 경우를 확인하기 위한 테스트
     5를 삭제한다고 할 때,...
     삭제하려는 노드가  양쪽 자식은 가지고 있지만...
                 9
                /
               5
             /  \
            1   7
                 \
                  8
     */
    Node<Integer> createNodeFig_custom_01() {
        Node<Integer> root = new Node<>(9);
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(1);
        Node<Integer> c = new Node<>(7);
        Node<Integer> d = new Node<>(8);

        root.left = a;

        a.left = b;
        a.right = c;

        c.right = d;
        return root;
    }

    /**
        [ 7 || 9 || null ]
        [ 1 || 7 || 8 ]
        [ null || 1 || null ]
        [ null || 8 || null ]

                9
              /
             7
           /  \
         1     8

     */
    @Test
    void testBinarySearchTreeDeleteHasTwoChildNode03() {
        BinarySearchTree<Integer> bSearchTree = new BinarySearchTree<>(createNodeFig_custom_01());
        bSearchTree.delete(5);
        logger.info(bSearchTree.toString());
        assertNull(bSearchTree.search(5));
    }


}