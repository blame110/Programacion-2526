package UNIDAD3;

import java.util.ArrayList;
import java.util.HashMap;
import UNIDAD3.Quest;

public class Gremio {

    private String nombre;
    private int reputacion;
    private Personaje lider;
    private HashMap<String, Quest> listaQuests;
    private ArrayList<Personaje> miembros;

    public Gremio() {
        this.nombre = "Gremio one";
        this.reputacion = 0;
        this.lider = null;
        this.listaQuests = new HashMap<String, Quest>();
        this.miembros = new ArrayList<Personaje>();

    }

    public Gremio(String nombre, int reputacion, Personaje lider) {
        this.nombre = nombre;
        this.reputacion = reputacion;
        this.lider = lider;
        this.listaQuests = new HashMap<String, Quest>();
        this.miembros = new ArrayList<Personaje>();
    }

    public Gremio(String nombre, int reputacion, Personaje lider, ArrayList<Personaje> miembros) {
        this.nombre = nombre;
        this.reputacion = reputacion;
        this.lider = lider;
        this.miembros = miembros;
        this.listaQuests = new HashMap<String, Quest>();
        this.miembros = new ArrayList<Personaje>();
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

    public HashMap<String, Quest> getListaQuests() {
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

    public void setListaQuests(HashMap<String, Quest> listaQuests) {
        this.listaQuests = listaQuests;
    }

    public ArrayList<Personaje> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<Personaje> miembros) {
        this.miembros = miembros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gremio {");
        sb.append("nombre='").append(this.nombre).append('\'');
        sb.append(", reputacion=").append(this.reputacion);
        sb.append(", lider=");
        sb.append(this.lider == null ? "null" : this.lider.toString());

        sb.append("\nQuests:");
        if (this.listaQuests == null || this.listaQuests.isEmpty()) {
            sb.append(" []");
        } else {
            for (String key : this.listaQuests.keySet()) {
                sb.append("\n  - ").append(key).append(": ").append(this.listaQuests.get(key));
            }
        }

        sb.append("\nMiembros:");
        if (this.miembros == null || this.miembros.isEmpty()) {
            sb.append(" []");
        } else {
            for (Personaje p : this.miembros) {
                sb.append("\n  - ").append(p == null ? "null" : p.toString());
            }
        }

        sb.append("\n}");
        return sb.toString();
    }

}
