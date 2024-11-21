package hilos;

public class HiloA extends Thread {
	private Contador hilo;
	public HiloA(String n, Contador c) {
		setName(n);
		hilo=c;
	}
	
	public void run() {
		for (int i = 0; i < 300; i++) {
			hilo.incrementa();
			
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.getStackTrace();
			}
			
		}
		System.out.println(getName()+"Contador vale"+hilo.valor());
	}
}
