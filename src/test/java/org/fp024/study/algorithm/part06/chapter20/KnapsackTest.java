package org.fp024.study.algorithm.part06.chapter20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 배낭 문제 테스트
 */
class KnapsackTest {
    @Test
    void testKnapsack() {
        // 배낭의 크기
        int knapsackSize = 16;
        Knapsack knapsack = new Knapsack(
                new int[]{2, 3, 5, 7, 9},   // 물건의 크기
                new int[]{2, 4, 7, 11, 14}  // 물건의 가격
        );

        assertEquals(25, knapsack.solve(knapsackSize));
    }
}

// 로그 출력의 예시
/*
2021-06-24 03:07:01,138  INFO [Knapsack] 배낭의 크기는 16
2021-06-24 03:07:01,143  INFO [Knapsack] i = 0
2021-06-24 03:07:01,144  INFO [Knapsack] total  =    0   0   2   2   4   4   6   6   8   8  10  10  12  12  14  14  16
2021-06-24 03:07:01,144  INFO [Knapsack] choice =   -1  -1   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
2021-06-24 03:07:01,145  INFO [Knapsack] i = 1
2021-06-24 03:07:01,145  INFO [Knapsack] total  =    0   0   2   4   4   6   8   8  10  12  12  14  16  16  18  20  20
2021-06-24 03:07:01,146  INFO [Knapsack] choice =   -1  -1   0   1   0   1   1   1   1   1   1   1   1   1   1   1   1
2021-06-24 03:07:01,146  INFO [Knapsack] i = 2
2021-06-24 03:07:01,146  INFO [Knapsack] total  =    0   0   2   4   4   7   8   9  11  12  14  15  16  18  19  21  22
2021-06-24 03:07:01,146  INFO [Knapsack] choice =   -1  -1   0   1   0   2   1   2   2   1   2   2   1   2   2   2   2
2021-06-24 03:07:01,146  INFO [Knapsack] i = 3
2021-06-24 03:07:01,147  INFO [Knapsack] total  =    0   0   2   4   4   7   8  11  11  13  15  15  18  19  22  22  24
2021-06-24 03:07:01,147  INFO [Knapsack] choice =   -1  -1   0   1   0   2   1   3   2   3   3   2   3   3   3   3   3
2021-06-24 03:07:01,147  INFO [Knapsack] i = 4
2021-06-24 03:07:01,147  INFO [Knapsack] total  =    0   0   2   4   4   7   8  11  11  14  15  16  18  19  22  22  25
2021-06-24 03:07:01,148  INFO [Knapsack] choice =   -1  -1   0   1   0   2   1   3   2   4   3   4   3   3   3   3   4
2021-06-24 03:07:01,148  INFO [Knapsack] 물건 4 (가격 14) 을 넣었다
2021-06-24 03:07:01,148  INFO [Knapsack] 물건 3 (가격 11) 을 넣었다
2021-06-24 03:07:01,148  INFO [Knapsack] 가격의 합계= 25
*/