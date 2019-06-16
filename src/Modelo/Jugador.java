package Modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Jugador implements Posicionable{

    private Herramienta herramientaEquipada;
    private Posicion posicion;
    private Image sprite;
    private Inventario inventario;


    public Jugador(Tablero tablero){
        sprite = new Image("file:src/Vista/Imagenes/CasillaJugador.png");
        Constructor constructor = new Constructor();
        herramientaEquipada = constructor.crearHachaDeMadera();
        posicion = new Posicion(5, 5, tablero);
        inventario = new Inventario();
    }

    public Herramienta herramientaEquipada() {
        return herramientaEquipada;
    }

    @Override
    public int estaLibre() {
        return 0;
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){
        posicion = nuevaPosicion;
    }

    public void moverDerecha(){
        posicion.moverDerecha();
    }
    public void moverIzquierda(){
        posicion.moverIzquierda();
    }
    public void moverArriba(){
        posicion.moverArriba();
    }
    public void moverAbajo(){
        posicion.moverAbajo();
    }

    public boolean esIgual(Posicionable otroJugador) {
        return otroJugador instanceof Jugador;
    }

    public void recoger(Material unMaterial){
        Almacenable materialRecogido = herramientaEquipada.recoger(unMaterial);
        if(materialRecogido != null){
            inventario.almacenar(materialRecogido);
        }
    }
    public Almacenable obtenerDeInventario(int x, int y){
        return inventario.obtenerDePosicion(x, y);
    }

    @Override
    public void dibujar(int x, int y, GraphicsContext gc){
        gc.drawImage(sprite,x,y);
    }
}
