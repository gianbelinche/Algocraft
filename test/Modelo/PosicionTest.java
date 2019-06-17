package Modelo;

import Modelo.Escenario.Posicion;
import Modelo.Escenario.Tablero;
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
        tablero = new Tablero(ancho, alto);
        posicion = new Posicion(posicionEnX,posicionEnY, tablero);

    }

    @Test
    public void testPosicionSeCreaCorrectamenteEnX(){
        assertEquals(posicionEnX, posicion.getX());
    }

    @Test
    public void testPosicionSeCreaCorrectamenteEnY(){
        assertEquals(posicionEnY, posicion.getY());
    }
}