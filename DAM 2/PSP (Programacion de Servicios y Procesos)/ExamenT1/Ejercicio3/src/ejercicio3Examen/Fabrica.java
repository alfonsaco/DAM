package ejercicio3Examen;

public class Fabrica {
    public static void main(String[] args) {
        int ranuras=10;

        // Creo los brazos
        Cinta c=new Cinta(ranuras);
        BrazoMecanicoUno brazo1=new BrazoMecanicoUno(c);
        BrazoMecanicoDos brazo2=new BrazoMecanicoDos(c);

        // Creo los hilos
        Thread hiloBrazo1=new Thread(brazo1);
        Thread hiloBrazo2=new Thread(brazo2);

        hiloBrazo1.start();
        hiloBrazo2.start();
    }
}