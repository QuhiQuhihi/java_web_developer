# 03. 함수형 인터페이스와 람다식 구현하여 사용하기

## 함수형 인터페이스 선언하기

- 람다식을 선언하기 위한 인터페이스

- 익명 함수와 매개 변수만으로 구현되므로 인터페이스는 단 하나의 메서드만을 선언해야함 

- @FunctionalInterface 애노테이션(annotation)

    함수형 인터페이스라는 의미, 내부에 여러 개의 메서드를 선언하면 에러남 

    ![error](./img/error.png)

- 람다식 구현과 호출

```
public class TestMyNumber {

	public static void main(String[] args) {
		MyNumber max = (x, y)->(x>= y)? x:y; // 람다식을 인터페이스 자료형 max 변수에 대입

		System.out.println(max.getMax(10, 20));// 인터페이스 자료형 변수로 함수 호출
			
	}
}
```



