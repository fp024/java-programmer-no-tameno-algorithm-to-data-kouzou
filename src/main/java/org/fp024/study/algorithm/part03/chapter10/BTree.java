package org.fp024.study.algorithm.part03.chapter10;

/**
 * B 트리
 */
class BTree {
    /**
     * 이진 탐색 트리의 루트
     */
    private Node root;

    /**
     * Node에 붙일 일련번호
     */
    private int serialNumber = 0;

    /**
     * search 메서드는 탐색에 성공하면
     * 발견한 리프를 currentLeaf 필드에 저장한다.
     * <p>
     * 발견한 리스트의
     * data 필드의 값을 얻기위해서는 getData 메서드를 사용.
     * data 필드에 값을 넣기 위해서는 setData 메서드를 사용.
     * <p>
     * delete 메서드의 insert 메서드를 호출하면 이 변수는 초기화된다.
     */
    private Leaf currentLeaf;

    /**
     * 5단 B 트리
     */
    final private static int MAX_CHILD = 5;

    final private static int HALF_CHILD = ((MAX_CHILD + 1) / 2);

    /**
     * deleteAux 메서드의 반환값
     */
    enum DeleteResult {
        OK, OK_REMOVED, OK_NEED_REORG, NOT_FOUND;
    }


    /**
     * B 트리의 노드
     */
    private abstract class Node {
        /**
         * 일련번호
         * (B 트리의 처리에는 필요없는 것이지만, toString으로 트리의 내용을 표시할 때 알아보기 쉽도록 한다.)
         */
        int serial;

        // Node 클래스는 추상 클래스이다.
        // 실제 인스턴스는 서브 프로그램인 InternalNode 클래스 (내부노드).
        // 또는 Left 클래스(리프)로 생성한다.
    }


    private class InternalNode extends Node {
        /**
         * 이 노드가 가지고 있는 자식의 수
         */
        int nChilds;

        /**
         * 서브 트리 : 배열대신에 List로 사용해보자.
         * 그러나 B 트리의 제약조건에 의해 배열의 크기는 고정되므로,
         * Arrays.asList(new Node[MAX_CHILD]); 로 만들면 되겠다.
         */
        Node[] child;

        /**
         * 각 서브 트리의 최소 요소
         */
        Comparable[] low;

        /**
         * 생성자: 빈 내부 노드를 생성한다.
         */
        private InternalNode() {
            super.serial = serialNumber++; // 일련 번호를 붙인다.
            this.nChilds = 0;
            this.child = new Node[MAX_CHILD];
            this.low = new Comparable[MAX_CHILD];
        }

        /**
         * 키 값이 key인 데이터는 몇번째 서브트리에 들어가 있는 가를 조사한다.
         *
         * @param key 조사할 키
         * @return key가 몇번째 서브트리에 들어 있는 가를 반환
         */
        private int locateSubtree(Comparable key) {
            for (int i = nChilds - 1; i > 0; i--) {
                if (key.compareTo(low[i]) >= 0) {
                    return i;
                }
            }
            return 0;
        }
    }

    /**
     * B 트리의 리프
     */
    private class Leaf extends Node {
        /**
         * 리프의 키 값
         */
        Comparable key;

        /**
         * 리프에 저장할 데이터
         */
        Object data;

        /**
         * 생성자: 리프를 생성한다.
         *
         * @param aKey  이 리프의 키
         * @param aData 이 리프의 데이터
         */
        private Leaf(Comparable aKey, Object aData) {
            super.serial = serialNumber++; // 일련 번호를 붙인다
            this.key = aKey;
            this.data = aData;
        }
    }


    /**
     * 생성자 : 빈 B 트리를 생성한다.
     */
    public BTree() {
        root = null;
    }

    /**
     * B 트리에서 키 key를 탐색한다.
     * 키 값이 key 인 리프를 발견하면 그것을 currentLeaf 필드에 저장한다.
     * <p>
     * 이 메서드는 탐색의  성공 여부만을 반환한다.
     * 실제로 key에 대응하는 값을 얻기 위해서는 search가 성공한 후에,
     * getData 메서드를 호출할 것, 또, setData 메서드를 호출하면,
     * 키 key에 대응하는 값을 변경할 수 있다.
     *
     * @param key 탐색할 키
     * @return 키 값이 key인 리프를 발견했으면 true, 발견하지 못했으면 false를 반환
     */
    public boolean search(Comparable key) {
        // currentLeaf 필드를 null 로 한다.
        this.currentLeaf = null;

        // 비어있는 트리라면 바로 false 를 반환
        if (this.root == null) {
            return false;
        } else {
            // 루트에서 시작하여 리프에 도달할 때까지 내부 노드를 순회한다.
            Node p = root;
            int i;
            while (p.getClass() == InternalNode.class) { // 정확한 객체 타입 비교라면 instanceof 보단 getClass()가 낫겠다.
                InternalNode node = (InternalNode) p;
                i = node.locateSubtree(key);
                p = node.child[i];
            }

            // 주어진 키와 리프에 저장되어 있는 키를 비교한다.
            //   <?> 먼저의 while 연산으로 p는 반드시 리프까지 도달한다는 것인지?
            if (key.compareTo(((Leaf) p).key) == 0) {
                // 탐색에 성공했다. 이 리프를 currentLeaf 필드에 저장하고 true를 반환
                currentLeaf = (Leaf) p;
                return true;
            } else {
                return false; // 탐색에 실패하였으므로 false 를 반환
            }
        }
    }


    /**
     * 마지막으로 성공한 search 메서드가 찾은 요소의 데이터를 얻는다.
     *
     * @return 바로 전에 search 된 요소의 데이터 (data 필드 )
     * 바로 전에 search 이외 (insert, delete)가 실행된 경우에는
     * null 을 반환
     */
    public Object getData() {
        if (currentLeaf == null) {
            return null;
        } else {
            return currentLeaf.data;
        }
    }


    /**
     * 마지막으로 성공한 search 메서드가 발견한 요소에 데이터를 저장한다.
     *
     * @param data 저장할 값
     * @return 저장에 성공했다면 true, 바로 전에 search 이외 (insert, delete) 가
     *         실행된 경우에는 false 반환
     */
    public boolean setData(Object data) {
        if (currentLeaf == null) {
            return false;
        } else {
            currentLeaf.data = data;
            return true;
        }
    }


    /**
     * InsertAux 메서드의 결과
     */





}
