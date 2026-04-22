package datos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    @Builder.Default
    private int saldo = 10;
    @Builder.Default
    private int nivel = 1;
    private String contrapin;
    private long ultimaVezJugado;
}