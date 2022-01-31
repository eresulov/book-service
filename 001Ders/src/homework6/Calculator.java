package homework6;

public class Calculator {
public int calculateSalary(Employee employee) {
	int salary=employee.age*100+employee.experience*1000+employee.quality*10;
	return salary;
}
}
