package Hacer;

public class Tortuga implements Runnable {

	@Override
	public void run() {
		int i=0;
		while(i<5) {
			try {
				Thread.sleep(5000);
				System.out.println("TORTUGA");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
		System.out.println("LA TORTUGA HA LLEGADO A LA META");
	}

}
