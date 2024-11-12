package edu.pruebas.prc2_alfonsorincon;

public class Casilla {
    public enum tipoEstado {OCULTA, DESCUBIERTA, MARCADA, MINA};
    public boolean mina;
    public int minasCerca;

    // Constructor
    public Casilla(boolean mina, int minasCerca) {
        this.mina = mina;
        this.minasCerca = minasCerca;
    }
    public Casilla() {

    }

    // Getters y Setters
    public boolean isMina() {
        return mina;
    }
    public void setMina(boolean mina) {
        this.mina = mina;
    }
    public int getMinasCerca() {
        return minasCerca;
    }
    public void setMinasCerca(int minasCerca) {
        this.minasCerca = minasCerca;
    }
}
