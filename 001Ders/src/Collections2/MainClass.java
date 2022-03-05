package Collections2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class MainClass{
public static void main(String[] args) {
	Computer c= new Computer();
	Computer c1= new Computer();
	Computer c2 = new Computer();
	c.id=1;
	c.model="Asus";
	c.ram= 32;
	c1.id=2;
	c1.model="Vivobook";
	c1.ram= 8;
	c2.id=3;
	c2.model="MacBook";
	c2.ram= 16;
	ArrayList<Computer> list1= new ArrayList<Computer>();
	list1.add(c);
	list1.add(c1);
	list1.add(c2);
System.out.println(list1);
Collections.sort(list1);
System.out.println(list1);

	
}
}
