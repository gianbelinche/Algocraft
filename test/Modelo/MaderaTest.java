package Modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaderaTest {

        private int durabilidadInicial;
        private Constructor constructor;
        private Madera madera;

        @Before
        public void setUp(){
            constructor = new Constructor();
            madera = new Madera();
            durabilidadInicial = madera.durabilidad();

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

        assertEquals(durabilidadInicial - hacha.fuerza() , madera.durabilidad());
    }

        @Test
        public void testUsoPicoDePiedraEnMaderaYNoSeDesgastaLaMadera(){

            Pico pico = constructor.crearPicoDePiedra();
            pico.recoger(madera);

        assertEquals(durabilidadInicial , madera.durabilidad());
    }

        @Test
        public void testUsoHachaDePiedraEnMaderaYSeDesgastaLaMadera(){

            Hacha hacha = constructor.crearHachaDePiedra();
            hacha.recoger(madera);

        assertEquals(durabilidadInicial - hacha.fuerza() , madera.durabilidad());
    }

    @Test
    public void testUsoPicoDeMetalEnMaderaYNoSeDesgastaLaMadera(){

        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(madera);

        assertEquals(durabilidadInicial, madera.durabilidad());
    }

    @Test
    public void testUsoHachaDeMetalEnMaderaYSeDesgastaLaMadera(){
        Hacha hacha = constructor.crearHachaDeMetal();
        int anchoTablero = 10;
        int altoTablero = 10;
        int xMadera = 0;
        int yMadera = 0;
        Tablero tablero = new Tablero(anchoTablero,altoTablero);
        tablero.colocarEnPosicion(xMadera,yMadera,madera);

        hacha.recoger(madera);

        assertEquals(durabilidadInicial - hacha.fuerza() , madera.durabilidad());
    }

    @Test
    public void testUsoPicoDePiedraRefinadaEnMaderaYNoSeDesgastaLaMadera(){

        Pico pico = constructor.crearPicoDePiedraRefinada();
        pico.recoger(madera);

        assertEquals(durabilidadInicial, madera.durabilidad());
    }


}