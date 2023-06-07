package chapter02_CreatingAndDestroyingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* static factory method의 장점
 * 1. 이름을 가질 수 있다.
 * 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
 * 3. 반환 타입의 하위 타입 객체를 반환할 수 있다.
 * 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
 * 5. static factory method를 작성하는 시점에서는 반환할 객체의 클래스가 존재하지 않아도 된다.
 * 
 * static factory method의 단점
 * 1. 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
 * 2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.
 * */
public class _01_StaticFactoryMethod {

	public static class Person {
	    private String name;
	    private int age;
	    
	    private Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	    
	    @Override
		public String toString() {
	    	byte[] nameBytes = name.getBytes(StandardCharsets.UTF_8);
	        String utf8Name = new String(nameBytes, StandardCharsets.UTF_8);
	        
			return "Person [name=" + utf8Name + ", age=" + age + "]";
		}



		// 정적 팩터리 메서드
	    public static Person createPerson(String name, int age) {
	        return new Person(name, age);
	    }
	}
	
    public static enum MyEnum {
        HARUKA, AHIRO, NINA
    }
	
	public static void main(String args[]) throws IOException {
		
		// 정적 팩터리 메서드 사용하기
		Person person = Person.createPerson("Mahiru", 15);
		System.out.println(person);
		System.out.println();
		
		// 정적 팩터리 메서드에 활용하는 명명방식
		Instant instance = Instant.now();
		Date date = Date.from(instance);
		System.out.println(date);
		
		Set<MyEnum> set = EnumSet.of(MyEnum.HARUKA, MyEnum.AHIRO, MyEnum.NINA);
		System.out.println(set);
		
		BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
		System.out.println(prime);
		
		Path filePath = Path.of("C:\\Temp\\test1.jpg");
		FileStore fs = Files.getFileStore(filePath);
		System.out.println(fs);
		
		BufferedReader br = Files.newBufferedReader(filePath);
		System.out.println(br);
		
		List<String> list = Collections.emptyList();
		System.out.println(list);
		
	}
}
