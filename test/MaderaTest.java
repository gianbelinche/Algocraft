import org.junit.Test;

import static org.junit.Assert.*;

public class MaderaTest {

    @Test
    public void testUsoHachaDePiedraEnMaderaYSeDesgastaLaMadera(){
        Madera madera = new Madera();
        Hacha hacha = new Hacha(100,new Piedra(),5);
        int durabilidadInicial = madera.durabilidad();

        hacha.recoger(madera);
        assertEquals(durabilidadInicial - 5,madera.durabilidad());
    }

    @Test
    public void testUsoHachaDeMaderaEnMaderaYSeDesgastaLaMadera(){
        Madera madera = new Madera();
        Hacha hacha = new Hacha(100,new Madera(),5);
        int durabilidadInicial = madera.durabilidad();

        hacha.recoger(madera);
        assertEquals(durabilidadInicial - 5,madera.durabilidad());
    }

    @Test
    public void testUsoPicoDeMaderaEnMaderaYNoSeDesgastaLaMadera(){
        Madera madera = new Madera();
        Constructor constructor = new Constructor();
        Pico pico = constructor.crearPicoDeMadera();
        int durabilidadInicial = madera.durabilidad();

        pico.recoger(madera);
        assertEquals(durabilidadInicial,madera.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraEnMaderaYNoSeDesgastaLaMadera(){
        Madera madera = new Madera();
        Constructor constructor = new Constructor();
        Pico pico = constructor.crearPicoDePiedra();
        int durabilidadInicial = madera.durabilidad();

        pico.recoger(madera);
        assertEquals(durabilidadInicial,madera.durabilidad());
    }
}