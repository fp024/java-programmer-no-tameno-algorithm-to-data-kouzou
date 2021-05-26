## Chapter 08 해싱

### 8.1 해싱의 원리
* 해싱(hashing)
    * 데이터 규모에 관계없이 삽입, 탐색, 삭제 조작을 실질적으로 O(1)에 할 수 있는 알고리즘
    * 키 값을 데이터가 저장된 위치와 직접 연관지음

### 8.2 충돌
* 충돌: 다른 키에대해 같은 해시값을 생성할 가능성
* 충돌의 해결방법
  1. 체인화(chaining), 연쇄화   
    같은 해시 값을 가지는 데이터를 연결리스트로 연결
  2. 오픈 어드레스법 (open addressing)  
    해시 값에 대응하는 버킷이 이미 차 있다면, 특정 절차에 따라 다른 버킷에 데이터를 저장



### 8.3 체인화

#### 8.3.1 체인화의 원리

#### 8.3.2 체인화 프로그램
* HashChaining, HashChainingTest 참조

#### 8.3.3 체인화의 성질
* 버킷의 수를 B, 등록할 데이터의 수를 N이라고 할 때...
  * 각 버킷에는 평균 N/B 개의 데이터가 들어감.
  * 탐색
    * 버킷을 찾는 비용 O(1)
    * 연결리스트의 선형 탐색 비용 O(N/B)
    * 버킷(B)이 충분히 크다면 O(1+N/B) => O(1)이 됨
    * 버킷에 비해 데이터(N)가 많다면 O(1+N/B) => O(N/B) => O(N)이 됨

* 체인화
  * 연결리스트를 이용한 선형 탐색을 개선한 것으로 볼 수 있음.



### 8.4 오픈 어드레스 법

#### 8.4.1 오픈 어드레스 법의 원리
* 재해싱(rehasing) : 충돌 발생시 미리 정해둔 절차에 따라 다른 버킷에 데이터를 저장
* 해시표의 버킷 저장 내용
  * 체인화
    * 연결리스트의 링크를 해시 표에 등록
  * 오픈 어드레스 법
    * 데이터만 저장
  
* 간단한 재해싱의 예)  
  * h<sub>k</sub> = (h(x) + k) mod B
  

* 삭제시 
  * 데이터를 비우지 않고 `삭제 되었음`으로 마킹
* 탐색시
  * `삭제 되었음` 표시가 된 버킷은 그냥 통과
  * `버킷에 데이터가 들어가 있지만 키 값이 일치하지 않는` 경우와 같이 취급
* 삽입 시
  * `삭제 되었음` 을 `비어있음` 과 동일하게 간주

#### 8.4.2 오픈 어드레스 법 프로그램
* HashOpenAddress, HashOpenAddressTest 참고
  * 버킷이 비어있음을 나타내기 : `EMPTY`
  * 버킷이 삭제되었음을 나타내기 : `DELETED`
    * 버킷 배열 데이터 형 자체로 나타내야 때문의 별도 `enum`을 쓰기엔 애매해보이긴함.


#### 8.4.3 재해싱 방법
* 충돌 해결
  * 재해싱할 때 조사할 버킷을 무작위로 선택하게 하면 연속 버킷 문제를 해결 할 수 있음

* `1`에서 `B - 1` 까지의 수가 반드시 한번만 랜덤하게 출현하는 수열 n<sub>1</sub>, n<sub>2</sub>, ... n<sub>B</sub> 을 준비해두고,
* h<sub>k</sub>(x) = (h(x) + n<sub>k</sub>) mod B  로 한다.
  

#### 8.4.4 오픈 어드레스 법의 수학적 해석
* 이 부분은 다시 볼때 자세히 보자. ㅠㅠ



### 8.5 해시 함수
* `체인화도 오픈 어드레스 법도 해시 함수가 균등한 해시 값을 발생시킨다` 라는 전제를 기본으로 함.
  * 정적 균등을 의미하지 않음.
  * 실제 키로 사용되는 값에 대해 해시 값이 균등하게 분배(동적 균등) 되도록 하는 것이 바람직함



### 8.6 해싱의 응용

#### 8.6.1 해싱의 성질
* 해싱의 뛰어난 성능은 `해시 표가 충분히 크다` 라는 것을 전제로 함.
  * 오픈 어드레스 법을 사용한다면 데이터의 개스를 버킷 개수의 80 ~ 90% 정도가 되게할 필요가 있음
  * 체인화의 경우 탐색속도가 느려지는 것을 무시한다면 얼마든지 데이터를 등록할 수 있음

* 비유를 하면...
  * 체이닝: 기본요금 + 종량제 요금
  * 오픈어드레스: 정액제 요금