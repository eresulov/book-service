package Practise;
import java.util.Scanner;
public class While1 {
	
	// eded sadedirmi onu yoxlayir
public static void main(String[] args) {
    System.out.println("Bir eded daxil et");
    Scanner scan=new Scanner(System.in);
    int say=scan.nextInt();
    int saygac=0;
    if(say<1){
        System.out.println("1 den boyuk ededler sade ola biler");
    }
    else{
        for(int i=1;i<=say;i++){
            int qalan=say%i;
            if(qalan==0){
            saygac++;
        }
        }
            if(saygac==2){
                System.out.println("Say sadedir");
            }
            else{
                System.out.println("Say murekkebdir");
            }
    }
}
}