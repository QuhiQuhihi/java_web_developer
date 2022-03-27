# Spring Expression Language

스프링의 표현식을 사용할 수 있는 곳...

- @Value() 안에서 쓸 수 있다.
- Security 의 Invocation 표현식에서 쓸 수 있다.

## 표현식 : #{}

- #{} 안의 값을 파싱해서 evaluation 해줍니다.
- #{} 안에는 숫자 연산, Boolean 연산, 객체 참조 및 객체 연산 등을 수행할 수 있습니다.

# 빈 참조

- 컨테이너 안에서 빈을 이름으로 참조할 수 있다.
- 스프링 Security 에서는 @를 이용해 빈을 참조한다.

# 동적인 빈 수정

- 빈의 값을 expression 을 이용해 수정할 수 있습니다.

## 참고

- https://www.baeldung.com/spring-expression-language
