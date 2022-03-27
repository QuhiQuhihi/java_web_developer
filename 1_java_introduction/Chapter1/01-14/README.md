# 14. 조건문 - if 문(만약에... 라면)

## 조건문 이란?

- 주어진 조건에 따라 다른 실행이 이루어 지도록 구현

- '재산이 1억 이상이면 100만원을 세금으로 낸다 그렇지 않으면 내지 않는다' 를 구현 한다면

   만약에 (재산이 1억 이상이면){ <br>
       세금을 100만원 낸다  <br>
   } <br>
   그렇지 않으면 {  <br>
       세금을 내지 않는다 <br>
   }

- if문 문법
    
      if(조건식){
        수행문;      // 조건식이 '참'인 경우에(조건에 맞는 경우) 수행문이 수행됨 
       }             // 조건식이 '참'이 아니면(조건에 맞지 않는 경우) 수행문이 수행되지 않음


- if - else 문 문법

      if( 조건식) {

          수행문1;   // 조건식이 '참'인 경우에 수행됨
      }
      else{
          수행문2;    // 조건식이 '참'이 아닌 경우에 수행됨
      }
  

- if - else 예제

```
package ch14;

import java.util.Scanner;

public class IfElseTest {

	public static void main(String[] args) {

		int age = 7;

		//Scanner scanner = new Scanner(System.in);
		//int age = scanner.nextInt();
		
		if( age >= 8) {
			System.out.println("학교에 다닙니다");
		}
		else {
			System.out.println("학교에 다니지 않습니다.");
		}
	}
}
```

## 다음 강의
[15. 조건이 여러 개 일 때의 if 문](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter1/01-15/README.md)