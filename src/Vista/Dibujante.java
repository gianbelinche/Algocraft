package Vista;

import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
import Modelo.Escenario.TableroIterador;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Dibujante {

    private GraphicsContext atril;
    private VistaPosicionable vistaPosicionable;
    private Tablero tablero;

    public Dibujante(GraphicsContext nuevoAtril, double corrimientoX,double corrimientoY){
        vistaPosicionable = new VistaPosicionable(corrimientoX,corrimientoY);
        tablero = Tablero.obtenerTablero();
        atril = nuevoAtril;
    }

    private void limpiarAtril(){
        atril.setFill(Color.LIGHTCYAN);
        atril.fillRect(0,0,3000,3000);
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

}
