package Modelo;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JugadorTest {

    @Test
    public void testCrearJugadorPoseeHachaDeMadera(){
        Jugador jugador = new Jugador();
        Herramienta herramienta = jugador.herramientaEquipada();
        assertEquals(100, herramienta.durabilidad());
        assertEquals(2,herramienta.fuerza());

        //Chequeo desgaste correspondiente al hacha de madera

        int durabilidad = herramienta.durabilidad();
        herramienta.recoger(new Madera());
        assertEquals(durabilidad-herramienta.fuerza(),herramienta.durabilidad());

        //Otra opcion

        assertTrue(herramienta.desgaste instanceof DesgasteLineal);
    }

}