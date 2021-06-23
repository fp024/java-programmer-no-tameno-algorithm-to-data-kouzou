package org.fp024.study.algorithm.part06.chapter20;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 동적 계획을 사용하여 배낭 문제를 푼다.
 * <p>
 * JUnit5로 실행하기 때문에, abort(), main() 메서드들은 구현하지 않는다.
 */
@Slf4j
class Knapsack {
    /**
     * 물건의 크기
     */
    private final int[] size;

    /**
     * 물건의 가격
     */
    private final int[] value;

    /**
     * 물건의 가지 수
     */
    private final int N;

    /**
     * 배낭 문제를 표현하는 객체를 생성한다.
     * (?) 물건을 별도 클래스로 나타내도 될 것 같긴 한데, 저자님 설명을 이해가 확실하게 될 시점에 바꿔야겠음.
     *
     * @param size  물건의 크기를 나타내는 배열
     * @param value 물건의 가격을 나타내는 배열
     */
    public Knapsack(int[] size, int[] value) {
        // 매개변수 size와 value의 요소의 개수가 같은 것을 확인한다.
        if (size.length != value.length) {
            throw new IllegalArgumentException("'size'와 'value'의 요소 수가 일치하지 않습니다.");
        }

        // 물건의 가지 수를 저장한다.
        this.N = size.length;

        // 배열 size의 복제본을 만들어 필드 size에 저장한다.
        // <?> 왜 원본 배열을 그대로 사용하지 않을까? ==> 이 클래스 사용처에서 배열의 변경하더라도 영향을 받지 않기위해서라고 하심.
        this.size = Arrays.copyOf(size, size.length);

        // 배열 value의 복제본을 만들어 필드 value에 저장한다.
        this.value = Arrays.copyOf(value, value.length);
    }


    /**
     * 크기 m인 배낭에 대한 해법을 구해 표시한다.
     *
     * @param m 배낭의 크기
     * @return 가격의 최대 합계
     */
    public int solve(int m) {
        // 현 시점에서 배낭에 넣은 물건의 가격의 합계
        int[] total = new int[m + 1]; // 모든 요소가 0으로 초기화 된다.

        // 마지막으로 고른 물건
        int[] choice = new int[m + 1];
        Arrays.fill(choice, -1);    // 모든 요소를 -1로 초기화한다.

        // 물건 i 를 넣었을 때 가격의 합계
        int repackTotal;

        // 배낭의 크기를 표시한다.
        logger.info("배낭의 크기는 {}", m);

        // 물건 0 ~ i 까지를 고려해 넣는다.
        for (int i = 0; i < N; i++) {
            // 크기 j인 배낭에 대해 물건을 넣어본다.
            for (int j = size[i]; j <= m; j++) {

                // 만약 물건 i를 넣었다고 하면, 가격의 합계가 얼마가 될지
                // 계산하여 변수 repackTotal에 넣는다.
                repackTotal = total[j - size[i]] + value[i];

                // 만약 물건 i를 넣어서 (넣지 않았을 때 보다) 가격이
                // 올라가면 물건 i를 넣는다.
                if (repackTotal > total[j]) {
                    total[j] = repackTotal;
                    choice[j] = i;
                }
            }

            // 배열 total, choice의 내용을 표시한다.
            logger.info("i = {}", i);
            StringBuilder totalBuilder = new StringBuilder("total  = ");
            for (int j = 0; j <= m; j++) {
                totalBuilder.append(pack(total[j]));
            }
            logger.info(totalBuilder.toString());

            StringBuilder choiceBuilder = new StringBuilder("choice = ");
            for (int j = 0; j <= m; j++) {
                choiceBuilder.append(pack(choice[j]));
            }
            logger.info(choiceBuilder.toString());
        }

        // 어느 물건을 배낭에 넣었는지를 표시한다.
        for (int i = m; choice[i] >= 0; i -= size[choice[i]]) {
            logger.info("물건 {} (가격 {}) 을 넣었다", choice[i], value[choice[i]]);
        }
        logger.info("가격의 합계= {}", total[m]);
        return total[m];
    }

    /**
     * 입력된 정수에 대해 4자리 기준으로 오른쪽 들여쓰기 문자열을 반환한다.
     * <p>
     * 저자님 께서는 출력 값 각각의 왼쪽 들여쓰기를 하고 싶으신 것 같은데, String.format() 으로 변경해본다.
     *
     * @param value 반환한 수치 값
     * @return 반환된 문자열
     */
    private String pack(int value) {
        return String.format("%4s", value);
    }
}
