# 10. 사용자 정의 예외 클래스와 그 활용

## 사용자 정의 예외 클래스 구현하기

- 자바에서 제공되는 예외 클래스외에 프로그래머가 직접 만들어야 하는 예외가 있을 수 있음

- 기존 예외 클래스중 가장 유사한 예외 클래스에서 상속 받아 사용자 정의 예외 클래스를 만든다.

- 기본적으로 Exception 클래스를 상속해서 만들 수 있음

## 패스워드에 대한 예외 처리 하기

- 패스워드를 입력할 때 다음과 같은 경우 오류처리를 합니다.

    비밀번호는 null일 수 없습니다.

    비밀번호의 길이는 5이상입니다.

    비밀번호는 문자로만 이루어져서는 안됩니다.(하나이상의 숫자나 특수문자를 포함)


```
public class PasswordException extends IllegalArgumentException{
	
	public PasswordException(String message) {
		super(message);
	}
}
```

```
public class PasswordTest {

		private String password;
		
		public String getPassword(){
			return password;
		}
		
		public void setPassword(String password) throws PasswordException{
			
			if(password == null){
				throw new PasswordException("비밀번호는 null 일 수 없습니다");
			}
			else if( password.length() < 5){
				throw new PasswordException("비밀번호는 5자 이상이어야 합니다.");
			}
			else if (password.matches("[a-zA-Z]+")){
				throw new PasswordException("비밀번호는 숫자나 특수문자를 포함해야 합니다.");
			}
			
			this.password = password;
		}
		
		public static void main(String[] args) {

			PasswordTest test = new PasswordTest();
			String password = null;
			try {
				test.setPassword(password);
				System.out.println("오류 없음1");
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			}
			
			password = "abcd";
			try {
				test.setPassword(password);
				System.out.println("오류 없음2");
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			}
			
			password = "abcde";
			try {
				test.setPassword(password);
				System.out.println("오류 없음3");
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			}
			
			password = "abcde#1";
			try {
				test.setPassword(password);
				System.out.println("오류 없음4");
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			}
		}
}
```



