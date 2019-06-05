package Modelo;

import org.junit.Test;

public class JugadorTest {

    @Test
    public void testCrearJugadorPoseeHachaDeMadera(){
        Jugador jugador = new Jugador();
        Herramienta herramienta = jugador.herramientaEquipada();
        // Chequear que la herramienta es un hacha de madera
    }

}