import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PiedraTest {
    int durabilidadInicial;
    Constructor constructor;
    Piedra piedra;

    @Before
    public void setUp(){
        constructor = new Constructor();
        piedra = new Piedra();
        durabilidadInicial = piedra.durabilidad();

    }
    @Test
    public void testUsoPicoDePiedraEnPiedraYSeDesgastaLaPiedra(){

        Pico pico = constructor.crearPicoDePiedra();
        pico.recoger(piedra);

       assertEquals(durabilidadInicial - pico.fuerza(),piedra.durabilidad());
    }

    @Test
    public void testUsoPicoDeMaderaEnPiedraYSeDesgastaLaPiedra(){
        Pico pico = constructor.crearPicoDeMadera();
        pico.recoger(piedra);

        assertEquals(durabilidadInicial - pico.fuerza(),piedra.durabilidad());
    }

    @Test
    public void testUsoHachaDeMaderaEnPiedraYNoSeDesgastaLaPiedra(){
        Hacha hacha = constructor.crearHachaDeMadera();
        hacha.recoger(piedra);

        assertEquals(durabilidadInicial,piedra.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraEnPiedraYNoSeDesgastaLaPiedra(){
        Hacha hacha = constructor.crearHachaDePiedra();
        hacha.recoger(piedra);

        assertEquals(durabilidadInicial,piedra.durabilidad());
    }

}