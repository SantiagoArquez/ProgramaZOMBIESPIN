package operaciones;

import java.util.List;
import datos.Jugador;

public class NodoRanking {

    Jugador jugador;
    NodoRanking izquierda, derecha;

    public NodoRanking(Jugador j) {
        this.jugador = j;
    }

    private int comparar(Jugador a, Jugador b) {

        if (a.getSaldo() != b.getSaldo()) {
            return Integer.compare(a.getSaldo(), b.getSaldo());
        }

        return Long.compare(a.getUltimaVezJugado(), b.getUltimaVezJugado());
    }

    public void insertar(Jugador nuevo) {

        if (comparar(nuevo, jugador) > 0) {
            if (derecha == null) derecha = new NodoRanking(nuevo);
            else derecha.insertar(nuevo);
        } else {
            if (izquierda == null) izquierda = new NodoRanking(nuevo);
            else izquierda.insertar(nuevo);
        }
    }

    public void inOrderDesc(List<Jugador> lista) {
        if (derecha != null) derecha.inOrderDesc(lista);
        lista.add(jugador);
        if (izquierda != null) izquierda.inOrderDesc(lista);
    }
}