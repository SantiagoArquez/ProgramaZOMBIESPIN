package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import datos.MusicaAdmi;
import recursos.Fuentes;

public class VentanaVictoria extends JPanel {

    private MusicaAdmi music;


    public VentanaVictoria(MusicaAdmi music) {
        MusicaAdmi.getInstance().detenerMusica();
        MusicaAdmi.getInstance().Sonarmusica("/musica/Victoria.wav");
        setSize(1020, 550);
        setLayout(null);
        inicializarComponentes();
        this.music = music;
    }
    private void inicializarComponentes(){
                JPanel panelJ = new JPanel() {

            private Image fondoOriginal = new ImageIcon(
                getClass().getResource("/images/VictoriaF.png")
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
        JButton meButton = new JButton("MENU");
        meButton.setBounds(410, 400, 200, 71);
        meButton.setBackground(Color.decode("#2e2e2e"));
        meButton.setForeground(Color.decode("#5effd7"));
        meButton.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 30));
        meButton.setFocusPainted(false);
                meButton.setBorder(null);meButton.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#28b191"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        );
        meButton.addActionListener(e -> {
        music.detenerMusica();
        music.Sonarmusica("/musica/Menu.wav");
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
        });
        panelJ.add(meButton);

        add(panelJ);
    }
}