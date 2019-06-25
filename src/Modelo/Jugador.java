package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Escenario.Posicion;
import Modelo.Escenario.Posicionable;
import Modelo.Escenario.Tablero;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Material;

public class Jugador implements Posicionable {

    private Herramienta herramientaEquipada;
    private Posicion posicion;
    private Inventario inventario;
    private Direccion direccion;
    private Tablero tablero;

    public Jugador(Inventario unInventario){
        Constructor constructor = new Constructor();
        herramientaEquipada = constructor.crearHachaDeMadera();
        posicion = new Posicion(5, 5,0);
        inventario = unInventario;
        direccion = new Abajo();
        tablero = Tablero.obtenerTablero();
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

    private void actualizarDireccion(Direccion direccion){
        this.direccion = direccion;
    }

    public Direccion getDireccion(){
        return direccion;
    }

    public void moverDerecha(){
        posicion.moverDerecha();
        actualizarDireccion(new Derecha());
    }

    public void moverIzquierda(){
        posicion.moverIzquierda();
        actualizarDireccion(new Izquierda());
    }

    public void moverArriba(){
        posicion.moverArriba();
        actualizarDireccion(new Arriba());
    }

    public void moverAbajo(){
        posicion.moverAbajo();
        actualizarDireccion(new Abajo());
    }

    public boolean esIgual(Posicionable otroJugador) {
        return otroJugador instanceof Jugador;
    }

    public void recoger(){
        int xMaterial = posicion.getX() + direccion.getIncrementoX();
        int yMaterial = posicion.getY() + direccion.getIncrementoY();
        int zMaterial = posicion.getZ();
        Posicionable unMaterial = tablero.obtenerDePosicion(xMaterial, yMaterial, zMaterial);
        Almacenable materialRecogido = null;

        try {
            materialRecogido = (Almacenable) herramientaEquipada.getClass().getDeclaredMethod("recoger",unMaterial.getClass()).invoke(herramientaEquipada,unMaterial);
        } catch (Exception e) {}

        if(materialRecogido != null){
            inventario.almacenar(materialRecogido);
        }
    }

    public void guardarEnInventario(Almacenable objeto){
        inventario.almacenar(objeto);
    }
    public Almacenable obtenerDeInventario(Almacenable objeto){
        return inventario.obtener(objeto);
    }
}
