package homework7;

public class Product {
	int id;
	String name;
	double price;
	int quantity;
	double totalPrice;
	Product() {

	}

	Product(int id,String name,double price,double totalPrice,int  quantity) {

	}
	void printInfo() {
		System.out.println("Product information->   name="+name+"   price="+price+"  quantity="+quantity+"  totalPrice="+totalPrice);
	}
}
