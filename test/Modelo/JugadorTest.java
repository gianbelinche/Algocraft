package Modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JugadorTest {

    Constructor constructor;
    Jugador jugador;
    Herramienta herramienta;
    Tablero tablero;
    int x;
    int y;

    @Before
    public void setUp(){
        constructor = new Constructor();
        jugador = new Jugador(tablero);
        herramienta = jugador.herramientaEquipada();

        tablero = new Tablero(10, 10);
        x = 5;
        y = 5;
        tablero.colocarEnPosicion(x,y,jugador);

    }

    @Test
    public void testCrearJugadorPoseeHachaComoHerramientaInicial(){
        assertTrue(herramienta instanceof Hacha);
    }

    @Test
    public void testCrearJugadorPoseeHachaDeDurabilidadCorrecta(){
        int durabilidadDeseada = 100;
        int durabilidadInicial = herramienta.durabilidad();

        assertEquals(durabilidadDeseada, durabilidadInicial);
    }

    @Test
    public void testCrearJugadorPoseeHachaConDesgasteLineal(){
        assertTrue(herramienta.desgaste instanceof DesgasteLineal);
    }

    @Test
    public void testCrearJugadorPoseeHachaConFuerzaCorrecta(){
        int fuerzaDeseada = 2;
        int fuerzaHerramienta = herramienta.fuerza();

        assertEquals(fuerzaDeseada, fuerzaHerramienta);
    }

    @Test
    public void testJugadorSeMueveHaciaLaDerechaYAumentaSuX(){

        jugador.moverDerecha();
        assertEquals(jugador, tablero.obtenerDePosicion(x + 1,y));
    }

    @Test
    public void testJugadorSeMueveHaciaLaIzquierdaYDisminuyeSuX(){

        jugador.moverIzquierda();
        assertEquals(jugador, tablero.obtenerDePosicion(x - 1,y));
    }

    @Test
    public void testJugadorSeMueveHaciaArribaYDisminuyeSuY(){

        jugador.moverArriba();
        assertEquals(jugador, tablero.obtenerDePosicion(x,y - 1));
    }

    @Test
    public void testJugadorSeMueveHaciaArribaYAumentaSuY(){

        jugador.moverAbajo();
        assertEquals(jugador, tablero.obtenerDePosicion(x,y + 1));
    }

}