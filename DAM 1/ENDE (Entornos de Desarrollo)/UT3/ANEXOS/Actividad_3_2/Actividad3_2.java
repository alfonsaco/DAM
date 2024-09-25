package Actividad_3_2;
import java.util.Scanner;


public class Actividad3_2 {
	private String nombre;
	private int mes;
	private int año;
	private double salario_bruto;
	private double salario_neto;

	
	public Actividad3_2() {
		this.nombre="";
		this.mes=0;
		this.año=0;
		this.salario_bruto=0;
		this.salario_neto=0;
	}
	
	public Actividad3_2(String nombre, int mes, int año, double salario_bruto, double salario_neto) {
		super();
		this.nombre = nombre;
		this.mes = mes;
		this.año = año;
		this.salario_bruto = salario_bruto;
		this.salario_neto = salario_neto;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public double getSalario_bruto() {
		return salario_bruto;
	}
	public void setSalario_bruto(int salario_bruto) {
		this.salario_bruto = salario_bruto;
	}
	public double getSalario_neto() {
		return salario_neto;
	}
	public void setSalario_neto(int salario_neto) {
		this.salario_neto = salario_neto;
	}
	
	
	
	public double calculaSalarioBruto(String TipoEmpleado, double ventasMes, int horasExtra) {
		double salarioBase=0;
		
		if(TipoEmpleado.equals("vendedor")) {
			salarioBase=1000;
		} else if(TipoEmpleado.equals("encargado")) {
			salarioBase=1500;
		} 
		
		if(ventasMes>=1000 && ventasMes<1500) {
			salarioBase=salarioBase+100;
		}else if(ventasMes>=1500) {
			salarioBase=salarioBase+200;
		}
		
		return salarioBase+(horasExtra*20);
	}
	
	public double calculaSalarioNeto(double salario_bruto) {
		if(salario_bruto<1000) {
			return salario_bruto;
		} else {
			if(salario_bruto>=1000 && salario_bruto<1500) {
				return salario_bruto=salario_bruto*0.84;
			}else if(salario_bruto>1500) {
				return salario_bruto=salario_bruto*0.82;
			}
				
		}
		return salario_bruto;
	}

}
