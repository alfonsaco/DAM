package Ejemplo1;

public class pruebaBuffer {
	public static void main(String[] args) {
		StringBuffer buffer=null;
		buffer=new StringBuffer("hola");
		
		buffer.setLength(100);
		System.out.println(buffer+" HOLA");
	}
}
