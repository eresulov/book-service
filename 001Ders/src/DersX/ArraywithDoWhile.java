package DersX;

import java.util.Scanner;

public class ArraywithDoWhile {
public static void main(String[] args) {
	String array[]=new String[3];
	Scanner scan=new Scanner(System.in);
	for (int i = 0; i < array.length; i++) {
		System.out.println(i+" ci deyeri daxil et: ");
	
		array[i]=scan.nextLine();
	}
	int i=0;
	do {
	System.out.println("Capa verilme : "+array[i]);
	i++;
	}
	while(i<array.length);
	
}
}
