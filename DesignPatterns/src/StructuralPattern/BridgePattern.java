package StructuralPattern;

// When you don't want a permanent binding between the functional abstraction and its implementation.
// When both the functional abstraction and its implementation need to extended using sub-classes.
// It is mostly used in those places where changes are made in the implementation does not affect the clients.

 interface Color {
	String fill();
}

class Blue implements Color {

	@Override
	public String fill() {
		return "I am Blue";

	}

}

class Red implements Color {

	@Override
	public String fill() {
		return "I am Red";

	}

}

abstract class Shape {
	// instance of interface can be created in abstract class , Java Nested Class,
	// Java Enum, Java Dynamic Proxy
	protected Color color;

	Shape(Color color) {
		this.color = color;
	}

	abstract String draw();
}

class Square extends Shape {

	Square(Color color) {
		super(color);
	}

	@Override
	public String draw() {
		return "Square drawn. " + color.fill();
	}
}

 class BridgePattern {

	public static void main(String[] args) {
		Shape square = new Square(new Red());
		Shape blueSquare = new Square(new Blue());
		System.out.println(square.draw());
		System.out.println(blueSquare.draw());
	}
}
