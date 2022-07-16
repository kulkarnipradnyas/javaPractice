
public class Child extends Parent {

	public int value = 20;

	public Child() {
		System.out.println("inside child  default const");

	}

	public Child(int value) {
		//super();
		this.value = value;
		System.out.println("inside child parameter const");

	}

	public int getValue() {
		
		System.out.println("inside child");
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Parent p1=new Parent();
		//p1.getValue();
		// Child c=  (Child)p1;// parent cannot be cast to child
		// c.getValue();
		// parent constructor called(default)
		// parents getValue=== 19

		 Parent p2=new Child(2); 
		 Child c=  (Child)p2;
		 c.getValue();
		// parent default const then child default constr
		// getvalue from child class

//		//down casting ==== parent cannot be cast to child but will call parent constructor (ClassCastException)
//		Child c1=  (Child) new Parent();
//		c1.getValue();
		
//		Child c2 = new Child();
//		c2.getValue();
	}

}
