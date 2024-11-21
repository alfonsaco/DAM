package Paquete;

public class ClienteB extends Thread {
    BarberoDurmiente b;
    int num;

    public ClienteB(BarberoDurmiente b, int num) {
        this.b = b;
        this.num = num;
    }

    public void run() {
        boolean t = false;
        while (true) {
            try {
                Thread.sleep(2000);
                t = b.entrar(num);
                if (t) {
                    // Espere para entrar otra vez porque se lo he cortado
                    Thread.sleep(20000);
                } else {
                    // Se da una vuelta e intentará entrar de nuevo
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}