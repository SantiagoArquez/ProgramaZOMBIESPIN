package gui;
 
import java.awt.Color;
import java.awt.Dimension;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
 
import recursos.Fuentes;
 
public class VentanaCargarPartida extends JPanel {
 
    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnCargar;
 
    public VentanaCargarPartida() {
 
        setLayout(null);
        setBackground(Color.decode("#2e2e2e"));
        setPreferredSize(new Dimension(460, 420));
 
        inicializarComponentes();
        cargarPartidasDemo();
    }
 
    private void inicializarComponentes() {
 
        JLabel titulo = new JLabel("SELECCIONAR PARTIDA");
        titulo.setBounds(25, 10, 550, 40);
        titulo.setForeground(Color.decode("#277717"));
        titulo.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        add(titulo);
 
        String[] columnas = {"NOMBRE", "SALDO", "NIVEL"};
 
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
 
        // =========================
        // 🧟‍♂️ ESTILO ZOMBIE TABLE
        // =========================
        tabla.setRowHeight(28);
        tabla.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 12));
 
        tabla.setForeground(Color.decode("#277717"));
        tabla.setBackground(Color.decode("#2e2e2e"));
 
        tabla.setSelectionBackground(Color.decode("#277717"));
        tabla.setSelectionForeground(Color.BLACK);
 
        tabla.setGridColor(new Color(0, 120, 0));
 
       
 
        // ===== HEADER ESTILO TERMINAL =====
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(Color.decode("#2e2e2e"));
        header.setForeground(Color.decode("#277717"));
        header.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 12));
        header.setBorder(BorderFactory.createLineBorder(Color.decode("#277717")));
 
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 60, 405, 250);
 
        scroll.setBackground(Color.decode("#2e2e2e"));
        scroll.getViewport().setBackground(Color.decode("#2e2e2e"));
        scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#277717")));
 
        add(scroll);
 
        // BOTÓN
        btnCargar = new JButton("CARGAR PARTIDA");
        btnCargar.setBounds(225, 318, 200, 50);
        btnCargar.setBackground(Color.decode("#2e2e2e"));
        btnCargar.setForeground(Color.decode("#277717"));
        btnCargar.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 25));
        btnCargar.setFocusPainted(false);
       
        add(btnCargar);
    }
 
    private void cargarPartidasDemo() {
 
        modelo.addRow(new Object[]{"SANTIAGO", 1500, 3});
        modelo.addRow(new Object[]{"LAURA", 2200, 5});
        modelo.addRow(new Object[]{"CARLOS", 800, 2});
    }
}