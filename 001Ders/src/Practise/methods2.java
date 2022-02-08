package Practise;

import java.util.Scanner;

public class methods2 {
	public static void main(String[] args) {
		/*
		 * sual 1 polindrom say tersdende eyni olsun 12321
		 */

		
System.out.println(isPalindrom());
	}

	public static boolean isPalindrom() {
		Scanner scan = new Scanner(System.in);
		System.out.println("eded gir");
		int input = scan.nextInt();
		int terssay=0,temp,qaliq;
		temp=input;
		while(temp!=0) {
			qaliq=temp%10;
			terssay=terssay*10+qaliq;
			temp/=10;
		}
		if(input==terssay) 
			return true;
		else 
			return false;
	}
}
