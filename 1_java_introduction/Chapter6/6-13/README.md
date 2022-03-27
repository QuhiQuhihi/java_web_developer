# 13. 표준 입출력 스트림

## System 클래스의 표준 입출력 멤버

```
public class System{ 
	public static PrintStream out; 
	public static InputStream in; 
	public static PrintStream err; 
}
```

- System.out

표준 출력(모니터) 스트림

System.out.println("출력 메세지");

- System.in

표준 입력(키보드) 스트림

int d = System.in.read() // 한 바이트 읽기

- System.err

표준 에러 출력(모니터) 스트림

System.err.println("에러 메세지");

## System.in 사용하기 예제

```
public class SystemInTest1 {

	public static void main(String[] args) {
		System.out.println("알파벳 하나를 쓰고 [Enter]를 누르세요");
		
		int i;
		try {
			i = System.in.read();
			System.out.println(i);
			System.out.println((char)i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
```

```
public class SystemInTest2 {

	public static void main(String[] args) {
		System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요");
		
		int i;
		try {
			while( (i = System.in.read()) != '\n' ) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```



