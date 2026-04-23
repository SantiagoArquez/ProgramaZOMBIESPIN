package gui;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

public final class VentanaValores extends JDialog {
    
    public VentanaValores(Window parent) {
        super(parent);
        setTitle("ZOMBIEZPIN VALORES");
        setModal(false); // sigue dejando jugar
        setSize(565, 735);
        setResizable(false);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(false); 
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JPanel panelJ = new JPanel() {
        private Image fondoOriginal = new ImageIcon(
            getClass().getResource("/images/valores.png")
            ).getImage();
            private Image fondoEscalado = fondoOriginal.getScaledInstance(550, 700, Image.SCALE_SMOOTH);
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoEscalado, 0, 0, this);
            }
        };
        panelJ.setLayout(null);
        panelJ.setBounds(0, 0, 550, 700);

        add(panelJ);
    }
}
