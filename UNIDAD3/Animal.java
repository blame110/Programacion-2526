package UNIDAD3;

public class Animal {

    public int edad;
    public int peso;
    public String nombre;

    public void comer() {
        System.out.println("El animal " + this.nombre + " esta comiendo");
    }

    public int cagar() {
        System.out.println("El animal " + this.nombre + " esta en la sala de pensar");
        return (int) (Math.random() * 1000);
    }

}
