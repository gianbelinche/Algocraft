package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class HachaTest {

    @Test
    public void crearHachaDeMetalPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int durabilidad = hachaDeMetal.durabilidad();
        assertEquals(400,durabilidad);
    }
    @Test
    public void crearHachaDeMetalPoseeFuerzaCorrecta() {
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int fuerza = hachaDeMetal.fuerza();
        assertEquals(10, fuerza);
    }
    @Test
    public void crearHachaDeMaderaPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        assertEquals(100,durabilidad);
    }
    @Test
    public void crearHachaDeMaderaPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int fuerza = hachaDeMadera.fuerza();
        assertEquals(2,fuerza);
    }

    @Test
    public void crearHachaDePiedraPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        assertEquals(200,durabilidad);
    }

    @Test
    public void crearHachaDePiedraPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int fuerza = hachaDePiedra.fuerza();
        assertEquals(5,fuerza);
    }

    @Test
    public void usarHachadeMaderaContraPiedraDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Piedra());
        assertEquals(durabilidad-hachaDeMadera.fuerza(),hachaDeMadera.durabilidad());

    }

    @Test
    public void usarHachadeMaderaContraMaderaDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Madera());
        assertEquals(durabilidad-hachaDeMadera.fuerza(),hachaDeMadera.durabilidad());

    }

    @Test
    public void usarHachadePiedraContraMaderaDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        hachaDePiedra.recoger(new Madera());
        assertEquals(durabilidad-hachaDePiedra.fuerza(),hachaDePiedra.durabilidad());

    }

    @Test
    public void usarHachadePiedraContraPiedraDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        hachaDePiedra.recoger(new Piedra());
        assertEquals(durabilidad-hachaDePiedra.fuerza(),hachaDePiedra.durabilidad());

    }
}
