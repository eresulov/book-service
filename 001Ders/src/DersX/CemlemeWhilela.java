package DersX;

import java.util.Scanner;

public class CemlemeWhilela {
public static void main(String[] args) {
	int cem=0,i=0;
	Scanner scan=new Scanner(System.in);
	System.out.println("Ededi daxil edin");
	int input=scan.nextInt();
	while(i<=input) {
		cem+=i;
		i++;
	}
System.out.println("0 dan "+input+" a qeder ededlerin cemi = "+cem);
}
}