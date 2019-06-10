package Modelo;

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