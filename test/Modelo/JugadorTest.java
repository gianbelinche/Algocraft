package Modelo;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JugadorTest {

    Constructor constructor;
    Jugador jugador;
    Herramienta herramienta;

    @Before
    public void setUp(){
        constructor = new Constructor();
        jugador = new Jugador();
        herramienta = jugador.herramientaEquipada();
    }

    @Test
    public void testCrearJugadorPoseeHachaComoHerramientaInicial(){
        assertTrue(herramienta instanceof Hacha);
    }

    @Test
    public void testCrearJugadorPoseeHachaDeDurabilidadCorrecta(){
        int durabilidadInicial = herramienta.durabilidad();

        assertEquals(100, durabilidadInicial);
    }

    @Test
    public void testCrearJugadorPoseeHachaConDesgasteLineal(){
        assertTrue(herramienta.desgaste instanceof DesgasteLineal);
    }

    @Test
    public void testCrearJugadorPoseeHachaConFuerzaCorrecta(){
        int fuerzaHerramienta = herramienta.fuerza();;

        assertEquals(2, herramienta.fuerza());
    }

}