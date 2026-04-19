package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import  javax.swing.JPanel;
import javax.swing.JTextField;

import datos.MusicaAdmi;
import recursos.Fuentes;
public class VentanaNombre extends JPanel{

    private JLabel titulo;
    private JTextField nombre;
    private JButton btValidar;


    public VentanaNombre(MusicaAdmi music){
        setLayout(null);
        inicializarComponentes();
        music.Sonarmusica("/musica/NickName.wav");
    }

    public void inicializarComponentes(){
        JPanel panelN = new JPanel();
        panelN.setLayout(null);
        panelN.setBounds(0, 0, 460, 420);
        panelN.setBackground(Color.decode("#1e1e1e"));

        //TEXTO DEL LA PANTALLA
        titulo = new JLabel("INGREZE ZU NOMBRE");
        titulo.setBounds(47, 60, 400, 90); // aquí controlas el tamaño real
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 50));
        titulo.setForeground(Color.decode("#ff0000"));
        titulo.setBackground(new Color(0,0,0,0)); //fondo transparente
        titulo.setBorder(null); // quita borde tipo input
        titulo.setFocusable(false);
        titulo.setHorizontalAlignment(JTextField.CENTER);
        panelN.add(titulo);

        JTextField nombre=new JTextField ();
        nombre.setBounds(130, 140, 200, 40);
        nombre.setBorder(getBorder());
        nombre.setEditable(true);
        panelN.add(nombre);

        JButton btValidar=new JButton("Nickname");
        btValidar.setBounds(130, 240, 200, 40);
        btValidar.setEnabled(false);
        btValidar.setBackground(Color.decode("#2e2e2e"));
        btValidar.setForeground(Color.decode("#277717"));
        btValidar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 10));
        btValidar.setFocusPainted(false);
        panelN.add(btValidar);

        add(panelN);
    }
}