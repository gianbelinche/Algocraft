package Modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PosicionTest {

    private Posicion posicion;
    private Tablero tablero;
    private int posicionEnX = 3;
    private int posicionEnY = 6;

    @Before
    public void setUp(){
        int ancho = 10;
        int alto = 15;
        posicion = new Posicion(posicionEnX,posicionEnY);
        tablero = new Tablero(ancho, alto);
    }

    @Test
    public void testPosicionSeCreaCorrectamenteEnX(){
        assertEquals(posicionEnX, posicion.getX());
    }

    @Test
    public void testPosicionSeCreaCorrectamenteEnY(){
        assertEquals(posicionEnY, posicion.getY());
    }

    @Test
    public void testMoverPosicionADerechaCambiaXCorrectamente(){
        posicion.moverDerecha(tablero);
        assertEquals(posicionEnX+1, posicion.getX());
    }

    @Test
    public void testMoverPosicionAIzquierdaCambiaXCorrectamente(){
        posicion.moverIzquierda(tablero);
        assertEquals(posicionEnX-1, posicion.getX());
    }

    @Test
    public void testMoverPosicionAbajoCambiaXCorrectamente(){
        posicion.moverAbajo(tablero);
        assertEquals(posicionEnY+1, posicion.getY());
    }

    @Test
    public void testMoverPosicionArribaCambiaXCorrectamente(){
        posicion.moverArriba(tablero);
        assertEquals(posicionEnY-1, posicion.getY());
    }

}