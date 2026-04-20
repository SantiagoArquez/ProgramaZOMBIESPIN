package gui;
 
import java.awt.Color;
 
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import recursos.Fuentes;
 
public final class VentanaValores extends JDialog {
 
    public VentanaValores() {
        setTitle("ZOMBIEZPIN VALORES");
        setModal(false); // bloquea el juego mientras está abierto
        setSize(550, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
 
        inicializarComponentes();
    }
 
    private void inicializarComponentes() {
 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#1e1e1e"));
        setContentPane(panel);
 
        JLabel sombra = new JLabel("ZOMBIEZPIN");
        sombra.setBounds(262, 42, 500, 90);
        sombra.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 100));
        sombra.setForeground(Color.BLACK);
        sombra.setHorizontalAlignment(JLabel.CENTER);
        panel.add(sombra);
 
        JLabel titulo = new JLabel("ZOMBIEZPIN");
        titulo.setBounds(260, 40, 500, 90);
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 100));
        titulo.setForeground(Color.decode("#013501"));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titulo);
 
        JLabel subtitulo = new JLabel("TABLA DE PAGOS");
        subtitulo.setBounds(360, 140, 300, 40);
        subtitulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtitulo);
    }
}