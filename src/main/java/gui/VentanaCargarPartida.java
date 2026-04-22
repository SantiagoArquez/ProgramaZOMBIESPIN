package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import datos.Jugador;
import datos.MusicaAdmi;
import operaciones.OperacionesJugador;
import recursos.Fuentes;

public class VentanaCargarPartida extends JPanel {
    
    private JTable tabla;
    private DefaultTableModel modelo;
    private JPasswordField campoPin;
    private JButton btnCargar;

    private List<Jugador> jugadores;

    public VentanaCargarPartida(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        setLayout(null);
        setBackground(Color.decode("#2e2e2e"));
        setPreferredSize(new Dimension(460, 420));

        inicializarComponentes();
        cargarTabla();
    }

    private void inicializarComponentes() {

        // ===== TÍTULO ESTILO ZOMBIE =====
        JLabel titulo = new JLabel("CARGAR PARTIDA");
        titulo.setBounds(25, 10, 550, 40);
        titulo.setForeground(Color.decode("#277717"));
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        add(titulo);

        // ===== TABLA =====
        String[] columnas = {"PUESTO","NOMBRE", "NIVEL", "SALDO", "ÚLTIMA VEZ"};
        modelo = new DefaultTableModel(columnas, 0);

        tabla = new JTable(modelo);

        tabla.setRowHeight(28);
        tabla.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 12));

        tabla.setForeground(Color.decode("#277717"));
        tabla.setBackground(Color.decode("#2e2e2e"));

        tabla.setSelectionBackground(Color.decode("#277717"));
        tabla.setSelectionForeground(Color.BLACK);

        tabla.setGridColor(new Color(0, 120, 0));

        JTableHeader header = tabla.getTableHeader();
        header.setBackground(Color.decode("#2e2e2e"));
        header.setForeground(Color.decode("#277717"));
        header.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 12));
        header.setBorder(BorderFactory.createLineBorder(Color.decode("#277717")));

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 60, 405, 220);
        scroll.setBackground(Color.decode("#2e2e2e"));
        scroll.getViewport().setBackground(Color.decode("#2e2e2e"));
        scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#277717")));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabla.setFillsViewportHeight(true);
        add(scroll);

        // ===== PIN =====
        JLabel lblPin = new JLabel("PIN:");
        lblPin.setBounds(20, 300, 50, 25);
        lblPin.setForeground(Color.decode("#277717"));
        lblPin.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 18));
        add(lblPin);

        campoPin = new JPasswordField();
        campoPin.setBounds(70, 300, 150, 25);
        campoPin.setBackground(Color.decode("#2e2e2e"));
        campoPin.setForeground(Color.decode("#277717"));
        campoPin.setCaretColor(Color.decode("#277717"));
        campoPin.setBorder(BorderFactory.createLineBorder(Color.decode("#277717")));
        add(campoPin);

        // ===== BOTÓN =====
        btnCargar = new JButton("CARGAR");
        btnCargar.setBounds(240, 300, 180, 45);
        btnCargar.setBackground(Color.decode("#2e2e2e"));
        btnCargar.setForeground(Color.decode("#277717"));
        btnCargar.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 25));
        btnCargar.setFocusPainted(false);
        btnCargar.setBorder(BorderFactory.createLineBorder(Color.decode("#277717")));

        add(btnCargar);

        // ===== EVENTO =====
        btnCargar.addActionListener(e -> 
            cargarPartida());
        }

        private void cargarTabla() {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        int puesto = 1;
        for (Jugador j : jugadores) {
        String ultima = (j.getUltimaVezJugado() == 0)
                ? "SOLO JUGO UNA VEZ"
                : formato.format(new Date(j.getUltimaVezJugado()));
        modelo.addRow(new Object[]{
                puesto,
                j.getNombre().toUpperCase(),
                j.getNivel(),
                j.getSaldo(),
                ultima
        });
        puesto++;
        }
        }

        private void cargarPartida() {

        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un jugador");
            return;
        }

        String pinIngresado = new String(campoPin.getPassword());
        Jugador seleccionado = jugadores.get(fila);

        if (!seleccionado.getContrapin().equals(pinIngresado)) {
        JOptionPane.showMessageDialog(this, "PIN incorrecto");
        return;
        }

        seleccionado.setUltimaVezJugado(System.currentTimeMillis());
        OperacionesJugador.actualizarArchivo();

        MusicaAdmi music= MusicaAdmi.getInstance();
        music.detenerMusica();
        JDialog dialogoJuego = new JDialog();
        VentanaJuego juego = new VentanaJuego(music, seleccionado);
        dialogoJuego.setTitle("ZOMBIEZPIN - JUEGO");
        dialogoJuego.setContentPane(juego);
        dialogoJuego.setSize(1020, 550);
        dialogoJuego.setLocationRelativeTo(null);
        dialogoJuego.setModal(true);
        dialogoJuego.setVisible(true);
        java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
        ventana.dispose();   // Cierra solo la ventana
    }
}