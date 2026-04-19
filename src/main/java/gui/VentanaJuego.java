package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.MusicaAdmi;

public class VentanaJuego extends JPanel {
    private MusicaAdmi music;
    private JButton nuevaPartida;
    private JButton continuar;
    private JLabel dedo;
    private JTextField titulo;
    private JTextField titulo2;


    public VentanaJuego(MusicaAdmi music) {
        this.music=music;
        setLayout(null);
        inicializarComponentes();
        music.Sonarmusica("/musica/Juego.wav");
    }

    private void inicializarComponentes() {
        JDialog nomb=new JDialog((JDialog)null,"ZOMBIEZPIN - REGISTRO",true);
        VentanaNombre requiNombre=new VentanaNombre(music);
        nomb.setContentPane(requiNombre);
        nomb.setSize(460, 420);
        nomb.setLocationRelativeTo(null);
        nomb.setVisible(true);

}
}
