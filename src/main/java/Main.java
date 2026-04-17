import gui.VentanaMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inicio aplicación.");
        SwingUtilities.invokeLater(() -> {
            new VentanaMenu().setVisible(true);
        });
    }
}
