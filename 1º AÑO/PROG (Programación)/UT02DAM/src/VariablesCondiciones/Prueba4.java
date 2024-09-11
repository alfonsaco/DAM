package VariablesCondiciones;

import java.util.Scanner;

public class Prueba4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cálculo de nómina:");
        System.out.println("1) Programador junior");
        System.out.println("2) Programador senior");
        System.out.println("3) Jefe de proyecto");

        System.out.print("Introduzca el cargo del empleado: ");
        int cargo = sc.nextInt();

        System.out.print("¿Cuántos días ha estado de viaje visitando clientes? ");
        int diasViaje = sc.nextInt();

        System.out.print("Introduzca su estado civil (1 - Soltero, 2 - Casado): ");
        int estadoCivil = sc.nextInt();

        // Definir variables para sueldo base y porcentaje de IRPF
        double sueldoBase = 0;
        double porcentajeIRPF = 0;

        // Calcular sueldo base y porcentaje de IRPF según el cargo
        switch (cargo) {
            case 1:
                sueldoBase = 950.0;
                break;
            case 2:
                sueldoBase = 1200.0;
                break;
            case 3:
                sueldoBase = 1600.0;
                break;
            default:
                System.out.println("Cargo no válido.");
                sc.close();
                return;
        }

        // Calcular dietas y sueldo bruto
        double dietas = diasViaje * 30.0;
        double sueldoBruto = sueldoBase + dietas;

        // Calcular porcentaje de IRPF según el estado civil
        switch (estadoCivil) {
            case 1:
                porcentajeIRPF = 0.25;
                break;
            case 2:
                porcentajeIRPF = 0.20;
                break;
            default:
                System.out.println("Estado civil no válido.");
                sc.close();
                return;
        }

        // Calcular retención de IRPF y sueldo neto
        double retencionIRPF = sueldoBruto * porcentajeIRPF;
        double sueldoNeto = sueldoBruto - retencionIRPF;

        // Mostrar resultados
        System.out.println("______________________________________");
        System.out.println("Sueldo base: " + sueldoBase + "€");
        System.out.println("Dietas (" + diasViaje + " viajes): " + dietas + "€");
        System.out.println("______________________________________");
        System.out.println("Sueldo bruto: " + sueldoBruto + "€");
        System.out.println("Retención IRPF (" + (porcentajeIRPF * 100) + "%): " + retencionIRPF + "€");
        System.out.println("______________________________________");
        System.out.println("Sueldo neto: " + sueldoNeto + "€");
        System.out.println("______________________________________");

        sc.close(); // Cierra el Scanner
    }
}