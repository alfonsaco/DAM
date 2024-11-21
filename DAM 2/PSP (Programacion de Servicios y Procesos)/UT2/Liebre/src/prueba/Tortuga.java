package prueba;

public class Tortuga implements Runnable {

	
	
	public Tortuga() {
		super();
	}

	@Override
	public void run() {
		int i=0;
		System.out.println("Empieza la tortuga");
		while(i<5) {
			try {
				Thread.sleep(5000);
				System.out.println("T");
			} catch (Exception e) {
				
			}
			i++;
		}
		System.out.println("La torguta llega a la meta");
		
	}

}
