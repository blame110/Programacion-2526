package UNIDAD3;

public class Arma {

    public static final int LARGA_DISTANCIA = 1;
    public static final int CORTA_DISTANCIA = 2;
    public static final int MELEE = 3;
    public static final int EXPLOSIVA = 4;

    private String nombre;
    private double peso;
    private int tipo;
    private int danio;

    public Arma() {
        this.nombre = "Pistola";
        this.peso = 2;
        this.tipo = this.CORTA_DISTANCIA;
        this.danio = 20;
    }

    public Arma(String nombre, double peso, int tipo, int danio) {
        this.nombre = nombre;
        this.peso = peso;
        this.tipo = tipo;
        this.danio = danio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public int getTipo() {
        return tipo;
    }

    public int getDanio() {
        return danio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    @Override
    public String toString() {
        // TODO cambiar y mostrar los datos del arma
        return super.toString();
    }

}
