package Encapsulation;

public class MainClass {
public static void main(String[] args) {
	Encapsulation enc=new Encapsulation();
	enc.setColor("qara");
	System.out.println("rengin capa verilmesi :  "+enc.getColor());
	enc.setDoors(4);
	System.out.println("qapilarin sayi : "+enc.getDoors());
	enc.setModel("BMW");
	System.out.println("moedlin capi : "+enc.getModel());
	enc.setEngine(4500);
	System.out.println("muherrikin capi : "+enc.getEngine());
	}
}
