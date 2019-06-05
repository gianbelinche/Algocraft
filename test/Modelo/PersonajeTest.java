package Modelo;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonajeTest {

    @Test
    public void testCrearJugadorPoseeHachaDeMadera(){
        Personaje personaje = new Personaje();
        Herramienta herramienta = personaje.herramientaEquipada();
    }

}