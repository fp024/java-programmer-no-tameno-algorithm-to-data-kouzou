package org.fp024.study.algorithm.part05.chapter18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Boyer-Moore 알고리즘을 이용한 문자열 탐색
 */
class BoyerMoore {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoyerMoore.class);

    /**
     * 문자열 text에서 문자열 pattern을 탐색한다. (BM법)
     *
     * @param text    텍스트 (탐색 대상이 되는 문자열)
     * @param pattern 패턴 (찾을 문자열)
     * @return 발견한 위치를 반환, 발견하지 못했다면 1을 반환
     */
    static int search(String text, String pattern) {
        int patternLength = pattern.length();   // 패턴의 길이
        int textLength = text.length();         // 텍스트의 길이

        // 텍스트의 패턴이 일치하지 않을 때에
        // 어느 만큼 이동해야 할지 나타나는 표, 유니코드 모든 문자에 대응하기 위해 16비트(2^16)배열을 만듦.
        int[] skip = new int[65536];

        int i; // 텍스트의 비교 위치를 나타내는 포인터
        int j; // 패턴의 비교 위치를 나타내는 포인터

        // 표 skip 을 작성한다.
        Arrays.fill(skip, patternLength);

        // 패턴 각 문자 하다의 Unicode 값을  인덱스로 삼고 해당하는 값에 skip count 수준을 설정
        for (int x = 0; x < patternLength - 1; x++) {
            skip[pattern.charAt(x)] = patternLength - x - 1;
        }

        // 포인터를 초기화한다. 패턴을 뒤에서부터 비교하기 때문에
        // "패턴의 길이 -1"로 초기화한다.
        i = patternLength - 1;

        // 텍스트의 가장 마지막에 도달할 때까지 반복한다.
        while (i < textLength) {
            // 포인터 j가 패턴의 마지막 문자를 가리키도록 한다.
            j = patternLength - 1;

            // 텍스트와 패턴이 일치하는 동안 반복한다.
            while (text.charAt(i) == pattern.charAt(j)) {
                // 처음 문자까지 일치했다면 탐색은 성공이다.
                if (j == 0) {
                    return i;
                }

                // 포인터 i와 j를 각각 1문자만큼 되돌린다.
                i--;
                j--;
            }

            // 일치하지 않았기 때문에 패턴을 이동시킨다. (skip 표에 미리 정한 값은 수정하지 않음.)
            i = i + Math.max(skip[text.charAt(i)], patternLength - j);
        }

        // 결국, 발견하지 못 했다.
        return -1;
    }
}
