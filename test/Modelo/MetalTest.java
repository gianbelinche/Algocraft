package Modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MetalTest {

    int durabilidadInicial;
    Constructor constructor;
    Metal metal;

    @Before
    public void setUp(){
        constructor = new Constructor();
        metal = new Metal();
        durabilidadInicial = metal.durabilidad();

    }

    /*
    @Test
    public void testUsoPicoDeMaderaEnMetalYNoSeDesgastaElMetal(){

        Pico pico = constructor.crearPicoDeMadera();
        pico.recoger(metal);

        assertEquals(durabilidadInicial, metal.durabilidad());
    }
    */

    @Test
    public void testUsoHachaDeMaderaEnMetalYNoSeDesgastaElMetal(){

        Hacha hacha = constructor.crearHachaDeMadera();
        hacha.recoger(metal);

        assertEquals(durabilidadInicial, metal.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraEnMetalYSeDesgastaElMetal(){

        Pico pico = constructor.crearPicoDePiedra();
        pico.recoger(metal);

        assertEquals(durabilidadInicial - pico.fuerza() , metal.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraEnMetalYNoSeDesgastaElMetal(){

        Hacha hacha = constructor.crearHachaDePiedra();
        hacha.recoger(metal);

        assertEquals(durabilidadInicial, metal.durabilidad());
    }

    @Test
    public void testUsoPicoDeMetalEnMetalYSeDesgastaElMetal(){

        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(metal);

        assertEquals(durabilidadInicial - pico.fuerza() , metal.durabilidad());
    }

    @Test
    public void testUsoHachaDeMetalEnMetalYNoSeDesgastaElMetal(){

        Hacha hacha = constructor.crearHachaDeMetal();
        hacha.recoger(metal);

        assertEquals(durabilidadInicial , metal.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraRefinadaEnMetalYSeDesgastaElMetal(){

        Pico pico = constructor.crearPicoDePiedraRefinada();
        pico.recoger(metal);

        assertEquals(durabilidadInicial - pico.fuerza() , metal.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraRefinadaEnMetalYNoSeDesgastaElMetal(){

        Hacha hacha = constructor.crearHachaDePiedraRefinada();
        hacha.recoger(metal);

        assertEquals(durabilidadInicial , metal.durabilidad());
    }

    @Test
    public void testUsoPicoDeDiamanteEnMetalYSeDesgastaElMetal(){

        Pico pico = constructor.crearPicoDeDiamante();
        pico.recoger(metal);

        assertEquals(durabilidadInicial - pico.fuerza() , metal.durabilidad());
    }

    @Test
    public void testUsoHachaDeDiamanteEnMetalYNoSeDesgastaElMetal(){

        Hacha hacha = constructor.crearHachaDeDiamante();
        hacha.recoger(metal);

        assertEquals(durabilidadInicial, metal.durabilidad());
    }


}