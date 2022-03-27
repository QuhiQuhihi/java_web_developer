# 15. 조건이 여러 개 일 때의 if 문

## if-else if-else 문

- 하나의 상황에 대한 조건이 여러개로 나뉘고 각 조건에 다른 수행이 이루어져야 할 경우 사용

- 각 조건은 상호 배타적임 


        if(조건식1){
            수행문1;        // 조건식1이 '참'인 경우 수행하고 전체 조건문을 빠져나감
        }
        else if(조건식2){
            수행문2;        // 조건식2이 '참'인 경우 수행하고 전체 조건문을 빠져나감
        }
        else if(조건식3){
            수행문3;        // 조건식3이 '참'인 경우 수행하고 전체 조건문을 빠져나감
        }
        else{
            수행문4;        // 위 조건이 모두 해당되지 않는 경우 수행됨 (디폴트 조건)
        }

        수행문5;            // if-else if-else 문이 끝나면 수행됨

        가령 조건식2가 만족되면 수행문2 -> 수행문5  순으로 수행됨

 ![ifelseif](./img/ifelseif.PNG)

 ```
 package ch15;

public class IfElseIfElseTest {

	public static void main(String[] args) {
		int age = 12;
		int charge;
		
		if(age < 8){
			charge = 1000; 
			System.out.println("미 취학 아동입니다.");
		}
		else if(age < 14){
			charge = 2000;
			System.out.println("초등학생 입니다.");
		}
		else if(age < 20){
			charge = 2500;
			System.out.println("중, 고등학생 입니다.");
		}
		else{
			charge = 3000;
			System.out.println("일반인 입니다.");
		} 
		
		System.out.println("입장료는 " + charge + "원입니다.");
	}
}
```
![ifelseifanswer](./img/ifelseanswer.PNG)
## if-else if 문과 if - if 문의 차이점

- if- else if 를 사용하는 경우 하나의 조건이 만족 되면 나머지 else if 부분은 수행되지 않음

- if - if 로 사용하게 되면 각각 다른 조건 문으로 해석되어 각각 수행하게 됨

   ( 위 예제를 if 로 모두 바꾸어 봅시다.)
```   
package ch15;

public class IfIfTest {

	public static void main(String[] args) {
		int age = 12;
		int charge;
		
		if(age < 8){
			charge = 1000; 
			System.out.println("미 취학 아동입니다.");
		}
		if(age < 14){
			charge = 2000;
			System.out.println("초등학생 입니다.");
		}
		if(age < 20){
			charge = 2500;
			System.out.println("중, 고등학생 입니다.");
		}
		else{
			charge = 3000;
			System.out.println("일반인 입니다.");
		} 
		
		System.out.println("입장료는 " + charge + "원입니다.");
	}
}
```
![ififanswer](./img/ififanswer.PNG)

## 다음 강의
[16. 조건이 여러 개 일 때 간단히 표현되는 switch-case 문](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter1/01-16/README.md)