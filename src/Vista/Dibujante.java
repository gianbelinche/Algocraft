package Vista;

import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
import Modelo.Escenario.TableroIterador;
import javafx.scene.canvas.GraphicsContext;

public class Dibujante {

    private VistaPosicionable vistaPosicionable;
    private Tablero tablero;

    public Dibujante(){
        vistaPosicionable = new VistaPosicionable();
        tablero = Tablero.obtenerTablero();
    }

    public void dibujar(GraphicsContext gc){
        Posicionable posicionable;
        TableroIterador tableroIterador = tablero.obtenerIterador();

        while(!tableroIterador.haFinalizado()){
            posicionable = tableroIterador.verActual();
            int x = tableroIterador.getX();
            int y = tableroIterador.getY();
            int z = tableroIterador.getZ();
            vistaPosicionable.dibujar(posicionable.getClass(),x,y,z,gc);
            tableroIterador.avanzar();
        }
    }

}
