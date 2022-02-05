package homework7;

public class MainClass {
public static void main(String[] args) {
	Product porshe=new Product(1,"Porshe panamera",100565,5);
	Product mercedes=new Product(2,"Mercedes S Class",20300,10);
	Product bmw=new Product(3,"BMW F10",25220,15);
	Calculate c=new Calculate();
	c.CalculatorTotalprice(porshe);
	c.CalculatorTotalprice(mercedes);
	c.CalculatorTotalprice(bmw);
	porshe.printInfo();
	mercedes.printInfo();
	bmw.printInfo();
	
}
}
