package gui;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.Jugador;
import datos.MusicaAdmi;
import recursos.Fuentes;

public class VentanaJuego extends JPanel {
    private MusicaAdmi music;
    public VentanaJuego(MusicaAdmi music) {
        this.music=music;
        setLayout(null);
        setBackground(Color.decode("#1e1e1e"));
 
        Dimension d = new Dimension(1020, 550);
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);

        inicializarComponentes();
        music.Sonarmusica("/musica/Juego.wav");
    }

    private void inicializarComponentes() {
        Jugador jugador=new Jugador();
        JDialog nomb=new JDialog((java.awt.Frame)null,"ZOMBIEZPIN - REGISTRO",true);
        nomb.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        VentanaNombre requiNombre=new VentanaNombre(music,jugador,"");
        nomb.setContentPane(requiNombre);
        nomb.setSize(460, 420);
        nomb.setLocationRelativeTo(null);
        nomb.setVisible(true);
        
        JPanel panelJ = new JPanel();
        panelJ.setLayout(null);
        panelJ.setBounds(0, 0, 1020, 550);
        panelJ.setBackground(Color.decode("#1e1e1e"));

        JButton jugar = new JButton("JUGAR");
        jugar.setBounds(800, 200, 150, 80);
        jugar.setBackground(Color.decode("#2e2e2e"));
        jugar.setForeground(Color.decode("#277717"));
        jugar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        jugar.setFocusPainted(false);
        panelJ.add(jugar);
 
 
        JTextField apuesta = new JTextField("APUESTA");
        apuesta.setBounds(800, 120, 200, 40);
        apuesta.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 50));
        apuesta.setForeground(Color.decode("#277717"));
        apuesta.setBackground(Color.RED); //fondo transparente
        apuesta.setBorder(null); // quita borde tipo input
        apuesta.setFocusable(false);
        apuesta.setEditable(false);
        apuesta.setOpaque(true);
        revalidate();
        repaint();
 
        panelJ.add(apuesta);

        JTextField valorApuesta = new JTextField();
        valorApuesta.setBounds(800, 120, 190, 40);
        valorApuesta.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 50));
        valorApuesta.setForeground(Color.decode("#277717"));
        valorApuesta.setBackground(new Color(0,0,0,0)); //fondo transparente
        valorApuesta.setBorder(null); // quita borde tipo input
        valorApuesta.setEditable(true);
        valorApuesta.setFocusable(false);
        panelJ.add(valorApuesta);
 
        JButton detalles = new JButton("DETALLES");
        detalles.setBounds(50, 450, 150, 50);
        detalles.setBackground(Color.decode("#2e2e2e"));
        detalles.setForeground(Color.decode("#277717"));
        detalles.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        detalles.setFocusPainted(false);
        panelJ.add(detalles);
    
        JButton pagarDeuda = new JButton("PAGAR DEUDA");
        pagarDeuda.setBounds(760, 450, 200, 50);
        pagarDeuda.setBackground(Color.decode("#2e2e2e"));
        pagarDeuda.setForeground(Color.decode("#277717"));
        pagarDeuda.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
        pagarDeuda.setFocusPainted(false);
        panelJ.add(pagarDeuda);
        
        add(panelJ);
}
}
