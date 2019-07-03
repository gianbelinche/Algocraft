package Vista;

import Modelo.Escenario.*;
import Modelo.ElementosJugador.Jugador;
import Modelo.Materiales.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.sqrt;

public class VistaPosicionable {

    private Map<Class, Image> imagenes;
    private double ladoCelda = 64;
    private double corrimientoX;
    private double corrimientoY;

    public VistaPosicionable(double anchoPantalla, double altoPantalla){
        imagenes = new HashMap<>();
        inicializarImagenes();
        corrimientoX = anchoPantalla/2;
        corrimientoY = altoPantalla/8;
    }

    private void inicializarImagenes(){

        imagenes.put(Jugador.class        ,new Image("file:src/Vista/Imagenes/JugadorAbajo.png"));
        imagenes.put(PosicionVacia.class  ,new Image("file:src/Vista/Imagenes/CasillaVacia.png"));
        imagenes.put(PosicionOcupada.class,new Image("file:src/Vista/Imagenes/CasillaOcupada.png"));
        imagenes.put(Tierra.class         ,new Image("file:src/Vista/Imagenes/CasillaTierra.png"));
        imagenes.put(Agua.class           ,new Image("file:src/Vista/Imagenes/CasillaAgua.png"));
        imagenes.put(Bote.class           ,new Image("file:src/Vista/Imagenes/CasillaBote.png"));
        imagenes.put(Madera.class         ,new Image("file:src/Vista/Imagenes/CasillaMadera.png"));
        imagenes.put(Piedra.class         ,new Image("file:src/Vista/Imagenes/CasillaPiedra.png"));
        imagenes.put(Metal.class          ,new Image("file:src/Vista/Imagenes/CasillaMetal.png"));
        imagenes.put(Diamante.class       ,new Image("file:src/Vista/Imagenes/CasillaDiamante.png"));

    }

    public void dibujar(Class clase, int x, int y,int z, GraphicsContext gc){

        Image imagen = imagenes.get(clase);
        x *= ladoCelda/2;y *= ladoCelda/2;z = (int)(z*ladoCelda/2 - imagen.getHeight());
        double XIso = (x - y)/sqrt(2);
        double YIso = (x + 2*z + y)/sqrt(6);
        gc.drawImage(imagen,XIso + corrimientoX,YIso + corrimientoY);
    }

    public void cambiarImagenJugador(Image imagen){
        imagenes.put(Jugador.class, imagen);
    }
}