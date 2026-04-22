package operaciones;

import java.util.ArrayList;
import java.util.List;

import datos.Jugador;

public class OperacionesJugador {

    private static final String RUTA = "jugadores.dat";
    private static List<Jugador> jugadores = new ArrayList<>();

    // ================== CARGA INICIAL ==================
    static {
        cargarJugadores();
    }

    // ================== AGREGAR / ACTUALIZAR ==================
    public static void guardar(Jugador jugador) {

        Jugador existente = buscarPorNombre(jugador.getNombre());

        if (existente == null) {
            jugadores.add(jugador);
        } else {
            existente.setSaldo(jugador.getSaldo());
            existente.setNivel(jugador.getNivel());
            existente.setContrapin(jugador.getContrapin());
        }

        guardarArchivo();
    }

    // ================== LISTA COMPLETA ==================
    public static List<Jugador> obtenerTodos() {
        return jugadores;
    }

    // ================== BUSCAR ==================
    public static Jugador buscarPorNombre(String nombre) {

        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        return null;
    }

    // ================== GUARDAR ARCHIVO ==================
    private static void guardarArchivo() {
        try {
            UtilidadArchivos.guardar(jugadores, RUTA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================== CARGAR ARCHIVO ==================
    @SuppressWarnings("unchecked")
    private static void cargarJugadores() {
        try {
            jugadores = UtilidadArchivos.leer(RUTA);
        } catch (Exception e) {
            jugadores = new ArrayList<>();
        }
    }
    // ================== OBTENER RANKING ==================
    public static List<Jugador> obtenerRanking() {

    ArbolRanking ranking = new ArbolRanking();

    for (Jugador j : jugadores) {
        ranking.insertar(j);
    }

    return ranking.obtenerRanking();
    }
    // ================== FORZAR GUARDADO ==================
    public static void actualizarArchivo() {
    guardarArchivo();
    }
}