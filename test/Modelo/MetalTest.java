package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Hacha;
import Modelo.Herramientas.Pico;
import Modelo.Materiales.Metal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MetalTest {

    private int durabilidadInicial;
    private Constructor constructor;
    private Metal metal;

    @Before
    public void setUp(){
        constructor = new Constructor();
        metal = new Metal();
        durabilidadInicial = metal.durabilidad();

    }

    @Test
    public void testUsoPicoDeMaderaEnMetalYNoSeDesgastaElMetal(){

        Pico pico = constructor.crearPicoDeMadera();
        pico.recoger(metal);

        assertEquals(durabilidadInicial, metal.durabilidad());
    }

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

}