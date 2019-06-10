package Modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {
    private Tablero tablero;
    int alto;
    int ancho;

    @Before
    public void SetUp(){
        alto = 8;
        ancho = 10;
        tablero = new Tablero(ancho, alto);
    }

    @Test
    public void TestTableroSeCreaConCeldasVacias(){
        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                assertEquals(tablero.obtenerDePosicion(x,y), null);
            }
        }
    }
    @Test
    public void TestTableroMoverDerecha(){
        int x = 5;
        int y = 5;
        int nuevo_x;
        nuevo_x = tablero.moverDerecha(x, y);
        assertEquals(nuevo_x, x+1);

    }
    @Test
    public void TestTableroMoverArriba(){
        int x = 5;
        int y = 5;
        int nuevo_y;
        nuevo_y = tablero.moverArriba(x, y);
        assertEquals(nuevo_y, y-1);
    }
    @Test
    public void TestTableroMoverIzquierda(){
        int x = 5;
        int y = 5;
        int nuevo_x;
        nuevo_x = tablero.moverIzquierda(x, y);
        assertEquals(nuevo_x, x-1);
    }
    @Test
    public void TestTableroMoverAbajo(){
        int x = 5;
        int y = 5;
        int nuevo_y;
        nuevo_y = tablero.moverAbajo(x, y);
        assertEquals(nuevo_y, y+1);
    }
    @Test
    public void TestTableroMoverFueraDeBordeNoAlteraPosicion(){
        int x = 10;
        int y = 5;
        int nuevo_x;
        nuevo_x = tablero.moverDerecha(x, y);
        assertEquals(nuevo_x, x);
    }
    @Test
    public void TestTableroColocarObjeto(){
        int x = 6;
        int y = 3;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        assertEquals(piedra, tablero.obtenerDePosicion(x,y));
    }
    @Test
    public void TestTableroColocarObjetoYMoverlo(){
        int x = 6;
        int y = 3;
        int nueva_y;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        nueva_y = tablero.moverArriba(x, y);
        assertEquals(piedra, tablero.obtenerDePosicion(x,nueva_y));
    }
    @Test
    public void TestTableroColocarObjetoYMoverloDevuelveNullEnPosicionOriginal(){
        int x = 6;
        int y = 3;
        int nueva_y;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        nueva_y = tablero.moverArriba(x, y);
        assertEquals(null, tablero.obtenerDePosicion(x,y));
    }


}