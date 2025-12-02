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
    private boolean estaEquipada;

    public Arma() {
        this.nombre = "Pistola";
        this.peso = 2;
        this.tipo = this.CORTA_DISTANCIA;
        this.danio = 20;
        this.estaEquipada = false;
    }

    public Arma(String nombre, double peso, int tipo, int danio, boolean estaEquipada) {
        this.nombre = nombre;
        this.peso = peso;
        this.tipo = tipo;
        this.danio = danio;
        this.estaEquipada = estaEquipada;
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

    public boolean getEstaEquipada() {
        return this.estaEquipada;
    }

    public void setEstaEquipada(boolean estaEquipada) {
        this.estaEquipada = estaEquipada;
    }

    private String tipoDescripcion() {
        switch (this.tipo) {
            case LARGA_DISTANCIA:
                return "Larga distancia";
            case CORTA_DISTANCIA:
                return "Corta distancia";
            case MELEE:
                return "Melee";
            case EXPLOSIVA:
                return "Explosiva";
            default:
                return "Desconocido";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Arma {");
        sb.append("nombre='").append(this.nombre).append('\'');
        sb.append(", peso=").append(this.peso);
        sb.append(", tipo=").append(tipoDescripcion()).append(" (" + this.tipo + ")");
        sb.append(", danio=").append(this.danio);
        sb.append(", equipada=").append(this.estaEquipada);
        sb.append("}");
        return sb.toString();
    }

}
