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
import operaciones.OperacionesJugador;
import recursos.Fuentes;

public final class VentanaMenu extends JFrame {

    private JButton nuevaPartida;
    private JButton continuar;
    private JLabel dedo;
    private JTextField titulo;
    private JTextField titulo2;
    private boolean musicaActiva = true;
    private MusicaAdmi music = MusicaAdmi.getInstance();

    // posición base del dedo
    private final int dedoXBase = 605;
    private final int dedoYBase = 100;

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

        JPanel panelJ = new JPanel() {

            private Image fondoOriginal = new ImageIcon(
                getClass().getResource("/images/Menu.png")
            ).getImage();
            private Image fondoEscalado = fondoOriginal.getScaledInstance(1020, 550, Image.SCALE_SMOOTH);
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoEscalado, 0, 0, this);
            }
        };
        panelJ.setLayout(null);
        panelJ.setBounds(0, 0, 1020, 550);
        add(panelJ);

        // ===== TITULO =====
        titulo = new JTextField("ZOMBIEZPIN");
        titulo.setBounds(240, 40, 500, 90);
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 100));
        titulo.setForeground(Color.decode("#00a300"));
        titulo.setBackground(new Color(0, 0, 0, 0));
        titulo.setBorder(null);
        titulo.setEditable(false);
        titulo.setFocusable(false);
        titulo.setHorizontalAlignment(JTextField.CENTER);
        panelJ.add(titulo);

        titulo2 = new JTextField("ZOMBIEZPIN");
        titulo2.setBounds(240, 43, 500, 90);
        titulo2.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 100));
        titulo2.setForeground(Color.decode("#000000"));
        titulo2.setBackground(new Color(0, 0, 0, 0));
        titulo2.setBorder(null);
        titulo2.setEditable(false);
        titulo2.setFocusable(false);
        titulo2.setHorizontalAlignment(JTextField.CENTER);
        panelJ.add(titulo2);

        // ===== BOTON NUEVA PARTIDA =====
        nuevaPartida = new JButton("NUEVA PARTIDA");
        nuevaPartida.setBounds(380, 150, 200, 71);
        nuevaPartida.setBackground(Color.decode("#2e2e2e"));
        nuevaPartida.setForeground(Color.decode("#fbff00"));
        nuevaPartida.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        nuevaPartida.setFocusPainted(false);
                nuevaPartida.setBorder(null);nuevaPartida.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(Color.decode("#d9dd00"), 2),
                javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
                )
        );
        panelJ.add(nuevaPartida);

        // ===== BOTON CONTINUAR =====
        continuar = new JButton("CONTINUAR");
        continuar.setBounds(380, 275, 200, 71);
        continuar.setBackground(Color.decode("#2e2e2e"));
        continuar.setForeground(Color.decode("#15ff00"));
        continuar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        continuar.setFocusPainted(false);            
            continuar.setBorder(null);continuar.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#12dd00"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );

        panelJ.add(continuar);

                // ===== BOTON <CREDITOS!!> =====
        JButton creditos = new JButton("CREDITOS");
        creditos.setBounds(380, 400, 200, 71);
        creditos.setBackground(Color.decode("#2e2e2e"));
        creditos.setForeground(Color.decode("#00ffbf"));
        creditos.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        creditos.setFocusPainted(false);
            creditos.setBorder(null);creditos.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#00ebb0"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );
        panelJ.add(creditos);

                // ===== BOTON SILENCIAR MUSICA =====
        JButton MuteMusica=new JButton("SILENCIAR");
        MuteMusica.setBounds(900, 10, 100, 30);
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
                music.Sonarmusica("/musica/Menu.wav");
            }
            musicaActiva = !musicaActiva;
        });
        panelJ.add(MuteMusica);

        //TEXTO SILENCIAR MUSICA
        JTextField Silen = new JTextField("MUSICA");
        Silen.setBounds(800, -20, 110, 90);
        Silen.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 30));
        Silen.setForeground(Color.decode("#23d400"));
        Silen.setBackground(new Color(0, 0, 0, 0));
        Silen.setBorder(null);
        Silen.setEditable(false);
        Silen.setFocusable(false);
        Silen.setHorizontalAlignment(JTextField.CENTER);
        panelJ.add(Silen);
        // ===== DEDO =====
        dedo = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/mano.png"));
        Image img = icon.getImage().getScaledInstance(230, 180, Image.SCALE_SMOOTH);
        dedo.setIcon(new ImageIcon(img));

        dedo.setBounds(dedoXBase+1000, dedoYBase, 230, 180);
        panelJ.add(dedo);

        add(panelJ);

        // =========================
        // EVENTOS DEL DEDO
        // =========================

        nuevaPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                moverDedo(605, 100);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                moverDedo(dedoXBase+1000, dedoYBase);
            }
        });

        continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                moverDedo(605, 225);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                moverDedo(dedoXBase+1000, dedoYBase);
            }
        });
        creditos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                moverDedo(605, 350);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                moverDedo(dedoXBase+1000, dedoYBase);
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
                    music.detenerMusica();
                    music.Sonarmusica("/musica/Menu.wav");
                }

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    music.detenerMusica();
                    music.Sonarmusica("/musica/Menu.wav");
                }
            });

            jueDialog.setVisible(true);
        });

        continuar.addActionListener(e -> {
            JDialog cargarDialog = new JDialog(this, "CARGAR PARTIDA", true);
            VentanaCargarPartida cargar = new VentanaCargarPartida(OperacionesJugador.obtenerRanking());
            cargarDialog.setContentPane(cargar);

            cargarDialog.setSize(460, 420);
            cargarDialog.setLocationRelativeTo(null);
                cargarDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    music.detenerMusica();
                    music.Sonarmusica("/musica/Menu.wav");
                }

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    music.detenerMusica();
                    music.Sonarmusica("/musica/Menu.wav");
                }
            });

            cargarDialog.setVisible(true);
        });
        creditos.addActionListener(e -> {
            JDialog crediDialog = new JDialog(this, "ZOMBIEZPIN - CREDITOS", true);
            VentanaCreditos creditosV = new VentanaCreditos(music);
            crediDialog.setContentPane(creditosV);

            crediDialog.setSize(1020, 550);
            crediDialog.setLocationRelativeTo(null);
                crediDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    music.detenerMusica();
                    music.Sonarmusica("/musica/Menu.wav");
                }

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    music.detenerMusica();
                    music.Sonarmusica("/musica/Menu.wav");
                }
            });

            crediDialog.setVisible(true);
        });
    }
    // mover dedo
    private void moverDedo(int x, int y) {
        dedo.setLocation(x, y);
    }
}