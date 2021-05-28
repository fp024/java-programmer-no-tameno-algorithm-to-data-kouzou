package org.fp024.study.algorithm.part03.chapter10;

/**
 * B 트리
 * <p>
 * 내가 현시점 코드이해가 잘 안되어서,... 제네릭으로 미리 바꾸진 말고, 기존 코드를 최대한 유지하자.
 * 테스트용 메인 루틴은 main 메서드의 stdin 키입력으로 테스트하는 것 대신, JUnit으로 확인해보자!
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
     * delete 메서드 또는 insert 메서드를 호출하면 이 변수는 초기화된다.
     */
    private Leaf currentLeaf;

    /**
     * 5단 B 트리
     */
    final private static int MAX_CHILD = 5;

    final private static int HALF_CHILD = ((MAX_CHILD + 1) / 2);

    /**
     * deleteAux 메서드의 반환값
     * 저자님은 JDK 1.4 환경이여서 정적 상수로 선언하셨지만, 그 이후 JDK환경은 enum이 가능하니 enum을 쓰자!
     */
    enum DeleteResult {
        /**
         * 삭제 성공. thisNode에는 아무런 변화도 없음
         */
        OK,

        /**
         * 삭제 성공. thisNode 자체가 삭제됨
         */
        OK_REMOVED,

        /**
         * 삭제 성공. thisNode 의 자식이 없어졌기 때문에 (HALF_CHILD 이하) 재편성이 필요해졌다.
         */
        OK_NEED_REORG,

        /**
         * 삭제 실패. 키 값이 key인 자식을 발견하지 못했다.
         */
        NOT_FOUND
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
         * 서브 트리
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
         * B트리의 m이 크다면 이부분은 이진 탐색을 사용하는 것이 좋음.
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
        currentLeaf = null;

        // 비어있는 트리라면 바로 false 를 반환
        if (root == null) {
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
     * 실행된 경우에는 false 반환
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
    private class InsertAuxResult {
        /**
         * 새로 노드를 만든 경우에, 그 노도가 들어간다.
         */
        Node newNode;

        /**
         * 새로운 노드를 만든 경우에, newNode가 가리키는
         * 서브 트리의 최소 요소가 들어간다.
         */
        Comparable lowest;

        private InsertAuxResult(Node aNewNode, Comparable theLowest) {
            this.newNode = aNewNode;
            this.lowest = theLowest;
        }
    }

    /**
     * 지정한 노드에 대해 키 값이 key인 요소를 삽입한다. (insert가 호출)
     *
     * @param pNode 내부 노드 pNode의 nth 번째 자식에 대해 삽입 처리를 한다.
     *              pNode가 null 인 경우에는 루트를 대상으로 한다.
     * @param nth   내부 노드 pNode의 nth번째 자식에 대해 삽입 처리를 한다.
     * @param key   삽입할 요소의 키
     * @param data  삽입할 요소의 데이터
     * @return 결과를 표시하는 InsertAuxResult 형의 객체, 키 key가 이동 되었다면 null
     */
    private InsertAuxResult insertAux(InternalNode pNode, int nth, Comparable key, Object data) {
        InsertAuxResult result;
        Node thisNode;

        // 요소의 삽입 대상이 되는 노드로의 링크를 변수 thisNode에 넣는다.
        if (pNode == null) {
            thisNode = root;
        } else {
            thisNode = pNode.child[nth];
        }

        if (thisNode instanceof Leaf) { // 이 노드는 리프이다.
            // 앞으로 이 노드를 리프 leaf로 참조한다.
            Leaf leaf = (Leaf) thisNode;


            if (leaf.key.compareTo(key) == 0) { // 이미 등록되어 있다면 아무것도 하지 않고 null을 반환
                return null;
            } else { // 새로운 리프 newLeaf를 할당한다
                Leaf newLeaf = new Leaf(key, data);

                // 만약, 할당된 리프 newLeaf가 리프 leaf보다 작다면
                // newLeaf와 leaf를 교환한다.
                if (key.compareTo(leaf.key) < 0) {
                    // 원래 노드에는 새롭게 할당된 newLeaf를 넣는다.
                    if (pNode == null) {
                        root = newLeaf;
                    } else {
                        pNode.child[nth] = newLeaf;
                    }

                    // leaf가 새롭게 할당된 리프라는 것을 알린다.
                    result = new InsertAuxResult(leaf, leaf.key);

                } else {
                    // newLeaf가 새롭게 할당된 리프라는 것을 알린다.
                    result = new InsertAuxResult(newLeaf, key);
                }
                return result;
            }
        } else {
            // 이 노드는 내부 노드이다.
            // 앞으로 이 노드를 내부 노드 node로 참조한다.
            InternalNode node = (InternalNode) thisNode;

            int pos; // 몇번째 서브트리에 삽입할 것 인가?

            // 어느 서브 트리에 삽입할지를 구한다.
            pos = node.locateSubtree(key);

            // 서브 트리에 대해, 자기 자신을 재귀호출한다.
            result = insertAux(node, pos, key, data);

            // 만약 분할이 이루어지지 않았다면 그대로 돌아간다.
            if (result == null || result.newNode == null) {
                return result;
            }

            // 분할이 이루어 졌기 때문에, 노드 node에 그것 (result.newNode)를 삽입한다.
            // 노드 node에 추가할 수 있는가?
            if (node.nChilds < MAX_CHILD) {
                // 추가할 수 있다면 적절한 위치에 삽입한다.
                for (int i = node.nChilds - 1; i > pos; i--) {
                    node.child[i + 1] = node.child[i];
                    node.low[i + 1] = node.low[i];
                }

                node.child[pos + 1] = result.newNode;
                node.low[pos + 1] = result.lowest;
                node.nChilds++;
                return new InsertAuxResult(null, null);
            } else {
                // 추가할 수 없기 때문에 노드 node를 2개로 분할 해야한다.
                // 새로운 내부 노드 newNode를 할당한다.
                InternalNode newNode = new InternalNode();

                // 노드 result.newNode가 어느쪽 노드에 삽입되는 가에 따라 개별 처리한다.
                if (pos < HALF_CHILD - 1) {
                    // 노드 result.newNode는 노드 node 쪽에 삽입된다.
                    // 우선 HALF_CHILD - 1 ~ MAX_CHILD - 1 번째 서브 트리를,
                    // 노드 node에서 노드 newNode로 옮긴다.
                    for (int i = HALF_CHILD - 1, j = 0; i < MAX_CHILD; i++, j++) {
                        newNode.child[j] = node.child[i];
                        newNode.low[j] = node.low[i];
                    }
                    // 0~HALF_CHILD-2번째 서브 트리 사이의 적절한 위치에
                    // 노드 result.newNode를 삽입한다.
                    for (int i = HALF_CHILD - 2; i > pos; i--) {
                        node.child[i + 1] = node.child[i];
                        node.low[i + 1] = node.low[i];
                    }
                    node.child[pos + 1] = result.newNode;
                    node.low[pos + 1] = result.lowest;
                } else {
                    // 노드 result.newNode는 노드 newNode 쪽에 삽입된다.
                    // HALF_CHILD ~ MAX_CHILD-1번째 서브 트리를
                    // 노드 newNode로 이동한다. 동시에, 노드 result.newNode를
                    // 적절한 위치에 삽입한다.
                    int j = MAX_CHILD - HALF_CHILD;
                    for (int i = MAX_CHILD - 1; i >= HALF_CHILD; i--) {
                        if (i == pos) {
                            newNode.child[j] = result.newNode;
                            newNode.low[j--] = result.lowest;
                        }
                        newNode.child[j] = node.child[i];
                        newNode.low[j--] = node.low[i];
                    }
                    if (pos < HALF_CHILD) {
                        newNode.child[0] = result.newNode;
                        newNode.low[0] = result.lowest;
                    }
                }
                // 자식수 nChild를 갱신한다.
                node.nChilds = HALF_CHILD;
                newNode.nChilds = (MAX_CHILD + 1) - HALF_CHILD;

                // 분할하여 만들어진 노드를 필드 newNode에,
                // 또 그 최소값을 lowest 필드에 반환한다.
                return new InsertAuxResult(newNode, newNode.low[0]);
            }
        }
    }

    /**
     * B 트리에 요소를 삽입한다.
     *
     * @param key  삽입할 요소의 키
     * @param data 삽입할 요소의 데이터
     * @return 요소의 삽입에 성공하였다면 true, 이미 키 값이 key인 요소가 등록되어있다면
     * 아무것도 하지 않고 false를 반환
     */
    public boolean insert(Comparable key, Object data) {
        // currentLeaf 필드를 null로 한다.
        currentLeaf = null;

        // 트리가 비어있는 경우에는 리프를 만들고 true를 반환한다.
        if (root == null) {
            root = new Leaf(key, data);
            return true;
        } else {
            // 트리가 비어있지 않은 경우에는 insertAux 메서드를 호출하여
            // 요소를 삽입한다.
            InsertAuxResult result = insertAux(null, -1, key, data);

            // 만약 결과가 null, 이라면 키 key는 등록되어 있기 때문에
            // 그냥 false 를 반환한다.
            if (result == null) {
                return false;
            }
            // 만약 분할 되었다면 트리의 높이를 1단 높인다.
            if (result.newNode != null) {
                InternalNode newNode = new InternalNode();
                newNode.nChilds = 2;
                newNode.child[0] = root;
                newNode.child[1] = result.newNode;
                newNode.low[1] = result.lowest;
                root = newNode;
            }
            return true;
        }
    }

    /**
     * 내부 노드 p의 x번째의 x+1번째 서브 트리를 재편성한다.
     * 만약 병합이 필요하다면 모든 요소를 x번째 부분 트리에 모으고
     * true를 반환한다. 병합이 필요하지 않다면 false를 반환한다.
     *
     * @param p 내부 노드 p
     * @param x 내부 노드 p의 x번째와 x+1번째 부분 트리를 재편성한다
     * @return 병합이 필요하다면 true, 필요하지 않다면 false
     */
    private boolean mergeNodes(InternalNode p, int x) {
        InternalNode a; // x번째 서브 트리
        InternalNode b; // x+1번째 서브 트리
        int an; // 부분 트리 a의 자식 수
        int bn; // 부분 트리 b의 자식 수

        a = (InternalNode) p.child[x];
        b = (InternalNode) p.child[x + 1];
        b.low[0] = p.low[x + 1];
        an = a.nChilds;
        bn = b.nChilds;

        if (an + bn <= MAX_CHILD) {
            // 부분 트리 a와 b를 병합해야 한다.
            // b의 자식을 모두 a로 이동한다
            for (int i = 0; i < bn; i++) {
                a.child[i + an] = b.child[i];
                b.child[i] = null; // 불필요한 참조를 제거한다.
                a.low[i + an] = b.low[i];
            }
            a.nChilds += bn;  // 자식 수를 갱신한다.
            // ### 여기서 b를 해제 한다. ###
            return true;    // 병합했다는 사실을 알린다.
        } else {
            // 서브트리 a와 b에 대해 노드를 재분배한다.
            int move; // 이동할 요소의 개수

            // 서브 트리 a에 분배할 자식의 수를 구한다.
            int n = (an + bn) / 2;
            if (an > n) {
                // 서브 트리 a에서 서브트리 b로 이동한다.
                move = an - n;  // move개의 자식을 a에서 b로 옮긴다

                // b의 요소를 오른쪽으로 모은다.
                for (int i = bn - 1; i >= 0; i--) {
                    b.child[i + move] = b.child[i];
                    b.low[i + move] = b.low[i];
                }

                // a에서 b로 move개의 자식을 이동한다.
                for (int i = 0; i < move; i++) {
                    b.child[i] = a.child[i + n];
                    a.child[i + n] = null;    // 불필요한 참조를 제거한다.
                    b.low[i] = a.low[i + n];
                }
            } else {
                // 서브 트리에서 b에서 서브트리 a로 이동한다.
                move = n - an; // move 개의 자식을 b에서 a로 옮긴다.
                // b에서 a로 move 개의 자식을 이동한다.
                for (int i = 0; i < move; i++) {
                    a.child[i + an] = b.child[i];
                    a.low[i + an] = b.low[i];
                }

                // b 요소를 왼쪽으로 모은다.
                for (int i = 0; i < bn - move; i++) {
                    b.child[i] = b.child[i + move];
                    b.child[i + move] = null; // 불필요한 참조를 제거한다.
                    b.low[i] = b.low[i + move];
                }
            }
            // 자식 개수를 갱신한다.
            a.nChilds = n;
            b.nChilds = an + bn - n;
            // 서브 트리 b의 최소 값을 노드 p에 저장한다.
            p.low[x + 1] = b.low[0];
            return false;
        }
    }

    /**
     * 노드 thisNode 에서 키 값이 key인 요소를 삭제한다. (delete 가 호출)
     *
     * @param thisNode 이 노드 (또는 그 서브트리)에서 요소를 삭제한다.
     * @param key      삭제할 요소의 키
     * @return 이하의 값을 반환한다 {@link DeleteResult}
     */
    private DeleteResult deleteAux(Node thisNode, Comparable key) {
        if (thisNode instanceof Leaf) { // 이 노드는 리프이다
            // 이 노드는 리프이다
            // 앞으로 이 노드를 리프 leaf로 참조한다
            Leaf leaf = (Leaf) thisNode;

            // 이 리프의 키와 key가 같다면 삭제한다.
            if (leaf.key.compareTo(key) == 0) {
                // ### 여기서 leaf를 해제한다 ###
                return DeleteResult.OK_REMOVED;
            } else {
                // 키가 일치하지 않음. 즉, 주어진 키를 가지고 있는
                // 요소가 존재하지 않음
                return DeleteResult.NOT_FOUND;
            }
        } else { // 이 노드는 내부 노드이다.
            // 앞으로 이 노드를 내부 노드 node로 참조한다.
            InternalNode node = (InternalNode) thisNode;

            int pos;    // 몇 번째 서브 트리에서 삭제할 것인가?
            boolean joined = false;  // 재편성 결과 서브 트리가 병합 되었는가?

            // 어느 서브 트리에서 삭제할 것인지 구한다.
            pos = node.locateSubtree(key);

            // 그 서브 트리에 대해, 자기 자신을 재귀 호출한다
            DeleteResult result = deleteAux(node.child[pos], key);

            // 서브 트리에 아무런 변화가 없다면 그대로 돌아간다
            if (result == DeleteResult.NOT_FOUND || result == DeleteResult.OK) {
                return result;
            }

            // 서브 트리에 pos를 재편성할 필요가 있는가?
            if (result == DeleteResult.OK_NEED_REORG) {
                // 서브트리 sub와 sub+1을 재편성한다
                int sub = (pos == 0) ? 0 : pos - 1;
                joined = mergeNodes(node, sub);

                // 만약, sub와 sub+1이 병합되었다면 서브 트리 sub+1을
                // node에서 삭제할 필요가 있다.
                if (joined) {
                    pos = sub + 1;
                }
            }

            DeleteResult myResult = DeleteResult.OK;    // 이 메서드가 반환할 값, 일단 OK로 둔다

            // 서브 트리 pos가 삭제되었다
            if (result == DeleteResult.OK_REMOVED || joined) {
                // node의 서브 트리를 모은다
                for (int i = pos; i < node.nChilds - 1; i++) {
                    node.child[i] = node.child[i + 1];
                    node.low[i] = node.low[i + 1];
                }

                node.child[node.nChilds - 1] = null; // 불필요한 참조를 제거한다.
                // 만약, node의 서브 트리의 수가 HALF_CHILD 보다 작다면
                // 재편성이 필요하다.
                if (--node.nChilds < HALF_CHILD) {
                    myResult = DeleteResult.OK_NEED_REORG;
                }
            }
            return myResult;
        }
    }


    /**
     * B 트리에서 요소를 삭제한다
     *
     * @param key 삭제할 요소의 키
     * @return 삭제에 성공하면 true, 요소가 존재하지 않는다면 false를 반환
     */
    public boolean delete(Comparable key) {
        // currentLeaf 필드를 null로 한다.
        currentLeaf = null;

        // 트리가 비어있다면 아무것도 하지 않는다.
        if (root == null) {
            return false;
        } else {
            // 트리가 비어있지 않은 경우
            // deleteAux 메서드를 호출하여 키 값이 key인 요소를 삭제한다.
            DeleteResult result = deleteAux(root, key);

            // 발견되지 않았으면 false를 반환한다.
            if (result == DeleteResult.NOT_FOUND) {
                return false;
            }

            if (result == DeleteResult.OK_REMOVED) {
                // 루트가 삭제 되었기 때문에 root에 null을 대입한다. (트리가 비었다)
                root = null;
            } else if (result == DeleteResult.OK_NEED_REORG
                    && ((InternalNode) root).nChilds == 1) {
                // 루트의 재편성된 결과, 루트의 자식이 하나가 되었다면
                // 트리의 높이를 1 낮춘다
                // ### Node p = root; ###
                root = ((InternalNode) root).child[0];
                // ### 여기서 p를 해제한다 ###
            }
            return true;
        }
    }

    /**
     * B 트리의 내용을 문자열로 반환
     *
     * @param p 이 노드보다 낮은 부분의 내용을 문자열로 반환
     * @return 노드 p보다 낮은 부분을 나타내는 문자열
     */
    private String toStringAux(Node p) {
        // 리프인지 내부 노드인지에 따라 다르게 처리한다.
        if (p instanceof Leaf) {
            // 리프이다
            Leaf l = (Leaf) p;
            return "Leaf #" + l.serial + " key=" + l.key;
        } else {
            // 내부 노드 이다
            InternalNode n = (InternalNode) p;
            String s = "Node #" + n.serial + " (" +
                    n.nChilds + " children): ";

            s += "#" + n.child[0].serial + " ";
            for (int i = 1; i < n.nChilds; i++) {
                s += "[" + n.low[i] + "] #" + n.child[i].serial + " ";
            }
            s += "\n";

            for (int i = 0; i < n.nChilds; i++) {
                s += toStringAux(n.child[i]) + "\n";
            }
            return s;
        }
    }


    /**
     * B 트리의 내용을 문자열로 반환
     * (실제 처리는 toStringAux가 담당)
     *
     * @return B 트리의 내용
     */
    public String toString() {
        if (root == null) {
            return "<트리는 비어있다>";
        } else {
            return toStringAux(root);
        }
    }
}
