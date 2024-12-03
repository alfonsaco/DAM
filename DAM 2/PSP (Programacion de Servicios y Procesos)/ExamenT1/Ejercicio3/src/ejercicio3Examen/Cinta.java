package ejercicio3Examen;

import java.util.ArrayList;

public class Cinta {
    private int dimension=0;
    private ArrayList<Double> cintatransportadora;
    private double cont=0;

    public Cinta(int dimension) {
        this.dimension=dimension;
        this.cintatransportadora=new ArrayList<>();
    }

    public synchronized void insertar(double valor) {
    	cont=valor;
    	
        if(cintatransportadora.size()>=10) {
            try {
                System.out.println("\tCINTA TRANSPORTADORA LLENA");
                wait();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        cintatransportadora.add(valor);
        System.out.println("NUEVA PIEZA EN LA CINTA "+valor);
        notifyAll();
    }
    
    
    public synchronized double extraer() {
        if(cintatransportadora.size()==0) {
            try {
                System.out.println("\tCINTA TRANSPORTADORA VACÍA");
                wait();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Cojo el primer valor del ArrayList
        double valor=cintatransportadora.get(0);
        cintatransportadora.remove(0);
        
        System.out.println("\t"+valor+" PASA A LA CADENA DE MONTAJE");
        notifyAll();
        
        return valor;
    }

}