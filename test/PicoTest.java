import org.junit.Test;

import static org.junit.Assert.*;

public class PicoTest {

    @Test
    public void construirPicoLoCreaConLaDurabilidadCorrecta(){

        for(int i = -1000;i <= 1000;i++) {
            Pico pico = new Pico(i,null,0);
            assertEquals(i,pico.durabilidad());
        }
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
        assertEquals(durabilidad - picoDeMadera.fuerza(),picoDeMadera.durabilidad());
    }

    /*
    @Test
    public void usarPicoDePiedraContraMaderaDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Madera());
        assert(durabilidad - picoDePiedra.fuerza()/1.5 == picoDePiedra.durabilidad());
    }

    @Test
    public void usarPicoDePiedraContraPiedraDisminuyeDurabilidadCorrectamente(){
        Constructor constructor = new Constructor();
        Pico picoDePiedra = constructor.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        picoDePiedra.recoger(new Piedra());
        assert(durabilidad - picoDePiedra.fuerza()/1.5 == picoDePiedra.durabilidad());
    }

     */
}