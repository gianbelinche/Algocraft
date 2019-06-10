package Modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JugadorTest {

    Constructor constructor;
    Jugador jugador;
    Herramienta herramienta;
    Tablero tablero;

    @Before
    public void setUp(){
        constructor = new Constructor();
        tablero = new Tablero(10, 10);
        jugador = new Jugador(tablero);
        herramienta = jugador.herramientaEquipada();
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

}