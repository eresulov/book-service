package Garbage;

public class GarbageColllectionsusing {
public static void main(String[] args) {
	Person emral=new Person();
	Person arif=emral;
	emral=null;
	
	emral.age=19;
	System.out.println(emral);
}
}
