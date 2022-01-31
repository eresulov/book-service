package homework6;

public class MainClass {
public static void main(String[] args) {
	Employee emral=new Employee();
	emral.experience=4;
	emral.age=19;
	emral.quality=100;
	Employee asif=new Employee();
	asif.experience=2;
	asif.age=20;
	asif.quality=50;
	Calculator clc=new Calculator();
	int emralsalary=clc.calculateSalary(emral);
	int asifsalary=clc.calculateSalary(asif);
	emral.info();
	System.out.println("Emral s salary ->"+emralsalary);
	asif.info();
	System.out.println("Asif s salary"+asifsalary);
}
}
