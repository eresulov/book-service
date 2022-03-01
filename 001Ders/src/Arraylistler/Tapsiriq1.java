package Arraylistler;

import java.util.ArrayList;

public class Tapsiriq1 {
public static void main(String[] args) {
	ArrayList<String> groups =new ArrayList<String>();
	groups.add("Metalicca");
	groups.add("Emral");
	groups.add("Nadir");
	System.out.print("capa verilme : ");
	System.out.println(groups);
	System.out.println("0 ci elementin capi : "+groups.get(0));
	System.out.println("element sayi : "+groups.size());
	// remove istediyivi silir daha sonra gorunmur 
	groups.remove("Nadir");
	if(groups.isEmpty()) {
		System.out.println("Ici bosdur ");
	} System.out.println("ici doludur ");
	
	
}
}
