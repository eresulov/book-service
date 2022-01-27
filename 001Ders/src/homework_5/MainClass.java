package homework_5;

public class MainClass {
public static void main(String[] args) {
	PrimitiveTypes bytee=new PrimitiveTypes(127,-128,8);
	PrimitiveTypes shortt=new PrimitiveTypes(32767,-32767,16);
	PrimitiveTypes intt=new PrimitiveTypes(2147483623,-2147483648,32);
	PrimitiveTypes longg=new PrimitiveTypes(92233777,-923322332,64);
	PrimitiveTypes charr=new PrimitiveTypes(1,0,16);
	PrimitiveTypes floatt=new PrimitiveTypes(34234321,-34543234,32);
	PrimitiveTypes doublee=new PrimitiveTypes(1795678678,1728798728,64);
	
	bytee.info();
	shortt.info();
	intt.info();
	longg.info();
	charr.info();
	floatt.info();
	doublee.info();
	tam_eded();
	kesr_eded();
}
public static void tam_eded() {
	System.out.println("Tam eded tipleri -> Byte , Short , Int , Long ");
}
public static void kesr_eded() {
	System.out.println("Kesr eded tipleri -> Float , Double ");
}
}
