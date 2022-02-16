package Practise;
//bu sadece capi ve cemlemekdir.
import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		int array[] = new int[5];
		System.out.println("Bu 1 ci sualdir");
		int cem = 0;
		int count=array.length;
		int avarage;
		Scanner scan = new Scanner(System.in);
		System.out.println("arrays daxil et");
		System.out.println("2  ci ededi daxil et");
		array[2] = scan.nextInt();
		System.out.println("4 cu ededi daxil et");
		array[4] = scan.nextInt();
		System.out.print("arrayin capi : ");
		for (int cap : array) {
			cem+=cap;
			System.out.print(cap + " ");
		}
		System.out.println();
		System.out.println("cem : " + cem);

		System.out.println("0  ci ededi daxil et");
		array[0] = scan.nextInt();
		System.out.println("1  ci ededi daxil et");
		array[1] = scan.nextInt();
		System.out.println("3 cu ededi daxil et");
		array[3] = scan.nextInt();
		System.out.print("Yeni arrayin capi : ");
		cem=0;
		for (int cap2 : array) {
			cem+=cap2;
			System.out.print(cap2 + " ");
		}
		System.out.println();
		System.out.println("Yeni cem : " + cem);
		avarage=cem/count;
		System.out.println("Avarage : "+avarage);
	}

}