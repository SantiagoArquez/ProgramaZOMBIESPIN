package gui;

import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class VentanaPin extends JDialog {

    private JPasswordField campoPin;
    private String pinIngresado = null;

    public VentanaPin(Window parent) {
        super(parent, "INGRESA EL PIN", ModalityType.APPLICATION_MODAL);

        setSize(300, 180);
        setLayout(null);
        setLocationRelativeTo(parent);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JLabel lbl = new JLabel("PIN DE LA PARTIDA");
        lbl.setBounds(60, 20, 200, 30);
        add(lbl);

        campoPin = new JPasswordField();
        campoPin.setBounds(60, 60, 180, 30);
        add(campoPin);

        JButton btn = new JButton("VALIDAR");
        btn.setBounds(90, 105, 120, 30);
        add(btn);

        btn.addActionListener(e -> validar());
    }

    private void validar() {

        String pin = new String(campoPin.getPassword()).trim();

        if (pin.isEmpty()) return;

        pinIngresado = pin;
        dispose();
    }

    public String getPinIngresado() {
        return pinIngresado;
    }
}