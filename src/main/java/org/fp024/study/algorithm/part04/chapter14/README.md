## 퀵 소트

### 14.1 퀵 소트의 원리

#### 14.1.1 퀵 소트의 기본 개념
* n개의 요소 a[0], a[1], ..., a[n-1] 을 가지는 배열 a를 정렬할 때...  
  어떤 특정한 요소 하나를 고름 - x라고 하면    
  그 요소가 최종적으로 놓여질 위치 a[v]로 이동 시킨다.
* x를 추측(pivot)이라고 함.
    *  x보다 작은 요소는 a[v]의 왼쪽, 큰요소는 오른쪽으로 나누는 작업을 함.

* 3부분으로 나눠진 배열 a
    1. a[v]보다 작은 요소
        * a[0], a[1], ..., a[v-1] 
    2. a[v]
    3. a[v]보다 큰요소
        * a[v+1], a[v+2], ...,a[n-1] 

* 부분 배열이 단 하나만 이루어져있다면 정렬 완료된 상태

* 분할 정복 (divide and conquer, divide and rule)
    * 큰 문제를 여러 개의 작은 문제로 분할한 후 각개 격파하는 방법

##### 퀵소트 알고리즘 (의사코드)
```
// 배열에서 a[l] ~ a[r]을 정렬한다. 
static void quickSort(int[] a, int l, int r) {
    if (정렬할 요소가 하나 뿐이다.) {
       return; 
    }
    
    적당한 요소 a[v]를 주축으로 하여,
    a[v]보다 작은 요소를 a[l] ~ a[v-1] 에 모으고
    a[v]보다 큰 요소를 a[v+1] ~ a[r]에 모은다.
    
    quickSort(a, l, v-1); // 왼쪽 부분을 정렬한다.
    quickSort(a, v+1, r); // 왼쪽 부분을 정렬한다.
}
```


#### 14.1.2 분할 알고리즘



### 14.2 퀵 소트 프로그램


### 14.3 퀵 소트의 복잡도


### 14.4 개선된 퀵 소트
