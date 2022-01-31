package onlypractices;

import java.util.Scanner;

public class Mainclass {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Yazmaq istediyinizi daxil edin");
	String s=scan.nextLine();
	System.out.println("s in uzunlugu > "+s.length());
	char c=s.charAt(0);
	System.out.println(c);
	System.out.println(s.toUpperCase());
	System.out.println(s.trim());
int a=s.indexOf("a");
System.out.println(a);
boolean f=s.startsWith("emr");
System.out.println(f);
boolean z=s.endsWith("salam");
System.out.println(z);
int h=s.lastIndexOf("ov");
System.out.println(h);
boolean t=s.contains("emral");
System.out.println(t);
System.out.println(s.replace("emral", "resul"));
}
}