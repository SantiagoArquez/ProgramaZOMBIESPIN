package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datos.Jugador;
import datos.MusicaAdmi;
import operaciones.OperacionesJugador;
import recursos.Fuentes;

public class VentanaNombre extends JPanel {

    private JLabel lblNombre;
    private JLabel lblPin;
    private JTextField campoNombre;
    private JPasswordField campoPin;
    private JButton btnValidar;
    private boolean musicaActiva = true;
    private MusicaAdmi music = MusicaAdmi.getInstance();

    private Jugador jugador;

    public VentanaNombre(MusicaAdmi music, Jugador jugador, String pin) {

        this.jugador = jugador;

        setLayout(null);
        setBackground(Color.decode("#1e1e1e"));

        inicializarComponentes();
        music.Sonarmusica("/musica/NickName.wav");
    }

    private void inicializarComponentes() {
        JPanel panelJ = new JPanel() {

        private Image fondoOriginal = new ImageIcon(
            getClass().getResource("/images/nombre.png")
            ).getImage();
            private Image fondoEscalado = fondoOriginal.getScaledInstance(460, 420, Image.SCALE_SMOOTH);
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoEscalado, 0, 0, this);
            }
        };
        panelJ.setLayout(null);
        panelJ.setBounds(0, 0, 460, 420);

        JLabel titulo = new JLabel("INGREZE ZU NOMBRE");
        titulo.setBounds(30, 190, 400, 40);
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        titulo.setForeground(Color.decode("#b3ff00"));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(titulo);

        lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(30,230, 100, 40);
        lblNombre.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 20));
        lblNombre.setForeground(Color.decode("#f19d00"));
        lblNombre.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(lblNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(130, 230, 220, 40);
        campoNombre.setForeground(Color.decode("#ffbd91"));
        campoNombre.setBackground(Color.decode("#2e2e2e"));
        campoNombre.setHorizontalAlignment(JTextField.CENTER);
        campoNombre.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(Color.decode("#ff6600"), 2),
                javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );
        panelJ.add(campoNombre);

        // ===== BOTON SILENCIAR MUSICA =====
        JButton MuteMusica=new JButton("SILENCIAR");
        MuteMusica.setBounds(330, 10, 100, 30);
        MuteMusica.setBackground(Color.decode("#2e2e2e"));
        MuteMusica.setForeground(Color.decode("#23d400"));
        MuteMusica.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 10));
        MuteMusica.setFocusPainted(false);
        MuteMusica.setBorder(null);MuteMusica.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#1eb300"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );

        MuteMusica.addActionListener(e -> {
        if (musicaActiva) {
            MuteMusica.setText("ACTIVAR");
            music.detenerMusica();
            } else {
                MuteMusica.setText("SILENCIAR");
                music.Sonarmusica("/musica/NickName.wav");
            }
            musicaActiva = !musicaActiva;
        });
        panelJ.add(MuteMusica);

        lblPin = new JLabel("PIN");
        lblPin.setBounds(30, 280, 100, 40);
        lblPin.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 20));
        lblPin.setForeground(Color.decode("#f19d00"));
        lblPin.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(lblPin);

        campoPin = new JPasswordField();
        campoPin.setBounds(130, 280, 220, 40);
        campoPin.setForeground(Color.decode("#ffbd91"));
        campoPin.setBackground(Color.decode("#2e2e2e"));
        campoPin.setHorizontalAlignment(JTextField.CENTER);
        campoPin.setEchoChar((char) 0);
        campoPin.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(Color.decode("#ff6600"), 2),
                javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );
        panelJ.add(campoPin);

        btnValidar = new JButton("NICKNAME");
        btnValidar.setBounds(130, 330, 220, 45);
        btnValidar.setEnabled(false);
        btnValidar.setBackground(Color.decode("#2e2e2e"));
        btnValidar.setForeground(Color.decode("#f59300"));
        btnValidar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 15));
        btnValidar.setFocusPainted(false); 
        panelJ.add(btnValidar);

        add(panelJ);

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

        String nombre = campoNombre.getText().trim().toUpperCase();
        String pin = new String(campoPin.getPassword()).trim();

        // BUSCAR SI YA EXISTE (ESTÁTICO)
        Jugador existente = OperacionesJugador.buscarPorNombre(nombre);

        if (existente != null) {

            if (existente.getContrapin().equals(pin)) {
                jugador.setNombre(existente.getNombre());
                jugador.setSaldo(existente.getSaldo());
                jugador.setNivel(existente.getNivel());
                jugador.setContrapin(existente.getContrapin());
            } else {
                JOptionPane.showMessageDialog(this, "PIN INCORRECTO");
                return;
            }

        } else {
            // Nuevo jugador
            jugador.setNombre(nombre);
            jugador.setContrapin(pin);

            OperacionesJugador.guardar(jugador);
        }

        java.awt.Window ventana =
                javax.swing.SwingUtilities.getWindowAncestor(this);

        if (ventana != null) {
            ventana.dispose();
        }
    }
}