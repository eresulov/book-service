package Ders12;

import java.util.Scanner;

public class Strniglebaglisuallar {
public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);
	System.out.println("Deyeri daxil edin : ");
	String name=scan.nextLine();
	System.out.println("Girdiyiniz deyer : "+name);
		System.out.println("Bu deyisende olan simvol sayi : "+name.length());
		System.out.println("i simvolu "+name.indexOf('i')+" cu indexdedir");
		System.out.println("Bu deyisenin simvollarin kicik edilmis version : "+name.toLowerCase());
		System.out.println("Bu deyisenin simvollarin boyuk edilmis version : "+name.toUpperCase());
		System.out.println("Cavid deyiseni burda varmi? -> "+name.contains("Cavid"));
		System.out.println("Girdiyiniz deyer id ile bitirmi? -> "+name.endsWith("id"));
		boolean baslayirmi=name.startsWith("Ca");
		System.out.println("Girdiyiniz deyer C ile baslayirmi -> "+baslayirmi);
		System.out.println("Deyisene Adil deyerini menimsedirik : "+name.replace(name, "Adil"));
		System.out.println("Deyisenin etrafinda olan lazimsiz bosluqlari silmek : "+name.trim());
		System.out.println("Deyisene Bextiyar deyerini menimsedirik : "+name.replace(name, "Bextiyar"));
		System.out.println("Deyisene Adil deyerini menimsedirik : "+name.replace(name, "Eli Hesenov"));
		System.out.println("Cumlelere bolmek ucun bir deyer girin : ");
		String newArray=scan.nextLine();
		String [] newArrays=newArray.split(" ");
		for (String cap : newArrays) {
			System.out.println(cap);
		}
}
}
