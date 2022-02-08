package Practise;

import java.util.Scanner;

public class for2 {
public static void main(String[] args) {
	/* sual1 armstrong sayilar
	  int temp,birler,onlar,yuzler,toplam;
	for (int i = 100; i <= 999 ; i++) {
		temp=i;
		birler=temp%10;
		temp/=10;
		onlar =temp%10;
		temp/=10;
		yuzler =temp%10;
		temp/=10;
	toplam =(birler*birler*birler) + (onlar*onlar*onlar)+ (yuzler*yuzler*yuzler);
	if(toplam==i) {
		System.out.println(i+" bir armstrong saydir");
	}
	}*/
	/*sual2 fibonacci 1 1 2 3 5 8 say1 olur soraki sonuncu ile cemlenir 
	  */
Scanner scan=new Scanner(System.in);
System.out.println("1ci ededi daxil et ");
int input=scan.nextInt();;
int s1=0;
int s2=1;
int toplam;
for (int i = 1; i <= input; i++) {
	System.out.print(s1+" , ");
	toplam =s1+s2;
	s1=s2;
	s2=toplam;
	
}
}
}
