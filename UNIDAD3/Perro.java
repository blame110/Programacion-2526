package UNIDAD3;

public class Perro extends Animal implements Volador {

    public String raza;

    public Perro() {
        super();
    }

    public void ladrar() {
        System.out.println("El perro esta ladrando");
    }

}
