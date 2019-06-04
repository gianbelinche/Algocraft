package Modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaderaTest {

        int durabilidadInicial;
        Constructor constructor;
        Madera madera;

        @Before
        public void setUp(){
            constructor = new Constructor();
            madera = new Madera();
            durabilidadInicial = madera.durabilidad();

        }
        @Test
        public void testUsoPicoDePiedraEnMaderaYNoSeDesgastaLaMadera(){

            Pico pico = constructor.crearPicoDePiedra();
            pico.recoger(madera);

            assertEquals(durabilidadInicial , madera.durabilidad());
        }

        @Test
        public void testUsoPicoDeMaderaEnMaderaYNoSeDesgastaLaMadera(){

        Pico pico = constructor.crearPicoDeMadera();
        pico.recoger(madera);

        assertEquals(durabilidadInicial , madera.durabilidad());
        }

        @Test
        public void testUsoHachaDeMaderaEnMaderaYSeDesgastaLaMadera(){
            Hacha hacha = constructor.crearHachaDeMadera();
            hacha.recoger(madera);

            assertEquals(durabilidadInicial - hacha.fuerza(), madera.durabilidad());
        }

        @Test
        public void testUsoHachaDePiedraEnMaderaYSeDesgastaLaMadera(){
            Hacha hacha = constructor.crearHachaDePiedra();
            hacha.recoger(madera);

            assertEquals(durabilidadInicial - hacha.fuerza(), madera.durabilidad());
        }

    }