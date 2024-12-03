package ejercicio3Examen;

public class BrazoMecanicoDos implements Runnable {
    private Cinta cinta;
    private int cont=0;

    public BrazoMecanicoDos(Cinta cinta) {
        this.cinta = cinta;
    }

    @Override
    public void run() {
    	double item=0;
        while (true) {
            try {
                Thread.sleep(100);
                cont++;
                item=cont;
                // Para inertar el producto en la cinta
                cinta.insertar(item);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}