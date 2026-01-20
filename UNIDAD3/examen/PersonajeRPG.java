public class PersonajeRPG {

    // ================= CONSTANTES =================
    public static final int CLASE_GUERRERO = 1;
    public static final int CLASE_MAGO = 2;
    public static final int CLASE_ARQUERO = 3;
    public static final int CLASE_ASESINO = 4;

    // ================= ATRIBUTOS =================
    private int idPersonaje;
    public String nombrePersonaje;
    private int clasePersonaje;
    private int nivel; // 1-100
    private int puntosVida;
    private float puntosDano;
    private boolean esLegendario;
    private String guildName;
    private String habilidades;

    // ================= CONSTRUCTOR VACÍO =================
    public PersonajeRPG() {
        this.idPersonaje = (int) (Math.random() * 90000) + 10000; // ID aleatorio (max-min+1)+min
        this.nombrePersonaje = "";
        this.clasePersonaje = (int) (Math.random() * 4) + 1; // Categoría aleatoria
        this.nivel = (int) (Math.random() * 50) + 1;
        this.puntosVida = (int) (Math.random() * 4001) + 1;
        this.puntosDano = (float) (Math.random() * 201) + 50;
        this.esLegendario = false;
        this.guildName = "";
        this.habilidades = habilidades;
    }

    // ================= CONSTRUCTOR COMPLETO =================
    public PersonajeRPG(String nombrePersonaje, int clasePersonaje, int nivel, int puntosVida, float puntosDano,
            boolean esLegendario, String guildName, String habilidades) {
        this.idPersonaje = (int) (Math.random() * 90000) + 10000;
        this.nombrePersonaje = nombrePersonaje;
        this.clasePersonaje = clasePersonaje;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.puntosDano = puntosDano;
        this.esLegendario = esLegendario;
        this.guildName = guildName;
        this.habilidades = habilidades;

    }

    // ================= GETTERS / SETTERS =================
    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public int getClasePersonaje() {
        return clasePersonaje;
    }

    public void setClasePersonaje(int clasePersonaje) {
        this.clasePersonaje = clasePersonaje;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public float getPuntosDano() {
        return puntosDano;
    }

    public void setPuntosDano(float puntosDano) {
        this.puntosDano = puntosDano;
    }

    public boolean getEsLegendario() {
        return esLegendario;
    }

    public void setEsLegendario(boolean esLegendario) {
        this.esLegendario = esLegendario;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    // ================= TOSTRING =================
    @Override
    public String toString() {
        String textoClase;
        if (clasePersonaje == CLASE_GUERRERO)
            textoClase = "Clase Guerrero";
        else if (clasePersonaje == CLASE_MAGO)
            textoClase = "Clase Mago";
        else if (clasePersonaje == CLASE_ARQUERO)
            textoClase = "Clase Arquero";
        else
            textoClase = "Clase Asesino";

        return "\n==========PERSONAJE RPG=========\n" +
                "-> ID Personaje: " + idPersonaje + "\n" +
                "-> Nombre Personaje: " + nombrePersonaje + "\n" +
                "-> Nivel: " + nivel + "\n" +
                "-> Puntos vida: " + puntosVida + "\n" +
                "-> Puntos daño: " + puntosDano + "\n" +
                "-> Clase Personaje: " + textoClase + "\n" +
                "-> ¿Es legendario?: " + (esLegendario ? "Sí" : "No") + "\n" +
                "-> Gremio: " + guildName + "\n" +
                "-> Habilidades: " + habilidades + "\n" +
                "==================================\n";
    }
}