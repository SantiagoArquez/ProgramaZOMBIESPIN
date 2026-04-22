package datos;
import lombok.Getter;
@Getter
public class Niveles {

    private int deuda;

    public Niveles(int nivel){
        switch (nivel) {
            case 1: deuda = 10000; break;
            case 2: deuda = 20000; break;
            case 3: deuda = 40000; break;
            case 4: deuda = 50000; break;
            case 5: deuda = 100000; break;
            case 6: deuda = 150000; break;
            case 7: deuda = 200000; break;
            case 8: deuda = 500000; break;
            case 9: deuda = 750000; break;
            case 10: deuda = 1000000; break;
            default:
            throw new AssertionError("Nivel no válido: " + nivel);
        }
    }
}
