package Exceptions;

public class Propagation {
public static void main(String[] args) {
	Propagation classExcprop=new Propagation();
	int result = classExcprop.divide(3,0);
	System.out.println(result);
}
 public int divide (int a ,int b)
 {
	 int result=0;
	 try {
		 result=a/b;
	 }catch(Exception ex) {
		 ex.printStackTrace();
	 }
	 return result;
	 }
}
