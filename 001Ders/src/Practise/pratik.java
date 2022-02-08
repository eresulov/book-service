package Practise;

import java.util.Scanner;

public class pratik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int toplam = 0;
		int input = 0;
		while (true) {
			System.out.println("say gir ");
			input = sc.nextInt();
			if (input < 0) {
				System.out.println("menfi eded girdiyin ucun bitti");

				break;
			}
			if (input % 2 == 1) {
				toplam += input;
				System.out.println("cem=" + toplam);
		}
		
		}
	}
}
