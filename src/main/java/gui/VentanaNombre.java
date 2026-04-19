package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import  javax.swing.JPanel;
import javax.swing.JTextField;

import datos.Jugador;
import datos.MusicaAdmi;
import recursos.Fuentes;
public class VentanaNombre extends JPanel{

    private JLabel titulo;
    private JLabel nom;
    private JLabel con;
    private JTextField nombre;
    private JTextField contra;
    private JButton btValidar;
    private Jugador nombreJ;
    private String Pin;


    public VentanaNombre(MusicaAdmi music,Jugador nombreJ,String Pin){
        this.nombreJ = nombreJ;
        this.Pin=Pin;
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
        titulo.setBounds(20, 100, 400, 90); // aquí controlas el tamaño real
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 50));
        titulo.setForeground(Color.decode("#ff0000"));
        titulo.setBackground(new Color(0,0,0,0)); //fondo transparente
        titulo.setBorder(null); // quita borde tipo input
        titulo.setFocusable(false);
        titulo.setHorizontalAlignment(JTextField.CENTER);
        panelN.add(titulo);

        nom = new JLabel("NOMBRE");
        nom.setBounds(10, 175, 100, 90); // aquí controlas el tamaño real
        nom.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 30));
        nom.setForeground(Color.decode("#09ff00"));
        nom.setBackground(new Color(0,0,0,0)); //fondo transparente
        nom.setBorder(null); // quita borde tipo input
        nom.setFocusable(false);
        nom.setHorizontalAlignment(JTextField.CENTER);
        panelN.add(nom);
        
        con = new JLabel("PIN");
        con.setBounds(10, 225, 100, 90); // aquí controlas el tamaño real
        con.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 30));
        con.setForeground(Color.decode("#09ff00"));
        con.setBackground(new Color(0,0,0,0)); //fondo transparente
        con.setBorder(null); // quita borde tipo input
        con.setFocusable(false);
        con.setHorizontalAlignment(JTextField.CENTER);
        panelN.add(con);

        //Textos
        nombre=new JTextField ();
        nombre.setBounds(125, 200, 200, 40);
        nombre.setEditable(true);
        panelN.add(nombre);

        contra=new JTextField ();
        contra.setBounds(125, 250, 200, 40);
        contra.setEditable(true);
        panelN.add(contra);

        //boton
        btValidar=new JButton("NICKNAME");
        btValidar.setBounds(125, 300, 200, 40);
        btValidar.setEnabled(false);
        btValidar.setBackground(Color.decode("#2e2e2e"));
        btValidar.setForeground(Color.decode("#277717"));
        btValidar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 15));
        btValidar.setFocusPainted(false);
        panelN.add(btValidar);

        add(panelN);

        //Evento
        btValidar.addActionListener(e -> {
            String texto = nombre.getText().trim();
            String pinTexto = contra.getText().trim();

            if (texto.isEmpty() || pinTexto.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Completa todos los campos");
                return;
            }

            nombreJ.setNombre(texto);        //
            nombreJ.setContrapin(pinTexto);  //

            System.out.println("Jugador: " + nombreJ.getNombre());
            System.out.println("PIN guardado: " + nombreJ.getContrapin());
            java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
    if (ventana != null) {
        ventana.dispose();
    }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent e) {
                btValidar.setEnabled((!nombre.getText().trim().isEmpty()));
            }
        });
    }
}