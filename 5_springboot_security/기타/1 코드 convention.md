# 코드 컨벤션

## 모듈 프로젝트 구성

- comp : 컴포넌트가 되는 모듈을 넣는다.
  - user-authority
  - paper
  - user-oauth2-support
  - web-util
  - common-utils
- web : 웹 컨트롤러나 리소스를 여러 서버에서 공통으로 사용하는 경우 web 컴포넌트로 관리한다.
  - user-admin-web
  - user-info-web
- server : 스터디의 특성상 여러개의 서버를 만들면서 실습할 것이다. 테스트가 필요할 때마다 서버를 만들어서 테스트 할 것이다.
  - basic-server
  - login-test
  - multiple-providers
  - paper-site

---

## package 구조

- com.sp.fc 를 그룹명으로 하고 기본 패키지로한다. (version 은 1.0.0 으로 한다.)
- 웹 애플리케이션은 com.sp.fc.web 밑에 xxxApplication.java 로 한다.
- 모듈이 되는 프로젝트의 component 스캔이나 JPA 설정 정보등은 com.sp.fc.config 밑에 xxxModule.java 클래스를 만들고 해당 모듈에 대한 설정을 기술한다. 이후에 서버에서 scanBasePackage 를 구성할 때 com.sp.fc.config 폴더를 기본으로 스캔하게 하기 위해서이다.
- lombok 을 사용한다. 특히 builder 패턴의 코딩을 주로 사용한다.

---

## 프로그램에 사용한 Live Template

- IntelliJ > Preferences > Editor > Live Templates 에 설정한 템플릿들이다.

- data

  ```java
  import lombok.AllArgsConstructor;
  import lombok.Builder;
  import lombok.Data;
  import lombok.NoArgsConstructor;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  ```

- test1 ( ... test13)

  ```java
  @DisplayName("1. $END$")
  @Test
  void test_1(){

  }
  ```
