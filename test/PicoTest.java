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
        Jugador jugador = new Jugador();
        Pico picoDeMadera = jugador.crearPicoDeMadera();
        int durabilidad = picoDeMadera.durabilidad();
        assertEquals(100,durabilidad);
    }

    @Test
    public void construirPicoDeMaderaPoseeFuerzaCorrecta(){
        Jugador jugador = new Jugador();
        Pico picoDeMadera = jugador.crearPicoDeMadera();
        int fuerza = picoDeMadera.fuerza();
        assertEquals(2,fuerza);
    }

    @Test
    public void construirPicoDePiedraPoseeDurabilidadCorrecta(){
        Jugador jugador = new Jugador();
        Pico picoDePiedra = jugador.crearPicoDePiedra();
        int durabilidad = picoDePiedra.durabilidad();
        assertEquals(200,durabilidad);
    }

    @Test
    public void construirPicoDePiedraPoseeFuerzaCorrecta(){
        Jugador jugador = new Jugador();
        Pico picoDePiedra = jugador.crearPicoDePiedra();
        int fuerza = picoDePiedra.fuerza();
        assertEquals(4,fuerza);
    }
}