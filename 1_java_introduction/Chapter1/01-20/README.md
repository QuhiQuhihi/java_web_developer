# 20. 반복문이 여러 번 포개진 중첩 반복문

## 중첩 반복문이란?

- 반복문 내부에 또 다른 반복문이 있음

- 여러 겹으로 반복문을 겹쳐서 구현 가능 (단 수행시간에 문제가 발생할 수 있음)

- 외부 반복문과 내부 반복문 간의 변수 값 변화에 유의 하며 구현하여야 함


## 구구단을 for와 while로 구현해 보자

```
package ch20;

public class NestedLoopTest {

	public static void main(String[] args) {
		int dan = 2;
		int count = 1;
		
		for( dan = 2; dan <= 9; dan++) {
			
			for(count = 1; count <=9; count++) {
				
				System.out.println( dan + "X" + count + "=" + dan * count);
			}
			System.out.println();
		}
		
		dan = 2;
		while( dan <= 9 ) {
			count = 1;
			while (count <= 9) {
				
				System.out.println( dan + "X" + count + "=" + dan * count);
				count++;
				
			}
			dan++;
			System.out.println();
		}
	}
}

```


## 다음 강의

[21. 중간에 멈추는 break문, 무시하고 계속 진행하는 continue문](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter1/01-21/README.md)

