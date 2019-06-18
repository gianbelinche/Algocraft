package Vista;

import Modelo.Escenario.Posicionable;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import javafx.scene.canvas.GraphicsContext;

public class VistaPosicionable {

    Vista vista;

    public void dibujar(Posicionable posicionable, int x, int y, GraphicsContext gc){
        this.dibujar(posicionable.getObjeto(), x, y, gc);
    }

    public void dibujar(Piedra posicionable, int x, int y, GraphicsContext gc){
        vista = new Vista("file:src/Vista/Imagenes/CasillaPiedra.png");
        vista.dibujar(x,y,gc);
    }

    public void dibujar(Madera posicionable, int x, int y, GraphicsContext gc){
        vista = new Vista("file:src/Vista/Imagenes/CasillaMadera.png");
        vista.dibujar(x,y,gc);
    }

    public void dibujar(Metal posicionable, int x, int y, GraphicsContext gc){
        vista = new Vista("file:src/Vista/Imagenes/CasillaMetal.png");
        vista.dibujar(x,y,gc);
    }

    public void dibujar(Diamante posicionable, int x, int y, GraphicsContext gc){
        vista = new Vista("file:src/Vista/Imagenes/CasillaDiamante.png");
        vista.dibujar(x,y,gc);
    }

}

