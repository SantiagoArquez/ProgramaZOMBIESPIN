package gui;
 
import java.awt.Color;
import java.awt.Dimension;
 
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
import datos.MusicaAdmi;
import recursos.Fuentes;
 
public final class VentanaJuego extends JPanel {
 
    private MusicaAdmi music;
 
    public VentanaJuego(MusicaAdmi music) {
        this.music = music;
 
        setLayout(null);
        setBackground(Color.decode("#1e1e1e"));
 
        Dimension d = new Dimension(1020, 550);
        setSize(d);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
 
        inicializarComponentes();
 
        music.detenerMusica();
        music.Sonarmusica("/musica/Juego.wav");
    }
 
    private void inicializarComponentes() {
 
    JButton jugar = new JButton("JUGAR");
    jugar.setBounds(800, 200, 150, 80);
    jugar.setBackground(Color.decode("#2e2e2e"));
    jugar.setForeground(Color.decode("#277717"));
    jugar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
    jugar.setFocusPainted(false);
    add(jugar);
 
 
    JTextField apuesta = new JTextField("APUESTA");
    apuesta.setBounds(800, 120, 190, 40);
    apuesta.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 50));
    apuesta.setForeground(Color.decode("#277717"));
    apuesta.setBackground(new Color(0,0,0,0)); //fondo transparente
    apuesta.setBorder(null); // quita borde tipo input
    apuesta.setEditable(false);
    apuesta.setFocusable(false);
 
    add(apuesta);
 
    JButton detalles = new JButton("DETALLES");
    detalles.setBounds(50, 450, 150, 50);
    detalles.setBackground(Color.decode("#2e2e2e"));
    detalles.setForeground(Color.decode("#277717"));
    detalles.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
    detalles.setFocusPainted(false);
    add(detalles);
 
    JButton pagarDeuda = new JButton("PAGAR DEUDA");
    pagarDeuda.setBounds(760, 450, 200, 50);
    pagarDeuda.setBackground(Color.decode("#2e2e2e"));
    pagarDeuda.setForeground(Color.decode("#277717"));
    pagarDeuda.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 21));
    pagarDeuda.setFocusPainted(false);
    add(pagarDeuda);
}
}