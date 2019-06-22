package Modelo;

import Modelo.Escenario.Posicion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PosicionTest {

    private Posicion posicion;
    private int posicionEnX = 3;
    private int posicionEnY = 6;
    private int posicionEnZ = 0;

    @Before
    public void setUp(){
        posicion = new Posicion(posicionEnX,posicionEnY,posicionEnZ);

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