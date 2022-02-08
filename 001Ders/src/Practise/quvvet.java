package Practise;
//girilen sayin 2 nin quvvetini tapsin

import java.util.Scanner;

public class quvvet {
	public static void main(String[] args) {
		System.out.println("say gir");
		Scanner scan =new Scanner(System.in);
		int input=scan.nextInt();
		int quvvet=1;
		for(int i=0;i<input;i++) {
			quvvet*=2;
			
		}
		System.out.println(quvvet);
		}

	}
