# 04. 객체의 속성은 멤버 변수로, 객체의 기능은 메서드로 구현한다

## 학생 클래스를 정의 하고 이를 사용해 보자

- 학생 클래스의 속성을 멤버 변수로 선언하고 메서드를 구현한다

```
public class Student {
	
	public int studentID;
	public String studentName;  
	public String address;
			
	public void showStudentInfo() {
		System.out.println(studentName + "," + address);
	}
	
	public String getStudentName() {
		return studentName;
	}
}
```

- 학생 클래스를 생성하여 생성된 객체(인스턴스)에 각각 다른 이름과 주소를 대입한다
```
public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student();
		studentLee.studentName = "이순신";
		studentLee.address = "서울";
		
		
		studentLee.showStudentInfo();
		
		Student studentKim = new Student();
		studentKim.studentName = "김유신";
		studentKim.address = "경주";
		
		studentKim.showStudentInfo();
		
		System.out.println(studentLee);
		System.out.println(studentKim);
	}

}
```

## 다음 강의
[05. 인스턴스 생성과 힙 메모리](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter2/2-05/README.md)
