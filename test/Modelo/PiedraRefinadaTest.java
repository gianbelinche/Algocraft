package Modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PiedraRefinadaTest {

    private int durabilidadInicial;
    private Constructor constructor;
    private PiedraRefinada piedrarefinada;

    @Before
    public void setUp(){
        constructor = new Constructor();
        piedrarefinada = new PiedraRefinada();
        durabilidadInicial = piedrarefinada.durabilidad();

    }

    @Test
    public void testUsoPicoDeMaderaEnPiedraRefinadaYNoSeDesgastaLaPiedraRefinada(){

        Pico pico = constructor.crearPicoDeMadera();
        pico.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoHachaDeMaderaEnPiedraRefinadaYNoSeDesgastaLaPiedraRefinada(){

        Hacha hacha = constructor.crearHachaDeMadera();
        hacha.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraEnPiedraRefinadaYNoSeDesgastaLaPiedraRefinada(){

        Pico pico = constructor.crearPicoDePiedra();
        pico.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraEnPiedraRefinadaYNoSeDesgastaLaPiedraRefinada(){

        Hacha hacha = constructor.crearHachaDePiedra();
        hacha.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoPicoDeMetalEnPiedraRefinadaYNoSeDesgastaLaPiedraRefinada(){

        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoHachaDeMetalEnPiedraRefinadaYNoSeDesgastaLaPiedraRefinada(){

        Hacha hacha = constructor.crearHachaDeMetal();
        hacha.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraRefinadaEnPiedraRefinadaYSeDesgastaLaPiedraRefinada(){

        Pico pico = constructor.crearPicoDePiedraRefinada();
        pico.recoger(piedrarefinada);

        assertEquals(durabilidadInicial - pico.fuerza(), piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraRefinadaEnPiedraRefinadaYSeDesgastaLaPiedraRefinada(){

        Hacha hacha = constructor.crearHachaDePiedraRefinada();
        hacha.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoPicoDeDiamanteEnPiedraRefinadaYSeDesgastaLaPiedraRefinada(){

        Pico pico = constructor.crearPicoDeDiamante();
        pico.recoger(piedrarefinada);

        assertEquals(durabilidadInicial- pico.fuerza(), piedrarefinada.durabilidad());
    }

    @Test
    public void testUsoHachaDeDiamanteEnPiedraRefinadaYNoSeDesgastaLaPiedraRefinada(){

        Hacha hacha = constructor.crearHachaDeDiamante();
        hacha.recoger(piedrarefinada);

        assertEquals(durabilidadInicial, piedrarefinada.durabilidad());
    }

}