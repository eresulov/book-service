package az.developia.main;

import java.util.Scanner;

import az.developia.model.Customer;



public class MainCLass {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	boolean createCustomer=true;
	while(createCustomer) {
		System.out.println("Musteri adini daxil edin : ");
		String customerName = input.nextLine();
		System.out.println("Musteri soyadini daxil edin : ");
		String customerSurname = input.nextLine();
		System.out.println("Musteri nomresini daxil edin : ");
		String customerPhone = input.nextLine();
		System.out.println("Musteri address ni daxil edin : ");
		String customerAdress = input.nextLine();
		Customer customer = new Customer();
		customer.setName(customerName);
		customer.setSurnime(customerSurname);
		customer.setPhone(customerPhone);
		customer.setAddress(customerAdress);
		System.out.println("Yeni musteri qeydiyyat etmek isteyirsiz?");
		if(input.nextLine().equals("Yes")) {
			
		}else createCustomer=false;
	}
System.out.println("");
	
	input.close();
}


}

