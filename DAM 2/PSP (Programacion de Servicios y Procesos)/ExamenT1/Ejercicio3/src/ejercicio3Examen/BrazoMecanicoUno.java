package ejercicio3Examen;

public class BrazoMecanicoUno implements Runnable {
    private Cinta cinta;

    public BrazoMecanicoUno(Cinta cinta) {
        this.cinta = cinta;
    }

    @Override
    public void run() {
    	double item;
        while (true) {
            try {
                Thread.sleep(300);
                // Extraigo el produto de la cinta
                cinta.extraer();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}