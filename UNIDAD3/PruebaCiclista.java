package UNIDAD3;

public class PruebaCiclista {

    public static void main(String[] args) {

        EquipoCiclista equipo = new EquipoCiclista();

        Ciclista perico = new Ciclista();
        equipo.getListaCiclistas().add(perico);

        Ciclista juan = equipo.getListaCiclistas().get(2);

        juan.setNombre("Pedro");

        int numero;

        System.out.println(equipo);

        System.out.println("Hay " + equipo.numCiclistas(Ciclista.ESP_MONTANA) + " ciclistas de montaña");

        System.out.println("El equipo de ciclistas tiene " + equipo.numCiclistas() + " ciclistas.");
    }
}
