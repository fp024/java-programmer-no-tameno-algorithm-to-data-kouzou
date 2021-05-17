package org.fp024.study.algorithm.part03.chapter09;

import lombok.extern.slf4j.Slf4j;

/**
 * 이진 탐색트리
 */
@Slf4j
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
        Node<T> lastVisitedParentNode = null;

        for (Node<T> node = this.root; node != null; ) {
            // Node를 찾는 for루프에서 마지막 not null 이 아닌
            // node 대입이 결국 지금 들어갈 키의 부모라고 생각해서 그렇했다.
            // node 값을 자식노드로 바꾸기전에 수행해야함.
            lastVisitedParentNode = node;

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
        if (lastVisitedParentNode == null) {
            this.root = newNode;
        } else if (lastVisitedParentNode.data.compareTo(key) < 0) {
            lastVisitedParentNode.right = newNode;
        } else {
            lastVisitedParentNode.left = newNode;
        }

        return newNode;
    }


    /**
     * 이진 트리에서 키 값이 key인 노드를 삭제한다.
     *
     * @param key 삭제할 키
     * @return 삭제에 성공하면 true, 요소가 존재하지 않으면 false를 반환
     */
    public boolean delete(T key) {
        // 검색되었을 경우 삭제할 key의 부모노드.
        Node<T> lastVisitedParentNode = null;
        boolean isLeftChild = false;

        for (Node<T> node = this.root; node != null; ) {
            int compareResult = node.data.compareTo(key);
            if (compareResult == 0) { // 삭제할 대상을 찾음
                // 1. 삭제할 노드가 자식이 없는 leaf 노드
                if (node.left == null && node.right == null) {
                    if (lastVisitedParentNode == null) {
                        this.root = null;
                    } else if (isLeftChild) {
                        lastVisitedParentNode.left = null;
                    } else {
                        lastVisitedParentNode.right = null;
                    }
                } else if (node.left == null) {
                    // 2-1. 삭제할 노드의 자식이 오른쪽만 있음
                    if (lastVisitedParentNode == null) {
                        this.root = node.right;
                    } else if (isLeftChild) {
                        lastVisitedParentNode.left = node.right;
                    } else {
                        lastVisitedParentNode.right = node.right;
                    }
                } else if (node.right == null) {
                    // 2-2. 삭제할 노드의 자식이 왼쪽만 있음
                    if (lastVisitedParentNode == null) {
                        this.root = node.left;
                    } else if (isLeftChild) {
                        lastVisitedParentNode.left = node.left;
                    } else {
                        lastVisitedParentNode.right = node.left;
                    }
                } else { // (중요) 좌우 2개의 자식을 가지고 있음.
                    // 오른쪽 서브트리의 가장 작은 요소를 제거한 뒤 변수에 넣는다.
                    logger.debug("\n====변경전====\n{}\n========\n", toString(root));
                    
                    Node<T> minNodeOfTargetRight = deleteMin(node, node.right);

                    logger.debug("\n====최소노드삭제 후====\n{}\n========\n", toString(root));
                    // 현재 처리
                    if (lastVisitedParentNode == null) {
                        this.root = minNodeOfTargetRight;
                    } else if (isLeftChild) {
                        lastVisitedParentNode.left = minNodeOfTargetRight;
                    } else {
                        lastVisitedParentNode.right = minNodeOfTargetRight;
                    }

                    logger.debug("\n====부모에 연결후 ====\n{}\n========\n", toString(root));

                    minNodeOfTargetRight.left = node.left;
                    minNodeOfTargetRight.right = node.right;

                    logger.debug("\n====신규노드에 삭제 노드의 좌/우 연결 후====\n{}\n========\n", toString(root));
                }
                return true; // 삭제에 성공함.
            } else if (compareResult < 0) {  // 비교 node가 key보다 작음
                // 순서가 중요하다. 노드를 갱신하기 전에 최종 방문 노드를 저장해야한다.
                lastVisitedParentNode = node;
                node = node.right;
                isLeftChild = false;
            } else { // 비교 node가 key보다 큼
                lastVisitedParentNode = node;
                node = node.left;

                isLeftChild = true;
            }
        }
        return false;
    }


    /**
     * 이진 탐색 트리에서 가장 작은 요소를 삭제한다.
     * parent 는 삭제 대상의 노드
     * p는 삭제대상 노드의 오른쪽 노드
     *
     * @param parent node의 부모노드
     * @param p      이진 탐색트리 (p를 루트로 시작하는 서브트리로 이해하자!)
     *               node 노드로 시작하는 트리에서 가장 작은 값을 찾는 것
     * @return 삭제한 노드
     */
    private Node<T> deleteMin(Node<T> parent, Node<T> p) {
        boolean isLeftChild = false;
        // p가 parent의 왼쪽 자식이라면 true,
        // 오른쪽 자식이라면 false,
        // 메서드가 호출한 시점에서는
        // p가 parent의 오른쪽 자식이기 때문에, 초기값은 false 이다.

        while (p.left != null) {
            parent = p;
            isLeftChild = true;
            p = p.left;
        }

        if (isLeftChild) {  // 가장 작은 요소 제거
            parent.left = p.right;
        } else { // 내부에서 호출할 때는
            parent.right = p.right;
        }
        return p;
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

    /**
     * 이진 탐색 트리를 중위 순회
     */
    private String inorder(Node<T> p) {
        if (p == null) {
            return "";
        } else {
            return inorder(p.left) + ":" + p.data + ":" + inorder(p.right);
        }
    }

    /**
     * 이진 탐색 트리의 모든 요소를 오름 차순으로 표시한다.
     */
    public String showAll() {
        return inorder(root);
    }

}


