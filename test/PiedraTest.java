import org.junit.Test;

import static org.junit.Assert.*;

public class PiedraTest {

    @Test
    public void testUsoPicoDePiedraEnPiedraYSeDesgastaLaPiedra(){
        Piedra piedra = new Piedra();
        Constructor constructor = new Constructor();
        Pico pico = constructor.crearPicoDePiedra();
        int durabilidadInicial = piedra.durabilidad();

        pico.recoger(piedra);
       assertEquals(durabilidadInicial - 4,piedra.durabilidad());
    }

    @Test
    public void testUsoPicoDeMaderaEnPiedraYSeDesgastaLaPiedra(){
        Piedra piedra = new Piedra();
        Constructor constructor = new Constructor();
        Pico pico = constructor.crearPicoDeMadera();
        int durabilidadInicial = piedra.durabilidad();

        pico.recoger(piedra);

        assertEquals(durabilidadInicial - pico.fuerza(),piedra.durabilidad());
    }

    @Test
    public void testUsoHachaDeMaderaEnPiedraYNoSeDesgastaLaPiedra(){
        Piedra piedra = new Piedra();
        Hacha hacha = new Hacha(100,new Piedra(),5);
        int durabilidadInicial = piedra.durabilidad();

        hacha.recoger(piedra);

        assertEquals(durabilidadInicial,piedra.durabilidad());
    }

    @Test
    public void testUsoHachaDePiedraEnPiedraYNoSeDesgastaLaPiedra(){
        Piedra piedra = new Piedra();
        Hacha hacha = new Hacha(100,new Madera(),5);
        int durabilidadInicial = piedra.durabilidad();

        hacha.recoger(piedra);

        assertEquals(durabilidadInicial,piedra.durabilidad());
    }

}