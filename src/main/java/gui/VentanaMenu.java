package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.MusicaAdmi;
import recursos.Fuentes;

public final class VentanaMenu extends JFrame {

    private JButton nuevaPartida;
    private JButton continuar;
    private JLabel dedo;
    private JTextField titulo;
    private JTextField titulo2;
    private MusicaAdmi music = new MusicaAdmi();

    // posición base del dedo
    private final int dedoXBase = 605;
    private final int dedoYBase = 120;

    public VentanaMenu() {
        setTitle("ZOMBIEZPIN MENU PRINCIPAL");
        setSize(1020, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        inicializarComponentes();

        music.detenerMusica();
        music.Sonarmusica("/musica/Menu.wav");
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1020, 550);
        panel.setBackground(Color.decode("#1e1e1e"));

        // ===== TITULO =====
        titulo = new JTextField("ZOMBIEZPIN");
        titulo.setBounds(240, 40, 500, 90);
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 100));
        titulo.setForeground(Color.decode("#013501"));
        titulo.setBackground(new Color(0, 0, 0, 0));
        titulo.setBorder(null);
        titulo.setEditable(false);
        titulo.setFocusable(false);
        titulo.setHorizontalAlignment(JTextField.CENTER);
        panel.add(titulo);

        titulo2 = new JTextField("ZOMBIEZPIN");
        titulo2.setBounds(240, 43, 500, 90);
        titulo2.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 100));
        titulo2.setForeground(Color.decode("#000000"));
        titulo2.setBackground(new Color(0, 0, 0, 0));
        titulo2.setBorder(null);
        titulo2.setEditable(false);
        titulo2.setFocusable(false);
        titulo2.setHorizontalAlignment(JTextField.CENTER);
        panel.add(titulo2);

        // ===== BOTON NUEVA PARTIDA =====
        nuevaPartida = new JButton("NUEVA PARTIDA");
        nuevaPartida.setBounds(380, 150, 200, 71);
        nuevaPartida.setBackground(Color.decode("#2e2e2e"));
        nuevaPartida.setForeground(Color.decode("#277717"));
        nuevaPartida.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        nuevaPartida.setFocusPainted(false);
        panel.add(nuevaPartida);

        // ===== BOTON CONTINUAR =====
        continuar = new JButton("CONTINUAR");
        continuar.setBounds(380, 275, 200, 71);
        continuar.setBackground(Color.decode("#2e2e2e"));
        continuar.setForeground(Color.decode("#277717"));
        continuar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        continuar.setFocusPainted(false);
        panel.add(continuar);

        // ===== DEDO =====
        dedo = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/mano.png"));
        Image img = icon.getImage().getScaledInstance(230, 180, Image.SCALE_SMOOTH);
        dedo.setIcon(new ImageIcon(img));

        dedo.setBounds(dedoXBase, dedoYBase, 230, 180);
        panel.add(dedo);

        add(panel);

        // =========================
        // EVENTOS DEL DEDO
        // =========================

        nuevaPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                moverDedo(605, 120);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                moverDedo(dedoXBase, dedoYBase);
            }
        });

        continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                moverDedo(605, 245);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                moverDedo(dedoXBase, dedoYBase);
            }
        });

        // =========================
        // ACCIONES BOTONES
        // =========================

        nuevaPartida.addActionListener(e -> {
            JDialog jueDialog = new JDialog(this, "ZOMBIEZPIN - JUEGO", true);
            music.detenerMusica();

            VentanaJuego juego = new VentanaJuego(music);
            jueDialog.setContentPane(juego);

            jueDialog.setSize(1020, 550);
            jueDialog.setLocationRelativeTo(null);

            jueDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    music.Sonarmusica("/musica/Menu.wav");
                }

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    music.Sonarmusica("/musica/Menu.wav");
                }
            });

            jueDialog.setVisible(true);
        });

        continuar.addActionListener(e -> {
            JDialog cargarDialog = new JDialog(this, "CARGAR PARTIDA", true);
            VentanaCargarPartida cargar = new VentanaCargarPartida();
            cargarDialog.setContentPane(cargar);

            cargarDialog.setSize(460, 420);
            cargarDialog.setLocationRelativeTo(null);

            cargarDialog.setVisible(true);
        });
    }

    // mover dedo
    private void moverDedo(int x, int y) {
        dedo.setLocation(x, y);
    }
}