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
                assertEquals(1, tablero.estaLibre(x,y));
            }
        }
    }

    @Test
    public void TestTableroColocarMaterial(){
        int x = 6;
        int y = 3;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        assertEquals(piedra, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void TestTableroBorrarMaterial(){
        int x = 6;
        int y = 3;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        tablero.borrarEnPosicion(x,y);
        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void TestTableroColocarJugador(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        assertEquals(jugador, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void TestTableroBorrarJugador(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        tablero.borrarEnPosicion(x,y);
        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void TestTableroJugadorSeMueveHaciaLaDerechaYAumentaSuX(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);

        jugador.moverDerecha();
        assertEquals(jugador, tablero.obtenerDePosicion(x + 1,y));
    }

    @Test
    public void TestTableroJugadorSeMueveHaciaLaDerechaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverDerecha();

        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void TestTableroJugadorSeMueveHaciaLaIzquierdaYDisminuyeSuX(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);

        jugador.moverIzquierda();
        assertEquals(jugador, tablero.obtenerDePosicion(x - 1,y));
    }

    @Test
    public void TestTableroJugadorSeMueveHaciaLaIzquierdaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverIzquierda();

        assertEquals(1, tablero.estaLibre(x,y));
    }


    @Test
    public void TestTableroJugadorSeMueveHaciaArribaYDisminuyeSuY(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);

        jugador.moverArriba();
        assertEquals(jugador, tablero.obtenerDePosicion(x,y - 1));
    }

    @Test
    public void TestTableroJugadorSeMueveHaciaArribaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverArriba();

        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void TestTableroJugadorSeMueveHaciaAbajoYAumentaSuY(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);

        jugador.moverAbajo();
        assertEquals(jugador, tablero.obtenerDePosicion(x,y + 1));
    }

    @Test
    public void TestTableroJugadorSeMueveHaciaAbajoYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverAbajo();

        assertEquals(1, tablero.estaLibre(x,y));
    }


    @Test
    public void TestTableroMoverJugadorFueraDelBordeNoAlteraPosicion(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);

        for(int i = 0;i <100;i++){
            jugador.moverDerecha();
        }

        assertEquals(jugador, tablero.obtenerDePosicion(ancho - 1,y));
    }

    @Test
    public void TestTableroMoverJugadorContraMaterialNoAlteraSuPosicion(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x + 1,y,piedra);

        jugador.moverDerecha();

        assertEquals(jugador, tablero.obtenerDePosicion(x,y));
    }




}