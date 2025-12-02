package UNIDAD3;

import java.util.ArrayList;
import java.util.HashMap;

public class Gremio {

    String nombre;
    int reputacion;
    Personaje lider;
    HashMap<String, String> listaQuests;
    ArrayList<Personaje> miembros;

    public Gremio() {
        this.nombre = "Gremio one";
        this.reputacion = 0;
        this.lider = null;
        this.listaQuests = null;
        this.miembros = null;
    }

    public Gremio(String nombre, int reputacion, Personaje lider, ArrayList<Personaje> miembros) {
        this.nombre = nombre;
        this.reputacion = reputacion;
        this.lider = lider;
        this.miembros = miembros;
    }

    /**
     * La función devuelve la lista de personajes que tengan mas de dos armas y sean
     * de la clase
     * que se recibe como parametro
     * 
     * @param clase
     * @return null si no hay o una lista de personajes
     */
    public ArrayList<Personaje> muyArmados(int clase) {
        ArrayList<Personaje> listaArmados = new ArrayList<Personaje>();

        for (Personaje personaje : miembros) {
            // Si en la lista de armas del personaje actual, su tamaño es 2 o mas
            // Y su clase coincide con la que recibimos como parametro
            // En ese caso de que cumpla la condicion lo añado a la lista de armados
            if (personaje.getListaArmas().size() >= 2 && personaje.getClase() == clase) {
                listaArmados.add(personaje);
            }
        }

        // Si la lista esta vacia devolvemos null sino la lista misma con los personajes
        // que cumplen todas las condiciones
        return listaArmados.isEmpty() ? null : listaArmados;

    }

    public Personaje getLider() {
        return lider;
    }

    public String getNombre() {
        return nombre;
    }

    public int getReputacion() {
        return reputacion;
    }

    public HashMap<String, String> getListaQuests() {
        return listaQuests;
    }

    public void setLider(Personaje lider) {
        this.lider = lider;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }

    public void setListaQuests(HashMap<String, String> listaQuests) {
        this.listaQuests = listaQuests;
    }

}
