package Vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class CajaMusical {

    static MediaPlayer  mediaPlayerSonido;
    static MediaPlayer mediaPlayerFondo;


    public static void reproducirMusicaDeFondo(){
        String musicaFondo = "src/Vista/Sonidos/C418  - Sweden - Minecraft Volume Alpha.mp3";
        Media melodia = new Media(new File(musicaFondo).toURI().toString());
        mediaPlayerFondo = new MediaPlayer(melodia);
        mediaPlayerFondo.play();
    }

    public static void reproducirMusicaDeHacha(){
        String musicaHacha = "src/Vista/Sonidos/Sonido hacha.wav";
        Media melodiaHacha = new Media(new File(musicaHacha).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(melodiaHacha);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }

    public static void reproducirMusicaGanar(){
        String musicaGanar = "src/Vista/Sonidos/Sonido ganar.wav";
        Media melodia = new Media(new File(musicaGanar).toURI().toString());
        mediaPlayerSonido.stop();
        mediaPlayerSonido = new MediaPlayer(melodia);
        mediaPlayerSonido.setVolume(0.5);
        mediaPlayerSonido.play();
    }
}
