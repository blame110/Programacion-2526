package UNIDAD3;

import UNIDAD3.*;

public class PruebasHerencia {
    public static void main(String[] args) {

        Animal hormiga = new Animal();
        Perro aura = new Perro();

        aura.nombre = "Aura";

        hormiga.cagar();
        aura.edad = 23;

        aura.ladrar();

        aura.cagar();

        Rectangulo arkanoid = new Rectangulo(3, 6);

        System.out.println("El área de arkanoid es: " + arkanoid.calcularArea());

    }
}
