package homework7;

public class Product {
	int id;
	String name;
	double price;
	int quantity;
	double totalPrice;
	

	Product(int id,String name,double price,int  quantity) {
this.id=id;
this.name=name;
this.price=price;
this.quantity=quantity;
	}
	void printInfo() {
		System.out.println("Product information->   name="+name+"   price="+price+"  quantity="+quantity+"  totalPrice="+totalPrice);
	}
}
