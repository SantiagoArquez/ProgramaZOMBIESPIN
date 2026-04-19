package gui;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datos.Jugador;
import datos.MusicaAdmi;
import recursos.Fuentes;

public class VentanaNombre extends JPanel {

    private JLabel titulo;
    private JLabel lblNombre;
    private JLabel lblPin;
    private JTextField campoNombre;
    private JPasswordField campoPin;
    private JButton btnValidar;
    private Jugador jugador;

    public VentanaNombre(MusicaAdmi music, Jugador jugador, String pin) {
        this.jugador = jugador;

        setLayout(null);
        setBackground(Color.decode("#1e1e1e"));

        inicializarComponentes();
        music.Sonarmusica("/musica/NickName.wav");
    }

    private void inicializarComponentes() {

        // ===== TÍTULO =====
        // TEXTO DE LA PANTALLA
        JLabel titulo = new JLabel("INGREZE ZU NOMBRE");
        titulo.setBounds(20, 100, 400, 90);
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 50));
        titulo.setForeground(Color.decode("#ff0000"));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo);

        // ===== LABEL NOMBRE =====
        lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(20, 180, 100, 40);
        lblNombre.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 18));
        lblNombre.setForeground(Color.decode("#277717"));
        lblNombre.setHorizontalAlignment(JLabel.CENTER);
        lblNombre.setBorder(null);
        add(lblNombre);

        // ===== CAMPO NOMBRE =====
        campoNombre = new JTextField();
        campoNombre.setBounds(130, 180, 220, 40);
        campoNombre.setForeground(Color.decode("#277717"));
        campoNombre.setBackground(Color.decode("#2e2e2e"));
        campoNombre.setBorder(null);campoNombre.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#277717"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        ); 
        add(campoNombre);

        // ===== LABEL PIN =====
        lblPin = new JLabel("PIN");
        lblPin.setBounds(20, 240, 100, 40);
        lblPin.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 18));
        lblPin.setForeground(Color.decode("#277717"));
        lblPin.setHorizontalAlignment(JLabel.CENTER);
        lblPin.setBorder(null);
        add(lblPin);

        // ===== CAMPO PIN (OCULTO) =====
        campoPin = new JPasswordField();
        campoPin.setBounds(130, 240, 220, 40);
        campoPin.setForeground(Color.decode("#277717"));
        campoPin.setBackground(Color.decode("#2e2e2e"));
        campoPin.setBorder(null);campoPin.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#277717"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        ); 
        add(campoPin);

        
        // ===== BOTÓN =====
        btnValidar = new JButton("NICKNAME");
        btnValidar.setBounds(130, 310, 220, 45);
        btnValidar.setEnabled(false);
        btnValidar.setBackground(Color.decode("#2e2e2e"));
        btnValidar.setForeground(Color.decode("#277717"));
        btnValidar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 15));
        btnValidar.setFocusPainted(false);
        add(btnValidar);

        // ===== EVENTOS =====
        KeyAdapter escuchador = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validarCampos();
            }
        };

        campoNombre.addKeyListener(escuchador);
        campoPin.addKeyListener(escuchador);

        btnValidar.addActionListener(e -> guardarJugadorYCerrar());
    }

    private void validarCampos() {
        boolean datosCompletos =
                !campoNombre.getText().trim().isEmpty() &&
                campoPin.getPassword().length > 0;

        btnValidar.setEnabled(datosCompletos);
    }

    private void guardarJugadorYCerrar() {
        String nombre = campoNombre.getText().trim();
        String pin = new String(campoPin.getPassword()).trim();

        jugador.setNombre(nombre);
        jugador.setContrapin(pin);

        System.out.println("Jugador: " + jugador.getNombre());
        System.out.println("PIN guardado: " + jugador.getContrapin());

        java.awt.Window ventana =
            javax.swing.SwingUtilities.getWindowAncestor(this);

        if (ventana != null) {
            ventana.dispose();
        }
    }
}