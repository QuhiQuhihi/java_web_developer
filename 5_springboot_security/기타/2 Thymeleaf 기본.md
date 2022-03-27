# Thymeleaf 기본 기능

## 기본 문법

### 변수 접근

- 기본 : ${...}
- 선택된 객체 안에서 접근 : \*{...}
- 메시지 : #{...}
- URL 링크 : @{...}
- Fragment : ~{...}

### namespace

- xmlns:th="http://www.thymeleaf.org
- xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
- xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"

### 명령어 (th:\*)

- text : 텍스트 내용
- utext : html
- attr (혹은 th:value, th:src, th:href) : 엘리먼트 attribute 값을 지정
- with : 변수값 지정
- switch, case : switch 문
- if : 조건문
- unless : 부정 조건문
- each object : 반복문
- class, classappend : 기존에 class가 있을 때, 로직으로 클래스를 추가할 때 사용

### template

- replace : 해당 엘리먼트를 template 의 엘리먼트로 대체합니다.
- include : block 문을 하위 엘리먼트로 넣어줍니다.
- fragment : html 태그 조각으로 재활용이 가능합니다.
- block

## layout

- layout:decorator
- layout:fragment

## 참고자료

- https://eblo.tistory.com/57 : layout 화면 구성
- http://progtrend.blogspot.com/2019/05/thymeleaf.html : thymeleaf 기본 문법을 정리해 놓은 블로그
