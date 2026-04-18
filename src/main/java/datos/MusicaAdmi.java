package datos;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicaAdmi{
    private Clip cancion;
    public void Sonarmusica(String ruta){
            try{
                if (cancion !=null){
                    cancion.stop();
                    cancion.close();
                }
                AudioInputStream audioMenu = AudioSystem.getAudioInputStream(
                    getClass().getResource(ruta)
                );

                cancion = AudioSystem.getClip();
                cancion.open(audioMenu);

                new Thread(() -> {
                    try {
                        Thread.sleep(500);
                        cancion.loop(Clip.LOOP_CONTINUOUSLY);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();

            } catch (Exception e){
                e.printStackTrace();
            }
        }
}
 