## Chapter 05 연결 리스트

### 5.1 연결 리스트

#### 5.1.1 연결 리스트란?
* 리스트에 포함된 각 요소들을 링크(link) 로 이어붙인 리스트
    ```java
    class Cell {
        Cell next;
        MyData value;
    }
    ```
    * 링크 방문
        ```
        for (Cell p = header; p != null; p=p.next) {
            System.out.println(p.value);
        }
        ```
    
#### 5.1.2 연결 리스트의 기본적인 성질
* 중간의 요소 방문 O(n)
* 처음의 요소 방문 O(1)
* 셀 하나당 참조 하나분의 메모리가 별도로 필요

* 장점
    * 삽입과 삭제가 간단함
    * (삽입/삭제할 셀의 참조를 알고있다면) 그 시점부터 삭제 삽입은 O(1) 
#### 5.1.3 연결 리스트의 조작



* Fig 5.3 에서의 삭제 설명과 관련해서..
    1. x다음의 삭제할 노드를 p라는 참조에 보관  
       `p = x.next`
    2. x의 next에 p.next 를 할당
       `x.next = p.next`
    3. (책에는 언급이 없지만...) 그러면 이때. p의 value와 next 및 p자체를 null로 비우면 되는것인지?  
       이렇게 까지 해야하는지?
       ```
       p.value = null
       p.next = null
       p = null
       ```
    
* 연결 리스트에서 어떤 요소를 지정하여 삭제하는 것은 불가능
* 삽입시 지정한 요소 뒤에 삽입하는 것은 간단하지만, 앞에 삽입하는 것은 불가능

#### 5.1.3 연결 리스트의 조작
* Cell, CellTest 참조
* 요소의 삭제
    * CellTest.testRemoveCell()
* 경계 조건의 취급
    * MyLinkedList
* Generic 을 적용해봄

#### 5.1.4 연결 리스트에 대한 이터레이터
* MyLinkedList.MyLinkedListIterator 참조



### 5.2 순환 리스트
* 연결리스트의 마지막 참조의 다음요소가 처음요소를 참조

#### 5.2.1 순환 리스트란?
* 요소가 고리형태로 결합되어있어 엄밀하게 말하면 처음이나 마지막 요소란느 것은 없다.

#### 5.2.2 순환 리스트의 조작
```java
class CellCircular {
    CellCircular next;
    int value;
}
```
* next: 다음 셀로의 링크
* value: 셀의 값

```
CellCircular ptr;
```
* ptr:  순환 리스트의 링크를 대입
    * ptr이 null이라면 순환 리스트는 비어있는 것으로 간주

#### 5.2.3 리스트의 헤드를 이용한 순환 리스트
* PureCellCircularTest, CellCircularTest 참조



### 5.3 이중 연결 리스트
* 다음 셀로의 링크 뿐만 아니라 앞의 셀의 링크도 가진 리스트

#### 5.3.1 이중 연결 리스트란?
* 리스트의 앞뒤로 자유롭게 이동할 수 있음
* 지정한 셀, 또는 지정한 셀의 앞의 요소 삭제도 가능함
* 연결리스트에 비해 여분의 링크가 하나 더 필요 (전방 탐색용)

#### 5.3.2 이중 연결 리스트의 조작
* CellDoubleTest 참조
    * 저자님이 리스트의 head 를 이용했다.
        * 순환 리스트로 되어있고, 마지막 요소의 next가 head를 참조함

#### 5.3.3 이중 연결 리스트의 구현
* MyDoublyLinkedList, MyDoublyLinkedListTest 참조
* MyStack2, MyStack2Test 참조
