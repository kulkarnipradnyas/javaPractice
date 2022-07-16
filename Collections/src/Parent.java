
public class Parent {

	public int value=19;
	public Parent() {
		System.out.println("inside parent default const");

	}

	public Parent(int value) {
		super();
		this.value = value;
		System.out.println("inside parent para const");
	}

	public int getValue() {
		System.out.println("inside parent");
		return value;
	}

	
	
}
