package Inheritance;


public class Ogul extends Ata {
@Override
	public String toString() {
		
		return "Emral";
	}
public int num_of_employees;
	Ogul(String name, int id,int num_of_employees) {
		super(name, id);
		this.num_of_employees=num_of_employees;
		
	}
public void raiseSalary(int amount ) {
	System.out.println("Iscilere : "+amount + " manat maas artimi oldu ");
}
@Override
public void printInfo() {
	super.printInfo();
	System.out.println("numofemployees : "+num_of_employees);
}
}
