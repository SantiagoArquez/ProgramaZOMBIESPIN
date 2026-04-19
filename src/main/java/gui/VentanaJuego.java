package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.Jugador;
import datos.MusicaAdmi;
import recursos.Fuentes;

public class VentanaJuego extends JPanel {

    private MusicaAdmi music;

    public VentanaJuego(MusicaAdmi music) {
        this.music = music;

        setLayout(null);
        setBackground(Color.decode("#1e1e1e"));

        Dimension d = new Dimension(1020, 550);
        setPreferredSize(d);

        inicializarComponentes();
        music.Sonarmusica("/musica/Juego.wav");
    }

    private void inicializarComponentes() {

        //donde se registra el jugador
        Jugador jugador = new Jugador();
        JDialog nomb = new JDialog((java.awt.Frame) null, "ZOMBIEZPIN - REGISTRO", true);
        nomb.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        VentanaNombre requiNombre = new VentanaNombre(music, jugador, "");
        nomb.setContentPane(requiNombre);
        nomb.setSize(460, 420);
        nomb.setLocationRelativeTo(null);
        nomb.setVisible(true);

        // PANEL PRINCIPAL DEL JUEGO
        JPanel panelJ = new JPanel();
        panelJ.setLayout(null);
        panelJ.setBounds(0, 0, 1020, 550);
        panelJ.setBackground(Color.decode("#1e1e1e"));
        add(panelJ);

        // LABEL NIVEL (TEXTO FIJO) 
        JLabel lblNivel = new JLabel("NIVEL №");
        lblNivel.setBounds(800, 20, 135, 60);
        lblNivel.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        lblNivel.setForeground(Color.decode("#277717"));
        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblNivel);


        // LABEL APUESTA (TEXTO FIJO) 
        JLabel lblApuesta = new JLabel("APUEZTA");
        lblApuesta.setBounds(800, 70, 135, 60);
        lblApuesta.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        lblApuesta.setForeground(Color.decode("#277717"));
        lblApuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApuesta.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblApuesta);

        // LABEL APUESTAMINIMA (TEXTO FIJO) 
        JLabel lblApuestaM = new JLabel("APUEZTA MINIMA  10");
        lblApuestaM.setBounds(800, 160, 130, 60);
        lblApuestaM.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 13));
        lblApuestaM.setForeground(Color.decode("#277717"));
        lblApuestaM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApuestaM.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblApuestaM);

        

        //SOL DE APUESTA MINIMA
        JLabel sol = new JLabel();
        ImageIcon icon = new ImageIcon(
            getClass().getResource("/images/Estrella.png")
        );
        Image img = icon.getImage().getScaledInstance(
            20, 20, Image.SCALE_SMOOTH
        );
        sol.setIcon(new ImageIcon(img));
        sol.setBounds(930, 178, 20, 20);
        panelJ.add(sol);

        //SOL DE CANTIDAD
        JLabel sol2 = new JLabel();
        ImageIcon icon2 = new ImageIcon(
            getClass().getResource("/images/Estrella.png")
        );
        Image img2 = icon2.getImage().getScaledInstance(
            50, 50, Image.SCALE_SMOOTH
        );
        sol2.setIcon(new ImageIcon(img2));
        sol2.setBounds(20, 20, 50, 50);
        panelJ.add(sol2);

        //SOL DE DEUDA
        JLabel sol3 = new JLabel();
        ImageIcon icon3 = new ImageIcon(
            getClass().getResource("/images/Estrella.png")
        );
        Image img3 = icon3.getImage().getScaledInstance(
            50, 50, Image.SCALE_SMOOTH
        );
        sol3.setIcon(new ImageIcon(img3));
        sol3.setBounds(680, 453, 50, 50);
        panelJ.add(sol3);


        // ====== CAMPO DONDE EL USUARIO ESCRIBE ======
        JTextField valorApuesta = new JTextField();
        valorApuesta.setBounds(800, 130, 150, 40);
        valorApuesta.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 15));
        valorApuesta.setForeground(Color.decode("#277717"));
        valorApuesta.setBackground(Color.decode("#2e2e2e"));
        valorApuesta.setBorder(null);valorApuesta.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#277717"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        ); 
        panelJ.add(valorApuesta);

        // ====== BOTÓN JUGAR ======
        JButton jugar = new JButton("JUGAR");
        jugar.setBounds(800, 240, 150, 80);
        jugar.setBackground(Color.decode("#2e2e2e"));
        jugar.setForeground(Color.decode("#277717"));
        jugar.setBorder(null);jugar.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#277717"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        );
        jugar.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 45));
        jugar.setFocusPainted(false);
        panelJ.add(jugar);

        // ====== BOTÓN DETALLES ======
        JButton detalles = new JButton("----");
        detalles.setBounds(20, 450, 50, 50);
        detalles.setBackground(Color.decode("#2e2e2e"));
        detalles.setForeground(Color.decode("#277717"));
        detalles.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        detalles.setFocusPainted(false);
        panelJ.add(detalles);

        // LABEL DETALLES (TEXTO FIJO) 
        JLabel lblDetalles = new JLabel("DETALLEZ");
        lblDetalles.setBounds(35, 445, 240, 60);
        lblDetalles.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        lblDetalles.setForeground(Color.decode("#277717"));
        lblDetalles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetalles.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblDetalles);


        // LABEL DEUDA (TEXTO FIJO) 
        JLabel lblDeuda = new JLabel("DEUDA A PAGAR:");
        lblDeuda.setBounds(250, 445, 280, 60);
        lblDeuda.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        lblDeuda.setForeground(Color.decode("#277717"));
        lblDeuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDeuda.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblDeuda);


        // ====== BOTÓN PAGAR DEUDA ======
        JButton pagarDeuda = new JButton("PAGAR DEUDA");
        pagarDeuda.setBounds(735, 450, 250, 50);
        pagarDeuda.setBackground(Color.decode("#2e2e2e"));
        pagarDeuda.setForeground(Color.decode("#277717"));
        pagarDeuda.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        pagarDeuda.setFocusPainted(false);
        panelJ.add(pagarDeuda);

        // ====== BOTÓN GUARDAR ======
        JButton guardar = new JButton("GUARDAR");
        guardar.setBounds(20, 390, 90, 25);
        guardar.setBackground(Color.decode("#2e2e2e"));
        guardar.setForeground(Color.decode("#277717"));
        guardar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 10));
        guardar.setFocusPainted(false);
        panelJ.add(guardar);


    }
}