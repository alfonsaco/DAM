package Hacer;

public class Partida {
	public static void main(String[] args) {
		Thread tortuga=new Thread(new Tortuga());
		Thread liebre=new Thread(new Liebre());
		
		tortuga.start();
		liebre.start();
	}
}
