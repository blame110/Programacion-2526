package UNIDAD3;

import UNIDAD3.*;

public class Rectangulo extends Figura {

    private double altura;
    private double base;

    public Rectangulo() {
        super();
    }

    /**
     * Constructor completo
     * 
     * @param altura
     * @param base
     */
    public Rectangulo(double altura, double base) {
        super();
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea() {
        return this.altura * this.base;
    }

    @Override
    public double calcularPerimetro() {
        return (this.altura * 2) + (this.base * 2);
    }

}
