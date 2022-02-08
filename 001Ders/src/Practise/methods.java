package Practise;

import java.util.Scanner;

public class methods {
	/*
	 * sual1 -> 2 usdu 3 tapmaq meselen yeni power Scanner scan =new
	 * Scanner(System.in); int say1=scan.nextInt(); int say2=scan.nextInt();
	 * power(say1,say2); } public static void power(int a,int b) { int result=1;
	 * for(int i=1;i<=b;i++) { result*=a; } System.out.println(result);
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ededi daxil edin");
		int input = scan.nextInt();
		int a = scan.nextInt();
		System.out.println("a ededi");
		int b = scan.nextInt();
		System.out.println("b ededi");
		welcome(input);
		topla(a, b);
		int vurma = vur(a, b);
		System.out.println(vurma);

	}

}

	public static void welcome(int x) {
		int result = (x + 2) * 6;
		System.out.println(result);
	}

	public static void topla(int a, int b) {
		int topla = a + b;
		System.out.println(topla);
	}

	public static int vur(int a, int b) {
		return a * b;
	}

	public static int recursive(int x) {
		if (x == 1) {
			return 1;
		}
		return x + recursive(x - 1);
	}

}