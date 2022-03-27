# 13. 정렬을 위해 Comparable과 Comparator 인터페이스 구현하기

## TreeSet 클래스 활용하기

- 객체의 정렬에 사용하는 클래스

- Set 인터페이스를 구현하여 중복을 허용하지 않고, 오름차순이나 내림차순으로 객체를 정렬할 수 있음

- 내부적으로 이진검색트리(binary search tree)로 구현됨

- 이진검색트리에 저장하기 위해 각 객체를 비교해야 함

- 비교 대상이 되는 객체에 Comparable이나 Comparator 인터페이스를 구현 해야 TreeSet에 추가 될 수 있음

- String, Integer등 JDK의 많은 클래스들이 이미 Comparable을 구현했음


TreeSetTest.java  
```
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("홍길동");
		treeSet.add("강감찬");
		treeSet.add("이순신");
		
		for(String str : treeSet) {
			System.out.println(str);
		}
	}
}
```
String 클래스는 이미 Comprable 인터페이스가 구현되어 있으므로 오름차순으로 정렬되어 출력됨


MemberTreeSet.java
```
public class MemberTreeSet {

	private TreeSet<Member> treeSet;

	public MemberTreeSet(){
		treeSet = new TreeSet<Member>();
	}
	
	public void addMember(Member member){
		treeSet.add(member);
	}
	
	public boolean removeMember(int memberId){
		
		Iterator<Member> ir = treeSet.iterator();
		
		while( ir.hasNext()){
			Member member = ir.next();
			int tempId = member.getMemberId();
			if( tempId == memberId){
				treeSet.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다");
		return false;
	}
	
	public void showAllMember(){
		for(Member member : treeSet){
			System.out.println(member);
		}
		System.out.println();
	}
}
```

MemberTreeSetTest.java
```
public class MemberTreeSetTest {

	public static void main(String[] args) {

		MemberTreeSet memberTreeSet = new MemberTreeSet();
		
		Member memberKim = new Member(1003, "김유신");
		Member memberLee = new Member(1001, "이순신");
		Member memberKang = new Member(1002, "강감찬");
		
		memberTreeSet.addMember(memberKim);
		memberTreeSet.addMember(memberLee);
		memberTreeSet.addMember(memberKang);
		memberTreeSet.showAllMember();
		
	}
}
```

- Member클래스가 아이디 오름차순으로 정렬되게 하기 위해 Comparable 인터페이스를 구현

Member.java
```
public class Member implements Comparable<Member>{

	......

	@Override
	public int compareTo(Member member) {
		
		//return (this.memberId - member.memberId);   //오름차순
		return (this.memberId - member.memberId) *  (-1);   //내림 차순
	}
}
```

- **Comparator의 활용** : 이미 Comparable이 구현된 경우 Comparator로 비교하는 방식을 다시 구현할 수 있음

```
class MyCompare implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return (s1.compareTo(s2)) *-1 ;
	}
}

public class ComparatorTest {
	
	public static void main(String[] args) {
		
		Set<String> set = new TreeSet<String>(new MyCompare());
		set.add("aaa");
		set.add("ccc");
		set.add("bbb");
				
		System.out.println(set);
	}
}
```
