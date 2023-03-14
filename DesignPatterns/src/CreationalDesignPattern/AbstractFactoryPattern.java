package CreationalDesignPattern;
// Step 1: created parent Computer abstract class(parent will have common component for child like harddisk), children Laptop and server from them
// Step 2: created ServerFactories from children LaptopFactor and ServerFactory and similarly for parent created interface called ComputerAbstractFactory interface
// Step 3: Each factory will written its child component like LaptopFactory=> Laptop
// Step 4: Now create a factory class called ComputerFactory which will accept factories and call there respective overriden methods 

abstract class Computer {
	abstract String getHdd();

}

class ComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}

interface ComputerAbstractFactory {

	Computer createComputer();

}

class Laptop extends Computer {
	public String hdd;

	public Laptop(String hdd) {
		super();
		this.hdd = hdd;
	}

	@Override
	String getHdd() {
		return this.hdd;
	}

}

class LaptopFactory implements ComputerAbstractFactory {
	private String hdd;

	public LaptopFactory(String h) {
		this.hdd = h;

	}

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new Laptop(hdd);
	}

}

class Server extends Computer {
	public String hdd;

	public Server(String hdd) {
		super();
		this.hdd = hdd;
	}

	public Server() {
		super();
	}

	@Override
	String getHdd() {
		return this.hdd;
	}
}

class ServerFactory implements ComputerAbstractFactory {
	private String hdd;

	public ServerFactory(String h) {
		this.hdd = h;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new Server(hdd);
	}

}

class AbstractFactoryPattern {
	private static void testAbstractFactory() {
		// here using Big factory we can call sub factories
		Computer pc = ComputerFactory.getComputer(new LaptopFactory("2 GB"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}

	public static void main(String[] args) {
		testAbstractFactory();
	}
}
