package gui;


import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datos.MusicaAdmi;
import recursos.Fuentes;

public class VentanaCreditos extends JPanel{

    private MusicaAdmi music;

    public VentanaCreditos(MusicaAdmi music){
        MusicaAdmi.getInstance().detenerMusica();
        setSize(1020, 550);
        setLayout(null);
        inicializarComponentes();
        this.music = music;
        music.Sonarmusica("/musica/Creditos.wav");
    }
    
    private void inicializarComponentes(){
        JPanel panelJ = new JPanel() {

        private Image fondoOriginal = new ImageIcon(
            getClass().getResource("/images/Creditos.png")
            ).getImage();
            private Image fondoEscalado = fondoOriginal.getScaledInstance(1010, 540, Image.SCALE_SMOOTH);
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoEscalado, 0, 0, this);
            }
        };
        panelJ.setLayout(null);
        panelJ.setBounds(0, 0, 1010, 540);

        JLabel lblNombreS = new JLabel("SHARA MORENO");
        lblNombreS.setBounds(70,120, 180, 40);
        lblNombreS.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 20));
        lblNombreS.setForeground(Color.decode("#00ff00"));
        lblNombreS.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(lblNombreS);

        JLabel Dise = new JLabel("(ARTE PRINCIPAL)");
        Dise.setBounds(70,140, 180, 40);
        Dise.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 13));
        Dise.setForeground(Color.decode("#00ff00"));
        Dise.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(Dise);

        JLabel lblNombreA = new JLabel("SANTIAGO ARQUEZ");
        lblNombreA.setBounds(750,120, 180, 40);
        lblNombreA.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 20));
        lblNombreA.setForeground(Color.decode("#00ff00"));
        lblNombreA.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(lblNombreA);

        JLabel ProArq = new JLabel("(PROGRAMADOR)");
        ProArq.setBounds(750,140, 180, 40);
        ProArq.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 13));
        ProArq.setForeground(Color.decode("#00ff00"));
        ProArq.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(ProArq);

        JLabel lblNombreC = new JLabel("CRISTIAN DIAZ");
        lblNombreC.setBounds(420,240, 180, 40);
        lblNombreC.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 20));
        lblNombreC.setForeground(Color.decode("#00ff00"));
        lblNombreC.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(lblNombreC);

        JLabel ProCris = new JLabel("(PROGRAMADOR)");
        ProCris.setBounds(420,260, 180, 40);
        ProCris.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 13));
        ProCris.setForeground(Color.decode("#00ff00"));
        ProCris.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(ProCris);

        JLabel cred = new JLabel("CREDITOS");
        cred.setBounds(340,20, 350, 120);
        cred.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 70));
        cred.setForeground(Color.decode("#fffb00"));
        cred.setHorizontalAlignment(JLabel.CENTER);
        panelJ.add(cred);
        
        JButton meButton = new JButton("MENU");
        meButton.setBounds(440, 140, 140, 50);
        meButton.setBackground(Color.decode("#2e2e2e"));
        meButton.setForeground(Color.decode("#fffb00"));
        meButton.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 20));
        meButton.setFocusPainted(false);
                meButton.setBorder(null);meButton.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#a6ff00"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        );
        meButton.addActionListener(e -> {
        music.detenerMusica();
        music.Sonarmusica("/musica/Creditos.wav");
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
        });
        panelJ.add(meButton);

        add(panelJ);
    }
}
