package Employee;

public class MainClass {
public static void main(String[] args) {
	Person emral=new Person("Emral",19);
	Calculator c=new Calculator();
	c.calculatePersonSalary(emral);
	c.printInfo(emral);
	int money=5;
	c.changeMoney(money);
System.out.println(money);

}
}
