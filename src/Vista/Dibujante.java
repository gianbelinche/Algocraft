package Vista;

import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
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

        for(int i = 0;i < anchoTablero;i++)
        {
            for(int j = 0;j < altoTablero;j++)
            {
                posicionable =  tablero.obtenerDePosicion(i,j);
                System.out.println(posicionable.getClass());
                vistaPosicionable.dibujar(posicionable, i,j,gc);
            }
        }
    }

}
