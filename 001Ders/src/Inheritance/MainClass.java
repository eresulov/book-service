package Inheritance;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Ata isci1 = new Ata("Nadir", 3);
		isci1.printInfo();
		Ogul og = new Ogul("Natiq", 2, 55);
		og.printInfo();
		Scanner scan = new Scanner(System.in);
		System.out.println("Neqeder maas artimi olsun isteyirsiz?");
		int maasArtimi = scan.nextInt();
		og.raiseSalary(maasArtimi);
		System.out.println(og.toString());
		}
}
