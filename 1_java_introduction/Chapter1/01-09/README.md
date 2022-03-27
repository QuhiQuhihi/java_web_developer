# 09. 자료형(data type)- 논리형과 자료형 없이 변수 사용하기

##  논리형
 - true(참), false(거짓) 두 가지만 나타냄

 - 1바이트를 사용 함

 - 값이 존재하는지, 배열이 비었는지, 결과가 참인지 거짓인지등을 표현


```
package ch09;

public class BooleanTest {

	public static void main(String[] args) {
		
		boolean isMarried = true;
		System.out.println(isMarried);
	}
}
```

## 지역 변수 자료형 없이 사용하기 (  자바 10 지원 됨 ) 

 - Local variable type inference

 - 추론 가능한 변수에 대한 자료형을 선언하지 않음
 
 - 한번 선언하여 추론 된 변수는 다른 타입의 값을 대입 할 수 없음

 - 지역 변수만 사용 가능

```
 package ch09;

public class LocalVariableType {

	public static void main(String[] args) {

		var i = 10;
		var j = 10.0;
		var str = "hello";
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(str);
		
		str = "test";
		//str = 3; 
	}
}
```

## 다음 강의 
[# 10. 변하지 않는 상수와 리터럴, 변수의 형 변환](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter1/01-10/README.md)

