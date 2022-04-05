package Collections;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
public class Set {
public static void main(String[] args) {
	TreeSet<String> names=new TreeSet<String>();

	// set de 1 addan 2 defe elave elemek olmaz sadece 1 ni cixarir 
	//TreeSet sira ile cixarir 
	names.add("Emral");	
	names.add("Nadir");
	names.add("Murad");
	System.out.println(names);
	
}
}
