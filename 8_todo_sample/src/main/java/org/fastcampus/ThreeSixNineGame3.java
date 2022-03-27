package org.fastcampus;

// 여은지
public class ThreeSixNineGame3 {

    public static void main(String[] args) {
        int i = 1;

        while(i <= 100) { // TODO i가 1부터 100까지 반복되어야합니다.
            // System.out.print(i + "\t");

            int firstNumber = i % 10; // TODO 1의 자리 숫자를 나타냅니다
            int secondNumber = i / 10;  // TODO 10의 자리 숫자를 나타냅니다.

            boolean is306090 = ((firstNumber) == 3) || ((firstNumber) == 6) || ((firstNumber) == 9); // TODO 숫자의 10의 자리수가 3, 6, 9 에 해당 되는지 확인해주세요
            boolean is369 = ((secondNumber) == 3) || ((secondNumber) == 6) || ((secondNumber) == 9);  // TODO 숫자의 1의 자리수가 3, 6, 9 에 해당 되는지 확인해주세요

            if (is306090 && is369)
                System.out.println("**");// TODO 숫자가 33, 36, 39, 63, 66, 69, 93, 96, 99에 해당되는 경우 '**'이 출력됩니다. System.out.println("**")
            else if (is306090 || is369)
                System.out.println("*");// TODO 숫자에 3, 6, 9가 한번 포함되는 경우 '*'이 출력됩니다. System.out.println("*")
            else System.out.println(i); // 숫자에 3, 6, 9 가 들어가지 않을 경우 숫자가 출력됩니다.
            i ++; // 숫자를 1 증가시킴
        }
    }
}