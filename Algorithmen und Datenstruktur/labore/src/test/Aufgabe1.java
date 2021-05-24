package test;

import java.util.Scanner;

public class Aufgabe1 {

	public static void main1(String[] args) {
		

		int a, b, flaeche, umfang;
		a=4;
		b=9;
		flaeche=a*b;
		umfang=a*2+b*2;
		System.out.println("flaeche = "+flaeche);
		System.out.println("umfang = "+umfang);
}

public static void main(String[] args) {
	

		int a, b, flaeche, umfang;
		Scanner in=new Scanner(System.in);
		System.out.println("Seitenlängen eingeben :");
		a=in.nextInt();
		b=in.nextInt();
		flaeche=a*b;
		umfang=a*2+b*2;
		System.out.println("flaeche = "+flaeche);
		System.out.println("umfang = "+umfang);
		in.close();
}

}
