package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class HachaTest {

    @Test
    public void testCrearHachaDeMetalPoseeDurabilidadCorrecta(){
        int durabilidadDelHacha = 400;
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int durabilidad = hachaDeMetal.durabilidad();
        assertEquals(durabilidadDelHacha,durabilidad);
    }
    @Test
    public void testCrearHachaDeMetalPoseeFuerzaCorrecta() {
        int fuerzaDelHacha = 10;
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int fuerza = hachaDeMetal.fuerza();
        assertEquals(fuerzaDelHacha, fuerza);
    }
    @Test
    public void testCrearHachaDeMaderaPoseeDurabilidadCorrecta(){
        int durabilidadDelHacha = 100;
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        assertEquals(durabilidadDelHacha,durabilidad);
    }
    @Test
    public void testCrearHachaDeMaderaPoseeFuerzaCorrecta(){
        int fuerzaDelHacha = 2;
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int fuerza = hachaDeMadera.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);
    }

    @Test
    public void testCrearHachaDePiedraPoseeDurabilidadCorrecta(){
        int durabilidadDelHacha = 200;
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        assertEquals(durabilidadDelHacha,durabilidad);
    }

    @Test
    public void testCrearHachaDePiedraPoseeFuerzaCorrecta(){
        int fuerzaDelHacha = 5;
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int fuerza = hachaDePiedra.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);
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
    public void testUsarHachadeMaderaContraMetalDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Metal());
        assertEquals(durabilidad-hachaDeMadera.fuerza(),hachaDeMadera.durabilidad());

    }

    @Test
    public void testUsarHachadeMaderaContraDiamanteDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Diamante());
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

    @Test
    public void testUsarHachadePiedraContraMetalDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        hachaDePiedra.recoger(new Metal());
        assertEquals(durabilidad-hachaDePiedra.fuerza(),hachaDePiedra.durabilidad());

    }

    @Test
    public void testUsarHachadePiedraContraDiamanteDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        hachaDePiedra.recoger(new Diamante());
        assertEquals(durabilidad-hachaDePiedra.fuerza(),hachaDePiedra.durabilidad());

    }
    private int factor = 2;
    @Test
    public void testUsarHachadeMetalContraMaderaDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int durabilidad = hachaDeMetal.durabilidad();

        Madera madera = new Madera();
        Tablero tablero = new Tablero(10,10);
        tablero.colocarEnPosicion(0,0,madera);

        hachaDeMetal.recoger(madera);
        assertEquals(durabilidad-hachaDeMetal.fuerza()/factor,hachaDeMetal.durabilidad());

    }

    @Test
    public void testUsarHachadeMetalContraPiedraDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int durabilidad = hachaDeMetal.durabilidad();
        hachaDeMetal.recoger(new Piedra());
        assertEquals(durabilidad-hachaDeMetal.fuerza()/factor,hachaDeMetal.durabilidad());

    }

    @Test
    public void testUsarHachadeMetalContraMetalDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int durabilidad = hachaDeMetal.durabilidad();
        hachaDeMetal.recoger(new Metal());
        assertEquals(durabilidad-hachaDeMetal.fuerza()/factor,hachaDeMetal.durabilidad());

    }

    @Test
    public void testUsarHachadeMetalContraDiamanteDisminuyeLaDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        int durabilidad = hachaDeMetal.durabilidad();
        hachaDeMetal.recoger(new Diamante());
        assertEquals(durabilidad-hachaDeMetal.fuerza()/factor,hachaDeMetal.durabilidad());

    }
}
