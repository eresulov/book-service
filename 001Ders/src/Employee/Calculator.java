package Employee;

public class Calculator {
public void calculatePersonSalary(Person p) {
	p.salary=p.age*1000;
}
public void printInfo(Person p) {
	System.out.println("Info: "+p.age+"  "+p.name+"  "+p.salary);
}
public void changeMoney(int money) {
	money=3;

}
}
