package UNIDAD3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 
 * 
 */

public class EquipoCiclista {

    /******************************************************************
     * VARIABLES MIEMBRO
     ******************************************************************/

    private String id;
    private String nombre;
    private int numCiclistas;
    private ArrayList<Ciclista> listaCiclistas;

    /*************************************************************************
     * CONSTRUCTORES
     *************************************************************************/

    public EquipoCiclista() {

        this.id = letraAleatoria() + String.valueOf((int) (Math.random() * 100) + 1);
        this.nombre = "Test";
        this.numCiclistas = (int) (Math.random() * 90) + 18;

        // Importante, para poder utilizar el ArrayList, al igual que con cualquier
        // objeto primero tenemos que crearlo con new
        this.listaCiclistas = new ArrayList<Ciclista>();
        // Creamos 10 ciclistas aleatorios y los metemos en la lista
        for (int i = 0; i < 10; i++) {
            Ciclista ciclista = new Ciclista();
            listaCiclistas.add(ciclista);

        }
    }

    public EquipoCiclista(String id,
            String nombre,
            int numCiclistas,
            ArrayList<Ciclista> listaCiclistas) {

        this.id = id;
        this.nombre = nombre;
        this.numCiclistas = numCiclistas;
        this.listaCiclistas = listaCiclistas;

    }

    /*********************************************************************************************
     * GETTERS Y SETTER
     ************************************************************************************************/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCiclistas() {
        return numCiclistas;
    }

    public void setNumCiclistas(int numCiclistas) {
        this.numCiclistas = numCiclistas;
    }

    public ArrayList<Ciclista> getListaCiclistas() {
        return listaCiclistas;
    }

    public void setListaCiclistas(ArrayList<Ciclista> listaCiclistas) {
        this.listaCiclistas = listaCiclistas;
    }

    @Override
    public String toString() {

        return "EQUIPO CICLISTA\n*******************************\n"
                + "Id: " + this.id + "\n"
                + "nombre: " + this.nombre + "\n"
                + "numCiclistas: " + this.numCiclistas + "\n"
                + "listaCiclistas: " + this.listaCiclistas.toString() + "\n"
                + "*****************************";

    }

    public static String letraAleatoria() {
        String letras = "abcdefghijklmnñopqrstuvwxyz";

        int posicion = (int) (Math.random() * letras.length());

        return String.valueOf(letras.charAt(posicion));
    }

    /*********************************************************************************************
     * FUNCIONALIDADES
     ************************************************************************************************/

    // int numCiclistas() (0,75 puntos) devolverá la cantidad de ciclistas.
    public int numCiclistas() {
        return this.listaCiclistas.size();
    }

    // float maxPeso() (0,75 puntos): Devolverá el peso máximo de los ciclistas de
    // los ciclistas

    public double maxPeso() {

        double max = 0;

        for (Ciclista ciclista : this.listaCiclistas) {

            if (ciclista.getPeso() > max) {
                max = ciclista.getPeso();
            }
        }
        // Con Stream calculamos el maximo indicandole que compare por el peso
        Ciclista ciclistaPesado = this.listaCiclistas.stream().max(Comparator.comparingDouble(Ciclista::getPeso))
                .orElse(null);
        // Otra mas Convertimos a stream filtramos solo el peso y calculamos el maximo
        return listaCiclistas.stream().mapToDouble(Ciclista::getPeso).max().orElse(0.0);
    }

    // int numCiclistas(String especialidad) (1 puntos): Devolverá la cantidad de
    // ciclistas de la especialidad indicada.

    public int numCiclistas(int especialidad) {
        int cantidadEspecialidad = 0;

        for (int i = 0; i < listaCiclistas.size(); i++) {

            if (listaCiclistas.get(i).getEspecialidad() == especialidad) {
                cantidadEspecialidad++;
            }

        }

        // return cantidadEspecialidad;
        return ((int) listaCiclistas.stream().filter(c -> c.getEspecialidad() == especialidad).count());
    }

}
