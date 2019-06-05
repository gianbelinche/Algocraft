package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class HachaTest {

    @Test
    public void testCrearHachaDeMetalPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int durabilidad = hachaDeMetal.durabilidad();
        assertEquals(400,durabilidad);
    }
    @Test
    public void testCrearHachaDeMetalPoseeFuerzaCorrecta() {
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int fuerza = hachaDeMetal.fuerza();
        assertEquals(10, fuerza);
    }
    @Test
    public void testCrearHachaDeMaderaPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        assertEquals(100,durabilidad);
    }
    @Test
    public void testCrearHachaDeMaderaPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int fuerza = hachaDeMadera.fuerza();
        assertEquals(2,fuerza);
    }

    @Test
    public void testCrearHachaDePiedraPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        assertEquals(200,durabilidad);
    }

    @Test
    public void testCrearHachaDePiedraPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int fuerza = hachaDePiedra.fuerza();
        assertEquals(5,fuerza);
    }

    @Test
    public void testUsarHachadeMaderaContraPiedraDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Piedra());
        assertEquals(durabilidad-hachaDeMadera.fuerza(),hachaDeMadera.durabilidad());

    }

    @Test
    public void testUsarHachadeMaderaContraMaderaDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Madera());
        assertEquals(durabilidad-hachaDeMadera.fuerza(),hachaDeMadera.durabilidad());

    }

    @Test
    public void testUsarHachadePiedraContraMaderaDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        hachaDePiedra.recoger(new Madera());
        assertEquals(durabilidad-hachaDePiedra.fuerza(),hachaDePiedra.durabilidad());

    }

    @Test
    public void testUsarHachadePiedraContraPiedraDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        hachaDePiedra.recoger(new Piedra());
        assertEquals(durabilidad-hachaDePiedra.fuerza(),hachaDePiedra.durabilidad());

    }
}
