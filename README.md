# Java-Programmer-no-tameno-Algorithm-to-Data-Kouzou

## Java 프로그래머를 위한 알고리즘과 자료구조 스터디 / 실습 진행.
* 저자: 近藤嘉雪 (Yoshiyuki kondou) 님
* 원제: Javaプログラマのためのアルゴリズムとデータ構造
* [yes24 도서 판매 페이지 링크(품절 상태)](http://www.yes24.com/Product/Goods/1441332?scode=029)
* [교보문고 판매 페이지 링크(품절 상태)](http://www.kyobobook.co.kr/product/detailViewKor.laf?barcode=9788931430424)


## 진행방향
* Part, Chapter 별로 패키지를 나눔
* Java 11, Gradle 프로젝트로 생성
* 최신 Java의 기능을 사용할 수 있는 부분에 대해서는 적용해본다.
    * Java 1.4 기준으로 소스코드가 만들어져서 제네릭이 적용되지 않은 것 같다.
    * 저자님의 의도를 해치지 않는선에서..
* 실행 코드에 대해 가능한 JUnit5 로 검증한다.

## 코딩 테스트
* 4월에 코딩테스트를 볼 수 있는 기회를 얻어서 보아봤는데, 역시 지식이 많이 부족한 것 같다.  
  현재 실력으로는 풀 수 없었고, 데모 문제정도 어렵게 풀 수 있었다.  
  지금 이 책의 내용은 한번 다 진행해보고, 코딩 테스트관련 연습문제를 많이 경험해봐야겠다.

  
## 정오표
* p94. 역 폴란드 계산기 소스파일명
    * Calcular.java -> Calculator.java
* p125. 경계조건2에서 newCell의 삽입되는 위치가 header 바로 다음이여아하는데,  
  그 다음 지점에 연결되어있습니다.
* p129. 38번째 주석  예와 => 예외
* p152. 64번째 주석문 fals => false
* p213. 8.4.3 -> 8.4.4 소 주제 번호 증가가 안되어있음.
* p206. 소스코드 164번째 줄
  `table[h].data = nall` -> `null`
* p226 List 9.4의 insert 함수
    * 주석에는 이미 등록되어있다면 null 반환처리가 되야하는데, 이미 등록된 값을 반환하게 되어있다.
* p262 217번쨰 줄 lowest 변수 선언
    * 사용처가 없는 변수, lowest 관련은 InsertAuxResult의 필드 lowest만 사용되고 있음.
* p268 509번째 줄 주석 nod => node
* p269 526번째 줄 주석 필요한다 => 필요하다
* p298 `교환소트`보다 선택소트가 => `삽입소트`보다 선택소트가
* p299 `삽입소트는` k가 변하더라도 => `선택소트는` k가 변하더라도
* p300 셀소트의 평균 성능 표현에서.. O(n<sup>2.5</sup>)~O(n<sup>1.5</sup>) => O(n<sup>1.25</sup>)~O(n<sup>1.5</sup>)
* p312 `14.1.1` 분할 알고리즘 => `14.1.2` 분할 알고리즘
* p353 `루프`에서 가장 떨어진 -> `루트`에서 가장 떨어진
* p362 Heap 소스 106줄에 public 지정자가 붙어야할 것 같습니다.
* p432 모두 `88` = 16,777,216가지 => `8`<sup>`8`</sup>
* p436 col은 수직 방향으로 `집히는지를` => `잡히는지를`
* p450 전체를 몇 개의 작은 `문자`로 분해한 => `문제`
* p461
    * 94줄 정수 값 `valu`를 -> 정수 값 `value`를 
    * 96줄 `value` -> `len`

## 기타
* 2022년 2월 1일 이후부터 JCenter 서비스 종료로 이용할 수 없다.
    * build.gradle 에서 jcenter() -> mavenCentral() 으로 변경
