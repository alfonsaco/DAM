package hilos;

public class Contador {
//	private int c=0;
//	Contador (int c) {
//		this.c=c;
//	}
//	
//	public void incrementa() {
//		c=c+1;
//	}
//	public void decrementa() {
//		c=c-1;
//	}
//	public int valor() {
//		return c;
//	}
	    private int conta = 0;

	    Contador(int c) {
	        conta = c;
	    }

	    public synchronized void incrementa() {
	        conta = conta + 1;
	    }

	    public synchronized void decrementa() {
	        conta = conta - 1;
	    }

	    public synchronized int valor() {
	        return conta;
	    }

}
