package Homework4;

public class Computer {
String ad;
String soyad;
int yas;
Computer(String ad,String soyad,int yas){
	this.ad=ad;
	this.soyad=soyad;
	this.yas=yas;
}
void info() {
	System.out.println("Informations->"+ad+"  "+soyad+"  "+yas);
}
}