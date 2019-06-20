package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Hacha;
import Modelo.Herramientas.Pico;
import Modelo.Materiales.Diamante;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiamanteTest {

    private int durabilidadInicial;
    private Constructor constructor;
    private Diamante diamante;

    @Before
    public void setUp(){
        constructor = new Constructor();
        diamante = new Diamante();
        durabilidadInicial = diamante.durabilidad();

    }

    @Test
    public void testUsoPicoDeMaderaEnDiamanteYNoSeDesgastaElDiamante(){

        Pico pico = constructor.crearPicoDeMadera();
        pico.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

    @Test
    public void testUsoHachaDeMaderaEnDiamanteYNoSeDesgastaElDiamante(){

        Hacha hacha = constructor.crearHachaDeMadera();
        hacha.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraEnDiamanteYNoSeDesgastaElDiamante(){

        Pico pico = constructor.crearPicoDePiedra();
        pico.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraEnDiamanteYNoSeDesgastaElDiamante(){

        Hacha hacha = constructor.crearHachaDePiedra();
        hacha.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

    @Test
    public void testUsoPicoDeMetalEnDiamanteYNoSeDesgastaElDiamante(){

        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

    @Test
    public void testUsoHachaDeMetalEnDiamanteYNoSeDesgastaElDiamante(){

        Hacha hacha = constructor.crearHachaDeMetal();
        hacha.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraRefinadaEnDiamanteYSeDesgastaElDiamante(){

        Pico pico = constructor.crearPicoDePiedraRefinada();
        pico.recoger(diamante);

        assertEquals(durabilidadInicial - pico.fuerza() , diamante.durabilidad());
    }

}