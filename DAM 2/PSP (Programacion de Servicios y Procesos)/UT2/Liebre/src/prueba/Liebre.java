package prueba;

public class Liebre implements Runnable {

	@Override
	public void run() {
		int i=0;
		System.out.println("Empieza la tortuga");
		while(i<5) {
			try {
				Thread.sleep(2000);
				System.out.println("L");
			} catch (Exception e) {
				
			}
			i++;
		}
		System.out.println("La torguta llega a la meta");
		
	}

	
}
