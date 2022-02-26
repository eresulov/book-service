package Inheritance;


public class Ata {
private String name;
private int id;
Ata(String name,int id){
	this.name=name;
	this.id=id;
}
public void printInfo() {
	System.out.println("Info :  name = "+this.name+" id= "+this.id);
}
}