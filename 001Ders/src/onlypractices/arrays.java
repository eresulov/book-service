package onlypractices;

import java.util.Scanner;

public class arrays {
public static void main(String[] args) {
	int arr[]=new int[5];
	for (int i = 0; i < arr.length; i++) {
		Scanner scan=new Scanner(System.in);
		arr[i]=scan.nextInt();
		
	}
	for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	}
	}
}