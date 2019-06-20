package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Hacha;
import Modelo.Herramientas.Pico;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiedraTest {
    private int durabilidadInicial;
    private Constructor constructor;
    private Piedra piedra;

    @Before
    public void setUp(){
        constructor = new Constructor();
        piedra = new Piedra();
        durabilidadInicial = piedra.durabilidad();
    }

    @Test
    public void testUsoPicoDeMaderaEnPiedraYSeDesgastaLaPiedra(){

        Pico pico = constructor.crearPicoDeMadera();
        pico.recoger(piedra);

        assertEquals(durabilidadInicial - pico.fuerza() , piedra.durabilidad());
    }

    @Test
    public void testUsoHachaDeMaderaEnPiedraYNoSeDesgastaLaPiedra(){

        Hacha hacha = constructor.crearHachaDeMadera();
        hacha.recoger(piedra);

        assertEquals(durabilidadInicial , piedra.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraEnPiedraYSeDesgastaLaPiedra(){

        Pico pico = constructor.crearPicoDePiedra();
        pico.recoger(piedra);

        assertEquals(durabilidadInicial - pico.fuerza() , piedra.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraEnPiedraYNoSeDesgastaLaPiedra(){

        Hacha hacha = constructor.crearHachaDePiedra();
        hacha.recoger(piedra);

        assertEquals(durabilidadInicial , piedra.durabilidad());
    }

    @Test
    public void testUsoPicoDeMetalEnPiedraYSeDesgastaLaPiedra(){

        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(piedra);

        assertEquals(durabilidadInicial - pico.fuerza() , piedra.durabilidad());
    }

    @Test
    public void testUsoHachaDeMetalEnPiedraYNoSeDesgastaLaPiedra(){

        Hacha hacha = constructor.crearHachaDeMetal();
        hacha.recoger(piedra);

        assertEquals(durabilidadInicial , piedra.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraRefinadaEnPiedraYSeDesgastaLaPiedra(){

        Pico pico = constructor.crearPicoDePiedraRefinada();
        pico.recoger(piedra);

        assertEquals(durabilidadInicial - pico.fuerza() , piedra.durabilidad());
    }

}