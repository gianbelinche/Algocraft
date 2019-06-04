package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class PicoTest {


    @Test
    public void construirPicoDeMetalPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int durabilidad = picoDeMetal.durabilidad();
        assertEquals(400,durabilidad);
    }
    @Test
    public void construirPicoDeMetalPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int fuerza = picoDeMetal.fuerza();
        assertEquals(12,fuerza);
    }
    @Test
    public void construirPicoDePiedraRefinadaPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada.durabilidad();
        assertEquals(1000,durabilidad);
    }
    @Test
    public void construirPicoDePiedraRefinadaPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int fuerza = picoDePiedraRefinada.fuerza();
        assertEquals(20,fuerza);
    }
    @Test
    public void construirPicoDeMaderaPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        assertEquals(100,durabilidad);
    }

    @Test
    public void construirPicoDeMaderaPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int fuerza = picoDeMadera.fuerza();
        assertEquals(2,fuerza);
    }

    @Test
    public void construirPicoDePiedraPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        assertEquals(200,durabilidad);
    }

    @Test
    public void construirPicoDePiedraPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int fuerza = picoDePiedra.fuerza();
        assertEquals(4,fuerza);
    }

    @Test
    public void usarPicoDeMaderaContraMaderaDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        picoDeMadera.recoger(new Madera());
        assertEquals(durabilidad - picoDeMadera.fuerza(),picoDeMadera.durabilidad());
    }

    @Test
    public void usarPicoDeMaderaContraPiedraDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        picoDeMadera.recoger(new Piedra());
        assertEquals( durabilidad - picoDeMadera.fuerza(),picoDeMadera.durabilidad());
    }


    @Test
    public void usarPicoDePiedraContraMaderaDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Madera());

        assert((int) (durabilidad - picoDePiedra.fuerza()/1.5) == picoDePiedra.durabilidad());
    }

    @Test
    public void usarPicoDePiedraContraPiedraDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Piedra());
        assert((int)(durabilidad - picoDePiedra.fuerza()/1.5) == picoDePiedra.durabilidad());
    }


}