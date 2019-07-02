package Vista;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;



public class CajaMusical {

    static AudioClip musicaPrincipal = new AudioClip(new File("src/Vista/Sonidos/C418  - Sweden - Minecraft Volume Alpha.mp3").toURI().toString());
    static AudioClip musicaHacha    = new AudioClip(new File("src/Vista/Sonidos/Sonido hacha.wav").toURI().toString());
    static AudioClip musicaVictoria = new AudioClip(new File("src/Vista/Sonidos/Sonido ganar.wav").toURI().toString());

    public static void reproducirMusicaDeFondo(){
        musicaPrincipal.play();
    }

    public static void reproducirMusicaDeHacha(){
        musicaHacha.play();
    }

    public static void reproducirMusicaVictoria(){

        musicaVictoria.play();
    }
}
