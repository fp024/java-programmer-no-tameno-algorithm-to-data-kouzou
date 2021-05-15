package org.fp024.study.algorithm.part03.chapter09;

/**
 * 이진 탐색트리
 */

class BinarySearchTree<T extends Comparable<T>> {
    // 이진 탐색 트리의 루트
    private Node<T> root;

    /**
     * 이진 탐색트리를 생성
     */
    public BinarySearchTree() {
    }

    /**
     * 이진 탐색트리를 생성
     *   삽입기능 만들기전 단위 테스트를 만들기위해
     *   외부로 부터 노드를 받는 생성자도 추가함.
     */
    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    /**
     * 이진 탐색 트리의 노드
     * (참고): static 을 붙이고 안붙이고의 차이?
     * static을 안 붙이면 외곽클래스가 인스턴스화가 되어야 내부클래스 접근이 가능하다.
     */
    static class Node<T extends Comparable<T>> {
        // 이 노드의 라벨
        final T data;
        // 왼쪽 서브 트리
        Node<T> left;
        // 오른쪽 서브 트리
        Node<T> right;

        /**
         * 이진트리의 노드를 생성한다.
         */
        Node(T label) {
            this.data = label;
            this.left = null;
            this.right = null;
        }
    }


    /**
     * 이진 탐색 트리에서 키 값이 key인 노드를 탐색한다.
     *
     * @param key 찾을 키
     * @return 키 값이 key인 노드를 발견하면 그것을 반환하고,
     * 발견하지 못하면 null을 반환
     */
    public Node search(T key) {
        for (Node node = root; node != null; ) {
            int compareResult = node.data.compareTo(key);
            if (compareResult < 0) {  // 비교 node가 key보다 작음
                node = node.right;
            } else if (compareResult > 0) { // 비교 node가 key보다 큼
                node = node.left;
            } else { // 키가 일치하는 노드 발견
                return node;
            }
        }
        return null; // 탐색 실패
    }


}


