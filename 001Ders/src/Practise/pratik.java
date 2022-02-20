package Practise;

import java.util.Scanner;

public class pratik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("a ededini daxil et");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int array[]=new int[3];
		array[0]=1;
		array[1]=4;
		array[2]=6;
		topla(a,b);
		
		System.out.println("sum="+sumArray(array));
	}
	public static void topla(int a,int b) {
		int cem=a+b;
		System.out.println("cem="+cem);
	}
	public static int sumArray(int array[]) {
		int sum=0;
		for (int i : array) {
		sum+=i;
		}
		return sum;
	}
}
