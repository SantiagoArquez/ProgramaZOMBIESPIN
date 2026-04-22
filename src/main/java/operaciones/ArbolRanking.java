package operaciones;

import java.util.ArrayList;
import java.util.List;
import datos.Jugador;

public class ArbolRanking {

    private NodoRanking raiz;

    public void insertar(Jugador j) {
        if (raiz == null) raiz = new NodoRanking(j);
        else raiz.insertar(j);
    }

    public List<Jugador> obtenerRanking() {
        List<Jugador> lista = new ArrayList<>();
        if (raiz != null) raiz.inOrderDesc(lista);
        return lista;
    }
}