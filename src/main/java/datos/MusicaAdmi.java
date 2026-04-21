package datos;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicaAdmi {

    private static MusicaAdmi instancia;
    private Clip cancion;

    private MusicaAdmi() {}

    public static MusicaAdmi getInstance() {
        if (instancia == null) {
            instancia = new MusicaAdmi();
        }
        return instancia;
    }

    public void Sonarmusica(String ruta) {
        try {
            detenerMusica();
            var url = getClass().getResource(ruta);
            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            cancion = AudioSystem.getClip();
            cancion.open(audio);
            cancion.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void detenerMusica() {
        if (cancion != null) {
            cancion.stop();
            cancion.close();
        }
    }
}