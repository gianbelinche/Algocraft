package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Escenario.Posicion;
import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Material;
import Vista.Vista;
import javafx.scene.canvas.GraphicsContext;

public class Jugador implements Posicionable {

    private Herramienta herramientaEquipada;
    private Posicion posicion;
    private Vista vista;
    private Inventario inventario;


    public Jugador(Tablero tablero){
        vista = new Vista("file:src/Vista/Imagenes/CasillaJugador.png");
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

    public void dibujar(int x, int y, GraphicsContext gc){
        vista.dibujar(x,y,gc);
    }

    public Almacenable obtenerDeInventario(int x, int y){
        return inventario.obtenerDePosicion(x, y);
    }
}
