package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class PicoTest {


    @Test
    public void testConstruirPicoDeMetalPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int durabilidad = picoDeMetal.durabilidad();
        assertEquals(400,durabilidad);
    }
    @Test
    public void testConstruirPicoDeMetalPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int fuerza = picoDeMetal.fuerza();
        assertEquals(12,fuerza);
    }
    @Test
    public void testConstruirPicoDePiedraRefinadaPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada.durabilidad();
        assertEquals(1000,durabilidad);
    }
    @Test
    public void testConstruirPicoDePiedraRefinadaPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int fuerza = picoDePiedraRefinada.fuerza();
        assertEquals(20,fuerza);
    }
    @Test
    public void testConstruirPicoDeMaderaPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        assertEquals(100,durabilidad);
    }

    @Test
    public void testConstruirPicoDeMaderaPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int fuerza = picoDeMadera.fuerza();
        assertEquals(2,fuerza);
    }

    @Test
    public void testConstruirPicoDePiedraPoseeDurabilidadCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        assertEquals(200,durabilidad);
    }

    @Test
    public void testConstruirPicoDePiedraPoseeFuerzaCorrecta(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int fuerza = picoDePiedra.fuerza();
        assertEquals(4,fuerza);
    }

    @Test
    public void testUsarPicoDeMaderaContraMaderaDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        picoDeMadera.recoger(new Madera());
        assertEquals(durabilidad - picoDeMadera.fuerza(),picoDeMadera.durabilidad());
    }

    @Test
    public void testUsarPicoDeMaderaContraPiedraDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        picoDeMadera.recoger(new Piedra());
        assertEquals( durabilidad - picoDeMadera.fuerza(),picoDeMadera.durabilidad());
    }

    @Test
    public void testUsarPicoDeMaderaContraMetalDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        picoDeMadera.recoger(new Metal());
        assertEquals( durabilidad - picoDeMadera.fuerza(),picoDeMadera.durabilidad());
    }

    @Test
    public void testUsarPicoDeMaderaContraDiamanteDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        picoDeMadera.recoger(new Diamante());
        assertEquals( durabilidad - picoDeMadera.fuerza(),picoDeMadera.durabilidad());
    }


    @Test
    public void testUsarPicoDePiedraContraMaderaDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Madera());

        assert((int) (durabilidad - picoDePiedra.fuerza()/1.5) == picoDePiedra.durabilidad());
    }

    @Test
    public void testUsarPicoDePiedraContraPiedraDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Piedra());
        assert((int)(durabilidad - picoDePiedra.fuerza()/1.5) == picoDePiedra.durabilidad());
    }

    @Test
    public void testUsarPicoDePiedraContraMetalDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Metal());
        assert((int)(durabilidad - picoDePiedra.fuerza()/1.5) == picoDePiedra.durabilidad());
    }

    @Test
    public void testUsarPicoDePiedraContraDiamanteDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Diamante());
        assert((int)(durabilidad - picoDePiedra.fuerza()/1.5) == picoDePiedra.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraMadera1VezNoDisminuyeDurabilidad(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int durabilidad = picoDeMetal.durabilidad();
        picoDeMetal.recoger(new Madera());

        assertEquals( durabilidad,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraPiedra1VezNoDisminuyeDurabilidad(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int durabilidad = picoDeMetal.durabilidad();
        picoDeMetal.recoger(new Piedra());

        assertEquals( durabilidad,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraMetal1VezNoDisminuyeDurabilidad(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int durabilidad = picoDeMetal.durabilidad();
        picoDeMetal.recoger(new Metal());

        assertEquals( durabilidad,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraDiamante1VezNoDisminuyeDurabilidad(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int durabilidad = picoDeMetal.durabilidad();
        picoDeMetal.recoger(new Diamante());

        assertEquals( durabilidad,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraMadera10VecesDisminuyeDurabilidadaCero(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        Madera madera = new Madera();

        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);
        picoDeMetal.recoger(madera);

        assertEquals( 0,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraPiedra10VecesDisminuyeDurabilidadaCero(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        Piedra piedra = new Piedra();

        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);
        picoDeMetal.recoger(piedra);


        assertEquals( 0,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraMetal10VecesDisminuyeDurabilidadaCero(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        Metal metal = new Metal();

        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);
        picoDeMetal.recoger(metal);


        assertEquals( 0,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraDiamante10VecesDisminuyeDurabilidadaCero(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        Diamante diamante = new Diamante();

        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);
        picoDeMetal.recoger(diamante);


        assertEquals( 0,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDePiedraRefinadaContraDiamanteDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada .durabilidad();
        picoDePiedraRefinada.recoger(new Diamante());
        assertEquals(durabilidad-durabilidad*0.1,picoDePiedraRefinada .durabilidad(),0);


    }

    @Test
    public void testUsarPicoDePiedraRefinadaContraMaderaNoDisminuyeDurabilidad(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada .durabilidad();
        picoDePiedraRefinada .recoger(new Madera());
        assertEquals(durabilidad,picoDePiedraRefinada .durabilidad(),0);


    }

    @Test
    public void testUsarPicoDePiedraRefinadaContraPiedraNoDisminuyeDurabilidad(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada .durabilidad();
        picoDePiedraRefinada .recoger(new Piedra());
        assertEquals(durabilidad,picoDePiedraRefinada .durabilidad(),0);


    }

    @Test
    public void testUsarPicoDePiedraRefinadaContraMetalNoDisminuyeDurabilidad(){
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada .durabilidad();
        picoDePiedraRefinada .recoger(new Metal());
        assertEquals(durabilidad,picoDePiedraRefinada .durabilidad(),0);


    }









}