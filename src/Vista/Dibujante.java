package Vista;

import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
import Modelo.Escenario.TableroIterador;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Dibujante {

    private GraphicsContext atril;
    private VistaPosicionable vistaPosicionable;
    private Tablero tablero;
    double anchoPantalla;
    double altoPantalla;

    public Dibujante(GraphicsContext nuevoAtril, double nuevoAnchoPantalla,double nuevoAltoPantalla){
        anchoPantalla = nuevoAnchoPantalla;
        altoPantalla = nuevoAltoPantalla;
        vistaPosicionable = new VistaPosicionable(anchoPantalla,altoPantalla);
        tablero = Tablero.obtenerTablero();
        atril = nuevoAtril;
    }

    private void limpiarAtril(){
        atril.setFill(Color.LIGHTCYAN);
        atril.fillRect(0,0,anchoPantalla,altoPantalla);
    }

    public void dibujar(){
        limpiarAtril();
        Posicionable posicionable;
        TableroIterador tableroIterador = tablero.obtenerIterador();

        while(!tableroIterador.haFinalizado()){
            posicionable = tableroIterador.verActual();
            int x = tableroIterador.getX();
            int y = tableroIterador.getY();
            int z = tableroIterador.getZ();
            vistaPosicionable.dibujar(posicionable.getClass(),x,y,z,atril);
            tableroIterador.avanzar();
        }
    }

    public void cambiarImagenJugador(Image imagen){
        vistaPosicionable.cambiarImagenJugador(imagen);
    }

}
