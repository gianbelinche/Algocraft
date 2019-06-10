package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class PicoTest {


    @Test
    public void testConstruirPicoDeMetalPoseeDurabilidadCorrecta(){
        int durabilidadDelPico = 400;
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int durabilidad = picoDeMetal.durabilidad();
        assertEquals(durabilidadDelPico,durabilidad);
    }
    @Test
    public void testConstruirPicoDeMetalPoseeFuerzaCorrecta(){
        int fuerzaDelPico = 12;
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        int fuerza = picoDeMetal.fuerza();
        assertEquals(fuerzaDelPico,fuerza);
    }
    @Test
    public void testConstruirPicoDePiedraRefinadaPoseeDurabilidadCorrecta(){
        int durabilidadDelPico = 1000;
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada.durabilidad();
        assertEquals(durabilidadDelPico,durabilidad);
    }
    @Test
    public void testConstruirPicoDePiedraRefinadaPoseeFuerzaCorrecta(){
        int fuerzaDelPico = 20;
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int fuerza = picoDePiedraRefinada.fuerza();
        assertEquals(fuerzaDelPico,fuerza);
    }
    @Test
    public void testConstruirPicoDeMaderaPoseeDurabilidadCorrecta(){
        int durabilidadDelPico = 100;
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        assertEquals(durabilidadDelPico,durabilidad);
    }

    @Test
    public void testConstruirPicoDeMaderaPoseeFuerzaCorrecta(){
        int fuerzaDelPico = 2;
        Constructor constructor = new Constructor();
        Pico picoDeMadera = constructor.crearPicoDeMadera();
        int fuerza = picoDeMadera.fuerza();
        assertEquals(fuerzaDelPico,fuerza);
    }

    @Test
    public void testConstruirPicoDePiedraPoseeDurabilidadCorrecta(){
        int durabilidadDelPico = 200;
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        assertEquals(durabilidadDelPico,durabilidad);
    }

    @Test
    public void testConstruirPicoDePiedraPoseeFuerzaCorrecta(){
        int fuerzaDelPico = 4;
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int fuerza = picoDePiedra.fuerza();
        assertEquals(fuerzaDelPico,fuerza);
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

    private double factor = 1.5;
    @Test
    public void testUsarPicoDePiedraContraMaderaDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Madera());

        assert((int) (durabilidad - picoDePiedra.fuerza()/factor) == picoDePiedra.durabilidad());
    }

    @Test
    public void testUsarPicoDePiedraContraPiedraDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Piedra());
        assert((int)(durabilidad - picoDePiedra.fuerza()/factor) == picoDePiedra.durabilidad());
    }

    @Test
    public void testUsarPicoDePiedraContraMetalDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Metal());
        assert((int)(durabilidad - picoDePiedra.fuerza()/factor) == picoDePiedra.durabilidad());
    }

    @Test
    public void testUsarPicoDePiedraContraDiamanteDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Diamante());
        assert((int)(durabilidad - picoDePiedra.fuerza()/factor) == picoDePiedra.durabilidad());
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
        Tablero tablero = new Tablero(10,10);

        for(int i = 0; i < 10; i++)
        {
            tablero.colocarEnPosicion(0,0,piedra);
            picoDeMetal.recoger(piedra);
        }


        assertEquals( 0,picoDeMetal.durabilidad());
    }

    @Test
    public void testUsarPicoDeMetalContraMetal10VecesDisminuyeDurabilidadaCero(){
        Constructor constructor = new Constructor();
        Pico picoDeMetal = constructor.crearPicoDeMetal();
        Metal metal = new Metal();
        Tablero tablero = new Tablero(10,10);

        for(int i = 0; i < 10; i++)
        {
            tablero.colocarEnPosicion(0,0,metal);
            picoDeMetal.recoger(metal);
        }

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
        double factor = 0.1;
        Constructor constructor = new Constructor();
        Pico picoDePiedraRefinada = constructor.crearPicoDePiedraRefinada();
        int durabilidad = picoDePiedraRefinada .durabilidad();
        picoDePiedraRefinada.recoger(new Diamante());
        assertEquals(durabilidad-durabilidad*factor,picoDePiedraRefinada .durabilidad(),0);


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