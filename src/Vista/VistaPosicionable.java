package Vista;

import Modelo.Escenario.*;
import Modelo.Jugador;
import Modelo.Materiales.*;
import Modelo.Escenario.Posicionable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import java.util.Map;

public class VistaPosicionable {

    Proyector proyector;
    private Map<Class, Image> imagenes;

    public VistaPosicionable(){

        proyector = new Proyector();
        imagenes = new HashMap<>();
        inicializarImagenes();

    }

    private void inicializarImagenes(){
        imagenes.put(Jugador.class      ,new Image("file:src/Vista/Imagenes/CasillaJugador.png"));
        imagenes.put(PosicionVacia.class,new Image("file:src/Vista/Imagenes/CasillaVacia.png"));
        imagenes.put(Madera.class       ,new Image("file:src/Vista/Imagenes/CasillaMadera.png"));
        imagenes.put(Piedra.class       ,new Image("file:src/Vista/Imagenes/CasillaPiedra.png"));
        imagenes.put(Metal.class        ,new Image("file:src/Vista/Imagenes/CasillaMetal.png"));
        imagenes.put(Diamante.class     ,new Image("file:src/Vista/Imagenes/CasillaDiamante.png"));
    }

    public void dibujar(Class clase, int x, int y, GraphicsContext gc){
        int XIso = proyector.obtenerXIso(x,y);
        int YIso = proyector.obtenerYIso(x,y);
        gc.drawImage(imagenes.get(clase),XIso,YIso);
    }
}