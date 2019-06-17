package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Escenario.Tablero;
import Modelo.Herramientas.Pico;
import Modelo.Materiales.Piedra;
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
    public void testTableroSeCreaConCeldasVacias(){
        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                assertEquals(1, tablero.estaLibre(x,y));
            }
        }
    }

    @Test
    public void testTableroColocarMaterial(){
        int x = 6;
        int y = 3;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        assertEquals(piedra, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void testTableroBorrarMaterial(){
        int x = 6;
        int y = 3;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        tablero.borrarEnPosicion(x,y);
        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void testTableroColocarJugador(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        assertEquals(jugador, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void testTableroBorrarJugador(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        tablero.borrarEnPosicion(x,y);
        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void testTableroJugadorSeMueveHaciaLaDerechaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverDerecha();

        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void testTableroJugadorSeMueveHaciaLaIzquierdaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverIzquierda();

        assertEquals(1, tablero.estaLibre(x,y));
    }

    @Test
    public void testTableroJugadorSeMueveHaciaArribaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverArriba();

        assertEquals(1, tablero.estaLibre(x,y));
    }


    @Test
    public void testTableroJugadorSeMueveHaciaAbajoYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverAbajo();

        assertEquals(1, tablero.estaLibre(x,y));
    }


    @Test
    public void testTableroMoverJugadorFueraDelBordeNoAlteraPosicion(){
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
    public void testTableroMoverJugadorContraMaterialNoAlteraSuPosicion(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador(tablero);
        tablero.colocarEnPosicion(x,y,jugador);
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x + 1,y,piedra);

        jugador.moverDerecha();

        assertEquals(jugador, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void testTableroAlRecolectarseUnMaterialSeEliminaDelMapa(){
        int x = 5;
        int y = 5;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);

        Constructor constructor = new Constructor();
        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(piedra);
        pico.recoger(piedra);
        pico.recoger(piedra);

        assertEquals(1, tablero.estaLibre(x,y));
    }
}