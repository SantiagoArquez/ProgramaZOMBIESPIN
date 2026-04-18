package recursos;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.InputStream;
import java.io.IOException;

public class Fuentes {

    public static Font loadFont(String path, float size) {
        try {
            // Usa getResourceAsStream para leer desde el interior del proyecto/JAR
            InputStream is = Fuentes.class.getResourceAsStream(path);
            if (is == null) {
                System.out.println("No se encontró el archivo en: " + path);
                return new Font("Arial", Font.PLAIN, (int) size);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, (int) size);
        }
    }
}