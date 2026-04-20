package datos;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Jugador {
    private String nombre;
    private int saldo=2000;
    private int nivel=1;
    private String contrapin;
}