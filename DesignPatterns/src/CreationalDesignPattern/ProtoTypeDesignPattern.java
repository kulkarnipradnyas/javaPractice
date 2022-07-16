package CreationalDesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time
 and resources and you have a similar object already existing.*/

class Employee implements Cloneable {
	private List<String> empList;

	public Employee() {
		empList = new ArrayList<String>();
	}

	public Employee(List<String> temp) {
		this.empList = temp;
		// TODO Auto-generated constructor stub
	}

	public void loadData() {
		empList.add("Rohan");
		empList.add("Sheena");
	}

	public List<String> getEmpList() {
		return empList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// create new Employee object hence the parameter creation for that
		List<String> temp = new ArrayList<String>();
		// java8
		Consumer<String> co = (names) -> temp.add(names);
		empList.forEach(co);
		return new Employee(temp);
		// old
//		for(String s : this.getEmpList()){
//			temp.add(s);
//		}
//		return new Employee(temp);

	}
}

class ProtoTypeDesignPattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee emp = new Employee();
		emp.loadData();
		List<String> empList=emp.getEmpList();
		
		Employee emp1 = (Employee)emp.clone();
		Employee emp2 = (Employee)emp.clone();
		
		List<String> emp1List=emp1.getEmpList();
		List<String> emp2List=emp2.getEmpList();

		emp1List.add("Emp 1");
		emp2List.add("Emp 2");
		
		System.out.println("Emp1" + emp1List);
		System.out.println("Emp2" + emp2List);
		System.out.println("Emp" + empList);


	}

}
