package Practise;

import java.util.Scanner;

public class SumArrayMethods {
public static void main(String[] args) {
	int array[]=new int[5];
	Scanner scan = new Scanner(System.in);
	System.out.println("array leri daxil et : ");
for (int i = 0; i < array.length; i++) {
	array[i]=scan.nextInt();
	
}
System.out.println(sumArray(array));
}
public static int sumArray(int array[]) {
	int sum=0;
	for (int i : array) {
		sum+=i;
	}
	return sum;
}
}
