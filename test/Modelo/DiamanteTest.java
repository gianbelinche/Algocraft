package Modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiamanteTest {

    int durabilidadInicial;
    Constructor constructor;
    Diamante diamante;

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

    @Test
    public void testUsoHachaDePiedraRefinadaEnDiamanteYNoSeDesgastaElDiamante(){

        Hacha hacha = constructor.crearHachaDePiedraRefinada();
        hacha.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

    @Test
    public void testUsoPicoDeDiamanteEnDiamanteYSeDesgastaElDiamante(){

        Pico pico = constructor.crearPicoDeDiamante();
        pico.recoger(diamante);

        assertEquals(durabilidadInicial - pico.fuerza() , diamante.durabilidad());
    }

    @Test
    public void testUsoHachaDeDiamanteEnDiamanteYNoSeDesgastaElDiamante(){

        Hacha hacha = constructor.crearHachaDeDiamante();
        hacha.recoger(diamante);

        assertEquals(durabilidadInicial , diamante.durabilidad());
    }

}