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


}