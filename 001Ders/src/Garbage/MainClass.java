package Garbage;

public class MainClass {
public static void main(String[] args) {
	Product computer=new Product();
	computer.name="Dell";
	ProductUtil productutil=new ProductUtil();
	System.out.println("First computer price: "+computer.price);
	int price=10;
	System.out.println("first price: "+price);
	productutil.setPriceforProduct(computer,price);
	System.out.println("Pass by reference: "+computer.price);
	System.out.println("Pass by value: "+price);
}
}
