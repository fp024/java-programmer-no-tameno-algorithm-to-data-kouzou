package org.fp024.study.algorithm.part02.chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

/**
 * 역 폴란드 전자 계산기
 * <p>
 * 저자님은 main 함수에, 아래 코드로 키보드 입력을 받아 테스트를 하셨는데,..
 * new PushbackReader(new BufferedReader(new InputStreamReader(System.in)))
 * main() 함수 실행방식으로 먼저해보고 JUnit 으로 바꿀만할지 생각해보자.
 */
class Calculator {
    /**
     * 스택에 수치값을 쌓는다
     *
     * @param stack 스택
     * @param value 넣을 값
     */
    private static void push(MyStack<Long> stack, long value) {
        stack.push(value);
    }

    /**
     * 스택에서 수치 값을 꺼낸다.
     *
     * @param stack 스택
     * @return 스택에서 꺼낸값
     */
    private static long pop(MyStack<Long> stack) {
        return stack.pop();
    }

    /**
     * 테스트 검증용 메시지 보관
     */
    private static String RESULT_MESSAGE = "";

    /**
     * 연산 결과가 누적되도록 하자
     *
     * @param resultMessage 누적할 결과 메시지
     */
    public static void appendResultMessage(String resultMessage) {
        RESULT_MESSAGE = RESULT_MESSAGE + resultMessage + "\r\n";
    }

    public static void clearMessage() {
        RESULT_MESSAGE = "";
    }

    public static String getResultMessage() {
        return RESULT_MESSAGE;
    }

    /**
     * 역 폴란드 전자 계산기의 메인 프로그램
     * 콘솔에서 입력한 식을 평가하고 결과를 표시한다
     */
    public static void main(String[] args) throws IOException {
        // 스택을 생성한다
        MyStack<Long> stack = new MyStack<>();

        // 표준입력에서 한문자씩 읽어들이기 위한 리더(reader)를 준비한다.
        // PushbackReader 클래스를 이용하여 지나간 문자를 반환할 수 있도록
        // 하고 있는 것에 주의
        PushbackReader input =
                new PushbackReader(
                        new BufferedReader(
                                new InputStreamReader(System.in)
                        )
                );

        // 읽어들인 문자
        int c;
        // 작업용 변수
        long a, b;

        // EOF가 될 때 까지 한문자 씩 읽어들여 처리한다.
        while ((c = input.read()) != -1) {
            char ch = (char) c;

            if (Character.isDigit(ch)) {
                // 읽어 들인 문자가 숫자였다
                // 숫자가 아닌 값이 나올때까지 읽은 후, 십진수로 해석하여
                // long 값으로 변환한다. 얻어진 값을 스택에 쌓음
                long num = 0;
                while (Character.isDigit(ch)) {
                    num = 10 * num + (ch - '0');
                    c = input.read();
                    ch = (char) c;
                }
                input.unread(c); // 숫자가 아닌 문자를 하나 읽었기 때문에 되돌림
                push(stack, num);
            } else {
                switch (ch) {
                    case '+':    // + 덧셈
                        b = pop(stack);
                        a = pop(stack);
                        push(stack, a + b);
                        break;
                    case '-':   // - 뺄셈
                        b = pop(stack);
                        a = pop(stack);
                        push(stack, a - b);
                        break;
                    case '*':   // * 곱셈
                        b = pop(stack);
                        a = pop(stack);
                        push(stack, a * b);
                        break;
                    case '/':   // / 나눗셈
                        b = pop(stack);
                        a = pop(stack);
                        push(stack, a / b);
                        break;
                    case '\n':  // '\n' 결과를 표시한다.
                        if (!stack.isEmpty()) {
                            String resultMessage = "답은 " + pop(stack) + " 입니다.";
                            appendResultMessage(resultMessage);
                            System.out.println(resultMessage);
                        }
                        stack.clear();
                        break;
                    case ' ':   // 공백문자라면 아무것도 출력하지 않는다.
                    case '\t':
                    case '\r':
                        break;
                    default: // 그외의 문자라면 에러
                        String message = "올바르지 않은 문자 " + ch + "가 있습니다.\r\n다시 입력해 주십시오.";
                        appendResultMessage(message);
                        System.out.println(message);
                        // 개행 문자까지 지나친 후 스택을 비운다
                        while ((c = input.read()) != -1 & c != '\n')
                            ;
                        stack.clear();
                        break;
                }
            }
        }
    }
}
