package hilos;

public class HiloB extends Thread {
	private Contador c;
	public HiloB(String n, Contador cont) {
		setName(n);
		c=cont;
	}
	
	public void run() {
		for (int i = 0; i < 300; i++) {
			c.decrementa();
			
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.getStackTrace();
			}
			
		}
		System.out.println(getName()+"Contador vale"+c.valor());
	}
}
