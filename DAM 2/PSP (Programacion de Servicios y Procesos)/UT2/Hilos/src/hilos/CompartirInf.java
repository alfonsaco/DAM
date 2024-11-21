package hilos;

public class CompartirInf {
	public static void main(String[] args) {
		Contador cont=new Contador(100);
		HiloA a=new HiloA("hiloA", cont);	
		HiloB a2=new HiloB("hiloB", cont);
		
		a.start();
		a2.start();
	}
}
