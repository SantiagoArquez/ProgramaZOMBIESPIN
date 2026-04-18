package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import recursos.Fuentes;
import recursos.BordesRedondeados;

public class VentanaMenu extends JFrame {

    private JButton nuevaPartida;
    private JButton continuar;
    private JLabel dedo;

    public VentanaMenu() {
        setTitle("ZOMBIEZPIN MENU PRINCIPAL");
        setSize(1020, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1020, 550);
        panel.setBackground(Color.decode("#eeeeee"));

        nuevaPartida = new JButton("Nueva Partida");
        nuevaPartida.setBounds(420, 150, 200, 71);
        nuevaPartida.setBackground(Color.decode("#ffffff"));
        nuevaPartida.setForeground(Color.decode("#1b1b1b"));
        nuevaPartida.setFont(Fuentes.loadFont("/fonts/Lexend.ttf", 21));
        nuevaPartida.setBorder(BordesRedondeados.crear(15, Color.decode("#626262"), 1));
        nuevaPartida.setFocusPainted(false);
        panel.add(nuevaPartida);

        continuar = new JButton("Continuar");
        continuar.setBounds(419, 275, 200, 71);
        continuar.setEnabled(false);
        continuar.setBackground(Color.decode("#ffffff"));
        continuar.setForeground(Color.decode("#1b1b1b"));
        continuar.setFont(Fuentes.loadFont("/fonts/Lexend.ttf", 21));
        continuar.setBorder(BordesRedondeados.crear(15, Color.decode("#626262"), 1));
        continuar.setFocusPainted(false);
        panel.add(continuar);

        dedo = new JLabel();
        ImageIcon icon = new ImageIcon(
            getClass().getResource("/images/mano.png")
        );
        Image img = icon.getImage().getScaledInstance(
            150, 150, Image.SCALE_SMOOTH
        );
        dedo.setIcon(new ImageIcon(img));
        dedo.setBounds(50, 50, 150, 150);
        panel.add(dedo);
        add(panel);
    }
}