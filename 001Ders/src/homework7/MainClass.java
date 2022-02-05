package homework7;

public class MainClass {
public static void main(String[] args) {
	Product porshe=new Product();
	porshe.id=1;
	porshe.name="Porshe panamera";
	porshe.price=100565;
	porshe.quantity=5;
	Product mercedes=new Product();
	mercedes.id=2;
	mercedes.name="Mercedes S Class";
	mercedes.price=20300;
	mercedes.quantity=10;
	Product bmw=new Product();
	bmw.id=3;
	bmw.name="BMW F10";
	bmw.price=25220;
	bmw.quantity=15;
	Calculate c=new Calculate();
	c.CalculatorTotalprice(porshe);
	c.CalculatorTotalprice(mercedes);
	c.CalculatorTotalprice(bmw);
	porshe.printInfo();
	mercedes.printInfo();
	bmw.printInfo();
	
}
}
