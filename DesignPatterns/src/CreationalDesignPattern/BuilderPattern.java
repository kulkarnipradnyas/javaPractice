package CreationalDesignPattern;

// It is used to construct a complex object step by step and the final step will return the object
// here employee object created step by step in builderpattern

class Employeee {
	public String name;
	public int id;

	Employeee() {
	}

	public Employeee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

}

class EmployeeBuilder {
	public String name;
	public int id;

	EmployeeBuilder() {
	}

	public EmployeeBuilder(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Employeee build() {
		return new Employeee(name, id);
	}

	public EmployeeBuilder setName(String n) {
		this.name = n;
		return this;
	}

	public EmployeeBuilder setId(int num) {
		this.id = num;
		return this;
	}

}

class BuilderPattern {
	public static void main(String[] args) {
		Employeee builder = new EmployeeBuilder().setId(1).setName("PK").build();
		System.out.println(builder.name);
	}

}
