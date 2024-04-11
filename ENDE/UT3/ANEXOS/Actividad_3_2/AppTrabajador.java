package Actividad_3_2;

public class AppTrabajador {
	public static void main(String[] args) {
		Actividad3_2 app=new Actividad3_2();
		System.out.println(app.calculaSalarioNeto(2000));
		System.out.println(app.calculaSalarioNeto(1500));
		System.out.println(app.calculaSalarioNeto(1499.99));
		System.out.println(app.calculaSalarioNeto(1250));
		System.out.println(app.calculaSalarioNeto(1000));
		System.out.println(app.calculaSalarioNeto(999.99));
		System.out.println(app.calculaSalarioNeto(500));
		System.out.println(app.calculaSalarioNeto(0));
		System.out.println();
		System.out.println(app.calculaSalarioBruto("vendedor", 2000, 8));
		System.out.println(app.calculaSalarioBruto("vendedor", 1500, 3));
		System.out.println(app.calculaSalarioBruto("vendedor", 1499.99, 0));
		System.out.println(app.calculaSalarioBruto("encargado", 1250, 8));
		System.out.println(app.calculaSalarioBruto("encargado", 1000, 0));
		System.out.println(app.calculaSalarioBruto("encargado", 999.99, 3));
		System.out.println(app.calculaSalarioBruto("encargado", 500, 0));
		System.out.println(app.calculaSalarioBruto("encargado", 0, 8));
		System.out.println();
		System.out.println(app.calculaSalarioBruto("Vendedor", 2000, 8));
		System.out.println(app.calculaSalarioBruto("vendedor  ", 1500, 3));
		System.out.println(app.calculaSalarioBruto("Encargado", 1499.99, 0));
		System.out.println(app.calculaSalarioBruto("encargado  ", 1250, 8));
		System.out.println(app.calculaSalarioBruto("encrgado", 1000, 0));
	}
}
