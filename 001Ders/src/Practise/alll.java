package Practise;

import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		int array[] = new int[5];
		int cem = 0;
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0 && i != 0) {

				System.out.println(i + "ci arrayi daxil et");
				
				array[i] = scan.nextInt();
				cem += array[i];
			}
		}
		System.out.print("girdiyiniz arrays->");
		for (int cap : array) {
			System.out.print(cap + " ");

		}
		System.out.println(" ");	
		System.out.println("cem : " + cem);
		System.out.println("Bos qalan arraylarin doldurulmasi");
		int cem2=cem;
for (int i =0; i < array.length; i++) {
	if (i % 2 == 1 && i == 0) {
		System.out.println(i + "ci arrayi daxil et");
		array[i] = scan.nextInt();
		cem2 += array[i];
}
	}
for (int cap2 : array) {
	System.out.println(cap2+" ");
}
System.out.println("2 ci cem "+cem2);
}
}