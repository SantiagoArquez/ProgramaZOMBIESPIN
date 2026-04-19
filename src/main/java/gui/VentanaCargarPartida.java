package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCargarPartida extends JFrame {

    private JButton nuevaPartida;
    private JButton continuar;
    private JLabel dedo;
    private JTextField titulo;
    private JTextField titulo2;

    public VentanaCargarPartida() {
        setTitle("ZOMBIEZPIN MENU PRINCIPAL");
        setSize(1020, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

}
}
