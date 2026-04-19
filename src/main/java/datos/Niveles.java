package datos;
import lombok.Getter;
@Getter

public class Niveles {

    private int deuda;

    public Niveles(int nivel){
        deuda=nivel*5000;
    }
}
