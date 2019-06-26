package Vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class CajaMusical {

    public static void reproducirMusicaDeFondo(){
        String musicaFondo = "src/Vista/Sonidos/C418  - Sweden - Minecraft Volume Alpha.mp3";
        Media melodia = new Media(new File(musicaFondo).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(melodia);
        mediaPlayer.play();
    }
}
