package chapter09_ProgrammingPrinciple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* - 지역변수의 범위를 줄이는 가장 강력한 기법은 처음 쓰일 때 선언하기다.
 * - 거의 모든 지역변수는 선언과 동시에 초기화해야 한다.
 * - 변수의 값을 반복문이 종료된 뒤에서 써야하는 상황이 아니라면 for문을 사용하는 편이 낫다.
 * */

public class _57_MinimizeRangeOfLocalVariable {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.addAll(Arrays.asList("haruka", "nanika", "kaede"));
		
		Iterator<String> i1 = names.iterator();
		while(i1.hasNext()) {
			System.out.println(i1.next());
		}
		System.out.println();
		
		@SuppressWarnings("unused")
		Iterator<String> i2 = names.iterator();
		while(i1.hasNext()) { // while문에서 i1의 범위가 넓기 때문에 사용될 수 있다.
			System.out.println(i1.next());
		}
		
		


	}

}
