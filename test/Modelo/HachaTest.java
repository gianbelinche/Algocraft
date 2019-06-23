package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Herramientas.Hacha;
import Modelo.Materiales.*;
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

    @Test
    public void testHachaDeMaderaRompeMaterialesMuchasVecesYSeRompeElla(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        hachaDeMadera.recoger(new Madera());
        hachaDeMadera.recoger(new Piedra());
        hachaDeMadera.recoger(new Metal());
        hachaDeMadera.recoger(new Diamante());
        for(int i = 0;i<46;i++){
            hachaDeMadera.recoger(new Madera());
        }
        boolean paso = false;
        try{
            hachaDeMadera.recoger(new Piedra());
        }catch (HerramientaRotaException e){
            paso = true;
        }
        assertTrue(paso);
    }

    @Test
    public void testHachaDePiedraRompeMaterialesMuchasVecesYSeRompeElla(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        hachaDePiedra.recoger(new Madera());
        hachaDePiedra.recoger(new Piedra());
        hachaDePiedra.recoger(new Metal());
        hachaDePiedra.recoger(new Diamante());
        for(int i = 0;i<36;i++){
            hachaDePiedra.recoger(new Madera());
        }
        boolean paso = false;
        try{
            hachaDePiedra.recoger(new Piedra());
        }catch (HerramientaRotaException e){
            paso = true;
        }
        assertTrue(paso);
    }

    @Test
    public void testHachaDeMetalRompeMaterialesMuchasVecesYSeRompeElla(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        hachaDeMetal.recoger(new Piedra());
        hachaDeMetal.recoger(new Metal());
        hachaDeMetal.recoger(new Diamante());
        for(int i = 0;i<77;i++){
            hachaDeMetal.recoger(new Piedra());
        }
        boolean paso = false;
        try{
            hachaDeMetal.recoger(new Piedra());
        }catch (HerramientaRotaException e){
            paso = true;
        }
        assertTrue(paso);
    }

    @Test
    public void testUsarHachaDeMaderaContraMaderaSeObtieneRecursoCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        Madera madera = new Madera();
        Material maderaRecogida;
        hachaDeMadera.recoger(madera);
        hachaDeMadera.recoger(madera);
        hachaDeMadera.recoger(madera);
        hachaDeMadera.recoger(madera);
        maderaRecogida = hachaDeMadera.recoger(madera);

        assertEquals(madera, maderaRecogida);

    }

    @Test
    public void testUsarHachaDePiedraContraMaderaSeObtieneRecursoCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra = constructor.crearHachaDePiedra();
        Madera madera = new Madera();
        Material maderaRecogida;
        int durabilidadMaterial = madera.durabilidad();
        int fuerzaHerramienta = hachaDePiedra.durabilidad();
        int numero_iteraciones = durabilidadMaterial/fuerzaHerramienta -1 ;
        for(int i=0; i<numero_iteraciones; i++){
            hachaDePiedra.recoger(madera);
        }
        hachaDePiedra.recoger(madera);
    maderaRecogida = hachaDePiedra.recoger(madera);

    assertEquals(madera, maderaRecogida);

    }
    @Test
    public void testUsarHachaDeMetalContraMaderaSeObtieneRecursoCorrectamente(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal = constructor.crearHachaDeMetal();
        Madera madera = new Madera();
        Material maderaRecogida;
        int durabilidadMaterial = madera.durabilidad();
        int fuerzaHerramienta = hachaDeMetal.durabilidad();
        int numero_iteraciones = durabilidadMaterial/fuerzaHerramienta/2 -1 ;
        for(int i=0; i<numero_iteraciones; i++){
            hachaDeMetal.recoger(madera);
        }
        hachaDeMetal.recoger(madera);
        maderaRecogida = hachaDeMetal.recoger(madera);

        assertEquals(madera, maderaRecogida);

    }

    @Test
    public void testUnHachaDeMaderaEsIgualAOtraHachaDeMadera(){
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera = constructor.crearHachaDeMadera();
        Hacha otraHachaDeMadera = constructor.crearHachaDeMadera();
        assertTrue(hachaDeMadera.equals(otraHachaDeMadera));
    }
}
