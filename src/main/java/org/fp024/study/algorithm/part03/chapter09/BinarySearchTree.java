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
     * 삽입 기능을 만들기 전, 단위 테스트를 만들기 위해
     * 외부로 부터 노드를 받는 생성자도 추가함.
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

        /**
         * 노드 자신과 자신의 왼쪽, 오른쪽 값을 반환.
         * [ 왼쪽값 || 자신값 || 오른쪽값 ]
         * 왼쪽이나 오른쪽이 없을 경우는 "null" 로 표현
         */
        @Override
        public String toString() {
            String leftData = "null";
            String rightData = "null";
            String myData = String.format("%s", this.data);

            if (this.left != null) {
                leftData = String.format("%s", this.left.data);
            }

            if (this.right != null) {
                rightData = String.format("%s", this.right.data);
            }
            return String.format("\n[ %s || %s || %s ]\n", leftData, myData, rightData);
        }
    }


    /**
     * 이진 탐색 트리에서 키 값이 key인 노드를 탐색한다.
     *
     * @param key 찾을 키
     * @return 키 값이 key인 노드를 발견하면 그것을 반환하고,
     * 발견하지 못하면 null을 반환
     */
    public Node<T> search(T key) {
        for (Node<T> node = root; node != null; ) {
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


    /**
     * 이진 탐색 트리에 키 값이 key인 노드를 삽입한다.
     *
     * @param key 삽입할 키
     * @return 삽입한 키를 가지는 노드로의 링크를 반환
     * 이미 키가 등록되어있다면 null을 반환
     */
    public Node<T> insert(T key) {
        // 입력할 key의 부모노드.
        Node<T> parentNode = null;

        for (Node<T> node = this.root; node != null; ) {
            // Node를 찾는 for루프에서 마지막 not null 이 아닌
            // node 대입이 결국 지금 들어갈 키의 부모라고 생각해서 그렇했다.
            // node 값을 자식노드로 바꾸기전에 수행해야함.
            parentNode = node;

            int compareResult = node.data.compareTo(key);
            if (compareResult < 0) {  // 비교 node가 key보다 작음
                node = node.right;
            } else if (compareResult > 0) { // 비교 node가 key보다 큼
                node = node.left;
            } else {
                return null; // 입력할 키가 이미 일치했다면 null 반환
            }
        }

        Node<T> newNode = new Node<>(key);
        if (parentNode == null) {
            this.root = newNode;
        } else if (parentNode.data.compareTo(key) < 0) {
            parentNode.right = newNode;
        } else {
            parentNode.left = newNode;
        }

        return newNode;
    }

    @Override
    public String toString() {
        return toString(this.root);
    }

    /**
     * 해당 노드의 모든 자식노드를 문자열로 반환
     * 재귀적으로 구현 했다.
     *
     * @param node 출력할 노드
     * @return 해당 노드의 모든 자식노드를 문자열로 반환
     */
    private String toString(Node<T> node) {
        if (node == null) {
            return "";
        }
        String result = "";
        result += node.toString();

        if (node.left != null) {
            result += toString(node.left);
        }

        if (node.right != null) {
            result += toString(node.right);
        }
        return result;
    }

}


