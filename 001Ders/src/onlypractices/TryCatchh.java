package onlypractices;

public class TryCatchh {
public static void main(String[] args) {
	try {
		int a=2/0;
		System.out.println(a);
	}catch(Exception ex) {
	System.out.println("Exception : "+ex);
		System.out.println(ex.getMessage());
		System.out.println(ex.toString());
	}
	System.out.println("Proqram bitti");
}
}
