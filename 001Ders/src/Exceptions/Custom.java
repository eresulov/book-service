package Exceptions;

import java.util.Scanner;

public class Custom {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println(" adinizi daxil edin : ");
	String ad=scan.nextLine();
try {
	if(ad.length()==0) {
		throw new Exception("Ici bosdur ");
		
	}
}catch (Exception e) {
	ad="Emral";
	System.out.println(e);
}

	System.out.println("Soyadini yaz : ");
	String soyad=scan.nextLine();
	
		System.out.println("Ad Soyadiniz : "+ad+" "+soyad);
	
}
}
