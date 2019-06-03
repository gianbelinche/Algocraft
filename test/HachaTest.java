import org.junit.Test;

import static org.junit.Assert.*;

public class HachaTest {

    @Test
    public void construirHachaLaCreaConLaDurabilidadCorrecta(){

        for(int i = -1000;i <= 1000;i++) {
            Hacha hacha = new Hacha(i,null,0);
            assertEquals(i,hacha.durabilidad());
        }
    }

    @Test
    public void crearHachaDeMaderaPoseeDurabilidadCorrecta(){
        Jugador jugador = new Jugador();
        Hacha hachaDeMadera = jugador.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        assertEquals(100,durabilidad);
    }

    @Test
    public void crearHachaDeMaderaPoseeFuerzaCorrecta(){
        Jugador jugador = new Jugador();
        Hacha hachaDeMadera = jugador.crearHachaDeMadera();
        int fuerza = hachaDeMadera.fuerza();
        assertEquals(2,fuerza);
    }

    @Test
    public void crearHachaDePiedraPoseeDurabilidadCorrecta(){
        Jugador jugador = new Jugador();
        Hacha hachaDePiedra = jugador.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        assertEquals(200,durabilidad);
    }

    @Test
    public void crearHachaDePiedraPoseeFuerzaCorrecta(){
        Jugador jugador = new Jugador();
        Hacha hachaDePiedra = jugador.crearHachaDePiedra();
        int fuerza = hachaDePiedra.fuerza();
        assertEquals(5,fuerza);
    }

    @Test
    public void usarHachadeMaderaContraPiedraDisminuyeLaDurabilidadCorrectamente(){
        Jugador jugador = new Jugador();
        Hacha hachaDeMadera = jugador.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Piedra());
        assertEquals(durabilidad-hachaDeMadera.fuerza(),hachaDeMadera.durabilidad());

    }

    @Test
    public void usarHachadeMaderaContraMaderaDisminuyeLaDurabilidadCorrectamente(){
        Jugador jugador = new Jugador();
        Hacha hachaDeMadera = jugador.crearHachaDeMadera();
        int durabilidad = hachaDeMadera.durabilidad();
        hachaDeMadera.recoger(new Madera());
        assertEquals(durabilidad-hachaDeMadera.fuerza(),hachaDeMadera.durabilidad());

    }

    @Test
    public void usarHachadePiedraContraMaderaDisminuyeLaDurabilidadCorrectamente(){
        Jugador jugador = new Jugador();
        Hacha hachaDePiedra = jugador.crearHachaDePiedra();
        int durabilidad = hachaDePiedra.durabilidad();
        hachaDePiedra.recoger(new Madera());
        assertEquals(durabilidad-hachaDePiedra.fuerza(),hachaDePiedra.durabilidad());

    }

}
