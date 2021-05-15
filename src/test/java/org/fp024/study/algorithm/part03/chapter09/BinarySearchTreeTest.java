package org.fp024.study.algorithm.part03.chapter09;

import org.junit.jupiter.api.Test;

import static org.fp024.study.algorithm.part03.chapter09.BinarySearchTree.Node;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * 이진 탐색트리 테스트
 */
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


}