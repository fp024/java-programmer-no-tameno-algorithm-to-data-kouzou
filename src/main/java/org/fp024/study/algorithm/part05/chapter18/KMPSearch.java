package org.fp024.study.algorithm.part05.chapter18;

/**
 * KMP 검색 구현이 없어서...
 * 알고리즘 4판 (케빈 웨인, 로버트 세지윅)의 KMP 클래스 코드를 사용방법만 약간 바꿈.
 * <p>
 * DFA 를 만드는 함수를 생성자에 넣지 않고 별도로 만들고 그것을 search()의 인자로 전달하는 식으로 변경
 * <p>
 * TODO: 이 코드는 '알고리즘 4판' 다시 볼 때 상세히 봐야할 것 같다.
 */
class KMPSearch {
    /**
     * 패턴으로 부터 DFA 만들기
     *
     * @param pattern 패턴
     * @return DFA(결정적 유한 상태 기계)
     */
    static int[][] createDFA(String pattern) {
        int M = pattern.length();
        int R = 256;
        int[][] dfa = new int[R][M];

        dfa[pattern.charAt(0)][0] = 1;

        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];  // 미스 매치의 경우, 복제
            }
            dfa[pattern.charAt(j)][j] = j + 1;  // 매치의 경우 설정
            X = dfa[pattern.charAt(j)][X];      // 재시작 상태 업데이트
        }
        return dfa;
    }

    /**
     * 검색
     *
     * @param text 패턴의 위치를 찾을 문자열
     * @return 패턴이 나타나는 인덱스 번호
     */
    static int search(String text, String pattern, int[][] dfa) {
        int i, j;
        int N = text.length();
        int M = pattern.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j];
        }
        return (j == M) ?
                i - M : // 찾음 (패턴의 끝 도달)
                -1;     // 찾지 못함
    }
}
