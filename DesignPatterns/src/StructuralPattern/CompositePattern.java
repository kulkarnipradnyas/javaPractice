package StructuralPattern;

import java.util.ArrayList;
import java.util.List;

// base component: As a component object we'll define a simple Department interface:
// Leaf: For the leaf components, let's define classes for financial and sales departments:
// Composite Element: As a composite class, let's create a HeadDepartment class:

interface Department {
	void printDepartmentName();
}

class FinancialDepartment implements Department {
	public Integer id;
	public String name;

	public FinancialDepartment(int i, String name) {
		this.id = i;
		this.name = name;
	}

	@Override
	public void printDepartmentName() {
		System.out.println("FinancialDepartment FinancialDepartment");
		//System.out.println(getClass().getSimpleName());
	}

}

class SalesDepartment implements Department {
	public Integer id;
	public String name;

	public SalesDepartment(int i, String name) {
		this.id = i;
		this.name = name;
	}

	@Override
	public void printDepartmentName() {
		System.out.println("SalesDepartment SalesDepartment");
//		System.out.println(getClass().getSimpleName());
	}

}

class HeadDepartment implements Department {
	public Integer id;
	public String name;
	List<Department> childDepartments;

	public HeadDepartment(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.childDepartments = new ArrayList<>();
	}

	@Override
	public void printDepartmentName() {
		for(Department s : childDepartments){
			s.printDepartmentName();
		}
		//childDepartments.forEach(Department::printDepartmentName);
	}

	public void addDepartment(Department department) {
		childDepartments.add(department);
	}

	public void removeDepartment(Department department) {
		childDepartments.remove(department);
	}

}

class CompositePattern {
	public static void main(String[] args) {
		Department salesDepartment = new SalesDepartment(1, "Sales department");
		Department financialDepartment = new FinancialDepartment(2, "Financial department");

		HeadDepartment headDepartment = new HeadDepartment(3, "Head department");

		headDepartment.addDepartment(salesDepartment);
		headDepartment.addDepartment(financialDepartment);

		headDepartment.printDepartmentName();
	}
}
