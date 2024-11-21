package Hacer;

public class Liebre implements Runnable {

	@Override
	public void run() {
		int i=0;
		while(i<5) {
			try {
				Thread.sleep(200);
				System.out.println("LIEBRE");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
		System.out.println("LA LIEBRE HA GANADO");
	}

}
