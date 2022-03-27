# RememberMe 실습

- 개발자 옵션이 있으면 기존 로그인 정보로 자동로그인이 됩니다. 그렇기 때문에 개발자옵션을 모두 끄고 서버를 테스트 해야 합니다.

### 실습 시나리오

### 로그아웃 이벤트를 프린트 하도록 한다.

```java
   @Bean
   public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
       return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher(){
           @Override
           public void sessionCreated(HttpSessionEvent event) {
               super.sessionCreated(event);
               System.out.printf("===>> [%s] 세션 생성됨 %s \n", LocalDateTime.now(), event.getSession().getId());
           }

           @Override
           public void sessionDestroyed(HttpSessionEvent event) {
               super.sessionDestroyed(event);
               System.out.printf("===>> [%s] 세션 만료됨 %s \n", LocalDateTime.now(), event.getSession().getId());
           }

           @Override
           public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
               super.sessionIdChanged(event, oldSessionId);
               System.out.printf("===>> [%s] 세션 아이디 변경  %s:%s \n",  LocalDateTime.now(), oldSessionId, event.getSession().getId());
           }
       });
   }
```

#### TokenBasedRememberMeServices

- user/1111 을 기본 사용자로 등록합니다. SecurityConfig에 아래와 같이 TokenBasedRememberMeServices 를 설정합니다.

  ```java
    @Bean
    RememberMeServices rememberMeServices(){
        return new TokenBasedRememberMeServices("hello", spUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        ...
        .rememberMe(rememberme->rememberme
          .rememberMeServices(rememberMeServices())
        );
    }
  ```

- 세션 종료시간을 60초로 줍니다.
- user/1111 으로 자동로그인 합니다.
- 쿠키에 remember-me 쿠키가 저장된 것을 확인합니다.
- 서버를 재시작 하고 자동 로그인 되는걸 확인합니다.
- user/1112 로 수정한 다음 로그인이 실패하는 것을 확인합니다.

#### PersistenceTokenBasedRememberMeServices

- DB를 파일 DB로 고정합니다.
- 아래와 같이 설정 정보를 변경합니다.

  ```java

  ```

- 비밀 번호를 수정합니다.
-
