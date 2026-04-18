package recursos;

import java.awt.*;
import javax.swing.border.Border;

public class BordesRedondeados implements Border {

    private final int radio;
    private final Color colorBorde;
    private final int grosor;

    private BordesRedondeados(Builder builder) {
        this.radio = builder.radio;
        this.colorBorde = builder.colorBorde;
        this.grosor = builder.grosor;
    }

    public static class Builder {
        private int radio = 6;
        private Color colorBorde = Color.GRAY;
        private int grosor = 1;

        public Builder radio(int radio) {
            this.radio = radio;
            return this;
        }
        public Builder color(Color color) {
            this.colorBorde = color;
            return this;
        }
        public Builder grosor(int grosor) {
            this.grosor = grosor;
            return this;
        }
        public BordesRedondeados construir() {
            return new BordesRedondeados(this);
        }
    }

    @Override
    public Insets getBorderInsets(Component componente) {
        return new Insets(grosor, grosor, grosor, grosor);
    }

    @Override
    public boolean isBorderOpaque() {
        return false; 
    }

    @Override
    public void paintBorder(Component componente, Graphics grafico, int x, int y, int ancho, int alto) {
        Graphics2D g2d = (Graphics2D) grafico.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(colorBorde);
        g2d.setStroke(new BasicStroke((float) grosor));
        
        int desplazamiento = grosor / 2;
        int anchoAjustado = ancho - grosor;
        int altoAjustado = alto - grosor;
        
        g2d.drawRoundRect(x + desplazamiento, y + desplazamiento, anchoAjustado, altoAjustado, radio, radio);
        g2d.dispose();
    }


    public static BordesRedondeados crear(int radio, Color color, int grosor) {
        return new Builder()
                .radio(radio)
                .color(color)
                .grosor(grosor)
                .construir();
    }
}