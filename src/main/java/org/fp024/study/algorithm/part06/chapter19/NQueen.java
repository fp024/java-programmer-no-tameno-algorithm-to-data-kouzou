package org.fp024.study.algorithm.part06.chapter19;

import java.util.Arrays;

import static org.fp024.study.algorithm.part06.chapter19.NQueen.QueenPosition.FREE;
import static org.fp024.study.algorithm.part06.chapter19.NQueen.QueenPosition.NOT_FREE;

/**
 * N 퀸 문제를 푼다
 */
class NQueen {
    // 현재는 java에 enum을 추가할 수 있으니 정의하자.
    enum QueenPosition {
        FREE,       // 놓을 수 있다.
        NOT_FREE    // 놓을 수 없다.
    }

    /**
     * 퀸의 수
     */
    private final int N;

    /**
     * 각 행에 놓여진 퀸의 위치
     */
    private final int[] pos;

    /**
     * 수직 방향의 관계를 나타내는 배열
     */
    private final QueenPosition[] col;

    /**
     * 대각선 상의 관계를 나타내는 배열 (오른쪽 아래로 기울어진 대각선)
     */
    private final QueenPosition[] down;

    /**
     * 대각선 상의 관계를 나타내는 배열 (왼쪽 위로 기울어진 대각선)
     */
    private final QueenPosition[] up;

    /**
     * N 퀸 문제를 풀기위한 객체를 생성
     *
     * @param numberOfQueens 퀸의 개수
     */
    public NQueen(int numberOfQueens) {
        // 배열을 할당한다.
        N = numberOfQueens;
        pos = new int[N];

        col = new QueenPosition[N];

        down = new QueenPosition[2 * N - 1];
        up = new QueenPosition[2 * N - 1];

        reset();
    }

    /**
     * 테이블을 초기화한다.
     */
    public void reset() {
        // 퀸의 위치와 잡히는 관계 정보를 초기화한다. - 배열을 하나하나 for문 돌려서 값을 초기화한 것과 같다.
        Arrays.fill(pos, -1);
        Arrays.fill(col, FREE);
        Arrays.fill(down, FREE);
        Arrays.fill(up, FREE);
    }

    /**
     * 행 a이후의 모든 행에  퀸을 놓는다.
     *
     * @param a 이 행이후에 퀸을 놓는다. (메인 프로그램에서의 시작은 0부터 호출하면 됨)
     * @return 퀸을 놓을 수 있었다면 true, 그렇지 못했다면 false를 반환
     */
    public boolean tryQueen(int a) {
        // 왼쪽에서 오른쪽으로 향해 순서대로 퀸을 놓을 수 있는지를 조사한다.
        for (int b = 0; b < N; b++) {
            // 행 a의 b번째에 놓을 수 있는지를 조사한다.
            if (canPositionQueen(a, b)) {
                // 놓을 수 있었다. 장소를 기록하고 잡히는 정보를 저장한다.
                positionQueen(a, b);

                // N개의 퀸을 모두 놓을 수 있었다면 성공이다.
                if (a + 1 >= N) {
                    return true;
                } else {
                    // 행이 a + 1 이후의 모든 행에 놓을 수 있었다면 성공이다.
                    if (tryQueen(a + 1)) {
                        return true;
                    } else {
                        // 실패한다 퀸을 제거한다.
                        removeQueen(a, b);
                    }
                }
            }
        }

        // 결국 이 행에는 놓을 장소가 없었다.
        return false;
    }


    /**
     * 퀸의 위치 문자열을 반환한다.
     * <p>
     * 저자님은 여기서 sysout 으로 콘솔에 출력했는데, 테스트를 위해 해당 위치문자열을 반환하도록 한다.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (pos[i] == j) {
                    builder.append("Q ");
                } else {
                    builder.append(". ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }


    /**
     * 행 a 이후의 모든 행에 퀸을 놓아본다. (모든 답을 표시)
     * <p>
     * 저자님은 내부에서 모든 퀸 결과에 대해 출력을 하셨는데...
     * 내부에서 출력되는 모든 퀸 문제를 String으로 반환하기 위해 메서드를 분리한다.
     *
     * @param a 이 행 이후의 퀸을 놓는다.
     */
    public String tryQueenAll(int a) {
        StringBuilder builder = new StringBuilder();
        tryQueenAll(a, builder);
        return builder.toString();
    }

    private void tryQueenAll(int a, StringBuilder builder) {
        // 왼쪽에서 오른쪽을 향해 순서대로 퀸을 놓을 수 있는지 조사한다.
        for (int b = 0; b < N; b++) {
            // 행의 a의 b번째에 놓을 수 있는가를 조사한다.
            if (canPositionQueen(a, b)) {
                // 놓을 수 있었다. 장소를 기록하고 잡히는 정보를 저장한다.
                positionQueen(a, b);

                // N개의 퀸을 모두 놓을 수 있었다면 성공이다.
                if (a + 1 >= N) {
                    // 출력 대신 현재 퀸 해답을 StringBuilder 에 추가했다.
                    builder.append(this).append("---------------\n");
                } else {
                    tryQueenAll(a + 1, builder);
                }

                removeQueen(a, b);
            }

        }
    }

    /**
     * (a, b) 에 퀸을 둘 수 있는지의 여부
     *
     * @param a 행 인덱스
     * @param b 열 인덱스
     * @return 퀸을 둘 수 있는지의 여부
     */
    private boolean canPositionQueen(int a, int b) {
        return col[b] == FREE
                && up[a + b] == FREE
                && down[a - b + (N - 1)] == FREE;
    }

    /**
     * (a, b) 에 퀸을 둔다
     *
     * @param a 행 인덱스
     * @param b 열 인덱스
     */
    private void positionQueen(int a, int b) {
        pos[a] = b;
        col[b] = NOT_FREE;
        up[a + b] = NOT_FREE;
        down[a - b + (N - 1)] = NOT_FREE;
    }

    /**
     * (a, b) 에 퀸을 제거한다.
     *
     * @param a 행 인덱스
     * @param b 열 인덱스
     */
    private void removeQueen(int a, int b) {
        pos[a] = -1;
        col[b] = FREE;
        up[a + b] = FREE;
        down[a - b + (N - 1)] = FREE;
    }

}
