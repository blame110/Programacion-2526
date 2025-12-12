package UNIDAD3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public long numMiembrosClase(int clase) {
        // Con count me devuelve la cantidad de elmentos que cumplen las condiciones
        return this.miembros.stream().filter(p -> p.getClase() == clase).count();
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

    public ArrayList<Personaje> muyArmadosStream(int clase) {

        List<Personaje> resultado = this.miembros.stream()
                .filter(p -> p.getClase() == clase)
                .filter(p -> p.getListaArmas().size() > 2)
                .collect(Collectors.toList());

        return resultado.isEmpty() ? null : new ArrayList<Personaje>(resultado);

    }

    /**
     * Funcion que devuelve la lista de los personajes del gremio que tienen mas
     * dinero
     * del que reciben
     * 
     * @param dinero de tipo int
     * @return Un ArrayList<String> con los nombres que cumplan la condicion o null
     *         si no hay
     */
    public ArrayList<String> getNombrePersonajesDineroArrayList(int creditos) {

        List<String> resultado = this.miembros.stream()// Con Stream creamos una agregacion sobre los datos
                .filter(p -> p.getCreditos() > creditos)// Filter sirve para poner condiciones y eliminar los que no las
                                                        // cumplan
                .map(p -> p.getNombre())// map sirve para mostrar solo los datos que queramos del objeto
                .collect(Collectors.toList());

        return resultado.isEmpty() ? null : new ArrayList<String>(resultado);

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
