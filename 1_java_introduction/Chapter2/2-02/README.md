# 02. 생활 속에서 객체 찾아 클래스로 구현해 보기

## 객체를 찾아 봅시다

- 온라인 쇼핑몰에 회원 로그인을 하고 여러 판매자가 판매하고 있는 제품 중 하나를 골라 주문을 한다

- 아침에 회사에 가는 길에 별다방 커피숍에 들려 아이스 카페라떼를 주문했다

- 성적확인을 위해 학사 관리 시스템에 로그인 하여 수강 한 과목들의 성적을 확인했다


## 클래스는 객체의 청사진(blueprint) 입니다

- 객체의 속성은 클래스의 <b>멤머 변수(member variable)</b>로 선언 함

- 학생 클래스
```
public class Student {

	int studentNumber;
	String studentName;
	int majorCode;
	String majorName;
	int grade;
}
```

- 주문 클래스
```
public class Order {

	int orderId;
	String buyerId;
	String sellerId;
	int productId;
	String orderDate;
}
```

- 회원 클래스
```
public class UserInfo {

	String userId;
	String userPassWord;
	String userName;
	String userAddress;
	int phoneNumber;
}
```

## 객체 지향 프로그램을 할 때는 

- 객체를 정의 하고

- 각 객체의 속성을 멤버 변수로 역할을 메서드로 구현하고

- 각 객체간의 협력을 구현합니다.

## 클래스 코딩하기

- 클래스는 대문자로 시작하는것이 좋음

- java 파일 하나에 클래스는 여러 개가 있을 수 있지만, public 클래스는 하나이고, public 클래스와 .java 파일의 이름은 동일함

- camel notation 방식으로 명명

## 다음 강의
[03. 함수와 메서드](https://gitlab.com/easyspubjava/javacoursework/-/blob/master/Chapter2/2-03/README.md)

