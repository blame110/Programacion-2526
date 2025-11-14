package UNIDAD2;

import java.util.Random;

public class tetoco {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Te toco " + random.nextInt(6));
    }
}
