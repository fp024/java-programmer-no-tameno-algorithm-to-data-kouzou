package org.fp024.study.algorithm.part02.chapter06;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString // 순환이 안되기 때문에 exclude 설정이 필요한 부분은 없다.
class BinaryTreeNode<T> {
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private final T label;

    public BinaryTreeNode(T label) {
        this.label = label;
    }

    public BinaryTreeNode(T label, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.label = label;
        this.left = left;
        this.right = right;
    }

    /**
     * 이진 트리를 전위 순회한다.
     * 저자님은 방문순서를 화면 출력했는데 ..
     * 트리 방문 순서대로 List에 저장하고 JUnit에서 검증하자!
     *
     * @param p 순회할 이진 트리
     * @return 방문 순서대로 저장된 라벨 목록
     */
    static <T> void traversePreorder(BinaryTreeNode<T> p, List<T> labelList) {
        if (p == null) { // 트리가 비었다면 순회하지 않음. 재귀 탈출조건
            return;
        }
        labelList.add(p.getLabel());
        traversePreorder(p.getLeft(), labelList);
        traversePreorder(p.getRight(), labelList);
    }


    /**
     * 이진 트리를 중위 순회한다.
     *
     * @param p 순회할 이진 트리
     * @return 방문 순서대로 저장된 라벨 목록
     */
    static <T> void traverseInorder(BinaryTreeNode<T> p, List<T> labelList) {
        if (p == null) { // 트리가 비었다면 순회하지 않음. 재귀 탈출조건
            return;
        }
        traverseInorder(p.getLeft(), labelList);
        labelList.add(p.getLabel());
        traverseInorder(p.getRight(), labelList);
    }


    /**
     * 이진 트리를 후위 순회한다.
     *
     * @param p 순회할 이진 트리
     * @return 방문 순서대로 저장된 라벨 목록
     */
    static <T> void traversePostorder(BinaryTreeNode<T> p, List<T> labelList) {
        if (p == null) { // 트리가 비었다면 순회하지 않음. 재귀 탈출조건
            return;
        }
        traversePostorder(p.getLeft(), labelList);
        traversePostorder(p.getRight(), labelList);
        labelList.add(p.getLabel());
    }

}
