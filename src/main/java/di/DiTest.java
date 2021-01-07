package di;

class Person{
	String name;
	int age;
	public Person() {}
	//private Person() {}
}

public class DiTest {

	/*
	강한결합(독립성낮음) : new를 통해 직접 객체를 생성함.
		결합도가 높기때문에 Person클래스의 변화에 직접적인 영향을 받는다.
	 */
	public static void aPerson() {
		Person person = new Person();
		person.name = "홍길동";
	}
	/*
	약한결합(독립성높아짐) : 미리 생성된 객체를 주입(Injection)받음.
		결합도가 낮아지기 때문에 Person클래스에 변화가 생기더라도
		영향을 받지 않는다. 또한 코드도 좀 더 간결해진다.
	*/
	public static void bPerson(Person person) {
		person.age = 33;
	}
	
	public static void main(String[] args) {
		
	}
}
