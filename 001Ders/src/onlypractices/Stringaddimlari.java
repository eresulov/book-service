package onlypractices;

import java.util.Scanner;

public class Stringaddimlari {
public static void main(String[] args) {
	//Emral Resulov
	Scanner scan=new Scanner(System.in);
	System.out.println("Yazmaq istediyinizi daxil edin");
	String s=scan.nextLine();
	System.out.println("s in uzunlugu > "+s.length());
	char c=s.charAt(0);
	System.out.println("0 ci element : "+c);
	System.out.println(s.toUpperCase());
	System.out.println(s.trim());
System.out.println("herflerin boyuk kicikliyini nezere almadan "+s.equalsIgnoreCase(s));
int a=s.indexOf("a");
System.out.println(a);
boolean f=s.startsWith("emr");
System.out.println(f);
boolean z=s.endsWith("salam");
System.out.println(z);
int h=s.lastIndexOf("ov");
System.out.println(h);
boolean t=s.contains("emral");
System.out.println("vardirmi orda "+t);
System.out.println(s.replace("emral", "resul"));
System.out.println("substring necencise simvoldan sonrani capa verir"+s.substring(5));
}
}