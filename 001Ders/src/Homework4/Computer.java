package Homework4;

public class Computer {
int id;
String brand;
String model;
String color;
int ram;
String cpu;
int year;
Computer(){
	System.out.println("Parametrsiz olan geldi");
}
Computer(int id,String brand,String model,String color,int ram,String cpu,int year){
	this.id=id;
	this.brand=brand;
	this.model=model;
	this.color=color;
	this.ram=ram;
	this.cpu=cpu;
	this.year=year;
}
void info() {
	System.out.println("Informations-> "+"id="+id+" brand ->"+brand+" model->"+model+" color->"+color+" ram->"+ram+" Cpu->"+cpu+" year->"+year);
}
}
