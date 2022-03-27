package org.fastcampus;

// 양인수
public class ThreeSixNineGame {

    public static void main(String[] args) {
        int i = 1;
        for(i = 1; i <= 100; i++) { // TODO i가 1부터 100까지 반복되어야합니다.
            int secondNumber = 0; // TODO 1의 자리 숫자를 나타냅니다
            int firstNumber = 0;  // TODO 10의 자리 숫자를 나타냅니다.

            boolean is306090 = false; // TODO 숫자의 10의 자리수가 3, 6, 9 에 해당 되는지 확인해주세요
            boolean is369 = false;  // TODO 숫자의 1의 자리수가 3, 6, 9 에 해당 되는지 확인해주세요

            secondNumber = i % 10;
            firstNumber = i / 10;

            if(firstNumber == 3 || firstNumber == 6 || firstNumber == 9) {
                is306090 = true;
            }

            if(secondNumber == 3 || secondNumber == 6 || secondNumber == 9) {
                is369 = true;
            }

            if(is306090 && is369) {
                System.out.println("**");
            }else if(is306090 || is369) {
                System.out.println("*");
            }else {
                System.out.println(i);
            }

        }
    }
}
