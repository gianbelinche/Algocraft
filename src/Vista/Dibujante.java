package Vista;

import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
import javafx.scene.canvas.GraphicsContext;

public class Dibujante {

    private VistaMaterial vistaMaterial;
    private Tablero tablero;
    private int anchoTablero;
    private int altoTablero;

    public Dibujante(){
        vistaMaterial = new VistaMaterial();
        tablero = new Tablero();
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
                vistaMaterial.dibujar(posicionable, i,j,gc);
            }
        }
    }

}
