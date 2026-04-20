package operaciones;
import java.util.Random;

import lombok.Getter;
@Getter
public class ValoresJuego {

    private double girasol=10;
    private double hongo=8;
    private double michael=30;
    private double faraon=20;

    private Random random = new Random();
    //genera un número del 1 al 4
    public int girar() {
        return random.nextInt(4) + 1;
    }
    //genera las 3 pantallas
    public int[] jugar() {
        return new int[] {
            girar(), // p1
            girar(), // p2
            girar()  // p3
        };
    }

    public double calcularResultado(int Triple,double apuesta){
    return switch (Triple) {
        case 1 -> apuesta + (apuesta * girasol); //El giraaa
        case 2 -> apuesta + (apuesta * hongo); // El HONGO
        case 3 -> (apuesta + (apuesta * michael)); // EL BEAT IT
        case 4 -> (apuesta + (apuesta * faraon));// EL del Ataud
        default -> 0;
        };
    }
        public double calcularResultado2(int Doble,double apuesta){
    return switch (Doble) {
        case 1 -> apuesta + (apuesta * 3); //El giraaa
        case 2 -> apuesta + (apuesta * 2); // El HONGO
        case 3 -> apuesta + (apuesta * 6); // EL BEAT IT
        case 4 -> apuesta + (apuesta * 4);// EL del Ataud
        default -> 0;
        };
    }
}