package CreationalDesignPattern;

interface Shapable {
	public void draw();

	public void getArea(ShapableFactory sh);
}

// you can use either interface or abstract class
class ShapableFactory implements Shapable {
	public String shape;

	public ShapableFactory() {
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	ShapableFactory getShape() {
		if (this.shape == "c") {
			return new Circle();
		}
		return new Rectange();

	}

	@Override
	public void getArea(ShapableFactory sh) {
		sh.draw();
		System.out.println("Shapable");

	}

}

class Circle extends ShapableFactory {
	public Circle() {
	}

	public Circle(String s) {
		this.shape = s;
	}

	@Override
	public void draw() {
		System.out.println("Circle");

	}

}

class Rectange extends ShapableFactory {
	public Rectange() {
	}

	public Rectange(String s) {
		this.shape = s;
	}

	@Override
	public void draw() {
		System.out.println("Rectange");

	}

}

class CustomerFactory {
	public static void main(String[] args) {

		ShapableFactory obj1 = new Circle("c");
		ShapableFactory obj2 = new Rectange("s");
		obj1.getShape();
		// obj1.draw();
		// other way

		ShapableFactory c1 = new Circle();
		c1.getArea(c1);
	}

}