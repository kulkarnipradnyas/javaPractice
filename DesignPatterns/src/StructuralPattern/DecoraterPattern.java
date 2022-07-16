package StructuralPattern;
// When we wish to add, enhance or even remove the behavior or state of objects

// When we just want to modify the functionality of a single object of class and leave others unchanged

//Step1: create interface
interface ChristmasTree {
	String decorate();
}
//Step2: ChrismasTreeImpl  and  abstract class TreeDecorator implements ChristmasTree
class ChrismasTreeImpl implements ChristmasTree {
	
	@Override
	public String decorate() {
		// TODO Auto-generated method stub
		return "Christmas tree";
	}

}

abstract class TreeDecorator implements ChristmasTree {
	// instance of interface
	private ChristmasTree christmasTree;

	TreeDecorator(ChristmasTree c) {
		this.christmasTree = c;
	}

	@Override
	public String decorate() {
		// TODO Auto-generated method stub
		return christmasTree.decorate();
	}
}
//Step3: Create subclass from abstract class which accept super class instance as a parameter in constructor
//BubbleLights and Garland
class BubbleLights extends TreeDecorator{

	BubbleLights(ChristmasTree c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	public String decorate() {
		// TODO Auto-generated method stub
		return super.decorate() + this.decorateWithBubbleLights();
	}
	private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
	
}
class Garland extends TreeDecorator{

	Garland(ChristmasTree c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	public String decorate() {
		// TODO Auto-generated method stub
		return super.decorate() + this.decorateWithBubbleLights();
	}
	private String decorateWithBubbleLights() {
        return " with Garland!!";
    }
	
}
// we can create object inside object in this pattern
//here ChrismasTreeImpl is parent class on the top of that we want to enhance something hence created child out of it
class DecoraterPattern {
	public static void main(String[] args) {
		ChristmasTree tree1 = new Garland(new ChrismasTreeImpl());
		System.out.println(tree1.decorate());
		// here we want both garland and bubblelight as they are part of ChristmasTree
		 ChristmasTree tree2 = new BubbleLights(
			      new Garland(new Garland(new ChrismasTreeImpl())));
		 System.out.println(tree2.decorate());
	}

}
