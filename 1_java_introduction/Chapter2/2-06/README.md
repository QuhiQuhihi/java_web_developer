# 06. 생성자에 대해 알아봅시다 (constructor)

## 생성자

- 생성자 기본 문법
<modifier><class_name>([<argument_list])
{
	[<statements]
}

- 객체를 생성할 때 new 키워드와 함께 사용   - new Student();

- 생성자는 일반 함수처럼 기능을 호출하는 것이 아니고 객체를 생성하기 위해 new 와 함께 호출 됨

- 객체가 생성될 때 변수나 상수를 초기화 하거나 다른 초기화 기능을 수행하는 메서드를 호출 함

- 생성자는 반환 값이 없고, 클래스의 이름과 동일

- 대부분의 생성자는 외부에서 접근 가능하지만, 필요에 의해 private 으로 선언되는 경우도 있음


## 기본 생성자 (default constructor)

- 클래스에는 반드시 적어도 하나 이상의 생성자가 존재

- 클래스에 생성자를 구현하지 않아도 new 키워드와 함께 생성자를 호출할 수 있음

- 클래스에 생성자가 하나도 없는 경우 컴파일러가 생성자 코드를 넣어 줌 

    public Student(){}  

-  매개 변수가 없음, 구현부가 없음

## 생성자 만들기

- 컴파일러가 제공해 주는 기본 생성자외에 필요에 의해 생성자를 직접 구현 할 수 있음

Student.java
```
public class Student {

	public int studentNumber;
	public String studentName;
	public int grade;
	
	public Student(int studentNumber, String studentName, int grade) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.grade = grade;
	}
	
	public String showStudentInfo() {
		return studentName + "학생의 학번은 " + studentNumber + "이고, " + grade + "학년 입니다.";
	}
}
```

StudentTest.java
```
public class StudentTest {

	public static void main(String[] args) {

		//Student studentLee = new Student();
		
		Student studentLee = new Student(12345, "Lee", 3);
		
		String data = studentLee.showStudentInfo();
		System.out.println(data);
	}

}
```
## 다음 강의
[07. 여러가지 생성자를 정의하는 생성자 오버로딩 (overloading)](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter2/2-07/README.md)