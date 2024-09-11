package arraysUnidimensionales;

import java.util.Scanner;

public class Temperaturas {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        double[] temperaturas=new double[7];
        double sumaTemperaturas=0;
        String[] diasSemana={"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
        for (int i=0;i<7;i++) {
            System.out.print("Dame la temperatura del "+diasSemana[i]+": ");
            temperaturas[i]=sc.nextDouble();
            sumaTemperaturas+=temperaturas[i];
        }
        double temperaturaMedia=sumaTemperaturas/7;
        System.out.println("La temperatura media es: "+temperaturaMedia);
        temperaturasPorEncimaDebajo(diasSemana,temperaturas,temperaturaMedia);
        sc.close();
	}
	
	private static void temperaturasPorEncimaDebajo(String[] diasSemana, double[] temperaturas, double temperaturaMedia) {
		for (int i=0;i<7;i++) {
            String dia=diasSemana[i];
            double temperatura=temperaturas[i];
            String relacionConMedia="";
            if (temperatura>temperaturaMedia) 
                relacionConMedia="por encima de la media";
            else if (temperatura<temperaturaMedia) 
                relacionConMedia="por debajo de la media";
            else 
                relacionConMedia="igual a la media";
            System.out.println("La temperatura del "+dia+" ("+temperatura+") está "+relacionConMedia+".");
        }
	}

}
