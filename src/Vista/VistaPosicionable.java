package Vista;

import Modelo.Escenario.Posicionable;
import javafx.scene.canvas.GraphicsContext;

public class VistaPosicionable {

    public void dibujar(Posicionable posicionable, int x, int y, GraphicsContext gc){
        String ruta = posicionable.obtenerRutaImagen();
        Vista vista = new Vista(ruta);
        vista.dibujar(x,y,gc);
    }
}

