## Chapter 06 트리 구조

### 6.1 트리 구조란?
* 계층 관계를 표현하기 위한 자료구조
* 노드의 집합에 대해 계층 관계를 부여한 것
* 루트는 가장 위에 위치함
* 리프(leaf): 자식이 없는 노드 (terminal node, external node) 
* 내부노드: 리프가 아닌 노드 (internal node, non-terminal node, branch node)
* 형제(sibling): 같은 부모를 가지는 노드 
* 루트 이외의 노드는 반드시 하나의 부모를 가짐
* 노드는 단 하나의 부모만 가질 수 있다

* Fig 6.3에서는 한번 갈려진 관계가 다시 합쳐지는 부분이 있는데,  
이것은 트리가 아님, 그래프(graph)임
  
* 서브 트리: 어떤 노드의 자식을 루트로 하는 트리
* 레벨 (level): 부자 관계에서 자식쪽으로 하나 내려갈 때마다 레벨을 1씩 증가

#### 정의
1. 하나의 노드는 그 자체가 트리이다, 이 트리에 포함되는 단 하나의 노드가 이 트리의 루트이다.
2. k개의 트리 T<sub>1</sub>~T<sub>k</sub> 가 있고, 각각의 루트를 노드 n<sub>i</sub> ~ n<sub>k</sub> 라고 한다.  
   노드 n을 노드 n<sub>i</sub> ~ n<sub>k</sub>의 부모로 하면, 노드 n을 루트로 하는 새로운 트리 T를 얻을 수 있다.  
   이 때 트리 T<sub>1</sub>~T<sub>k</sub> 는 트리 T의 서브 트리(subtree)가 된다.  
   서브 트리의 루트 n<sub>i</sub> ~ n<sub>k</sub> 는 노드 n의 자식이라고 한다.

* null tree: 노드가 전혀없는 경우 


### 6.2 순서 트리와 무순서 트리
* 순서트리 (ordered tree): 형제 간에 순서를 매긴 트리, 순서 트리에서는 형제 순번이 다르면 완전히 다른 트리로 간주.  
  무 순서였다면 같게봄.

* 무순서 트리 (unordered tree, oriented tree):  
  부자 관계만 일치하면 형제의 위치가 다르더라도 같은 트리로 간주함.

* 트리를 자료구조로 구현할 때는 어떠한 순서로 노드를 나열하여,  
  특별한 언급이 없다면 트리는 순서 트리로 생각하자. (이 책에서...)

### 6.3 이진 트리
#### 이진 트리 정의 (binary tree)
1. 빈 트리는 이진 트리이다.
2. 다음 중 어느 한 조건을 만족하는 노드로만 이루어진 트리는 이진 트리이다.
    * 자식을 가지지 않음
    * 왼쪽 자식만 가짐
    * 오른쪽 자식만 가짐
    * 죄우 두 개의 자식을 가짐

* 이진 트리의 클래스 정의 예시
    ```java
    class BinaryTreeNode {
        BinaryTreeNode left;  // 왼쪽 서브트리
        BinaryTreeNode right; // 오른쪽 서브트리
        Object label; // 이 노드의 라벨
    }
    ```

### 6.4 트리 순회
* 순회 (traverse)
트리의 모든 노드를 빠짐 없이 조사하여 각 노드를 한 번씩 방문하는 것
#### 6.4.1 트리 순회
*이진 트리를 순회 하는 방법*
* 전위 순회 (preorder)
    1. 노드를 방문한다.
    2. 왼쪽 서브 트리를 순회한다.
    3. 오른쪽 서브 트리를 순회한다.
    
* 중위 순회 (inorder)
    1. 왼쪽 서브 트리를 순회한다.
    2. 노드를 방문한다.
    3. 오른쪽 서브 트리를 순회한다.
    
* 후위 순회 (postorder) 
    1. 왼쪽 서브트리를 순회한다.
    2. 오른쪽 서브 트리를 순회한다.
    3. 노드를 방문한다.
    
*보통 트리를 순회하는 과정*    
* 전위 순회
    1. 노드를 방문한다.
    2. 왼쪽부터 차례대로 모든 서브트리를 순회한다. (왼쪽 모두 보고, 오른쪽 모두 본 뒤)
* 중위 순회
    1. 가장 왼쪽 서브트리를 순회한다.
    2. 노드를 방문한다.
    3. 왼쪽에서 두 번째 이후 서브 트리를 순서대로 순회한다.
* 후위 순회
    1. 왼쪽부터 차례대로 모든 서브트리를 순회한다. (왼쪽 모두 보고, 오른쪽 모두 본뒤에)
    2. 노드를 방문한다.
    
#### 6.4.2 전위 순회
* BinaryTreeNode, BinaryTreeNodeTest.testTraversePreorder 참조 

#### 6.4.3 중위 순회
* BinaryTreeNode, BinaryTreeNodeTest.testTraverseInorder 참조

#### 6.4.4 후위 순회
* BinaryTreeNode, BinaryTreeNodeTest.testTraversePostorder 참조

#### 6.4.5 이진 트리 순회 메서드 
* BinaryTreeNode, BinaryTreeNodeTest 참조



### 6.5 수식 트리
* FormulaTreeTest 참조



### 6.6 트리의 구현
* 일반트리는 임의의 자식을 가질 수 있어, 모든 자식으로의 링크를 노드가 가지게 할 수는 없다.
    * 그래서 연결 리스트를 이용함. 노드 하나하나에 자식을 연결한 연결리스트를 가지게함.

* 트리 표현의 공통 단점
    * 어떤 주어진 노드의 부모를 알 수 있는 수단이 없다.
    * 어떤주어진 노드의 형(왼쪽 형제)를 알 수단이 없다.  


그러나 트리 구조를 이용하는 알고리즘에서는 .. 
`루트에서 시작하여 트리를 재귀적으로 순회한다.` 는 처리를 하는 경우가 대부분이긴함.
