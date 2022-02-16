package DersX;

import java.util.Scanner;

public class ArraywithString {
public static void main(String[] args) {
	String array[]=new String[3];
	Scanner scan=new Scanner(System.in);
	
	for (int i = 0; i < array.length; i++) {
		System.out.println(i+" ci elementi daxil et :");
		array[i]=scan.nextLine();
	}
	int i=0;
while(i<array.length) {
	System.out.println(i+"ci element : "+array[i]);
	i++;
}
}
}
