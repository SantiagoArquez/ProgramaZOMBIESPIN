package datos;
import lombok.Getter;
@Getter
public class Niveles {

    private int deuda;

    public Niveles(int nivel){
        if (nivel==1){
            deuda=20000;
        }else{
            deuda=nivel*200000;
        }
    }
}
