package chapter02_CreatingAndDestroyingObjects;


/* - 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기가 어려워질 수 있다.
 * */

public class _03_GuaranteeToBeSingleton {

	// 정적 팩터리 싱글턴
	public static class Singleton {
	    private static final Singleton instance = new Singleton();

	    private Singleton() {
	        // private 생성자로 외부에서 인스턴스 생성을 막습니다.
	    }

	    public static Singleton getInstance() {
	        return instance;
	    }
	    
	    public void printMessage(String message) {
	        System.out.println(message);
	    }

	}
	
	// 원소가 하나인 열거타입을 이용한 싱글턴
	public static enum EnumSingleton {
	    INSTANCE;

	    public void printMessage(String message) {
	        System.out.println(message);
	    }
	}
	
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		singleton1.printMessage("Hello, Singleton!");
		
		EnumSingleton singleton2 = EnumSingleton.INSTANCE;
		singleton2.printMessage("Hello, EnumSingleton!");
	}

}
