## Chapter 02 복잡도

### 2.1 알고리즘 성능의 기준
벤치마크 수행을 통해 실행시간이 짧은 알고리즘이 좋은알고리즘이라 할 수 있지만,  
벤치마크를 실제로 프로그램을 동작하여 평가하는 방법은,  
수행하는 머신, 알고리즘을 구현한 프로그래밍 언어에 따른 차이 때문에 
객관성을 만족할 수 없다.

### 2.2 복잡도
알고리즘의 성능의 표현은 실제 머신을 이용하지 않고, 복잡도(complexity)라는 추상적인 척도를 사용한다.

* 복잡도  
  가상적인 컴퓨터로 어떤 알고리즘을 실행했을 때, 어느정도 시간이 걸리는지를 입력의 크기 n의 함수로서 표현

#### 2.2.1 선형 탐색의 복잡도
* 탐색 (searching)  
  n개의 데이터가 등록되어있는 테이블에서 어떤 특정 키를가지는 데이터를 찾아내는 처리
    
* 복잡도의 덧셈
  * O(f(n))  + O(g(n)) = O(max(f(n),g(n)))

* 복잡도의 곱셈
  * O(f(n)) \* O(g(n)) = O(f(n)g(n)) 

  * ?> O(1) \* (n/2) = O(1) * O(n) = O(n) 의 이유가 최악을 기준으로 해서 그런건가?
  

### 2.2.2 이진 탐색의 복잡도

* 이진 탐색의 복잡도 O(log n)
  * 한번 루프가 반복할 때마다 찾을 범위가 반으로 줄어듬. while루프가 실행되는 회수는 log2 n번 정도가 됨.

  
### 2.2.3 데이터의 등록에 필요한 복잡도
* 이진 탐색시에선 데이터를 넣을 때도 이진 탐색을 해서 위치를 찾아야한다.
* O(n) 의 시간이 걸림


### 2.2.4 선형 탐색과 이진 탐색의 비교
이진 탐색은 '프로그램의 실행 중에 빈번한 데이터 등록을 하면서 동시에 탐색을 한다' 라는 경우에는 적절치 않음.
?> 등록에 O(n^2) 이 되었다는 말이 해깔림..

### 2.2.5 해싱
*키 값을 배열의 첨자로 변환하는 함수를 이용하여 고속 탐색을 수행하는 알고리즘.
* 해싱은 해시 함수의 선택만 올바르게하면 등록 탐색 모두 O(1)로 할 수 있는 알고리즘

### 2.2.6 알고리즘을 선택하는 기준
* 복잡도로 평가시 가장 뛰어난 것은 해싱 > 이진 탐색 > 선형탐색
* 다른 득실도 따져야함.
  * 선형 탐색시 데이터 등록 순서 보존
    * 이진 탐색, 해싱에서는 어떤 순서로 등록했는지에 대한 정보는 잃어버림.
  * 해싱에서는 등록할 데이터 개수보다 큰 배열을 준비할 필요가 있음
  * 해시 함수의 선택에 따라 해시 값이 빈번히 충돌하여 성능이 대폭 저하될 우려가 있음

