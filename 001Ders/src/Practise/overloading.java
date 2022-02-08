package Practise;

import java.util.Scanner;

public class overloading {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println("a ededini daxil edin");
	int a=scan.nextInt();
	System.out.println("b ededini daxil edin");
	int b=scan.nextInt();
	System.out.println("c ededini daxil edin");
	double c=scan.nextDouble();
	System.out.println(add(a,b));
	System.out.println(add(5,6,7.5));
	System.out.println(add(a,b,c));
}
public static int add(int a,int b) {
	return a+b;
}
public static int add(int a,int b,int c) {
	return a+b+c;
}
public static double add(int a,int b,double c) {
	return a+b+c;
}
}
