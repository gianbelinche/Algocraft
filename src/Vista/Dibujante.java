package Vista;

import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
import Modelo.Escenario.TableroIterador;
import javafx.scene.canvas.GraphicsContext;

public class Dibujante {

    private VistaPosicionable vistaPosicionable;
    private Tablero tablero;
    private int anchoTablero;
    private int altoTablero;

    public Dibujante(){
        vistaPosicionable = new VistaPosicionable();
        tablero = Tablero.obtenerTablero();
        anchoTablero = tablero.getAncho();
        altoTablero = tablero.getAlto();
    }

    public void dibujar(GraphicsContext gc){

        Posicionable posicionable;
        TableroIterador tableroIterador = tablero.obtenerIterador();
        while(!tableroIterador.haFinalizado()){
            posicionable = tableroIterador.verActual();
            int x = tableroIterador.getX();
            int y = tableroIterador.getY();
            vistaPosicionable.dibujar(posicionable.getClass().getName(), x,y,gc);
            tableroIterador.avanzar();
        }
/*
        for(int i = 0;i < anchoTablero;i++)
        {
            for(int j = 0;j < altoTablero;j++)
            {
                posicionable =  tablero.obtenerDePosicion(i,j);
                System.out.println(posicionable.getClass());
                vistaPosicionable.dibujar(posicionable, i,j,gc);
            }
        }*/
    }

}
