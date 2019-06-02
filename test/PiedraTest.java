import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiedraTest {

    @Test
    public void testUsoPicoDePiedraEnPiedraYSeDesgastaLaPiedra(){
        Piedra piedra = new Piedra();
        Pico pico = new Pico(100,new Piedra(),5);
        int durabilidadInicial = piedra.durabilidad();

        pico.recoger(piedra);
       assertEquals(durabilidadInicial - 5,piedra.durabilidad());
    }

    @Test
    public void testUsoPicoDeMaderaEnPiedraYNoSeDesgastaLaPiedra(){
        Piedra piedra = new Piedra();
        Pico pico = new Pico(100,new Madera(),5);
        int durabilidadInicial = piedra.durabilidad();

        pico.recoger(piedra);

        assertEquals(durabilidadInicial,piedra.durabilidad());
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