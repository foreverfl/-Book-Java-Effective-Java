package chapter02_CreatingAndDestroyingObjects;

/* - private 생성자를 추가하면 클래스의 인스턴스화를 막을 수 있다.
 * */

public class _04_PrivateConstructorToPreventInstantiation {
	public static class MathUtils {
		private MathUtils() { // 인스턴스화를 막기 위한 구현
			
		}

		public static int add(int a, int b) {
			return a + b;
		}

		public static int subtract(int a, int b) {
			return a - b;
		}

		public static int multiply(int a, int b) {
			return a * b;
		}

		public static int divide(int a, int b) {
			if (b != 0) {
				return a / b;
			} else {
				throw new IllegalArgumentException("Divisor cannot be zero");
			}
		}
	}

	public static void main(String[] args) {
        int result = MathUtils.add(5, 3); // 정적 메서드를 통한 호출
        System.out.println("Addition: " + result);

        result = MathUtils.subtract(8, 4);
        System.out.println("Subtraction: " + result);

        result = MathUtils.multiply(6, 2);
        System.out.println("Multiplication: " + result);

        result = MathUtils.divide(10, 2);
        System.out.println("Division: " + result);

	}

}
