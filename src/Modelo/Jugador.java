package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Escenario.Posicion;
import Modelo.Escenario.Posicionable;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Material;

public class Jugador implements Posicionable {

    private Herramienta herramientaEquipada;
    private Posicion posicion;
    private Inventario inventario;


    public Jugador(){
        Constructor constructor = new Constructor();
        herramientaEquipada = constructor.crearHachaDeMadera();
        posicion = new Posicion(5, 5,0);
        inventario = new Inventario();
    }

    public Herramienta herramientaEquipada() {
        return herramientaEquipada;
    }

    public void equipar(Herramienta herramienta){
        herramientaEquipada = herramienta;
    }

    @Override
    public Posicion actualizarPosicion(int viejaX, int viejaY,int viejaZ, int nuevaX, int nuevaY,int nuevaZ){
        return new Posicion(viejaX,viejaY,viejaZ);
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
        Almacenable materialRecogido = null;

        try {
            materialRecogido = (Almacenable) herramientaEquipada.getClass().getDeclaredMethod("recoger",unMaterial.getClass()).invoke(herramientaEquipada,unMaterial);
        } catch (Exception e) {}

        if(materialRecogido != null){
            inventario.almacenar(materialRecogido);
        }
    }

    public Almacenable obtenerDeInventario(int x, int y){
        return inventario.obtenerDePosicion(x, y);
    }

}
