package operaciones;

import java.util.ArrayList;
import java.util.List;

import datos.Jugador;

public class OperacionesJugador {

    private static final String RUTA = "jugadores.dat";
    private static List<Jugador> jugadores = new ArrayList<>();

    // Se ejecuta apenas se carga la clase
    static {
        cargarJugadores();
    }

    // ================== AGREGAR O ACTUALIZAR ==================
    public static void agregar(Jugador jugador) {

        Jugador existente = buscarPorNombre(jugador.getNombre());

        if (existente == null) {
            jugadores.add(jugador); // Nuevo jugador
        } else {
            // Actualiza datos del jugador existente
            existente.setSaldo(jugador.getSaldo());
            existente.setNivel(jugador.getNivel());
            existente.setContrapin(jugador.getContrapin());
        }

        guardarArchivo();
    }

    
    public static List<Jugador> obtenerTodos() {
        return jugadores;
    }

    
    public static Jugador buscarPorNombre(String nombre) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        return null;
    }

    
    private static void guardarArchivo() {
        try {
            UtilidadArchivos.guardar(jugadores, RUTA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    private static void cargarJugadores() {
        try {
            jugadores = UtilidadArchivos.leer(RUTA);
        } catch (Exception e) {
            jugadores = new ArrayList<>();
        }
    }


}